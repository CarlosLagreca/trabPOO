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
import model.IHospede;
import model.Item;
import model.ItemConta;

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
		ItemConta itemconta = new ItemConta(item, quantidade);
		Hospedagem hospedagem = hospedagens.get(numeroAcomodacao);
		if(hospedagem == null) {
			return 3;
		}
		
		// Inserindo item na conta
		hospedagem.getConta().addItem(item, quantidade);
		
		MainController.save();
		
		return 0;
	}
	

}
