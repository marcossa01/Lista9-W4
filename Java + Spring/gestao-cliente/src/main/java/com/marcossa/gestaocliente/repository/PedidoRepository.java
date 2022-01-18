package com.marcossa.gestaocliente.repository;

import com.marcossa.gestaocliente.domain.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {

    List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }


}
