package com.marcossa.gestaocliente.service;

import com.marcossa.gestaocliente.domain.Cliente;
import com.marcossa.gestaocliente.domain.Pedido;
import com.marcossa.gestaocliente.domain.dto.ClienteDTO;
import com.marcossa.gestaocliente.repository.ClienteRepository;
import com.marcossa.gestaocliente.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    @Autowired
    PedidoRepository pedidoRepository;

    public Cliente insert(Cliente cliente) {
        cliente.setId(setarId());
        repository.cadastrarCliente(cliente);
        return cliente;
    }

    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> list = repository.listarClientes().stream().map(x -> new ClienteDTO(x.getId(), x.getNome(), x.getCpf())).collect(Collectors.toList());
        return list;
    }

    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> cliente = repository.listarClientes().stream().filter(x -> x.getId().equals(id)).findFirst();
        return cliente.orElse(null);
    }

    public ClienteDTO buscarPorIdDto(Integer id) {
        Optional<Cliente> cliente = repository.listarClientes().stream().filter(x -> x.getId().equals(id)).findFirst();
        ClienteDTO dto = fromDto(cliente.orElse(null));
        return dto;
    }

    public void acrescentarPedido(Integer idCliente) {
        Cliente cliente = buscarPorId(idCliente);
        List<Pedido> list = pedidoRepository.listarPedidos();
        for (Pedido p : list ) {
            if(p.getCliente().getId().equals(cliente.getId())) {
                cliente.getPedidos().add(p);
            }
        }
    }

    public Integer setarId() {
        Integer maior = 0;
        for (Cliente c : repository.listarClientes()) {
            if (c.getId() > maior) {
                maior = c.getId();
            }
        }
        return maior + 1;
    }

    public ClienteDTO fromDto(Cliente cliente) {
        ClienteDTO clienteDto = new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf());
        return clienteDto;
    }

}
