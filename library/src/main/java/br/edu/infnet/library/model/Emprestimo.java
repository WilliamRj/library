package br.edu.infnet.library.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
public class Emprestimo {

	@Id @GeneratedValue @NonNull
	private Integer codigo_emprestimo;
	
	@NonNull
	private Integer codigo_livro;
	
	@NonNull
	private Integer codigo_cliente;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataIniEmprestimo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataFimEmprestimo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataRetornada;
	
	private Double multa;
	
	public Emprestimo() {
		
	}

	public Emprestimo(LocalDate dataIniEmprestimo, LocalDate dataFimEmprestimo, LocalDate dataRetornada, Double multa) {
		super();
		this.dataIniEmprestimo = dataIniEmprestimo;
		this.dataFimEmprestimo = dataFimEmprestimo;
		this.dataRetornada = dataRetornada;
		this.multa = multa;
	}

	public Integer getCodigo_emprestimo() {
		return codigo_emprestimo;
	}

	public void setCodigo_emprestimo(Integer codigo_emprestimo) {
		this.codigo_emprestimo = codigo_emprestimo;
	}

	public LocalDate getDataIniEmprestimo() {
		return dataIniEmprestimo;
	}

	public void setDataIniEmprestimo(LocalDate dataIniEmprestimo) {
		this.dataIniEmprestimo = dataIniEmprestimo;
	}

	public LocalDate getDataFimEmprestimo() {
		return dataFimEmprestimo;
	}

	public void setDataFimEmprestimo(LocalDate dataFimEmprestimo) {
		this.dataFimEmprestimo = dataFimEmprestimo;
	}

	public LocalDate getDataRetornada() {
		return dataRetornada;
	}

	public void setDataRetornada(LocalDate dataRetornada) {
		this.dataRetornada = dataRetornada;
	}

	public Double getMulta() {
		return multa;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}

	public Integer getCodigo_livro() {
		return codigo_livro;
	}

	public void setCodigo_livro(Integer codigo_livro) {
		this.codigo_livro = codigo_livro;
	}

	public Integer getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Integer codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

}
