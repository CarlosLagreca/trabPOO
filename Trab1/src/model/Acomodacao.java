package model;

import java.io.Serializable;

import exceptions.CannotCreateModelException;
import exceptions.OperationNotAllowedException;

public class Acomodacao implements IAcomodacao, Serializable{
	private static final long serialVersionUID = -4335473616730693277L;
	private final int numero;
	private final int ocupacaoMax;
	private EEstadoOcupacao estadoOcupacao;
	private TipoAcomodacao tipo;

	public Acomodacao(int numero, int ocupacaoMax, TipoAcomodacao tipo) throws CannotCreateModelException {
		if(numero <= 0) {
			throw new CannotCreateModelException("Numero inválido.");
		}
		if(tipo == null) {
			throw new CannotCreateModelException("Tipo não pode ser null.");
		}
		if(ocupacaoMax < 1) {
			throw new CannotCreateModelException("Ocupação máxima inválida.");
		}
		this.numero = numero;
		this.ocupacaoMax = ocupacaoMax;
		this.estadoOcupacao = EEstadoOcupacao.DISPONIVEL;
		this.tipo = tipo;
	}

	public enum EEstadoOcupacao {
		DISPONIVEL, OCUPADO, MANUTENCAO
	}

	@Override
	public int getNumero() {
		return numero;
	}

	@Override
	public int getOcupacaoMax() {
		return ocupacaoMax;
	}

	@Override
	public void setEstadoOcupacao(EEstadoOcupacao estadoOcupacao) throws OperationNotAllowedException {
		if(this.estadoOcupacao == EEstadoOcupacao.OCUPADO && estadoOcupacao != EEstadoOcupacao.MANUTENCAO)
			throw new OperationNotAllowedException("Acomodação atualmente ocupada!");
		this.estadoOcupacao = estadoOcupacao;
	}

	@Override
	public EEstadoOcupacao getEstadoOcupacao() {
		return estadoOcupacao;
	}

	@Override
	public String getTipo() {
		return tipo.getNome();
	}
	
	@Override
	public double getTarifaDiaria() {
		return tipo.getTarifaDiaria();
	}

	@Override
	public double getAdicionalAcompanhante() {
		return tipo.getAdicionalAcompanhante();
	}

}
