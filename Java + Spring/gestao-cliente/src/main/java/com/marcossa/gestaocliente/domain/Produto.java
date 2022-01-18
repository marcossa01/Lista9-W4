package com.marcossa.gestaocliente.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {
    private static final long serialVersionUID = 1075360409664597153L;

    private Integer id;
    private String descricao;
    private String cor;
    private Double preco;
}
