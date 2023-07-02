package view;

import controller.AptController;
import controller.MainController;
import exceptions.OperationNotAllowedException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JButton;
import java.awt.Toolkit;

public class MenuView extends JFrame {
	private static final long serialVersionUID = -4786237314541903229L;
	private JTabbedPane tabbedPane;
	
	/**
	 * ESPAÇO PARA TODOs gerais do projeto:
	 * TODO: Fazer busca geral de erros ao terminar o projeto.
	 * TODO: Organizar arquivos.
	 * TODO: Não se esquecer de retirar TODOs.
	 * TODO: Investigar getSelectedRow nas tabelas (InfoHospedagens).
	 * TODO: Resolver remendicionamento da janela de gerenciamento (segunda tab) (deve ter um action listener no botao da tab)
	 * TODO: Implementar edição do cliente. (excluir clientes também)
	 * TODO: Colocar um ícone decente.
	 */
	

	/**
	 * Create the frame.
	 */
	public MenuView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuView.class.getResource("/view/icone.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 679, 429);
		setMinimumSize(new Dimension(730, 450));
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
		gbl_panel_1_2.columnWidths = new int[]{21, 129, 86, 105, 121, 71, 0, 0};
		gbl_panel_1_2.rowHeights = new int[]{35, 18, 39, 27, 39, 25, 48, 0, 25, 0};
		gbl_panel_1_2.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1_2.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1_2.setLayout(gbl_panel_1_2);
		
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
				CriarAptView novajanela = new CriarAptView(0);
				novajanela.setVisible(true);
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
		gbc_lblItens_2_1.gridx = 3;
		gbc_lblItens_2_1.gridy = 1;
		panel_1_2.add(lblItens_2_1, gbc_lblItens_2_1);
		
		JLabel lblItens_2_2 = new JLabel("Clientes");
		lblItens_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblItens_2_2.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblItens_2_2 = new GridBagConstraints();
		gbc_lblItens_2_2.anchor = GridBagConstraints.NORTH;
		gbc_lblItens_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblItens_2_2.gridx = 5;
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
		gbc_btnItemCriar.gridx = 3;
		gbc_btnItemCriar.gridy = 3;
		panel_1_2.add(btnItemCriar, gbc_btnItemCriar);
		
		JButton btnItemEditPreco = new JButton("Visualizar");
		btnItemEditPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciarItemView janela = new GerenciarItemView();
				janela.setVisible(true);
			}
		});
		
		JButton btnAptVisualizar = new JButton("Visualizar");
		
		btnAptVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String input = JOptionPane.showInputDialog("Insira a Acomodação");
					if (input == null || (input != null && ("".equals(input)))) {
						return;
					}
					if(input.equals("0"))
						input = "error";
					int numero = Integer.parseInt(input);
					new CriarAptView(numero);
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
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 5;
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
		gbc_btnItemEditPreco.gridx = 3;
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
					JOptionPane.showMessageDialog(null, "Limpeza concluída!\nAcomodação disponível.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Insira um numero válido.", "Erro!", JOptionPane.ERROR_MESSAGE);
				} catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Acomodação não encontrada!", "Erro!", JOptionPane.ERROR_MESSAGE);
				} catch(OperationNotAllowedException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
				} catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String input = JOptionPane.showInputDialog("Insira o Cpf do Cliente");
					if (input == null || (input != null && ("".equals(input)))) {
						return;
					}
					if(input.equals("0"))
						input = "error";
					long cpf = Long.parseLong(input);
					new CadastroClienteView(cpf);
				} catch (NumberFormatException exp) {
					JOptionPane.showMessageDialog(null, "Insira um cpf válido!\n", "Erro!", JOptionPane.ERROR_MESSAGE);
				} catch (Exception exp) {
					exp.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + exp.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 5;
		panel_1_2.add(btnNewButton, gbc_btnNewButton);
		btnAptConcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAptConcluir = new GridBagConstraints();
		gbc_btnAptConcluir.anchor = GridBagConstraints.NORTH;
		gbc_btnAptConcluir.insets = new Insets(0, 0, 5, 5);
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
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{38, 183, 54, 31, 75, 177, 0, 0};
		gbl_panel.rowHeights = new int[]{69, 46, 49, 86, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnCheckin = new JButton("CheckIn");
		btnCheckin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckInView janela = new CheckInView();
				janela.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCheckin = new GridBagConstraints();
		gbc_btnCheckin.fill = GridBagConstraints.BOTH;
		gbc_btnCheckin.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckin.gridwidth = 3;
		gbc_btnCheckin.gridx = 1;
		gbc_btnCheckin.gridy = 1;
		panel.add(btnCheckin, gbc_btnCheckin);
		
		JButton btnClientes = new JButton("Cadastro Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new CadastroClienteView(0);
				} catch (Exception exp) {
					exp.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + exp.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnCheckout = new JButton("CheckOut");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String input = JOptionPane.showInputDialog("Insira a Acomodação");
					if (input == null || (input != null && ("".equals(input)))) {
						return;
					}
					int numero = Integer.parseInt(input);
					CheckOutView janela = new CheckOutView(numero);
					janela.setVisible(true);
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Insira um numero válido", "Erro!", JOptionPane.ERROR_MESSAGE);
				} catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(null, "Nenhuma hospedagem na acomodação informada.", "Atenção!", JOptionPane.WARNING_MESSAGE);
				} catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
		gbc_btnCheckout.gridwidth = 2;
		gbc_btnCheckout.fill = GridBagConstraints.BOTH;
		gbc_btnCheckout.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckout.gridx = 4;
		gbc_btnCheckout.gridy = 1;
		panel.add(btnCheckout, gbc_btnCheckout);
		GridBagConstraints gbc_btnClientes = new GridBagConstraints();
		gbc_btnClientes.fill = GridBagConstraints.BOTH;
		gbc_btnClientes.insets = new Insets(0, 0, 5, 5);
		gbc_btnClientes.gridx = 1;
		gbc_btnClientes.gridy = 2;
		panel.add(btnClientes, gbc_btnClientes);
		
		JButton btnServios = new JButton("Serviços Adicionais");
		btnServios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CatalogoView janela = new CatalogoView();
				janela.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnServios = new GridBagConstraints();
		gbc_btnServios.fill = GridBagConstraints.BOTH;
		gbc_btnServios.insets = new Insets(0, 0, 5, 5);
		gbc_btnServios.gridwidth = 3;
		gbc_btnServios.gridx = 2;
		gbc_btnServios.gridy = 2;
		panel.add(btnServios, gbc_btnServios);
		
		JButton btnInfoHospedagens = new JButton("Info. Hospedagens");
		btnInfoHospedagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HospedagensView janela = new HospedagensView();
				janela.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnInfoHospedagens = new GridBagConstraints();
		gbc_btnInfoHospedagens.insets = new Insets(0, 0, 5, 5);
		gbc_btnInfoHospedagens.fill = GridBagConstraints.BOTH;
		gbc_btnInfoHospedagens.gridx = 5;
		gbc_btnInfoHospedagens.gridy = 2;
		panel.add(btnInfoHospedagens, gbc_btnInfoHospedagens);
	}
}