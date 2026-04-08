package com.emmanuelcuxe.Tienda.service;

import com.emmanuelcuxe.Tienda.entity.Clientes;
import com.emmanuelcuxe.Tienda.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImplements implements ClientesService {
    private final ClientesRepository clientesRepository;


    public ClientesServiceImplements(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public List<Clientes> getAllClientes() { return clientesRepository.findAll();
    }

    @Override
    public Clientes getClientesById(Integer id) {
        return clientesRepository.findById(id).orElse(null);
    }

    @Override
    public Clientes saveClientes(Clientes clientes) throws RuntimeException {
        return clientesRepository.save(clientes);
    }

    @Override
    public Clientes updateClientes(Integer id, Clientes clientes) throws RuntimeException{
        clientes.setDpiCliente(id);
        return clientesRepository.save(clientes);
    }

    @Override
    public void deleteClientes(Integer id) {clientesRepository.deleteById(id);
    }
}