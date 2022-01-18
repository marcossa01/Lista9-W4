package com.marcossa.gestaocliente.resource;

import com.marcossa.gestaocliente.domain.Cliente;
import com.marcossa.gestaocliente.domain.Produto;
import com.marcossa.gestaocliente.service.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Produto produto) {
        service.insert(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body("Produto cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> list = service.listarProdutos();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }
}
