package controller;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import model.Acomodacao;
import model.TipoAcomodacao;

public class AptController implements Serializable{

	private static final long serialVersionUID = 2252831249496233980L;
	
	private Map<Integer, Acomodacao> apartamentos;
	
	public AptController() {
		apartamentos = new TreeMap<>();
	}
	
	public void addApartamento(int numero, int ocupacaomax, TipoAcomodacao tipo) {
		Acomodacao apartamento = new Acomodacao(numero, ocupacaomax, tipo);
		apartamentos.put(apartamento.getNumero(), apartamento);
		
		MainController.save();
		
		System.out.println("feito!");
	}
}
