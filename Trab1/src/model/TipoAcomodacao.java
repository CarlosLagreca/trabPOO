package model;

import java.io.Serializable;

public class TipoAcomodacao implements Serializable {
	private static final long serialVersionUID = -7743288878774212647L;
	private final String nome;
	private double tarifaDiaria;
	private double adicionalAcompanhante;

	public TipoAcomodacao(String nome, double tarifaDiaria, double adicionalAcompanhante) {
		this.nome = nome;
		this.tarifaDiaria = tarifaDiaria;
		this.adicionalAcompanhante = adicionalAcompanhante;
	}

	public double getTarifaDiaria() {
		return tarifaDiaria;
	}

	public void setTarifaDiaria(double tarifaDiaria) {
		this.tarifaDiaria = tarifaDiaria;
	}

	public double getAdicionalAcompanhante() {
		return adicionalAcompanhante;
	}

	public void setAdicionalAcompanhante(double adicionalAcompanhante) {
		this.adicionalAcompanhante = adicionalAcompanhante;
	}

	public String getNome() {
		return nome;
	}

}
