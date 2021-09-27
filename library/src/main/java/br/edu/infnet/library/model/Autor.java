package br.edu.infnet.library.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Autor {
	
	@Id @GeneratedValue
	private Integer codigo_autor;
	
	String nome;
	String sobrenome;
	
	public Autor() {
		
	}
	
	public Autor(Integer codigo_autor, String nome, String sobrenome) {
		super();
		this.codigo_autor = codigo_autor;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	

}
