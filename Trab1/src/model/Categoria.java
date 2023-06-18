package model;

import java.io.Serializable;

import java.util.Map;
import java.util.TreeMap;

public class Categoria implements Serializable{
	private static final long serialVersionUID = -8033937422622471378L;
	private final String nome;
	private Map<Long, Item> itens;

	public Categoria(String nome) {
		this.nome = nome;
		this.itens = new TreeMap<Long, Item>();
	}
	
	public Map<Long,Item> getItens() {
		return itens;
	}
	
	public void addItem(Item item) {
		itens.put(item.getCodigo(), item);
	}
	
	public void removeItem(long codigo) {
		itens.remove(codigo);
	}
	
	public String getNome() {
		return nome;
	}

}
