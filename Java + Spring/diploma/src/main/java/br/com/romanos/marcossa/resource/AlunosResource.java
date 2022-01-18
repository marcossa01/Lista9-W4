package br.com.romanos.marcossa.resource;

import java.net.URI;
import java.util.List;

import br.com.romanos.marcossa.domain.Disciplina;
import br.com.romanos.marcossa.domain.dto.DisciplinaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.romanos.marcossa.domain.Aluno;
import br.com.romanos.marcossa.domain.dto.AlunoDTO;
import br.com.romanos.marcossa.service.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunosResource {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> findAll(){
		List<AlunoDTO> list = alunoService.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		Aluno aluno = alunoService.findById(id);
		return ResponseEntity.ok(aluno);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AlunoDTO objDTO) {
		Aluno obj = alunoService.fromDTO(objDTO);
		obj = alunoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
