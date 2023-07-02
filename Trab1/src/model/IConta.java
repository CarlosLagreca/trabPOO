package model;

import exceptions.OperationNotAllowedException;

public interface IConta{
	public void addItem(Item item, int qtde) throws OperationNotAllowedException;
	public void removeItem(int index);
	public double getTotal();
	public String[][] getItens();

}