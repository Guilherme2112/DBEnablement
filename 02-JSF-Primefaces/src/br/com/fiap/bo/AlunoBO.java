package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.impl.AlunoDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitErrorException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class AlunoBO {
	private EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();

	public void cadastrar(Aluno aluno) throws CommitErrorException {
		EntityManager em = factory.createEntityManager();
		AlunoDAO dao = new AlunoDAOImpl(em);
		try {
			dao.cadastrar(aluno);
			dao.commit();
		} catch (Exception e) {
			throw new CommitErrorException(e);
		} finally {
			em.close();
		}
	}

	public void atualizar(Aluno aluno) throws CommitErrorException {
		EntityManager em = factory.createEntityManager();
		AlunoDAO dao = new AlunoDAOImpl(em);
		try {
			dao.atualizar(aluno);
			dao.commit();
		} catch (Exception e) {
			throw new CommitErrorException(e);
		} finally {
			em.close();
		}
	}

	public List<Aluno> listar() {
		EntityManager em = factory.createEntityManager();
		AlunoDAO dao = new AlunoDAOImpl(em);
		List<Aluno> lista = dao.listar();
		em.close();
		return lista;
	}

	public Aluno buscarPorRm(int codigo) {
		EntityManager em = factory.createEntityManager();
		AlunoDAO dao = new AlunoDAOImpl(em);
		Aluno aluno = dao.buscar(codigo);
		em.close();
		return aluno;
	}
	
	public void remover(int codigo) throws CodigoInvalidoException,CommitErrorException{
		EntityManager em = factory.createEntityManager();
		AlunoDAO dao = new AlunoDAOImpl(em);
		try {
			dao.excluir(codigo);
			dao.commit();
		} catch (CommitErrorException e) {
			e.printStackTrace();
			new CommitErrorException(e);
		}catch (CodigoInvalidoException e) {
				e.printStackTrace();
				new CodigoInvalidoException(e);
		}finally {
			em.close();
		}
	}

	public boolean validarEmailExistente(String email) {
		EntityManager em = factory.createEntityManager();
		AlunoDAO dao = new AlunoDAOImpl(em);
		return dao.validarEmailExistente(email);		
	}

	public List<Aluno> buscarPorNome(String nome) {
		EntityManager em = factory.createEntityManager();
		AlunoDAO dao = new AlunoDAOImpl(em);
		return dao.buscarPorNome(nome);
	}

	public List<String> completar(String texto) {
		EntityManager em = factory.createEntityManager();
		AlunoDAO dao = new AlunoDAOImpl(em);
		return dao.completar(texto);
	}
	
	public long contarPorRating(int inicio, int fim){
		AlunoDAO dao = new AlunoDAOImpl(
							factory.createEntityManager());
		return dao.contarPorRating(inicio, fim);
	}
	
	public long contarPorMes(int mes){
		AlunoDAO dao = new AlunoDAOImpl(
							factory.createEntityManager());
		return dao.contarPorMes(mes);
	}
	
}




