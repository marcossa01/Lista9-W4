package com.marcossa.gestaocliente.repository;

import ch.qos.logback.core.net.server.Client;
import com.marcossa.gestaocliente.domain.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {

    List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void RemoverCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
}
