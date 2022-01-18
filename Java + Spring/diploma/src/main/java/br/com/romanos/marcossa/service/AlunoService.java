package br.com.romanos.marcossa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.romanos.marcossa.domain.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.romanos.marcossa.domain.Aluno;
import br.com.romanos.marcossa.domain.dto.AlunoDTO;

@Service
public class AlunoService {

	@Autowired
	private DisciplinaService disciplinaService;
	
	List<Aluno> alunos = new ArrayList<>();
	
	public List<AlunoDTO> findAll() {
		List<Aluno> list = alunos;
		return list.stream().map(x -> new AlunoDTO(x.getId(), x.getNome())).collect(Collectors.toList());
	}
	
	public Aluno insert(Aluno obj) {
		obj.setId(getMaxId() + 1);
		alunos.add(obj);
		return obj;
	}

	public Aluno findById(Integer id) {
		Optional<Aluno> aluno = alunos.stream().filter(x -> x.getId() == id).findFirst();
		return aluno.orElse(null);
	}
	
	public Aluno fromDTO(AlunoDTO objDto) {
		Aluno aluno = new Aluno(objDto.getId() ,objDto.getNome());
		return aluno;
	}

	public void salvar(Aluno aluno) {
		alunos.add(aluno);
	}

	private Integer getMaxId() {
		Integer id = 0;
		for (Aluno a : alunos) {
			if (a.getId() != null && a.getId().compareTo(id) > 0) {
				id = a.getId();
			}
		}
		return id;
	}
}
