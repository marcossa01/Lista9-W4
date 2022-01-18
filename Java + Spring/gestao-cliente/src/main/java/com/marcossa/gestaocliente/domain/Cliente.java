package com.marcossa.gestaocliente.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {
    private static final long serialVersionUID = 4912216872019380857L;

    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Set<Pedido> pedidos = new HashSet<>();
}
