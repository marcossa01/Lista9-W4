package com.marcossa.pedidosrestaurante.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mesa implements Serializable {
    private static final long serialVersionUID = 3914626834781832465L;

    private Integer id;
    private Set<Pedido> pedidos = new HashSet<>();

    public Double getValorTotalMesa() {
        Double valorTotal = 0.0;
        for (Pedido p : pedidos) {
            valorTotal += p.getValorTotal();
        }
        return valorTotal;
    }
}
