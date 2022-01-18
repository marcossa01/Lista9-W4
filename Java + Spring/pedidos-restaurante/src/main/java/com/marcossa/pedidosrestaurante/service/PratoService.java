package com.marcossa.pedidosrestaurante.service;

import com.marcossa.pedidosrestaurante.domain.Pedido;
import com.marcossa.pedidosrestaurante.domain.Prato;
import com.marcossa.pedidosrestaurante.domain.dto.PratoDTO;
import com.marcossa.pedidosrestaurante.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PratoService {

    @Autowired
    private PratoRepository repository;

    public Prato inserir(Prato prato) {
        prato.setId(setarId());
        repository.inserirPrato(prato);
        return prato;
    }

    public List<PratoDTO> todosPratos() {
        List<PratoDTO> list = repository.todosPratos().stream().map(x -> new PratoDTO(x.getId(), x.getPreco(), x.getDescricao())).collect(Collectors.toList());
        return list;
    }

    public Prato buscarPorId(Integer id) {
        Optional<Prato> prato = repository.todosPratos().stream().filter(x -> x.getId().equals(id)).findFirst();
        return prato.orElse(null);
    }


    //Seta Id Automaticamente
    public Integer setarId() {
        List<Prato> list = repository.todosPratos();
        Integer maior = 0;
        for(Prato m : list) {
            if (m.getId() > maior) {
                maior = m.getId();
            }
        }
        return maior + 1;
    }
}
