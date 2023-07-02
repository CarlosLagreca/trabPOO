package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import exceptions.OperationNotAllowedException;
import model.Acomodacao;
import model.Hospedagem;
import model.Hospede;
import model.IHospede;
import model.Item;
import model.Pagamento.ETipoPagamento;
import util.Time;

public class HospedagemController implements Serializable{
	
	private static final long serialVersionUID = -2986449868123120251L;
	private Map<Integer, Hospedagem> hospedagens;
	private Map<String, Hospedagem> oldHospedagens;
	
	public HospedagemController() {
		hospedagens = new TreeMap<>();
		oldHospedagens = new TreeMap<>();
	}
	
	public void criarHospedagem(String numeroAcomodacao, String cpfHospede, String[] acompanhantes) throws Exception {
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
		
		MainController.save();
	}
	
	public void addItemConta(int numeroAcomodacao, String categoria, String codigo, int quantidade) throws Exception {
		ItemController itemcontroller = MainController.getItemController();
		
		//Pegando objetos
		Item item = itemcontroller.getItem(categoria, Long.parseLong(codigo));
		Hospedagem hospedagem = hospedagens.get(numeroAcomodacao);
		if(hospedagem == null) {
			throw new NullPointerException("Não foi possível acessar hospedagem.");
		}
		
		// Inserindo item na conta
		hospedagem.getConta().addItem(item, quantidade);
		
		MainController.save();
	}
	public void realizarPagamento(ETipoPagamento tipo, double valor, int numApt) throws Exception{
		Hospedagem hospedagem = hospedagens.get(numApt);
		hospedagem.addPagamento(tipo, valor);
		System.out.println("pagamento feito!");
		MainController.save();

	}
	
	public Hospedagem getHospedagem(int id) {
		return hospedagens.get(id);
	}
	
//	public double getValorItens(int id) {
//		Hospedagem hospedagem = hospedagens.get(id);
//		return hospedagem.getValorItens();	
//	}
	
	public double getValorTotal(int idApartamento) {
		Hospedagem hospedagem = hospedagens.get(idApartamento);
		
		return hospedagem.getValorTotal();
	}
	
	public String[][] getHospedagensAtuais(){
		List<String[]> table = new ArrayList<String[]>();
		for(Hospedagem hospedagem : hospedagens.values()) {
			String[] linha = {Integer.toString(hospedagem.getAcomodacao().getNumero()), hospedagem.getId(), hospedagem.getHospede().getNome(), Time.formatTime(hospedagem.getCheckin())};
			table.add(linha);
		}
		
		return table.toArray(new String[0][0]);
	}
	
	public String[][] getHospedagensAntigas(){
		List<String[]> table = new ArrayList<String[]>();
		for(Hospedagem hospedagem : oldHospedagens.values()) {
			String[] linha = {Integer.toString(hospedagem.getAcomodacao().getNumero()), hospedagem.getId(), hospedagem.getHospede().getNome(), Time.formatTime(hospedagem.getCheckin()), Time.formatTime(hospedagem.getCheckout())};
			table.add(linha);
		}
		
		return table.toArray(new String[0][0]);
	}
	
	public void realizarCheckout(int numeroApt) throws OperationNotAllowedException {
		hospedagens.get(numeroApt).realizarCheckout();
		oldHospedagens.put(hospedagens.get(numeroApt).getId(), hospedagens.get(numeroApt));
		hospedagens.remove(numeroApt);
		MainController.save();
	}
	
	public void retirarItemHospedagem(int item, int numApt) {
		if (hospedagens.get(numApt) == null)
			throw new NullPointerException("Não há hospedagem nesse apartamento!");
		hospedagens.get(numApt).removerItemConta(item);
		MainController.save();
	}
	
	public String[] getDadosHospedagem(int x) {
		return hospedagens.get(x).listarDados();
	}

	public String[] getDadosHospedagem(String x) {
		return oldHospedagens.get(x).listarDados();
	}
	
	public String[][] getItensHospedagem(int apt){
		return hospedagens.get(apt).getItensHospedagem();
	}
	
	public String[][] getItensHospedagem(String id){
		return oldHospedagens.get(id).getItensHospedagem();
	}
	
	public String[][] getAcompanhantesHospedagem(int apt){
		return hospedagens.get(apt).getAcompanhantesHospedagem();
	}
	
	public String[][] getAcompanhantesHospedagem(String id){
		return oldHospedagens.get(id).getAcompanhantesHospedagem();
	}
}
