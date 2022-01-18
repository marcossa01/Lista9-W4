package br.com.romanos.marcossa.domain.dto;

import java.io.Serializable;

public class DisciplinaDTO implements Serializable {
	private static final long serialVersionUID = 1678310198310658775L;

	private Integer id;
	private String nome;
	
	public DisciplinaDTO() {
	}

	public DisciplinaDTO(Integer id, String nome) {
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
