package com.marcossa.gestaocliente.service;

import com.marcossa.gestaocliente.domain.Pedido;
import com.marcossa.gestaocliente.domain.pk.ItemPedido;
import com.marcossa.gestaocliente.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Pedido insert(Pedido pedido) {
        pedido.setId(setarId());
        pedido.setCliente(clienteService.buscarPorIdDto(pedido.getCliente().getId()));

        for(ItemPedido p : pedido.getProdutos()) {
            p.setProduto(produtoService.buscarPorId(p.getProduto().getId()));
            p.setQuantidade(p.getQuantidade());
        }

        repository.adicionarPedido(pedido);
        clienteService.acrescentarPedido(pedido.getCliente().getId());
        return pedido;
    }

    public List<Pedido> listarPedidos() {
        List<Pedido> list = repository.listarPedidos();
        return list;
    }

    public Pedido buscarPorId(Integer id) {
        Optional<Pedido> pedido = repository.listarPedidos().stream().filter(x -> x.getId().equals(id)).findFirst();
        return pedido.orElse(null);
    }

    public Integer setarId() {
        Integer maior = 0;
        for(Pedido p : repository.listarPedidos()) {
            if (p.getId() > maior) {
                maior = p.getId();
            }
        }
        return maior + 1;
    }
}
