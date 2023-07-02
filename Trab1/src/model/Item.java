package model;

import java.io.Serializable;

import exceptions.CannotCreateModelException;

public class Item implements Serializable{
	private static final long serialVersionUID = 1437011155733728216L;
	private final long codigo;
	private final String descricao;
	private double preco;

	public Item(long codigo, String descricao, double preco) throws CannotCreateModelException {
		if(codigo < 0)
			throw new CannotCreateModelException("Código inválido.");
		if(descricao.length() < 1)
			throw new CannotCreateModelException("Descrição inválida.");
		if(preco < 0)
			throw new CannotCreateModelException("Preço inválido.");
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if(preco < 0)
			throw new IllegalArgumentException("Preço inválido");
		this.preco = preco;
	}

	public long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}
