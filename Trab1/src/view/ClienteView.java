package view;

import controller.MainController;
import controller.ClienteController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteView extends JFrame {
	private static final long serialVersionUID = -4078223847792620531L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane barraRolagem;

	/**
	 * Create the frame.
	 */
	public ClienteView() {
		initialize();
	}
	
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteView.class.getResource("/view/icone.png")));
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setMinimumSize(new Dimension(500, 300));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		ClienteController controller = MainController.getClienteContoller();
		// Montando tabela de clientes
		String[] colunas = {"Nome", "Cpf", "Telefone", "Email"};
		
		String[][] linhas = controller.getClientes();
		
		table = new JTable(linhas, colunas);
		barraRolagem = new JScrollPane(table);
		
		
		JLabel lblNewLabel = new JLabel("Lista de Clientes Cadastrados");
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(barraRolagem, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(barraRolagem, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
	
}
