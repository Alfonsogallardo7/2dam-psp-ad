package com.triana.salesianos.dam.E08Herencia.services;

import com.triana.salesianos.dam.E08Herencia.models.Pedidos;
import com.triana.salesianos.dam.E08Herencia.repositories.PedidosRepository;
import com.triana.salesianos.dam.E08Herencia.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends BaseService <Pedidos, Long, PedidosRepository> {
}
