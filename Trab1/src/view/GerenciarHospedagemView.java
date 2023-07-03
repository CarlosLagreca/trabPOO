package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import controller.HospedagemController;
import controller.MainController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GerenciarHospedagemView extends JFrame {
	private static final long serialVersionUID = -8666884440398223144L;
	private JPanel contentPane;
	private JTable tableItens;
	private DefaultTableModel modelItens = new DefaultTableModel();
	private JTable tableAcompanhantes;
	private DefaultTableModel modelAcompanhantes = new DefaultTableModel();
	private JLabel lblIdHosp;
	private JLabel lblNumeroAcm;
	private JLabel lblNomeCliente;
	private JLabel lblPreco;
	private JButton btnDelItem;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollItens;
	private JScrollPane scrollAcompanhantes;
	private String[] infos;

	/**
	 * Create the frame.
	 */
	public GerenciarHospedagemView(int numeroAcomodacao, boolean janelaCheckout) {
		initialize(janelaCheckout);
		buildInfos(numeroAcomodacao);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public GerenciarHospedagemView(String idAcomodacao) {
		initialize(true);
		buildInfos(idAcomodacao);
	}

	private void initialize(boolean janelaCheckout) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(GerenciarHospedagemView.class.getResource("/view/icone.png")));
		setTitle("Listagem de Hospedagens");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 819, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 32, 151, 65, 194, 85, 0 };
		gbl_panel_1.rowHeights = new int[] { 14, 14, 14, 34, 14, 14, 23, 23, 341, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNmeroDaHospedagem = new JLabel("Número da hospedagem");
		GridBagConstraints gbc_lblNmeroDaHospedagem = new GridBagConstraints();
		gbc_lblNmeroDaHospedagem.anchor = GridBagConstraints.NORTH;
		gbc_lblNmeroDaHospedagem.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNmeroDaHospedagem.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroDaHospedagem.gridx = 1;
		gbc_lblNmeroDaHospedagem.gridy = 0;
		panel_1.add(lblNmeroDaHospedagem, gbc_lblNmeroDaHospedagem);

		JLabel lblNewLabel_1 = new JLabel("Numero da acomodação");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nome Cliente");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		lblIdHosp = new JLabel("New label");
		GridBagConstraints gbc_lblIdHosp = new GridBagConstraints();
		gbc_lblIdHosp.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblIdHosp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdHosp.gridx = 1;
		gbc_lblIdHosp.gridy = 1;
		panel_1.add(lblIdHosp, gbc_lblIdHosp);

		lblNumeroAcm = new JLabel("New label");
		GridBagConstraints gbc_lblNumeroAcm = new GridBagConstraints();
		gbc_lblNumeroAcm.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNumeroAcm.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroAcm.gridx = 3;
		gbc_lblNumeroAcm.gridy = 1;
		panel_1.add(lblNumeroAcm, gbc_lblNumeroAcm);

		lblNomeCliente = new JLabel("New label");
		GridBagConstraints gbc_lblNomeCliente = new GridBagConstraints();
		gbc_lblNomeCliente.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNomeCliente.insets = new Insets(0, 0, 5, 0);
		gbc_lblNomeCliente.gridx = 4;
		gbc_lblNomeCliente.gridy = 1;
		panel_1.add(lblNomeCliente, gbc_lblNomeCliente);

		JLabel lblNewLabel_3 = new JLabel("Informações");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 2;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblPagamento = new JLabel("Preço a ser pago");
		GridBagConstraints gbc_lblPagamento = new GridBagConstraints();
		gbc_lblPagamento.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPagamento.insets = new Insets(0, 0, 5, 0);
		gbc_lblPagamento.gridx = 4;
		gbc_lblPagamento.gridy = 4;
		panel_1.add(lblPagamento, gbc_lblPagamento);

		lblPreco = new JLabel("R$: Preço");
		GridBagConstraints gbc_lblPreco = new GridBagConstraints();
		gbc_lblPreco.anchor = GridBagConstraints.NORTH;
		gbc_lblPreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPreco.insets = new Insets(0, 0, 5, 0);
		gbc_lblPreco.gridx = 4;
		gbc_lblPreco.gridy = 5;
		panel_1.add(lblPreco, gbc_lblPreco);

		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PagamentoView janela = new PagamentoView(Integer.parseInt(infos[0]));
				janela.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnPagar = new GridBagConstraints();
		gbc_btnPagar.anchor = GridBagConstraints.NORTH;
		gbc_btnPagar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPagar.insets = new Insets(0, 0, 5, 0);
		gbc_btnPagar.gridx = 4;
		gbc_btnPagar.gridy = 6;
		panel_1.add(btnPagar, gbc_btnPagar);

		btnDelItem = new JButton("DeletarItem");
		btnDelItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarItemAction();
			}
		});
		GridBagConstraints gbc_btnDelItem = new GridBagConstraints();
		gbc_btnDelItem.anchor = GridBagConstraints.NORTH;
		gbc_btnDelItem.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelItem.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelItem.gridx = 4;
		gbc_btnDelItem.gridy = 7;
		panel_1.add(btnDelItem, gbc_btnDelItem);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Itens", null, panel, null);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		tableItens = new JTable();
		tableItens.setModel(modelItens);
		scrollItens = new JScrollPane(tableItens);
		panel.add(scrollItens);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Acompanhantes", null, panel_2, null);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		tableAcompanhantes = new JTable();
		tableAcompanhantes.setModel(modelAcompanhantes);
		scrollAcompanhantes = new JScrollPane(tableAcompanhantes);
		panel_2.add(scrollAcompanhantes);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 6;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.insets = new Insets(0, 0, 0, 5);
		gbc_tabbedPane.gridwidth = 3;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 3;
		panel_1.add(tabbedPane, gbc_tabbedPane);

		
		
		// Caso a janela tenha sido chamada pela janela de checkout, desabilitar opções
		// de pagamento
		if (janelaCheckout) {
			lblPagamento.setVisible(false);
			lblPreco.setVisible(false);
			btnPagar.setEnabled(false);
			btnPagar.setVisible(false);
			
		}

	}

	private void buildInfos(int numApt) {
		// Pegando informações e preenchendo labels
		HospedagemController controller = MainController.getHospedagemController();
		infos = controller.getDadosHospedagem(numApt);

		lblIdHosp.setText(infos[12]);
		lblNomeCliente.setText(infos[1]);
		lblNumeroAcm.setText(infos[0]);
		lblPreco.setText(infos[9]);

		// Preenchendo table de itens da conta da hospedagem
		modelItens.setColumnCount(0);
		modelItens.setRowCount(0);
		modelItens.addColumn("Descrição");
		modelItens.addColumn("Preço");
		modelItens.addColumn("Quantidade");
		modelItens.addColumn("Data");
		String[][] itens = controller.getItensHospedagem(numApt);
		for (String[] linha : itens) {
			modelItens.addRow(linha);
		}

		// Preenchendo table de acompanhantes da hospedagem

		modelAcompanhantes.addColumn("Nome");
		modelAcompanhantes.addColumn("CPF");
		modelAcompanhantes.addColumn("Telefone");
		modelAcompanhantes.addColumn("Email");
		String[][] acompanhantes = controller.getAcompanhantesHospedagem(numApt);
		for (String[] linha : acompanhantes) {
			modelAcompanhantes.addRow(linha);
		}

		modelAcompanhantes.fireTableDataChanged();
		modelItens.fireTableDataChanged();
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int pane = tabbedPane.getSelectedIndex();
				if(pane == 0) {
					btnDelItem.setEnabled(true);
					btnDelItem.setVisible(true);
				}
				else{
					btnDelItem.setEnabled(false);
					btnDelItem.setVisible(false);
				}
				
			}
		});
	}

	private void buildInfos(String id) {
		// Pegando informações e preenchendo labels
		HospedagemController controller = MainController.getHospedagemController();
		infos = controller.getDadosHospedagem(id);

		lblIdHosp.setText(infos[12]);
		lblNomeCliente.setText(infos[1]);
		lblNumeroAcm.setText(infos[0]);
		lblPreco.setText(infos[9]);

		// Preenchendo table de itens da conta da hospedagem
		modelItens.addColumn("Descrição");
		modelItens.addColumn("Preço");
		modelItens.addColumn("Quantidade");
		modelItens.addColumn("Data");
		String[][] itens = controller.getItensHospedagem(id);
		for (String[] linha : itens) {
			modelItens.addRow(linha);
		}

		// Preenchendo table de acompanhantes da hospedagem

		modelAcompanhantes.addColumn("Nome");
		modelAcompanhantes.addColumn("CPF");
		modelAcompanhantes.addColumn("Telefone");
		modelAcompanhantes.addColumn("Email");
		String[][] acompanhantes = controller.getAcompanhantesHospedagem(id);
		for (String[] linha : acompanhantes) {
			modelAcompanhantes.addRow(linha);
		}

		modelAcompanhantes.fireTableDataChanged();
		modelItens.fireTableDataChanged();
		btnDelItem.setEnabled(false);
		btnDelItem.setVisible(false);
	}

	private void deletarItemAction() {
		try {
			int index = tableItens.getSelectedRow();
			if (index < 0) {
				JOptionPane.showMessageDialog(null, "Selecione um item na tabela!", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			HospedagemController controller = MainController.getHospedagemController();
			controller.retirarItemHospedagem(index, Integer.parseInt(infos[0]));
			buildInfos(Integer.parseInt(infos[0]));
			JOptionPane.showMessageDialog(null, "Item deletado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível deletar o item selecionado!\n" + e.getMessage(),
					"Erro!", JOptionPane.ERROR_MESSAGE);
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Erro ao selecionar um item da tabela!\n" + e.getMessage(), "Erro!",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Orroceu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
