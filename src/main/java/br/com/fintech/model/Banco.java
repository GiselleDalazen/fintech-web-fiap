package br.com.fintech.model;

import java.io.Serializable;

public class Banco implements Serializable{
    private int numero;
    private String nome;
    
    public Banco() {

    }

	public Banco(int numero, String nome) {
		super();
		this.numero = numero;
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Banco{" +
				"numero=" + numero +
				", nome='" + nome + '\'' +
				'}';
	}
}
