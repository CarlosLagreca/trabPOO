package model;

import exceptions.CannotCreateModelException;

public interface IConta {
	public void addItem(Item item, int qtde) throws CannotCreateModelException;

	public void removeItem(int index);

	public double getTotal();

	public String[][] getItens();

}