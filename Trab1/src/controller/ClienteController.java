package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Hospede;

public class ClienteController implements Serializable {
	private static final long serialVersionUID = 2593105786319947110L;
	
	// TODO: Trocar forma da lista para ser mais fácil a pesquisa e remoção.
	private List<Hospede> listaHospedes = new ArrayList<Hospede>();

	// TODO: Fazer tratamento caso cliente já esteja cadastrado;
	public void cadastrarCliente(String nome, long cpf, long telefone, String email) {
		try {
			listaHospedes.add(new Hospede(cpf, nome, email, telefone));
			MainController.save();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
