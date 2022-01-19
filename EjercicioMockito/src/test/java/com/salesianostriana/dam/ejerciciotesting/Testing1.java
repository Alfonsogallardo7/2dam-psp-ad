package com.salesianostriana.dam.ejerciciotesting;

import com.salesianostriana.dam.ejerciciotesting.model.Cliente;
import com.salesianostriana.dam.ejerciciotesting.model.LineaDeVenta;
import com.salesianostriana.dam.ejerciciotesting.model.Producto;
import com.salesianostriana.dam.ejerciciotesting.model.Venta;
import com.salesianostriana.dam.ejerciciotesting.repos.ProductoRepositorio;
import com.salesianostriana.dam.ejerciciotesting.repos.VentaRepositorio;
import com.salesianostriana.dam.ejerciciotesting.services.VentaServicio;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.lenient;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class Testing1 {

    @Mock
    VentaRepositorio ventaRepositorio;

    @Mock
    ProductoRepositorio productoRepositorio;

    @InjectMocks
    VentaServicio ventaServicio;

    //Caja Negra
    @Test
    public void nuevaVenta() {
        Producto producto = Producto.builder()
                .codigoProducto("1")
                .nombre("Cascos huenos")
                .precio(19.99).build();

        Cliente cliente = Cliente.builder()
                .nombre("Alfonso")
                .email("alfonso@gmail.com")
                .dni("54436607V")
                .build();

        lenient().when(productoRepositorio.findOne("1")).thenReturn(producto);

        Map<String, Integer> carrito = Map.of("1", 2);

        Venta venta = new Venta();
        venta.setId(2L);
        venta.setCliente(cliente);
        venta.setLineasDeVenta(List.of(new LineaDeVenta(producto, 2, 19.99)));
        lenient().when(ventaRepositorio.save(venta)).thenReturn(venta);
        assertEquals(venta, ventaServicio.nuevaVenta(carrito, cliente));


        /*LineaDeVenta lineaDeVenta = new LineaDeVenta(new Producto("4", "Ratón 3 botones", 19.99), 3,19.99);
        Cliente cliente = new Cliente();
        List<LineaDeVenta> listaLineaVenta = new ArrayList<>();
        listaLineaVenta.add(lineaDeVenta);
        Venta venta = new Venta(1L, LocalDate.now(), listaLineaVenta, cliente);
        lenient().when(productoRepositorio.findOne("4")).thenReturn(new Producto("4", "Ratón 3 botones", 19.99));
        lenient().when(ventaRepositorio.save(venta)).thenReturn(venta);*/

    }

    //Caja Blanca
    @Test
    public void addProductoToLineaDeVenta () {
        List<LineaDeVenta> listaLineaVenta = new ArrayList<>();
        Cliente cliente = new Cliente();
        LineaDeVenta lineaDeVenta1 = new LineaDeVenta(new Producto("5", "Alfombrilla", 9.99), 2, 18.98);
        LineaDeVenta lineaDeVenta2 = new LineaDeVenta(new Producto("6", "Auriculares Gaming", 69.99), 1, 69.99);
        listaLineaVenta.add(lineaDeVenta1);
        listaLineaVenta.add(lineaDeVenta2);
        Optional<Venta> optionalVenta = Optional.of(new Venta(1L, LocalDate.now(), listaLineaVenta, cliente));
        listaLineaVenta.remove(lineaDeVenta1);
        Venta venta = new Venta(1L, LocalDate.now(), listaLineaVenta, cliente);
        lenient().when(ventaRepositorio.findOneOptional(1L)).thenReturn(optionalVenta);
        lenient().when(ventaRepositorio.edit(optionalVenta.get())).thenReturn(venta);
        Venta venta1 = ventaServicio.addProductoToVenta(1L, "5", 7);
        assertEquals(venta, venta1);
    }

    //Caja Blanca
    @Test
    public void removeLineaVenta() {
        Cliente cliente = new Cliente();
        List<LineaDeVenta> listaLineaVenta = new ArrayList<>();
        LineaDeVenta lineaDeVenta1 = new LineaDeVenta(new Producto("5", "Alfombrilla", 9.99), 2, 18.98);
        LineaDeVenta lineaDeVenta2 = new LineaDeVenta(new Producto("6", "Auriculares Gaming", 69.99), 1, 69.99);
        listaLineaVenta.add(lineaDeVenta1);
        listaLineaVenta.add(lineaDeVenta2);
        Optional<Venta> optionalVenta = Optional.of(new Venta(1L, LocalDate.now(), listaLineaVenta, cliente));
        listaLineaVenta.remove(lineaDeVenta1);
        Venta venta = new Venta(1L, LocalDate.now(), listaLineaVenta, cliente);
        lenient().when(ventaRepositorio.findOneOptional(1L)).thenReturn(optionalVenta);
        lenient().when(ventaRepositorio.edit(optionalVenta.get())).thenReturn(venta);
        Venta venta1 = ventaServicio.removeLineaVenta(1L, "6");
    }


}
