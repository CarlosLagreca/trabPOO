package controller;

import view.CadastroClienteView;

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
