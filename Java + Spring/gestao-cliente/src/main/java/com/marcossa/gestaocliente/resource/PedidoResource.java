package com.marcossa.gestaocliente.resource;

import com.marcossa.gestaocliente.domain.Pedido;
import com.marcossa.gestaocliente.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Pedido pedido) {
        service.insert(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body("Pedido criado");
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedido() {
        List<Pedido> list = service.listarPedidos();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id) {
        Pedido pedido = service.buscarPorId(id);
        return ResponseEntity.ok(pedido);
    }
}
