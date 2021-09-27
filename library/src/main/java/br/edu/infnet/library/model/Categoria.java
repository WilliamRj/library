package br.edu.infnet.library.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Categoria {
	
	@Id @GeneratedValue
	private Integer codigo_categoria;
	
	String nome;

}
