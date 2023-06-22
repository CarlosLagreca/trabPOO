package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Acomodacao;
import model.Hospedagem;
import model.Hospede;
import model.IHospede;

public class HospedagemController implements Serializable{

	private static final long serialVersionUID = -2986449868123120251L;
	private Map<String, Hospedagem> hospedagens;
	
	public HospedagemController() {
		hospedagens = new TreeMap<>();
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
		
		hospedagens.put(hospedagem.getId(), hospedagem);
		
	}
	

}
