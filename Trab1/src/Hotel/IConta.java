package Hotel;

public interface IConta {
	public void addItem(Item item, int qtde);
	public void removeItem(int index);
	public double getTotal();
	public StringBuilder listar();
	public int teste();
	public void addIten2();

}