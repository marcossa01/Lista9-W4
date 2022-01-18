package com.marcossa.gestaocliente.domain;

import com.marcossa.gestaocliente.domain.dto.ClienteDTO;
import com.marcossa.gestaocliente.domain.pk.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1497832519591141949L;

    private Integer id;
    private ClienteDTO cliente;
    private List<ItemPedido> produtos = new ArrayList<>();

    public Double getvalorTotalCompra() {
        Double valorTotal = 0.0;
        for (ItemPedido ip : produtos) {
            valorTotal += ip.getValorTotal();
        }
        return  valorTotal;
    }

}
