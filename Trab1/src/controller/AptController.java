package controller;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import model.Acomodacao;
import model.Acomodacao.EEstadoOcupacao;
import model.TipoAcomodacao;

public class AptController implements Serializable {

	private static final long serialVersionUID = 2252831249496233980L;

	private Map<Integer, Acomodacao> apartamentos;

	public AptController() {
		apartamentos = new TreeMap<>();
	}

	public void addApartamento(int numero, int ocupacaomax, String tipo) {
		Acomodacao apartamento = new Acomodacao(numero, ocupacaomax, new TipoAcomodacao(tipo, 10, 1));
		apartamentos.put(apartamento.getNumero(), apartamento);

		MainController.save();
	}

	public Acomodacao getApartamento(int numero) {
		return apartamentos.get(numero);
	}

	// TODO: .MANUTENCAO está aqui por motivos de testes. Tem que tirar.
	public void concluirLimpeza(int numero) {
		apartamentos.get(numero).setEstadoOcupacao(EEstadoOcupacao.MANUTENCAO);
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
}
