package model;

import java.io.Serializable;

public class Item implements Serializable{
	private static final long serialVersionUID = 1437011155733728216L;
	private final long codigo;
	private final String descricao;
	private double preco;

	public Item(long codigo, String descricao, double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}
