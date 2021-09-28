package br.edu.infnet.library.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Emprestimo {

	@Id @GeneratedValue
	private Integer codigo_emprestimo;
	
	private Date dataIniEmprestimo;
	private Date dataFimEmprestimo;
	private Date dataRetornada;
	private Double multa;
	
	public Emprestimo() {
		
	}

	public Emprestimo(Date dataIniEmprestimo, Date dataFimEmprestimo, Date dataRetornada, Double multa) {
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

	public Date getDataIniEmprestimo() {
		return dataIniEmprestimo;
	}

	public void setDataIniEmprestimo(Date dataIniEmprestimo) {
		this.dataIniEmprestimo = dataIniEmprestimo;
	}

	public Date getDataFimEmprestimo() {
		return dataFimEmprestimo;
	}

	public void setDataFimEmprestimo(Date dataFimEmprestimo) {
		this.dataFimEmprestimo = dataFimEmprestimo;
	}

	public Date getDataRetornada() {
		return dataRetornada;
	}

	public void setDataRetornada(Date dataRetornada) {
		this.dataRetornada = dataRetornada;
	}

	public Double getMulta() {
		return multa;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}
	
	
}
