package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Item;
import model.Categoria;

public class ItemController implements Serializable {
	private static final long serialVersionUID = 8263992833356022496L;

	// TODO: Fazer relação de itens e categoria da mesma forma que apt e tipo.
	private Map<String, Categoria> categorias;
	private Map<Long, Item> itens;

	public ItemController() {
		categorias = new TreeMap<>();
		itens = new TreeMap<>();
	}

	public void addCategoria(String nome) {
		categorias.put(nome, new Categoria(nome));
		MainController.save();
	}

	public int addItem(String nomeCategoria, long codigo, String descricao, double preco) {
		
		try {
			Categoria categoria = categorias.get(nomeCategoria);
			Item item = new Item(codigo, descricao, preco);
			itens.put(codigo, item);
			categoria.addItem(item);
			MainController.save();
		} catch(Exception e) {
			e.printStackTrace();
			return 1;
		}
		
		return 0;
	}
	
	public int removeItem(String nomeCategoria, long codigo) {
		try {
			Categoria categoria = categorias.get(nomeCategoria);
			categoria.getItens().remove(codigo);
			itens.remove(codigo);
			MainController.save();
		}catch(Exception e) {
			e.printStackTrace();
			return 1;
		}
		
		return 0;
	}

	public int editPreco(String nomeCategoria, long codItem, double preco) {
		try {
			Item item = itens.get(codItem);
			item.setPreco(preco);
			MainController.save();
		} catch(Exception e) {
			e.printStackTrace();
			return 1;
		}
		
		return 0;
	}
	
	public String[] getCategorias() {
		List<String> lista = new ArrayList<String>();
		for(String nome : categorias.keySet()) {
			lista.add(nome);
		}
		return lista.toArray(new String[0]);
	}
	
	public String[][] getItens(String nomeCategoria) {
		List<String[]> table = new ArrayList<String[]>();
		Categoria categoria = categorias.get(nomeCategoria);
		for(Item item : categoria.getItens().values()) {
			String[] linha = {Long.toString(item.getCodigo()), item.getDescricao(), Double.toString(item.getPreco())};
			table.add(linha);
		}
		
		return table.toArray(new String[0][0]);
	}
	
	public Item getItem(String nomeCategoria, long codItem) {
		return itens.get(codItem);
	}
}
