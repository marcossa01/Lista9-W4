package com.marcossa.pedidosrestaurante.repository;

import com.marcossa.pedidosrestaurante.domain.Mesa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MesaRepository {

    public List<Mesa> mesas = new ArrayList<>();

    public void inserirMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public List<Mesa> todasMesas() {
        return mesas;
    }

}
