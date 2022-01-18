package com.marcossa.pedidosrestaurante.resource;

import com.marcossa.pedidosrestaurante.domain.Pedido;
import com.marcossa.pedidosrestaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Pedido pedido) {
        service.cadastrarPedido(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body("Pedido Cadastrado com sucesso!");
    }

    @GetMapping(value = "/todosPedidos")
    public ResponseEntity<List<Pedido>> listarTodos(){
        List<Pedido> list = service.listarPedido();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id) {
        Pedido ped = service.buscarPedidoId(id);
        return ResponseEntity.ok(ped);
    }

    @GetMapping(value = "/fechamentoPedido/{id}/{valor}")
    public ResponseEntity<String> fechamentoPedido(@PathVariable Integer id, @PathVariable Double valor) {
        service.fechamentoPedido(id, valor);
        return ResponseEntity.ok("Pedido pago!");
    }

}
