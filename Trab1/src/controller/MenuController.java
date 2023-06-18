package controller;

import view.CadastroClienteView;


//TODO: Essa classe não deve existir, tem que colocar isso na MenuView diretamente.
public class MenuController {
	
	public void openCadastroCliente() {
		try {
			CadastroClienteView frame = new CadastroClienteView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
