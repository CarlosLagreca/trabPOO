package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exceptions.OperationNotAllowedException;

public class Conta implements IConta, Serializable{
	private static final long serialVersionUID = -2382567513224317717L;
	private ArrayList<ItemConta> itens = new ArrayList<ItemConta>();

	@Override
	public void addItem(Item item, int qtde) throws OperationNotAllowedException {
		if(item == null) {
			throw new NullPointerException("Erro ao acessar item.");
		}
		if(qtde < 0) {
			throw new OperationNotAllowedException("Quantidade inválida.");
		}
		ItemConta newItem = new ItemConta(item, qtde);
		this.itens.add(newItem);
	}
	
	// TODO: Precisamos de um removeItem?
	@Override
	public void removeItem(int index) {
		itens.remove(index);
	}

	@Override
	public double getTotal() {
		double total = 0;
		for(ItemConta item : itens) {
			total += item.getPreco() * item.getQtde();
		}
		return total;
	}

	@Override
	public String[][] getItens() {
		List<String[]> table = new ArrayList<String[]>();
		for(ItemConta item : itens) {
			String[] linha = {item.getDescricao(), Double.toString(item.getPreco()), Integer.toString(item.getQtde())};
			table.add(linha);
		}
		return table.toArray(new String[0][0]);
	}

}
