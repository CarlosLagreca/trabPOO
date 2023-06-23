package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import model.Pagamento.ETipoPagamento;

public class Hospedagem implements Serializable {
	private static final long serialVersionUID = 7345409444938260273L;
	private int inicioCheckin = 13;
	private int limiteCheckout = 12;
	private final String id = UUID.randomUUID().toString().replace("-", "");
	private Date checkin;
	private IConta conta;
	private Date checkout;
	private IHospede hospede;
	private List<IHospede> acompanhantes = new ArrayList<IHospede>();
	private IAcomodacao acomodacao;
	
	private List<Pagamento> pagamento = new ArrayList<Pagamento>();
	
	
	
	public List<Pagamento> getPagamento() {
		return pagamento;
	}

	public void addPagamento(ETipoPagamento tipo, double valor) {
		Pagamento pagar = new Pagamento(tipo, valor);
		pagamento.add(pagar);
	}

	public Hospedagem(Acomodacao acomodacao, Hospede hospede) {
		this.checkin = new Date();
		this.conta = new Conta();
		this.acomodacao = acomodacao;
		this.hospede = hospede;
	}
	
	public IConta getConta() {
		return conta;
	}

	public void addAcompanhantes(List<IHospede> list) {
		acompanhantes.addAll(list);
	}

	public StringBuilder listar() {
		return null;
	}

	public String getId() {
		return id;
	}

	public Date getCheckin() {
		return checkin;
	}

	public IHospede getHospede() {
		return hospede;
	}

	public List<IHospede> getAcompanhantes() {
		return acompanhantes;
	}

	public IAcomodacao getAcomodacao() {
		return acomodacao;
	}

}
