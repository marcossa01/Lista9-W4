package br.com.romanos.marcossa.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.romanos.marcossa.domain.Disciplina;
import br.com.romanos.marcossa.domain.dto.DisciplinaDTO;
import br.com.romanos.marcossa.service.DisciplinaService;

@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaResource {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping
	public ResponseEntity<List<DisciplinaDTO>> findAll(){
		List<DisciplinaDTO> list = disciplinaService.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Disciplina> findById(@PathVariable Integer id) {
		Disciplina disciplina = disciplinaService.findById(id);
		return ResponseEntity.ok(disciplina);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody DisciplinaDTO dto) {
		Disciplina obj = disciplinaService.fromDTO(dto);
		obj = disciplinaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	

}
