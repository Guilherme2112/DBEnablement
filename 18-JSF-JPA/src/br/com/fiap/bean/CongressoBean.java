package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.CongressoBO;
import br.com.fiap.entity.Congresso;
import br.com.fiap.exception.CommitErrorException;


@ManagedBean
public class CongressoBean {
	private Congresso congresso;
	private int codigo;
	private CongressoBO bo;
	
	@PostConstruct
	public void init(){
		congresso = new Congresso();	
		congresso.setData(Calendar.getInstance());

	}
	
	public void c(){
		FacesMessage msg;
		try{
		msg = new FacesMessage("Sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		bo.cadastrar(congresso);
		}catch(Exception e){
			msg = new FacesMessage("Ocorreu um erro.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void r(){
		
		bo.buscarPorCodigo(codigo);
	}
	public void u(){
		try {
			bo.atualizar(congresso);
		} catch (CommitErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void d(){
			try {
				bo.remover(codigo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	public void l(){
		bo.listar();
	}
	public Congresso getCongresso() {
		return congresso;
	}
	public void setCongresso(Congresso congresso) {
		this.congresso = congresso;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
