package model;

import exceptions.OperationNotAllowedException;
import model.Acomodacao.EEstadoOcupacao;

public interface IAcomodacao {
	public int getNumero();
	public int getOcupacaoMax();
	public void setEstadoOcupacao(EEstadoOcupacao e) throws OperationNotAllowedException;
	public EEstadoOcupacao getEstadoOcupacao();
	public String getTipo();
	public double getTarifaDiaria();
	public double getAdicionalAcompanhante();
}
