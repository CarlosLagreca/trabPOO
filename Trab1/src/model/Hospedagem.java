package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import model.Pagamento.ETipoPagamento;

//TODO Revisar Model de Hospedagem
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

	public double getValorTotal() {
		return getValorItens() + getValorAcompanhantes() + getValorDiarias();
	}

	public double getValorDiarias() {
		return checkin.compareTo(new Date()) * acomodacao.getTarifaDiaria();
	}

	public double getValorAcompanhantes() {
		return acomodacao.getAdicionalAcompanhante() * acompanhantes.size();
	}

	public double getValorItens() {
		return conta.getTotal();
	}

	public double getValorPago() {
		double total = 0;
		for (Pagamento x : pagamento) {
			total += x.getValor();
		}
		return total;
	}

	public void addAcompanhantes(List<IHospede> list) {
		acompanhantes.addAll(list);
	}

	public String[] listarDados() {
		List<String> lista = new ArrayList<String>();
		lista.add(Integer.toString(acomodacao.getNumero()));
		lista.add(hospede.getNome());
		lista.add(Integer.toString(checkin.compareTo(checkout)));
		lista.add(acomodacao.getTipo());
		lista.add(Long.toString(hospede.getCpf()));
		lista.add(Integer.toString(acompanhantes.size()));
		lista.add(Double.toString(getValorDiarias()));
		lista.add(Double.toString(getValorAcompanhantes()));
		lista.add(Double.toString(getValorItens()));
		lista.add(Double.toString(getValorTotal()));
		lista.add(Double.toString(getValorPago()));
		return (String[]) lista.toArray();
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
