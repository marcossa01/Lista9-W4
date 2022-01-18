package com.marcossa.gestaocliente.domain.pk;

import com.marcossa.gestaocliente.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

    private Produto produto;
    private Integer quantidade;

    public Double getValorTotal() {
        return produto.getPreco() * quantidade;
    }
}
