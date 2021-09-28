package br.edu.infnet.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id @GeneratedValue
	private Integer codigo_categoria;
	
	String nome;
	
	public Categoria() {
		
	}

	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getCodigo_categoria() {
		return codigo_categoria;
	}

	public void setCodigo_categoria(Integer codigo_categoria) {
		this.codigo_categoria = codigo_categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
