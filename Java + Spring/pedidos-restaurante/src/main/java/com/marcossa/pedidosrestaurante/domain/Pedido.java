package com.marcossa.pedidosrestaurante.domain;

import com.marcossa.pedidosrestaurante.domain.dto.MesaDTO;
import com.marcossa.pedidosrestaurante.domain.pk.ItensPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido implements Serializable {
    private static final long serialVersionUID = -4992008953268975856L;

    private Integer id;
    private MesaDTO mesa;
    private List<ItensPedido> pratos = new ArrayList<>();
    private Double valorTotal = 0.0;

    public Double valorTotal(){
        for (ItensPedido p : pratos) {
            valorTotal += p.getPrecoTotal();
        }
        return valorTotal;
    }
}
