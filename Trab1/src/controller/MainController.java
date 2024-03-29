package controller;

import java.io.Serializable;

import persistence.Serializer;

public class MainController implements Serializable {

	private static final long serialVersionUID = -25595180939938054L;

	private static MainController instance;
	private AptController aptcontroller;
	private ItemController itemcontroller;
	private ClienteController clientecontroller;
	private HospedagemController hospcontroller;

	private MainController() {
		aptcontroller = new AptController();
		itemcontroller = new ItemController();
		clientecontroller = new ClienteController();
		hospcontroller = new HospedagemController();
	}

	public static MainController getInstance() {
		return instance;
	}

	public static ClienteController getClienteContoller() {
		return instance.clientecontroller;
	}

	public static AptController getAptController() {
		return instance.aptcontroller;
	}

	public static ItemController getItemController() {
		return instance.itemcontroller;
	}
	
	public static HospedagemController getHospedagemController() {
		return instance.hospcontroller;
	}

	public static void load() {
		instance = Serializer.readFile();
		if (instance == null) {
			instance = new MainController();
		}
	}

	public static void save() {
		Serializer.writeFile(instance);
	}
}
