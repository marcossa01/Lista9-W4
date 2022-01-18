package com.marcossa.pedidosrestaurante.service;

import com.marcossa.pedidosrestaurante.domain.Mesa;
import com.marcossa.pedidosrestaurante.domain.Pedido;
import com.marcossa.pedidosrestaurante.domain.Prato;
import com.marcossa.pedidosrestaurante.domain.pk.ItensPedido;
import com.marcossa.pedidosrestaurante.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private PratoService pratoService;

    public Pedido cadastrarPedido(Pedido pedido) {
        pedido.setId(setarId());
        pedido.setMesa(mesaService.buscarPorIdMesaDto(pedido.getMesa().getId()));

        for(ItensPedido p : pedido.getPratos()) {
            p.setPrato(pratoService.buscarPorId(p.getPrato().getId()));
            p.setQuantidade(p.getQuantidade());
        }

        pedido.setValorTotal(pedido.valorTotal());
        repository.cadastrarPedido(pedido);
        return pedido;
    }

    public List<Pedido> listarPedido() {
        return repository.listarPedidos();
    }

    public Pedido buscarPedidoId(Integer id) {
        Optional<Pedido> pedido = repository.listarPedidos().stream().filter(x -> x.getId().equals(id)).findFirst();
        return pedido.orElse(null);
    }

    public void fechamentoPedido(Integer idPedido, Double valor) {
        List<Pedido> list = repository.listarPedidos();
        Pedido ped = buscarPedidoId(idPedido);
        Mesa mesa = mesaService.buscarPorId(ped.getMesa().getId());

        if(ped.getValorTotal().equals(valor)) {
            mesa.getPedidos().add(ped);
            list.remove(ped);
        }
        else {
            throw new RuntimeException("Error");
        }
    }

    //Método para setar Id do pedido
    public Integer setarId() {
        List<Pedido> list = repository.listarPedidos();
        Integer maior = 0;
        for(Pedido p : list) {
            if (p.getId() > maior) {
                maior = p.getId();
            }
        }
        return maior + 1;
    }
}
