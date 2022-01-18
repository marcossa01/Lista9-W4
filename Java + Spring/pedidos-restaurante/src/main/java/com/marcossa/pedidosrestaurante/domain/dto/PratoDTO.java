package com.marcossa.pedidosrestaurante.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PratoDTO implements Serializable {
    private static final long serialVersionUID = 624698991925296170L;

    private Integer id;
    private Double preco;
    private String descricao;
}
