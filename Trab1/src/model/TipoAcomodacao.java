package model;

import java.io.Serializable;

import exceptions.CannotCreateModelException;

public class TipoAcomodacao implements Serializable {
	private static final long serialVersionUID = -7743288878774212647L;
	private final String nome;
	private double tarifaDiaria;
	private double adicionalAcompanhante;

	public TipoAcomodacao(String nome, double tarifaDiaria, double adicionalAcompanhante)
			throws CannotCreateModelException {
		if (nome.length() < 1)
			throw new CannotCreateModelException("Nome inválido.");
		if (tarifaDiaria < 0)
			throw new CannotCreateModelException("Tarifa diária inválida.");
		if (adicionalAcompanhante < 0)
			throw new CannotCreateModelException("Valor adicional acompanhante inválido.");
		this.nome = nome;
		this.tarifaDiaria = tarifaDiaria;
		this.adicionalAcompanhante = adicionalAcompanhante;
	}

	public double getTarifaDiaria() {
		return tarifaDiaria;
	}

	public void setTarifaDiaria(double tarifaDiaria) {
		if (tarifaDiaria < 0)
			throw new IllegalArgumentException("Tarifa diária inválida.");
		this.tarifaDiaria = tarifaDiaria;
	}

	public double getAdicionalAcompanhante() {
		return adicionalAcompanhante;
	}

	public void setAdicionalAcompanhante(double adicionalAcompanhante) {
		if (adicionalAcompanhante < 0)
			throw new IllegalArgumentException("Valor adicional acompanhante inválido.");
		this.adicionalAcompanhante = adicionalAcompanhante;
	}

	public String getNome() {
		return nome;
	}

}
