package Hotel;

import java.util.ArrayList;

public class Conta implements IConta{
	private ArrayList<ItemConta> itens = new ArrayList<ItemConta>();
	

	@Override
	public void addItem(ItemConta item, int qtde) {
		for(int i=0; i<qtde; i++) {
			itens.add(item);
		}
		
	}

	@Override
	public void removeItem(int index) {
		itens.remove(index);
		
	}

	@Override
	public double getTotal() {
		for(int i=0; i<qtde; i++) {
			itens.add(item);
		}
		return 0;
	}

	@Override
	public StringBuilder listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
