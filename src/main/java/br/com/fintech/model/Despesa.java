package br.com.fintech.model;

import java.io.Serializable;

public class Despesa {
    private int codigo;
    private float valor;
    private String nome;

	private String email;

    public Despesa() {

    }

	public Despesa(int codigo, float valor, String nome) {
		super();
		this.codigo = codigo;
		this.valor = valor;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Despesa{" +
				"codigo=" + codigo +
				", valor=" + valor +
				", nome='" + nome + '\'' +
				", userName='" + email + '\'' +
				'}';
	}
}
