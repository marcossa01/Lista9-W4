package br.com.romanos.marcossa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aluno implements Serializable {
	private static final long serialVersionUID = -4810175054610111413L;

	private Integer id;
	private String nome;
	
	private Map<Disciplina, Double> listaDisciplinas = new HashMap<>();
	
	public Aluno() {
		
	}
	
	public Aluno(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<Disciplina, Double> getListaDisciplinas() {
		return listaDisciplinas;
	}

	@Override
	public String toString() {
		return "Nome do Aluno: " + nome;
	}

}
