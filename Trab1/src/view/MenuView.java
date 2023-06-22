package view;

import controller.AptController;
import controller.MainController;
import controller.MenuController;
import main.Main;
import controller.ItemController;

import view.CriarAptView;

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
import javax.swing.JOptionPane;

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
import javax.swing.JToggleButton;

public class MenuView extends JFrame {
	private static final long serialVersionUID = -4786237314541903229L;
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
	 * ESPAÇO PARA TODOs gerais do projeto:
	 * TODO: Fazer botão (janela) Serviços adicionais.
	 * TODO: Fazer botão (janela) Checkin.
	 * TODO: Fazer botão (janela) Checkout.
	 * TODO: Fazer botão (janela) Info. Hospedagens.
	 * TODO: Fazer busca geral de erros ao terminar o projeto.
	 *  * TODO: Fazer busca geral de erros ao terminar o projeto.
	 *             
	 */
	

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
		gbl_panelGerenciamento.columnWidths = new int[] {300, 0};
		gbl_panelGerenciamento.rowHeights = new int[]{0, 0};
		gbl_panelGerenciamento.columnWeights = new double[]{1.0, 0.0, 0.0};
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
		gbl_panel_1_2.columnWidths = new int[]{51, 141, 139, 148, 0};
		gbl_panel_1_2.rowHeights = new int[]{34, 18, 94, 27, 123, 25, 137, 25, 0};
		gbl_panel_1_2.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1_2.setLayout(gbl_panel_1_2);
		
		JButton btnItemEditPreco = new JButton("Visualizar");
		btnItemEditPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciarItemView janela = new GerenciarItemView();
				janela.setVisible(true);
			}
		});
		
		JLabel lblItens_2 = new JLabel("Apartamentos");
		lblItens_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblItens_2.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblItens_2 = new GridBagConstraints();
		gbc_lblItens_2.anchor = GridBagConstraints.NORTH;
		gbc_lblItens_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblItens_2.gridx = 1;
		gbc_lblItens_2.gridy = 1;
		panel_1_2.add(lblItens_2, gbc_lblItens_2);
		
		JLabel lblItens_2_1 = new JLabel("Itens");
		lblItens_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblItens_2_1.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblItens_2_1 = new GridBagConstraints();
		gbc_lblItens_2_1.anchor = GridBagConstraints.NORTH;
		gbc_lblItens_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblItens_2_1.gridx = 2;
		gbc_lblItens_2_1.gridy = 1;
		panel_1_2.add(lblItens_2_1, gbc_lblItens_2_1);
		
		JButton btnItemCriar = new JButton("Criar novo");
		btnItemCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemView janela = new ItemView();
				janela.setVisible(true);
			}
		});
		
		JButton btnAptCriar = new JButton("Criar novo");
		btnAptCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarAptView novajanela = new CriarAptView(-1);
				novajanela.setVisible(true);
			}
		});
		
		JLabel lblItens_2_2 = new JLabel("Clientes");
		lblItens_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblItens_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblItens_2_2 = new GridBagConstraints();
		gbc_lblItens_2_2.anchor = GridBagConstraints.NORTH;
		gbc_lblItens_2_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblItens_2_2.gridx = 3;
		gbc_lblItens_2_2.gridy = 1;
		panel_1_2.add(lblItens_2_2, gbc_lblItens_2_2);
		btnAptCriar.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAptCriar = new GridBagConstraints();
		gbc_btnAptCriar.anchor = GridBagConstraints.NORTH;
		gbc_btnAptCriar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAptCriar.gridx = 1;
		gbc_btnAptCriar.gridy = 3;
		panel_1_2.add(btnAptCriar, gbc_btnAptCriar);
		btnItemCriar.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_btnItemCriar = new GridBagConstraints();
		gbc_btnItemCriar.anchor = GridBagConstraints.NORTH;
		gbc_btnItemCriar.insets = new Insets(0, 0, 5, 5);
		gbc_btnItemCriar.gridx = 2;
		gbc_btnItemCriar.gridy = 3;
		panel_1_2.add(btnItemCriar, gbc_btnItemCriar);
		
		JButton btnAptVisualizar = new JButton("Visualizar");
		
		btnAptVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String input = JOptionPane.showInputDialog("Insira a Acomodação");
					if (input == null || (input != null && ("".equals(input)))) {
						return;
					}
					int numero = Integer.parseInt(input);
					CriarAptView janela = new CriarAptView(numero);
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Insira um numero válido", "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnNewButton_2 = new JButton("Listar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame janela = new ClienteView();
				janela.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 3;
		panel_1_2.add(btnNewButton_2, gbc_btnNewButton_2);
		
		btnAptVisualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAptVisualizar = new GridBagConstraints();
		gbc_btnAptVisualizar.anchor = GridBagConstraints.NORTH;
		gbc_btnAptVisualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAptVisualizar.gridx = 1;
		gbc_btnAptVisualizar.gridy = 5;
		panel_1_2.add(btnAptVisualizar, gbc_btnAptVisualizar);
		btnItemEditPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnItemEditPreco = new GridBagConstraints();
		gbc_btnItemEditPreco.anchor = GridBagConstraints.NORTH;
		gbc_btnItemEditPreco.insets = new Insets(0, 0, 5, 5);
		gbc_btnItemEditPreco.gridx = 2;
		gbc_btnItemEditPreco.gridy = 5;
		panel_1_2.add(btnItemEditPreco, gbc_btnItemEditPreco);
		
		JButton btnAptConcluir = new JButton("Concluir limpeza");
		btnAptConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AptController controller = MainController.getAptController();
				try {
					String input = JOptionPane.showInputDialog("Insira a Acomodação");
					if (input == null || (input != null && ("".equals(input)))) {
						return;
					}
					int numero = Integer.parseInt(input);
					controller.concluirLimpeza(numero);
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Insira um numero válido", "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 5;
		panel_1_2.add(btnNewButton, gbc_btnNewButton);
		btnAptConcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAptConcluir = new GridBagConstraints();
		gbc_btnAptConcluir.anchor = GridBagConstraints.NORTH;
		gbc_btnAptConcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnAptConcluir.gridx = 1;
		gbc_btnAptConcluir.gridy = 7;
		panel_1_2.add(btnAptConcluir, gbc_btnAptConcluir);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 0, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		panelGerenciamento.add(separator, gbc_separator);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridx = 2;
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
		
		JButton btnCheckout = new JButton("CheckOut");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnClientes = new JButton("Cadastro Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuController controller = new MenuController();
				controller.openCadastroCliente();
			}
		});
		
		JButton btnServios = new JButton("Serviços Adicionais");
		btnServios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CatalogoView janela = new CatalogoView();
				janela.setVisible(true);
			}
		});
		
		JButton btnInfoHospedagens = new JButton("Info. Hospedagens");
		
		JButton btnCheckin = new JButton("CheckIn");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckInView janela = new CheckInView();
				janela.setVisible(true);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(181)
					.addComponent(btnCheckin, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnCheckout, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addGap(193))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(81)
					.addComponent(btnClientes, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addGap(36)
					.addComponent(btnServios, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addGap(36)
					.addComponent(btnInfoHospedagens, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addGap(84))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(162)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCheckout, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCheckin, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(69)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(btnClientes, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnServios, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInfoHospedagens, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(163))
		);
		panel.setLayout(gl_panel);
	}
}