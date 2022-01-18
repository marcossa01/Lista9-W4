package com.marcossa.pedidosrestaurante.service;

import com.marcossa.pedidosrestaurante.domain.Mesa;
import com.marcossa.pedidosrestaurante.domain.Pedido;
import com.marcossa.pedidosrestaurante.domain.dto.MesaDTO;
import com.marcossa.pedidosrestaurante.repository.MesaRepository;
import com.marcossa.pedidosrestaurante.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MesaService {

    @Autowired
    private MesaRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public Mesa inserir(Mesa mesa) {
        mesa.setId(verificarId(mesa.getId()));
        //mesa.setValorTotal(mesa.getValorTotal());
        repository.inserirMesa(mesa);
        return mesa;
    }

    public List<MesaDTO> todasMesas() {
        List<MesaDTO> list = repository.todasMesas().stream().map(x -> new MesaDTO(x.getId())).collect(Collectors.toList());
        return list;
    }

    public MesaDTO buscarPorIdMesaDto(Integer id) {
        Optional<Mesa> mesa = repository.todasMesas().stream().filter(x -> x.getId().equals(id)).findFirst();
        MesaDTO mesaDto = fromDto(mesa.orElse(null));
        return mesaDto;
    }

    public Mesa buscarPorId(Integer id) {
        Optional<Mesa> mesa = repository.todasMesas().stream().filter(x -> x.getId().equals(id)).findFirst();
        return mesa.orElse(null);
    }

    //Método para verificar se há o mesmo id na lista de Mesa
    public Integer verificarId(Integer idMesa) {
        for(Mesa m : repository.todasMesas()) {
            if(m.getId().equals(idMesa)) {
                throw new RuntimeException();
            }
        }
        return idMesa;
    }

    public MesaDTO fromDto(Mesa mesa) {
        MesaDTO mesaDto = new MesaDTO(mesa.getId());
        return mesaDto;
    }


}
