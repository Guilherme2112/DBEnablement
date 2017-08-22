package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.AlunoBO;
import br.com.fiap.entity.Aluno;

@ManagedBean
@ViewScoped
public class ListaAlunoBean {

	private List<Aluno> lista;

	private AlunoBO bo;
	
	private String nome;
	
	private int rm;

	public String excluir(){
		FacesMessage msg;
		try {
			bo.remover(rm);
			msg = new FacesMessage("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "lista-aluno?faces-redirect=true";
	}
	
	@PostConstruct
	private void init(){
		bo = new AlunoBO();
		lista = bo.listar();
	}
	
	public List<String> completar(String texto){
		return bo.completar(texto);
	}
	
	public void buscar(){
		lista = bo.buscarPorNome(nome);
	}
	
	public List<Aluno> getLista() {
		return lista;
	}

	public void setLista(List<Aluno> lista) {
		this.lista = lista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}
	
}