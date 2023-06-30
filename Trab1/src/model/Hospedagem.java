package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import model.Acomodacao.EEstadoOcupacao;
import model.Pagamento.ETipoPagamento;

//TODO Revisar Model de Hospedagem
public class Hospedagem implements Serializable {
	private static final long serialVersionUID = 7345409444938260273L;
	private int inicioCheckin = 13;
	private int limiteCheckout = 12;
	private final String id = UUID.randomUUID().toString().replace("-", "");
	private LocalDateTime checkin;
	private IConta conta;
	private LocalDateTime checkout;
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
		this.checkin = LocalDateTime.now();
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
		long dias = ChronoUnit.DAYS.between(LocalDateTime.now(), checkin);
		if (LocalDateTime.now().getHour() > limiteCheckout && checkin.getHour() < inicioCheckin)
			return dias * acomodacao.getTarifaDiaria() + 2;
		else if(LocalDateTime.now().getHour() > limiteCheckout)
			return dias * acomodacao.getTarifaDiaria() + 1;
		else if(checkin.getHour() < inicioCheckin)
			return dias * acomodacao.getTarifaDiaria() + 1;
		else if(dias == 0)
			return acomodacao.getTarifaDiaria();
		else 
			return dias * acomodacao.getTarifaDiaria();
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
		lista.add(Long.toString(ChronoUnit.DAYS.between(LocalDateTime.now(), checkin)));
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
	
	public String[][] getItensHospedagem() {
		return conta.getItens();
	}
	
	public String[][] getAcompanhantesHospedagem(){
		List<String[]> table = new ArrayList<String[]>();
		for (IHospede acompanhante : acompanhantes) {
			String[] linha = {acompanhante.getNome(), Long.toString(acompanhante.getCpf()), Long.toString(acompanhante.getTelefone()), acompanhante.getEmail()};
			table.add(linha);
		}
		return table.toArray(new String[0][0]);
	}

	public String getId() {
		return id;
	}
	
	public LocalDateTime getCheckin() {
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
	
	public LocalDateTime getCheckout() {
		return checkout;
	}
	
	public void realizarCheckout() {
		// TODO: Verificar questão do limite checkout
		// TODO: Verificar se ja está corretamente pago
		checkout = LocalDateTime.now();
		acomodacao.setEstadoOcupacao(EEstadoOcupacao.MANUTENCAO);
	}
	
	
}
