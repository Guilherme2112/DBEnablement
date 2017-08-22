package br.com.fiap.bean;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.bo.AlunoBO;
import br.com.fiap.entity.Aluno;
import br.com.fiap.exception.CommitErrorException;

@ManagedBean
@SessionScoped
public class AlunoBean {

	private Aluno aluno;
	private AlunoBO bo;

	@PostConstruct
	private void init(){
		aluno = new Aluno();
		aluno.setDataNascimento(Calendar.getInstance());
		bo = new AlunoBO();
	}

	public String alterar(){
		FacesMessage msg;
		try {
			bo.atualizar(aluno);
			msg = new FacesMessage("Atualizado!");
		} catch (CommitErrorException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");			
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "lista-aluno?faces-redirect=true";
	}
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			bo.cadastrar(aluno);
			msg = new FacesMessage("Cadastrado!");
		} catch (CommitErrorException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");			
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "aluno?faces-redirect=true";
	}
	
	
	public void uploadFile(FileUploadEvent event){
		/*
		 * Só no caso do campo foto armazanar uma string com nome de arquivo
		String arquivo = event.getFile().getFileName();
		try{
		File file = new File("C:\\temp\\",arquivo);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(event.getFile().getContents());
		fos.close();
		aluno.setFoto(arquivo);
		}catch(Exception e){
			System.out.println("Algo errado não está certo.");
			e.printStackTrace();
		}
		*/
		//grava a imagem
		try {
			aluno.setFoto(IOUtils.toByteArray(event.getFile().getInputstream()));
			} catch (IOException e) {
			e.printStackTrace();
			}
		}

	private StreamedContent foto;
	public StreamedContent getFoto() {
	/*
	 * só em caso da foto armazenar string, como antes.
	 
	FacesContext context = FacesContext.getCurrentInstance();
	DefaultStreamedContent content = new DefaultStreamedContent();
	content.setContentType("image/jpg");
	try {
	if (context.getRenderResponse() || aluno.getFoto() == null) {
	content.setStream(new FileInputStream("C:\\temp\\semFoto.png"));
	} else {
	content.setStream(new FileInputStream("C:\\temp\\" + aluno.getFoto()));
	}
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}
	return content;
	*/
		
		FacesContext context = FacesContext.getCurrentInstance();
		DefaultStreamedContent content = new DefaultStreamedContent();
		content.setContentType("image/jpg");
		try{
		if (context.getRenderResponse() || aluno.getFoto() == null){
		content.setStream(new FileInputStream("C:\\temp\\semFoto.png"));
		}else{
		content.setStream(new ByteArrayInputStream(aluno.getFoto()));
		}
		}catch(Exception e){
		e.printStackTrace();
		}
		return content;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
