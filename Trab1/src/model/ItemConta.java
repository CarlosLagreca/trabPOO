package model;

import java.io.Serializable;
import java.time.LocalDateTime;

import exceptions.CannotCreateModelException;

public class ItemConta implements Serializable{
	private static final long serialVersionUID = 7491698926789829640L;
	private final LocalDateTime dataHora;
	private final double preco;
	private final int qtde;
	private final Item item;

	public ItemConta(Item item, int qtde) throws CannotCreateModelException {
		if(item == null)
			throw new CannotCreateModelException("Erro ao acessar item");
		if(qtde < 1)
			throw new CannotCreateModelException("Quantidade inválida");
		this.dataHora = LocalDateTime.now();
		this.preco = item.getPreco();
		this.qtde = qtde;
		this.item = item;
	}

	public LocalDateTime getDataHora() {
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
