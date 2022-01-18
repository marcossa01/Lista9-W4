package com.marcossa.pedidosrestaurante.repository;

import com.marcossa.pedidosrestaurante.domain.Prato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PratoRepository {

    public List<Prato> pratos = new ArrayList<>();

    public void inserirPrato(Prato prato) {
        pratos.add(prato);
    }

    public List<Prato> todosPratos() {
        return pratos;
    }
}
