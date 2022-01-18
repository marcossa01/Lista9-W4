package br.com.romanos.marcossa.config;

import br.com.romanos.marcossa.domain.Aluno;
import br.com.romanos.marcossa.domain.Disciplina;
import br.com.romanos.marcossa.service.AlunoService;
import br.com.romanos.marcossa.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private DisciplinaService disciplinaService;

	@Autowired
	private AlunoService alunoService;
	
	@Override
	public void run(String... args) throws Exception {

		Disciplina d1 = new Disciplina(1, "Matemática");
		disciplinaService.salvar(d1);

		Disciplina d2 = new Disciplina(2, "Português");
		disciplinaService.salvar(d2);

		Disciplina d3 = new Disciplina(3, "Geografia");
		disciplinaService.salvar(d3);

		Disciplina d4 = new Disciplina(4, "Historia");
		disciplinaService.salvar(d4);

		Disciplina d5 = new Disciplina(5, "Artes");
		disciplinaService.salvar(d5);

		Disciplina d6 = new Disciplina(6, "Sociologia");
		disciplinaService.salvar(d6);


		Aluno a1 = new Aluno(1, "Marcos Vinicius");
		alunoService.salvar(a1);

		Aluno a2 = new Aluno(2, "Leonardo Victor");
		alunoService.salvar(a2);

		Aluno a3 = new Aluno(3, "Arthur Gabriel");
		alunoService.salvar(a3);

		Aluno a4 = new Aluno(4, "Maria Fernanda");
		alunoService.salvar(a4);

		Aluno a5 = new Aluno(5, "Gustavo Henrique");
		alunoService.salvar(a5);

		a1.getListaDisciplinas().put(d1, 10.0);
		a1.getListaDisciplinas().put(d2, 5.5);
		a1.getListaDisciplinas().put(d3, 7.0);

		a2.getListaDisciplinas().put(d1, 5.0);
		a2.getListaDisciplinas().put(d2, 8.5);
		a2.getListaDisciplinas().put(d3, 1.5);
		
	}

}
