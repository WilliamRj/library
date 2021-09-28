package br.edu.infnet.library.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Livro {
	
	@Id @GeneratedValue
	private Integer codigo_livro;
	
	private String titulo_livro;
	
	/**@ManyToMany*/
	private String autor_livro;
	
	/**@ManyToMany*/
	private String categoria_livro;
	
	private Date data_publicacao;
	
	public Livro() {
		
	}

	public Livro(String titulo_livro, String autor_livro, String categoria_livro, Date data_publicacao) {
		super();
		this.titulo_livro = titulo_livro;
		this.autor_livro = autor_livro;
		this.categoria_livro = categoria_livro;
		this.data_publicacao = data_publicacao;
	}

	public Integer getCodigo_livro() {
		return codigo_livro;
	}

	public void setCodigo_livro(Integer codigo_livro) {
		this.codigo_livro = codigo_livro;
	}

	public String getTitulo_livro() {
		return titulo_livro;
	}

	public void setTitulo_livro(String titulo_livro) {
		this.titulo_livro = titulo_livro;
	}

	public String getAutor_livro() {
		return autor_livro;
	}

	public void setAutor_livro(String autor_livro) {
		this.autor_livro = autor_livro;
	}

	public String getCategoria_livro() {
		return categoria_livro;
	}

	public void setCategoria_livro(String categoria_livro) {
		this.categoria_livro = categoria_livro;
	}

	public Date getData_publicacao() {
		return data_publicacao;
	}

	public void setData_publicacao(Date data_publicacao) {
		this.data_publicacao = data_publicacao;
	}	

}
