package model;

import java.util.ArrayList;

public class Conta implements IConta{
	private ArrayList<ItemConta> itens = new ArrayList<ItemConta>();

	@Override
	public void addItem(Item item, int qtde) {
		ItemConta newItem = new ItemConta(item, qtde);
		this.itens.add(newItem);
	}

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
	public StringBuilder listar() {
		StringBuilder sb = new StringBuilder();
		for(ItemConta item : itens) {
			sb.append("Item: " + item.getDescricao() + 
					" | Preço: R$" + item.getPreco() + 
					" | Qtd: " + item.getQtde() + "\n");
			
		}
		return sb;
	}

}
