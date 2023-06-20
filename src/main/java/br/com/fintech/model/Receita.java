package br.com.fintech.model;

import java.io.Serializable;

public class Receita {
    private int codigo;
    private String descricao;
    private String recorrencia;
    private float valor;

	private String email;

    public Receita() {

    }

	public Receita(int codigo, String descricao, String recorrencia, float valor, String email) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.recorrencia = recorrencia;
		this.valor = valor;
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

	public String getRecorrencia() {
		return recorrencia;
	}

	public void setRecorrencia(String recorrencia) {
		this.recorrencia = recorrencia;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Receita{" +
				"codigo=" + codigo +
				", descricao='" + descricao + '\'' +
				", recorrencia='" + recorrencia + '\'' +
				", valor=" + valor +
				", email='" + email + '\'' +
				'}';
	}
}
