package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import exceptions.CannotCreateModelException;
import model.Hospede;

public class ClienteController implements Serializable {
	private static final long serialVersionUID = 2593105786319947110L;
	
	private Map<Long, Hospede> listaHospedes = new TreeMap<>();

	public void cadastrarCliente(String nome, long cpf, long telefone, String email) throws Exception {
			if(listaHospedes.get(cpf) != null) {
				throw new CannotCreateModelException("Cpf já cadastrado!");
			}
			Hospede newHospede = new Hospede(cpf, nome, email, telefone);
			listaHospedes.put(newHospede.getCpf(), newHospede);
			MainController.save();
	}
	
	public String[][] getClientes() {
		List<String[]> table = new ArrayList<String[]>();
		for(Hospede cliente : listaHospedes.values()) {
			String[] linha = {cliente.getNome(), Long.toString(cliente.getCpf()), Long.toString(cliente.getTelefone()), cliente.getEmail()};
			table.add(linha);
		}
		
		return table.toArray(new String[0][0]);
	}
	
	public Hospede getHospede(long cpf) {
		
		return listaHospedes.get(cpf);
	}
}
