package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.entity.Aluno;

public class AlunoDAOImpl extends GenericDAOImpl<Aluno, Integer>
	implements AlunoDAO{

	public AlunoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public boolean validarEmailExistente(String email) {
		return em.createQuery("select count(a) from Aluno "
				+ "a where a.email = :e", Long.class)
				.setParameter("e", email)
				.getSingleResult() > 0;
	}

	@Override
	public List<Aluno> buscarPorNome(String nome) {
		return em.createQuery("from Aluno a where "
				+ "upper(a.nome) like upper(:n)",Aluno.class)
				.setParameter("n", "%"+nome+"%")
				.getResultList();
	}

	@Override
	public List<String> completar(String texto) {
		return em.createQuery("select a.nome from Aluno a "
				+ "where upper(a.nome) like upper(:n)"
				,String.class)
				.setParameter("n", "%"+texto+"%")
				.getResultList();
	}

	@Override
	public long contarPorRating(int inicio, int fim) {		
		return em.createQuery("select count(a) from "
				+ "Aluno a where a.rating between :i and :f"
				,Long.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getSingleResult();
	}

	@Override
	public long contarPorMes(int mes) {		
		return em.createQuery("select count(a) from "
				+ "Aluno a where month(a.dataNascimento) = :d"
				,Long.class)
				.setParameter("d", mes)
				.getSingleResult();
	}

}





