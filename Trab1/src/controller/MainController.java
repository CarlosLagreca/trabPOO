package controller;

import java.io.Serializable;

import persistence.Serializer;

public class MainController implements Serializable{

	private static final long serialVersionUID = -25595180939938054L;
	
	private static MainController instance;
	private AptController aptcontroller;
	private ItemController itemcontroller;
	 
	private MainController() {
		aptcontroller = new AptController();
	}
	
	public static MainController getInstance() {
		return instance;
	}
	
	public static AptController getAptController() {
		return instance.aptcontroller;
	}
	
	public static ItemController getItemController() {
		return instance.itemcontroller;
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
