package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import model.Acomodacao.EEstadoOcupacao;
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
		long periodo = getDateDiff(checkin, new Date(), TimeUnit.DAYS);
		if (periodo < 1) {
			return acomodacao.getTarifaDiaria();
		}

		return periodo * acomodacao.getTarifaDiaria();
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
		lista.add(Long.toString(getDateDiff(checkin, new Date(), TimeUnit.DAYS)));
		lista.add(acomodacao.getTipo());
		lista.add(Long.toString(hospede.getCpf()));
		lista.add(Integer.toString(acompanhantes.size()));
		lista.add(Double.toString(getValorDiarias()));
		lista.add(Double.toString(getValorAcompanhantes()));
		lista.add(Double.toString(getValorItens()));
		lista.add(Double.toString(getValorTotal()));
		lista.add(Double.toString(getValorPago()));
		return lista.toArray(new String[0]);
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
	
	public void realizarCheckout() {
		// TODO: Verificar questão do limite checkout
		// TODO: Verificar se ja está corretamente pago
		checkout = new Date();
		acomodacao.setEstadoOcupacao(EEstadoOcupacao.MANUTENCAO);
	}
	

	// TODO: Criar package utilities
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

}
