package br.edu.infnet.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {
	
	@Id @GeneratedValue
	private Integer codigo_autor;
	
	String nome;
	String sobrenome;
	
	public Autor() {
		
	}
	
	public Autor(String nome, String sobrenome) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public Integer getCodigo_autor() {
		return codigo_autor;
	}

	public void setCodigo_autor(Integer codigo_autor) {
		this.codigo_autor = codigo_autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	

}
