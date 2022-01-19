package com.salesianostriana.dam;

import com.jayway.jsonpath.internal.filter.LogicalExpressionNode;
import com.salesianostriana.dam.model.Cliente;
import com.salesianostriana.dam.model.LineaDeVenta;
import com.salesianostriana.dam.model.Producto;
import com.salesianostriana.dam.model.Venta;
import com.salesianostriana.dam.repos.ProductoRepositorio;
import com.salesianostriana.dam.repos.VentaRepositorio;
import com.salesianostriana.dam.service.VentaServicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.lenient;

@ExtendWith(SpringExtension.class)
class DemoApplicationTests {

	@Mock
	ProductoRepositorio productoRepositorio;

	@Mock
	VentaRepositorio ventaRepositorio;

	@InjectMocks
	VentaServicio ventaServicio;

	@Test
	void nuevaVenta () {

		Producto producto = Producto.builder()
				.codigoProducto("1")
				.nombre("Monitor Curvo")
				.precio(399.99)
				.build();

		Cliente cliente = Cliente.builder()
				.nombre("Juan Rodriguez")
				.email("juanrodriguez@gmail.com")
				.dni("123456789R")
				.build();

		lenient().when(productoRepositorio.findById(1l)).thenReturn(java.util.Optional.ofNullable(producto));

		Map<Long, Integer> carrito = Map.of(1L, 2);

		Venta venta = Venta.builder()
				.cliente(cliente)
				.lineasDeVenta(List.of(new LineaDeVenta(producto, 4, 399.99)))
				.build();

		Venta venta1 = ventaServicio.nuevaVenta(carrito, cliente);

		lenient().when(ventaRepositorio.save(venta)).thenReturn(venta);
		assertThat(venta.equals(venta1));
	}

	@Test
	void addProductoToLineaVenta () {
		Cliente cliente = Cliente.builder()
				.nombre("Juan Rodriguez")
				.email("juanrodriguez@gmail.com")
				.dni("123456789R")
				.build();
		List<LineaDeVenta> listaLineaVenta = new ArrayList<>();
		LineaDeVenta lineaDeVenta1 = new LineaDeVenta(new Producto(1L,"5", "Alfombrilla", 9.99), 2, 18.98);
		LineaDeVenta lineaDeVenta2 = new LineaDeVenta(new Producto(2L,"6", "Auriculares Gaming", 69.99), 1, 69.99);
		listaLineaVenta.add(lineaDeVenta1);
		Optional<Venta> optionalVenta = Optional.of(new Venta(3L, LocalDate.now(),listaLineaVenta,cliente));
		listaLineaVenta.add(lineaDeVenta2);
		Venta venta = new Venta(3L, LocalDate.now(),listaLineaVenta,cliente);
		lenient().when(ventaRepositorio.findById(1L)).thenReturn(optionalVenta);
		lenient().when(productoRepositorio.findById(2L)).thenReturn(Optional.of(new Producto(2L, "6", "Auriculares Gaming", 69.99)));
		lenient().when(ventaRepositorio.save(optionalVenta.get())).thenReturn(venta);
		Venta venta1 = ventaServicio.addProductoToVenta(1L, 2L, 4);
		assertThat(venta.equals(venta1));
	}

	@Test
	void removeLineaVenta() {
		Cliente cliente = Cliente.builder()
				.nombre("Juan Rodriguez")
				.email("juanrodriguez@gmail.com")
				.dni("123456789R")
				.build();
		List<LineaDeVenta> listaLineaVenta = new ArrayList<>();
		LineaDeVenta lineaDeVenta1 = new LineaDeVenta(new Producto(1L,"5", "Alfombrilla", 9.99), 2, 18.98);
		LineaDeVenta lineaDeVenta2 = new LineaDeVenta(new Producto(2L,"6", "Auriculares Gaming", 69.99), 1, 69.99);
		listaLineaVenta.add(lineaDeVenta1);
		Optional<Venta> optionalVenta = Optional.of(new Venta(3L, LocalDate.now(),listaLineaVenta,cliente));
		listaLineaVenta.add(lineaDeVenta2);
		Venta venta = new Venta(3L, LocalDate.now(),listaLineaVenta,cliente);
		lenient().when(ventaRepositorio.findById(1L)).thenReturn(optionalVenta);
		lenient().when(ventaRepositorio.save(optionalVenta.get())).thenReturn(venta);
		Venta venta1 = ventaServicio.removeLineaVenta(1L, 2L);
		assertThat(venta.equals(venta1));
	}


}
