package br.com.romanos.marcossa.domain.dto;

import java.io.Serializable;
import java.util.List;

import br.com.romanos.marcossa.domain.Disciplina;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	public AlunoDTO() {
	}

	public AlunoDTO(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
