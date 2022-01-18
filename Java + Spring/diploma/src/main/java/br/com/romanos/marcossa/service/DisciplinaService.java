package br.com.romanos.marcossa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.romanos.marcossa.domain.Disciplina;
import br.com.romanos.marcossa.domain.dto.DisciplinaDTO;

@Service
public class DisciplinaService {
	
	List<Disciplina> disciplinas = new ArrayList<>();
	
	public List<DisciplinaDTO> findAll() {
		List<Disciplina> list = disciplinas;
		return list.stream().map(x -> new DisciplinaDTO(x.getId(), x.getNome())).collect(Collectors.toList());
	}

	public Disciplina findById(Integer id) {
		Optional<Disciplina> disciplina = disciplinas.stream().filter(x -> x.getId() == id).findFirst();
		return disciplina.orElse(null);
	}
	
	public Disciplina insert(Disciplina obj) {
		obj.setId(getMaxId() + 1);
		disciplinas.add(obj);
		return obj;
	}

	public void salvar(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}
	
	public Disciplina fromDTO (DisciplinaDTO dto) {
		Disciplina disciplina = new Disciplina(dto.getId() ,dto.getNome());
		return disciplina;
	}

	private Integer getMaxId(){
		Integer id = 0;
		for ( Disciplina d : disciplinas ) {
			if (d.getId() != null && d.getId().compareTo(id) > 0 ){
				id = d.getId();
			}
		}
		return id;
	}
}
