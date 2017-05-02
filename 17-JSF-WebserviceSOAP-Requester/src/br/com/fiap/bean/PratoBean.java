package br.com.fiap.bean;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.PratoBOStub;
import br.com.fiap.bo.PratoBOStub.Buscar;
import br.com.fiap.bo.PratoBOStub.BuscarResponse;
import br.com.fiap.bo.PratoBOStub.Cadastrar;
import br.com.fiap.bo.PratoBOStub.Prato;

@ManagedBean
public class PratoBean {
	private Prato prato;
	int codigo;
	@PostConstruct
	private void init(){
		prato = new Prato();
	}
	
	public Prato getPrato() {
		return prato;
	}
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	public void cadastrar(){
		FacesMessage msg = null;
		try{
		PratoBOStub stub = new PratoBOStub();
		Cadastrar params = new Cadastrar();
		params.setPrato(prato);
		stub.cadastrar(params);
		msg = new FacesMessage("Cadastrado!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		}catch(Exception e){
		msg = new FacesMessage("Ocorreu um Erro!");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			e.printStackTrace();
		}
	}
	public void buscar(){
		try{
		PratoBOStub stub = new PratoBOStub();
		Buscar params = new Buscar();
		params.setId(codigo);
		BuscarResponse response = stub.buscar(params);
		prato = response.get_return();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
