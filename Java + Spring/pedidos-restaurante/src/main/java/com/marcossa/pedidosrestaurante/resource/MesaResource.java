package com.marcossa.pedidosrestaurante.resource;

import com.marcossa.pedidosrestaurante.domain.Mesa;
import com.marcossa.pedidosrestaurante.domain.Pedido;
import com.marcossa.pedidosrestaurante.domain.dto.MesaDTO;
import com.marcossa.pedidosrestaurante.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/mesas")
public class MesaResource {

    @Autowired
    private MesaService service;

    @PostMapping
    public ResponseEntity<String> cadastrarMesa(@RequestBody Mesa mesa) {
        service.inserir(mesa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mesa.getId()).toUri();
        return ResponseEntity.created(uri).body("Mesa cadastrada!");
    }

    @GetMapping("/todasMesas")
    public ResponseEntity<List<MesaDTO>> todasMesas(){
        List<MesaDTO> list = service.todasMesas();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<Mesa> buscarPorId(@PathVariable Integer id) {
        Mesa mesa = service.buscarPorId(id);
        return ResponseEntity.ok(mesa);
    }

}
