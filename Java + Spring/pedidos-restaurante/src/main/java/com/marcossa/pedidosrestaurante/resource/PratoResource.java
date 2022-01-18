package com.marcossa.pedidosrestaurante.resource;

import com.marcossa.pedidosrestaurante.domain.Prato;
import com.marcossa.pedidosrestaurante.domain.dto.PratoDTO;
import com.marcossa.pedidosrestaurante.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pratos")
public class PratoResource {

    @Autowired
    private PratoService service;

    @PostMapping
    public ResponseEntity<String> cadastrarPrato(@RequestBody Prato prato) {
        service.inserir(prato);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prato.getId()).toUri();
        return ResponseEntity.created(uri).body("Prato cadastrado!");
    }

    @GetMapping(value = "/todosPratos")
    public ResponseEntity<List<PratoDTO>> todosPratos() {
        List<PratoDTO> list = service.todosPratos();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<Prato> buscarPorId(@PathVariable Integer id) {
        Prato prato = service.buscarPorId(id);
        return ResponseEntity.ok(prato);
    }
}
