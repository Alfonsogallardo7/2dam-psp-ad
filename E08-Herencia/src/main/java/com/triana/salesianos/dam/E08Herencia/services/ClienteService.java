package com.triana.salesianos.dam.E08Herencia.services;

import com.triana.salesianos.dam.E08Herencia.models.Cliente;
import com.triana.salesianos.dam.E08Herencia.repositories.ClienteRepository;
import com.triana.salesianos.dam.E08Herencia.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseService <Cliente, Long, ClienteRepository> {
}
