package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Acomodacao;
import model.Acomodacao.EEstadoOcupacao;
import model.Hospedagem;
import model.Hospede;
import model.IAcomodacao;
import model.IConta;
import model.IHospede;
import model.Item;
import model.Pagamento;
import model.Pagamento.ETipoPagamento;

public class HospedagemController implements Serializable{
	
	private static final long serialVersionUID = -2986449868123120251L;
	private Map<Integer, Hospedagem> hospedagens;
	private Map<String, Hospedagem> oldHospedagens;
	
	public HospedagemController() {
		hospedagens = new TreeMap<>();
		oldHospedagens = new TreeMap<>();
	}
	
	public void criarHospedagem(String numeroAcomodacao, String cpfHospede, String[] acompanhantes) {
		AptController aptcontroller = MainController.getAptController();
		ClienteController clientecontroller = MainController.getClienteContoller();
		
		Acomodacao acomodacao = aptcontroller.getApartamento(Integer.parseInt(numeroAcomodacao));
		Hospede hospede = clientecontroller.getHospede(Long.parseLong(cpfHospede));
		
		List<IHospede> listaAcompanhantes = new ArrayList<IHospede>();
		for(String cpf : acompanhantes) {
			Hospede acompanhante = clientecontroller.getHospede(Long.parseLong(cpf));
			listaAcompanhantes.add(acompanhante);
		}
		
		Hospedagem hospedagem = new Hospedagem(acomodacao, hospede);
		
		hospedagem.addAcompanhantes(listaAcompanhantes);
		
		hospedagens.put(acomodacao.getNumero(), hospedagem);
		
		acomodacao.setEstadoOcupacao(EEstadoOcupacao.OCUPADO);
		
		MainController.save();
	}
	
	public int addItemConta(int numeroAcomodacao, String categoria, String codigo, int quantidade) {
		ItemController itemcontroller = MainController.getItemController();
		
		//Pegando objetos
		Item item = itemcontroller.getItem(categoria, Long.parseLong(codigo));
		if(item == null) {
			return 2;
		}
		Hospedagem hospedagem = hospedagens.get(numeroAcomodacao);
		if(hospedagem == null) {
			return 3;
		}
		
		// Inserindo item na conta
		hospedagem.getConta().addItem(item, quantidade);
		
		MainController.save();
		
		return 0;
	}
	public void realizarPagamento(ETipoPagamento tipo, double valor, int numApt){
		try {
		Hospedagem hospedagem = hospedagens.get(numApt);
		hospedagem.getPagamento().add(new Pagamento(tipo, valor));
		System.out.println("pagamento feito!");
		MainController.save();
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public Hospedagem getHospedagem(int id) {
		return hospedagens.get(id);
	}
	
	public double getValorItens(int id) {
		Hospedagem hospedagem = hospedagens.get(id);
		IConta conta = hospedagem.getConta();
		List<Pagamento> pagamento = hospedagem.getPagamento();
		double valorPagamento = 0;
		for (Pagamento aux : pagamento) {
			valorPagamento+=aux.getValor();
		}
		//TODO tratar returns negativos
		return conta.getTotal() - valorPagamento;	
	}
	
	public double getValorTotal(int idApartamento, int dias, int acompanhantes) {
		Hospedagem hospedagem = hospedagens.get(idApartamento);
		IAcomodacao apt = hospedagem.getAcomodacao();
		
		return apt.getTarifaDiaria()*dias + apt.getAdicionalAcompanhante()*acompanhantes*dias + getValorItens(idApartamento);
	}
	
	public String[][] getHospedagensAtuais(){
		List<String[]> table = new ArrayList<String[]>();
		for(Hospedagem hospedagem : hospedagens.values()) {
			String[] linha = {Integer.toString(hospedagem.getAcomodacao().getNumero()), hospedagem.getId(), hospedagem.getHospede().getNome()};
			table.add(linha);
		}
		
		return table.toArray(new String[0][0]);
	}
	
	public String[][] getHospedagensAntigas(){
		List<String[]> table = new ArrayList<String[]>();
		for(Hospedagem hospedagem : oldHospedagens.values()) {
			String[] linha = {Integer.toString(hospedagem.getAcomodacao().getNumero()), hospedagem.getId(), hospedagem.getHospede().getNome()};
			table.add(linha);
		}
		
		return table.toArray(new String[0][0]);
	}
	
	public String[] getDadosHospedagem(int x) {
		return hospedagens.get(x).listarDados();
	}

	public String[] getDadosHospedagem(String x) {
		return oldHospedagens.get(x).listarDados();
	}
}
