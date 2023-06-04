package Hotel;

import java.util.Date;

public class ItemConta {
	private final Date dataHora;
	private final double preco;
	private final int qtde;
	private final Item item;

	public ItemConta(Item item, int qtde) {
		this.dataHora = new Date();
		this.preco = item.getPreco();
		this.qtde = qtde;
		this.item = item;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public double getPreco() {
		return preco;
	}

	public int getQtde() {
		return qtde;
	}

	public Item getItem() {
		return item;
	}
	
	public String getDescricao() {
		return item.getDescricao();
	}
}
