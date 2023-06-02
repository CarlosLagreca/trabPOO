package Hotel;

import java.util.ArrayList;

public class Categoria {
	private final String nome;
	private ArrayList<Item> itens = new ArrayList<Item>();

	public Categoria(String nome, ArrayList<Item> itens) {
		this.nome = nome;
		this.itens = itens;
	}

}
