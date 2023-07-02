package model;

import java.io.Serializable;

import java.util.Map;
import java.util.TreeMap;

import exceptions.CannotCreateModelException;

public class Categoria implements Serializable{
	private static final long serialVersionUID = -8033937422622471378L;
	private final String nome;
	private Map<Long, Item> itens;

	public Categoria(String nome) throws CannotCreateModelException {
		if(nome.length() < 1) {
			throw new CannotCreateModelException("Nome inválido.");
		}
		this.nome = nome;
		this.itens = new TreeMap<Long, Item>();
	}
	
	public Map<Long,Item> getItens() {
		return itens;
	}
	
	public void addItem(Item item) {
		if(item == null)
			throw new NullPointerException("Item adicionado na categoria não pode ser null.");
		itens.put(item.getCodigo(), item);
	}
	
	public void removeItem(long codigo) {
		itens.remove(codigo);
	}
	
	public String getNome() {
		return nome;
	}

}
