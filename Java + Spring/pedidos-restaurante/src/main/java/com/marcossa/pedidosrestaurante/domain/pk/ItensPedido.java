package com.marcossa.pedidosrestaurante.domain.pk;

import com.marcossa.pedidosrestaurante.domain.Prato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItensPedido {

    private Prato prato;
    private Integer quantidade;

    public Double getPrecoTotal(){
        return prato.getPreco() * quantidade;
    }

}
