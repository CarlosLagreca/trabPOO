package Hotel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CategoriaView extends JFrame{
	private static final long serialVersionUID = -3063735540464982922L;
	
	private JPanel panel1;
	private JPanel panel2;
	private JLabel l1;
	private JTextField t1;
	private JButton b1;
	private JButton b2;
	private JTextArea ta1;
	
	public CategoriaView() {
		initialize();
	}
	
	
	private void initialize() {
		setTitle("My Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);
		
		setLayout(new BorderLayout());
		
		// Inicializando elementos
		panel1 = new JPanel();
		panel2 = new JPanel();
		l1 = new JLabel("Nome");
		t1 = new JTextField("TextField");
		b1 = new JButton("Savlar");
		b2 = new JButton("Listar");
		ta1 = new JTextArea("(categorias)");
		
		// Adicionando e organizando
		t1.setColumns(20);
		
		panel1.setLayout(new FlowLayout());
		panel1.add(l1);
		panel1.add(t1);
		panel1.add(b1);
		
		panel2.setLayout(new FlowLayout());
		panel2.add(b2);
		
		this.add(panel1, BorderLayout.PAGE_START);
		this.add(panel2, BorderLayout.LINE_END);
		this.add(ta1, BorderLayout.CENTER);
		
		this.setVisible(true);
		
		
		
		
	
	}
}

