package model;

public class Acomodacao implements IAcomodacao {
	private final int numero;
	private final int ocupacaoMax;
	private EEstadoOcupacao estadoOcupacao;
	private TipoAcomodacao tipo;

	public Acomodacao(int numero, int ocupacaoMax, TipoAcomodacao tipo) {
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
	public void setEstadoOcupacao(EEstadoOcupacao estadoOcupacao) {
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
