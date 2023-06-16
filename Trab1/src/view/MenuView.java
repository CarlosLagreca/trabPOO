package view;

import controller.MainController;
import controller.MenuController;
import main.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.Toolkit;

public class MenuView extends JFrame {

	private JTabbedPane tabbedPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/view/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 800, 600);
		setMinimumSize(new Dimension(500, 400));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(tabbedPane);
		
		
		JPanel panelMenu = new JPanel();
		JPanel panelGerenciamento = new JPanel();
		
		tabbedPane.addTab("Menu", null, panelMenu, null);
		tabbedPane.addTab("Gerenciamento", null, panelGerenciamento, null);
		
		
		
		////// CRANDO PANEL GERENCIAMENTO //////
		GridBagLayout gbl_panelGerenciamento = new GridBagLayout();
		gbl_panelGerenciamento.columnWidths = new int[] {300, 300, 300, 0};
		gbl_panelGerenciamento.rowHeights = new int[]{0, 0};
		gbl_panelGerenciamento.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0};
		gbl_panelGerenciamento.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelGerenciamento.setLayout(gbl_panelGerenciamento);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1_2 = new GridBagConstraints();
		gbc_panel_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1_2.fill = GridBagConstraints.BOTH;
		gbc_panel_1_2.gridx = 0;
		gbc_panel_1_2.gridy = 0;
		panelGerenciamento.add(panel_1_2, gbc_panel_1_2);
		GridBagLayout gbl_panel_1_2 = new GridBagLayout();
		gbl_panel_1_2.columnWidths = new int[]{30, 0};
		gbl_panel_1_2.rowHeights = new int[]{87, 18, 10, 20, 20, 20, 30, 0, 0};
		gbl_panel_1_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1_2.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1_2.setLayout(gbl_panel_1_2);
		
		JLabel lblItens_2 = new JLabel("Apartamentos");
		lblItens_2.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblItens_2 = new GridBagConstraints();
		gbc_lblItens_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblItens_2.gridx = 0;
		gbc_lblItens_2.gridy = 0;
		panel_1_2.add(lblItens_2, gbc_lblItens_2);
		
		JButton btnApt = new JButton("Criar novo");
		btnApt.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_btnApt = new GridBagConstraints();
		gbc_btnApt.insets = new Insets(0, 0, 5, 0);
		gbc_btnApt.gridx = 0;
		gbc_btnApt.gridy = 3;
		panel_1_2.add(btnApt, gbc_btnApt);
		
		JButton btnNewButton_1_2 = new JButton("Editar");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton_1_2 = new GridBagConstraints();
		gbc_btnNewButton_1_2.gridheight = 3;
		gbc_btnNewButton_1_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1_2.gridx = 0;
		gbc_btnNewButton_1_2.gridy = 4;
		panel_1_2.add(btnNewButton_1_2, gbc_btnNewButton_1_2);
		
		JButton btnNewButton_3_2 = new JButton("Concluir limpeza");
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton_3_2 = new GridBagConstraints();
		gbc_btnNewButton_3_2.gridx = 0;
		gbc_btnNewButton_3_2.gridy = 7;
		panel_1_2.add(btnNewButton_3_2, gbc_btnNewButton_3_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panelGerenciamento.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {30, 0};
		gbl_panel_1.rowHeights = new int[] {87, 18, 10, 20, 20, 20, 30, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblItens = new JLabel("Itens");
		lblItens.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblItens = new GridBagConstraints();
		gbc_lblItens.insets = new Insets(0, 0, 5, 0);
		gbc_lblItens.gridx = 0;
		gbc_lblItens.gridy = 0;
		panel_1.add(lblItens, gbc_lblItens);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 3;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 4;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 7;
		panel_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_1.gridx = 2;
		gbc_panel_1_1.gridy = 0;
		panelGerenciamento.add(panel_1_1, gbc_panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[]{30, 0};
		gbl_panel_1_1.rowHeights = new int[]{87, 18, 10, 20, 20, 20, 30, 0, 0};
		gbl_panel_1_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1_1.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1_1.setLayout(gbl_panel_1_1);
		
		JLabel lblItens_1 = new JLabel("Itens");
		lblItens_1.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblItens_1 = new GridBagConstraints();
		gbc_lblItens_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblItens_1.gridx = 0;
		gbc_lblItens_1.gridy = 0;
		panel_1_1.add(lblItens_1, gbc_lblItens_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 3;
		panel_1_1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.gridheight = 3;
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1_1.gridx = 0;
		gbc_btnNewButton_1_1.gridy = 4;
		panel_1_1.add(btnNewButton_1_1, gbc_btnNewButton_1_1);
		
		JButton btnNewButton_3_1 = new JButton("New button");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton_3_1 = new GridBagConstraints();
		gbc_btnNewButton_3_1.gridx = 0;
		gbc_btnNewButton_3_1.gridy = 7;
		panel_1_1.add(btnNewButton_3_1, gbc_btnNewButton_3_1);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 0, 5);
		gbc_separator.gridx = 3;
		gbc_separator.gridy = 0;
		panelGerenciamento.add(separator, gbc_separator);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridx = 4;
		gbc_separator_1.gridy = 0;
		panelGerenciamento.add(separator_1, gbc_separator_1);
		
		
		
		///// CRIANDO PANEL MENU ///////
		panelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelMenu.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Sistema de Hotelaria");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panelMenu.add(panel, BorderLayout.CENTER);
		
		JButton btnCheckout = new JButton("Checkout");
		
		JButton btnAcomodaes = new JButton("Checkin");
		
		JButton btnClientes = new JButton("Cadastro clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuController controller = new MenuController();
				controller.openCadastroCliente();
			}
		});
		
		JButton btnServios = new JButton("Serviços adicionais");
		
		JButton btnInfoHospedagens = new JButton("Info. Hospedagens");
		
		JButton btnGerenciamento = new JButton("Gerenciamento");
		btnGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciamentoView janela = new GerenciamentoView();
				janela.setVisible(true);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnCheckout, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
							.addComponent(btnServios, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAcomodaes, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
							.addGap(148)
							.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnInfoHospedagens, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
							.addComponent(btnGerenciamento, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAcomodaes, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
						.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCheckout, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnServios, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnInfoHospedagens, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGerenciamento, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(116))
		);
		panel.setLayout(gl_panel);
	}
}