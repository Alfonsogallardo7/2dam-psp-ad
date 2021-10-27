package com.triana.salesianos.dam.E08Herencia;

import com.triana.salesianos.dam.E08Herencia.models.ClienteCorporativo;
import com.triana.salesianos.dam.E08Herencia.models.ClienteParticular;
import com.triana.salesianos.dam.E08Herencia.models.Empleado;
import com.triana.salesianos.dam.E08Herencia.models.Pedidos;
import com.triana.salesianos.dam.E08Herencia.services.ClienteService;
import com.triana.salesianos.dam.E08Herencia.services.EmpleadoService;
import com.triana.salesianos.dam.E08Herencia.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final ClienteService clienteService;
    private final EmpleadoService empleadoService;
    private final PedidoService pedidoService;

    @PostConstruct
    public void test() {



        ClienteCorporativo clientecorporativo= ClienteCorporativo.builder()
                .nombreEmpresa("Ayesa")
                .email("ayesa@gmail.com")
                .telefono(666777888)
                .build();

        clienteService.edit(clientecorporativo);


        Empleado empleado= Empleado.builder()
                .nombre("Guillermo")
                .apellidos("Ferrari Ferrari")
                .departamento("Hardware")
                .email("guillermoferrari@gmail.com")
                .build();

        empleadoService.edit(empleado);

        empleado.addClienteCorporativo(clientecorporativo);



        Pedidos pedidos= Pedidos.builder()
                .codPedido("25554ad")
                .total(326.23)
                .cliente(clientecorporativo)
                .build();

        pedidoService.edit(pedidos);


        ClienteParticular clienteparticular= ClienteParticular.builder()
                .nombreEmpresa("Sermicro")
                .email("sermicro@gmail.com")
                .telefono(888999111)
                .nombreEmpleado("Luismi Lopez")
                .build();

        clienteService.edit(clienteparticular);



        System.out.println("La empresa corporativa se llama " + clientecorporativo.getNombreEmpresa()
                + " ,el pedido lo ha realizado " + clientecorporativo.getEmpleado().getNombre() + "" + clientecorporativo.getEmpleado().getApellidos());
        System.out.println("El total del pedido es de: " + pedidos.getTotal() + "€");

        System.out.println("El la empresa particular se llama " + clienteparticular.getNombreEmpresa());

    }
}
