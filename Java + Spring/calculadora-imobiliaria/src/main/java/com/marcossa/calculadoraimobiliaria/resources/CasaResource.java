package com.marcossa.calculadoraimobiliaria.resources;

import com.marcossa.calculadoraimobiliaria.domain.Casa;
import com.marcossa.calculadoraimobiliaria.domain.Comodo;
import com.marcossa.calculadoraimobiliaria.domain.dto.CasaDto;
import com.marcossa.calculadoraimobiliaria.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/casas")
public class CasaResource {

    @Autowired
    private CasaService casaService;

    @GetMapping
    public ResponseEntity<List<CasaDto>> findAll() {
        List<CasaDto> list = casaService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{nome}")
    public ResponseEntity<Casa> findByNome(@PathVariable String nome) {
        Casa casa = casaService.findByNome(nome);
        return ResponseEntity.ok(casa);
    }

    @GetMapping(value = "/area/{nome}")
    public ResponseEntity<String> areaTotal(@PathVariable String nome) {
        String casa = casaService.getAreaCasa(nome);
        return ResponseEntity.ok(casa);
    }

    @GetMapping(value = "/{valor}/{nome}")
    public ResponseEntity<String> valorCasa(@PathVariable Integer valor, @PathVariable String nome) {
        String valorCasa = casaService.getValorCasa(nome, valor);
        return ResponseEntity.ok(valorCasa);
    }

    @GetMapping(value = "/maiorComodo/{nome}")
    public ResponseEntity<String> maiorComodo(@PathVariable String nome){
        String maiorComodo = casaService.getMaiorComodo(nome);
        return ResponseEntity.ok(maiorComodo);
    }
    @GetMapping(value = "/areaComodos/{nome}")
    public ResponseEntity<String> areaComodos(@PathVariable String nome) {
        String areaComodos = casaService.areaComodos(nome);
        return ResponseEntity.ok(areaComodos);
    }

    @PostMapping
    public ResponseEntity<String> insertCasa(@RequestBody Casa casa) {
        casaService.salvarCasa(casa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nome}").buildAndExpand(casa.getNome()).toUri();
        return ResponseEntity.created(uri).body("Casa Salva");
    }
}
