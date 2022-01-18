package com.marcossa.gestaocliente.resource;

import com.marcossa.gestaocliente.domain.Cliente;
import com.marcossa.gestaocliente.domain.dto.ClienteDTO;
import com.marcossa.gestaocliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<String> cadastroCliente(@RequestBody Cliente cliente) {
        service.insert(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body("Cliente cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> list = service.listarClientes();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaPorId(@PathVariable Integer id) {
        Cliente cliente = service.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }
}
