package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Aluno;

public interface AlunoDAO extends GenericDAO<Aluno, Integer>{

	boolean validarEmailExistente(String email);

	List<Aluno> buscarPorNome(String nome);

	List<String> completar(String texto);
	
	long contarPorRating(int inicio, int fim);
	
	long contarPorMes(int mes);


}
