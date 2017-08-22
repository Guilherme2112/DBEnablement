package br.com.fiap.entity;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.primefaces.event.FileUploadEvent;

@Entity
public class Aluno {

	@Id
	private int rm;
	
	private String nome;
	
	private String cpf;
	
	private Calendar dataNascimento;
	
	private String email;
	
	@Lob
	private byte[] foto;
	
	private int rating;

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	
	
}
