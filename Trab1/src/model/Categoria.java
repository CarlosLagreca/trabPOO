package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable{
	private static final long serialVersionUID = -8033937422622471378L;
	private final String nome;
	private ArrayList<Item> itens = new ArrayList<Item>();

	public Categoria(String nome, ArrayList<Item> itens) {
		this.nome = nome;
		this.itens = itens;
	}

}
