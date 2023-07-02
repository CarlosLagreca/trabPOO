package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import exceptions.CannotCreateModelException;
import exceptions.OperationNotAllowedException;
import model.Acomodacao.EEstadoOcupacao;
import model.Pagamento.ETipoPagamento;
import util.Time;

public class Hospedagem implements Serializable {
	private static final long serialVersionUID = 7345409444938260273L;
	private int inicioCheckin = 13;
	private int limiteCheckout = 12;
	//variavel troco de bala foi criada para resolver problemas de arredondamento, então é permitido 
	private final double trocodebala = 0.01;
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

	public void addPagamento(ETipoPagamento tipo, double valor) throws OperationNotAllowedException {
		if(getTotalPago() + trocodebala + valor > getValorTotal())
			throw new OperationNotAllowedException("Valor maior do que a dívida.");
		Pagamento pagar = new Pagamento(tipo, valor);
		pagamento.add(pagar);
	}

	public Hospedagem(Acomodacao acomodacao, Hospede hospede) throws CannotCreateModelException{
		// Verificando se acomodacao pode ser criada
		if(acomodacao == null) {
			throw new CannotCreateModelException("Acomodação não pode ser null");
		}
		if(acomodacao.getEstadoOcupacao() != EEstadoOcupacao.DISPONIVEL) {
			throw new CannotCreateModelException("Acmodação não disponível. (" + acomodacao.getEstadoOcupacao().toString() + ")");
		}
		if(hospede == null) {
			throw new CannotCreateModelException("Hospede não pode ser null.");
		}
		
		this.checkin = LocalDateTime.now();
		this.conta = new Conta();
		this.acomodacao = acomodacao;
		try {
			acomodacao.setEstadoOcupacao(EEstadoOcupacao.OCUPADO);
		} catch(OperationNotAllowedException e) {
			throw new CannotCreateModelException(e.getMessage());
		}
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
			return (dias + 2) * acomodacao.getTarifaDiaria();
		else if(LocalDateTime.now().getHour() > limiteCheckout)
			return (dias + 1) * acomodacao.getTarifaDiaria();
		else if(checkin.getHour() < inicioCheckin)
			return (dias + 1) * acomodacao.getTarifaDiaria();
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
		if(list.contains(null)){
			throw new NullPointerException("Lista de acompanhantes contém null.");
		}
		acompanhantes.addAll(list);
	}
	
	public String[] listarDados() {
		List<String> lista = new ArrayList<String>();
		lista.add(Integer.toString(acomodacao.getNumero()));
		lista.add(hospede.getNome());
		long dias = ChronoUnit.DAYS.between(LocalDateTime.now(), checkin);
		if(dias == 0)
			dias = 1;
		lista.add(Long.toString(dias));
		lista.add(acomodacao.getTipo());
		lista.add(Long.toString(hospede.getCpf()));
		lista.add(Integer.toString(acompanhantes.size()));
		lista.add(Double.toString(getValorDiarias()));
		lista.add(Double.toString(getValorAcompanhantes()));
		lista.add(Double.toString(getValorItens()));
		lista.add(Double.toString(getValorTotal()));
		lista.add(Double.toString(getValorPago()));
		lista.add(Time.formatTime(checkin));
		if(checkout == null) {}
		else lista.add(Time.formatTime(checkout));
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
	
	public double getTotalPago() {
		double totalPago=0;
		for (Pagamento pag : pagamento) {
			totalPago += pag.getValor();
		}
		return totalPago;
	}
	
	public void realizarCheckout() throws OperationNotAllowedException {

		if(getValorTotal() >= getTotalPago() + trocodebala) {
			throw new OperationNotAllowedException("Pagamento pendente.");
		}
		
		checkout = LocalDateTime.now();
		acomodacao.setEstadoOcupacao(EEstadoOcupacao.MANUTENCAO);	
	}
	
	
}
