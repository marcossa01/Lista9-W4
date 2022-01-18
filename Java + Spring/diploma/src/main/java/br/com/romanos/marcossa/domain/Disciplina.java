package br.com.romanos.marcossa.domain;

import java.io.Serializable;

public class Disciplina implements Serializable {
	private static final long serialVersionUID = 7758787931958505916L;

	private Integer id;
	private String nome;
	
	public Disciplina() {
	}
	
	public Disciplina(Integer id, String nome) {
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
	
	@Override
	public String toString() {
		return "Disciplina: " + nome + "; Nota";
	}

}
