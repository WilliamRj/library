package br.edu.infnet.library.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Livro {
	
	@Id @GeneratedValue
	private Integer codigo_livro;
	
	private String tituloLivro;
	
	/**@ManyToMany*/
//	@Column(name="autor_livro", length=255)
	private String autorLivro;
	
	/**@ManyToMany*/
	private String categoria_livro;
	
	/**@DateTimeFormat(pattern="dd/MM/yyyy")*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data_publicacao;
	
	public Livro() {
		
	}

	public Livro(String tituloLivro, String autorLivro, String categoria_livro, LocalDate data_publicacao) {
		super();
		this.tituloLivro = tituloLivro;
		this.autorLivro = autorLivro;
		this.categoria_livro = categoria_livro;
		this.data_publicacao = data_publicacao;
	}

	public Integer getCodigo_livro() {
		return codigo_livro;
	}

	public void setCodigo_livro(Integer codigo_livro) {
		this.codigo_livro = codigo_livro;
	}

	public String getCategoria_livro() {
		return categoria_livro;
	}

	public void setCategoria_livro(String categoria_livro) {
		this.categoria_livro = categoria_livro;
	}

	public LocalDate getData_publicacao() {
		return data_publicacao;
	}

	public void setData_publicacao(LocalDate data_publicacao) {
		this.data_publicacao = data_publicacao;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}	

}
