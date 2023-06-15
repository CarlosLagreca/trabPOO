package controller;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import model.Hospede;

public class CadastroClienteController {
	//TODO Fazer funções para cadastrar um novo hospede com os argumentos recebidos (array de string? varias strings?)
	
	private List<Hospede> listaHospedes = new ArrayList<Hospede>();
	
	public void cancelar(JFrame frame) {
		frame.setVisible(false);
	}
	
	public void cadastrarCliente(String nome, long cpf, long telefone, String email) {
		listaHospedes.add(new Hospede(cpf, nome, email, telefone));
		System.out.println("Cliente cadastrado!");
	}
}
