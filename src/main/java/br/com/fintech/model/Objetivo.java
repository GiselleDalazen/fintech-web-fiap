package br.com.fintech.model;

import java.io.Serializable;
import java.sql.Date;



public class Objetivo {
	private int codigo;
	private String descricao;
	private double valor;
	private Date data;

	private String email;
	
	
	public Objetivo() {
	
	}

	
	public Objetivo(int codigo, String descricao, double valor, Date data, String email) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.email = email;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Objetivo{" +
				"codigo=" + codigo +
				", descricao='" + descricao + '\'' +
				", valor=" + valor +
				", data=" + data +
				", email='" + email + '\'' +
				'}';
	}
}


	


