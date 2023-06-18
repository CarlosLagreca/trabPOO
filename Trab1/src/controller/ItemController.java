package controller;

import java.io.Serializable;

import java.util.Map;
import java.util.TreeMap;

import model.Item;
import model.Categoria;

public class ItemController implements Serializable {
	private static final long serialVersionUID = 8263992833356022496L;

	private Map<String, Categoria> categorias;

	public ItemController() {
		categorias = new TreeMap<>();
	}

	public void addCategoria(String nome) {
		categorias.put(nome, new Categoria(nome));
	}

	public int addItem(String nomeCategoria, long codigo, String descricao, double preco) {
		
		try {
			Categoria categoria = categorias.get(nomeCategoria);
			Item item = new Item(codigo, descricao, preco);
			categoria.addItem(item);
		} catch(Exception e) {
			e.printStackTrace();
			return 1;
		}
		
		return 0;
	}

	public int editPreco(String nomeCategoria, long codItem, double preco) {
		
		try {
		Categoria categoria = categorias.get(nomeCategoria);
		Item item = categoria.getItens().get(codItem);
		item.setPreco(preco);
		} catch(Exception e) {
			e.printStackTrace();
			return 1;
		}
		
		return 0;
	}
}
