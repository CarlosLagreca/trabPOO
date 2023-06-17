package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Hospedagem implements Serializable {
	private static final long serialVersionUID = 7345409444938260273L;
	private int inicioCheckin = 13;
	private int limiteCheckout = 12;
	private final String id;
	private Date checkin;
	private IConta conta;
	private Date checkout;
	private IHospede hospede;
	private List<IHospede> acompanhantes;
	private IAcomodacao acomodacao;

	public Hospedagem(int inicioCheckin, int limiteCheckout, String id) {
		this.inicioCheckin = inicioCheckin;
		this.limiteCheckout = limiteCheckout;
		this.id = id;
		this.checkin = new Date();
	}

	public void addAcompanhantes(List<IHospede> l) {
		acompanhantes.addAll(l);
	}

	public StringBuilder listar() {
		return null;
	}
}
