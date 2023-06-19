package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

import model.Acomodacao;
import model.Acomodacao.EEstadoOcupacao;
import model.TipoAcomodacao;

public class AptController implements Serializable {

	private static final long serialVersionUID = 2252831249496233980L;

	
	//TODO: Arrumar relação entre acomodação e tipos.
	private Map<Integer, Acomodacao> apartamentos;
	private Map<String, TipoAcomodacao> tipos;

	public AptController() {
		apartamentos = new TreeMap<>();
		tipos = new TreeMap<>();
	}

	public void addApartamento(int numero, int ocupacaomax, String nomeTipo) {
		TipoAcomodacao tipo = tipos.get(nomeTipo);
		Acomodacao apartamento = new Acomodacao(numero, ocupacaomax, tipo);
		apartamentos.put(apartamento.getNumero(), apartamento);

		MainController.save();
	}

	public Acomodacao getApartamento(int numero) {
		return apartamentos.get(numero);
	}

	// TODO: .MANUTENCAO está aqui por motivos de testes. Tem que tirar.
	public void concluirLimpeza(int numero) {
		apartamentos.get(numero).setEstadoOcupacao(EEstadoOcupacao.MANUTENCAO);
		MainController.save();
	}

	public int deleteApartamento(int numero) {
		// Verificando estado para excluir apartamento
		Acomodacao ac = apartamentos.get(numero);

		// TODO: Except NullPointerException para quando não tiver apartamento do numero

		if (ac.getEstadoOcupacao() != EEstadoOcupacao.DISPONIVEL) {
			return 2;
		}

		try {
			apartamentos.remove(numero);
		} catch (Exception e) {
			return 1;
		}
		
		MainController.save();

		return 0;
	}
	
	public void addTipoAcomodacao(String nome, double tarifaDiaria, double adicionalAcompanhante) {
		TipoAcomodacao novoTipo = new TipoAcomodacao(nome, tarifaDiaria, adicionalAcompanhante);
		tipos.put(nome, novoTipo);
		MainController.save();
	}
	
	public String[][] getTipos() {
		List<String[]> lista = new ArrayList<String[]>();
		
		List<String> nomes = new ArrayList<String>();
		for(String nome : tipos.keySet()) {
			nomes.add(nome);
		}
		lista.add(nomes.toArray(new String[0]));
		
		for(String nome : tipos.keySet()) {
			double addAcomp = tipos.get(nome).getAdicionalAcompanhante();
			double tarifaD = tipos.get(nome).getTarifaDiaria();
			String[] infos = {Double.toString(tarifaD), Double.toString(addAcomp)};
			lista.add(infos);
		}
		return lista.toArray(new String[0][0]);
	}
}
