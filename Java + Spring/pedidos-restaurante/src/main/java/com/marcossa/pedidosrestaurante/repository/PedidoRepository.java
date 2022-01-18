package com.marcossa.pedidosrestaurante.repository;

import com.marcossa.pedidosrestaurante.domain.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {

    public List<Pedido> pedidos = new ArrayList<>();

    public void cadastrarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public List<Pedido> listarPedidos(){
        return pedidos;
    }
}
