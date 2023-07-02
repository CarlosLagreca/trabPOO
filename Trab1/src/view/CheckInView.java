package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AptController;
import controller.ClienteController;
import controller.HospedagemController;
import controller.MainController;
import model.Acomodacao;
import model.Hospede;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class CheckInView extends JFrame {
	private static final long serialVersionUID = 3592668593351058496L;
	private JPanel contentPane;
	private JTextField textCpfCliente;
	private JTable table;
	private JTextField textCpfAcompanhante;
	private JScrollPane barraRolagem;
	private JComboBox<String> comboBox_numeros;
	private JButton btnConfirmar;
	private JLabel lblApt;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private List<String> acompanhantes = new ArrayList<String>();
	private JButton btnAdicionar;
	private JToggleButton tglbtnAcompanhantes;
	private JButton btnConfCliente;
	private JLabel lblNewLabel_2;
	private JLabel lblOcupacaoMax;
	
	/*
	 * TODO: Melhorar tratamento de erros;
	 */

	public CheckInView() {
		initialize();
	}
	
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CheckInView.class.getResource("/view/icone.png")));
		setTitle("CheckIn");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 454);
		setMinimumSize(new Dimension(490, 300));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		tableModel.addColumn("Nome");
		tableModel.addColumn("Cpf");
		tableModel.addColumn("Email");
		tableModel.addColumn("Telefone");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{37, 133, 135, 0, 101, 22, 0};
		gbl_panel.rowHeights = new int[]{44, 14, 22, 27, 14, 20, 0, 0, 0, 38, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
				
		JLabel lblNewLabel = new JLabel("Selecione a Acomodação");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		lblApt = new JLabel("Selecione o número");
		lblApt.setVisible(false);
		GridBagConstraints gbc_lblApt = new GridBagConstraints();
		gbc_lblApt.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblApt.insets = new Insets(0, 0, 5, 5);
		gbc_lblApt.gridx = 2;
		gbc_lblApt.gridy = 1;
		panel.add(lblApt, gbc_lblApt);
						
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(contentCombobox()));
		comboBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				buildComboboxApt(comboBox.getSelectedItem().toString());
			}
		});
	
		lblNewLabel_2 = new JLabel("Digite o CPF do acompanhante");
		lblNewLabel_2.setEnabled(false);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);

		comboBox_numeros = new JComboBox<>();
		comboBox_numeros.setEnabled(false);
		comboBox_numeros.setVisible(false);
		comboBox_numeros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				verificarOcupacaoMax();
			}
		});
		
		GridBagConstraints gbc_comboBox_numeros = new GridBagConstraints();
		gbc_comboBox_numeros.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_numeros.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_numeros.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_numeros.gridx = 2;
		gbc_comboBox_numeros.gridy = 2;
		panel.add(comboBox_numeros, gbc_comboBox_numeros);

		tglbtnAcompanhantes = new JToggleButton("Acompanhantes");
		tglbtnAcompanhantes.setEnabled(false);
		tglbtnAcompanhantes.setToolTipText("Informe o hospede principal primeiro.");
		tglbtnAcompanhantes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				selectWindowAction();
			}
		});
		
		textCpfAcompanhante = new JTextField();
		textCpfAcompanhante.setColumns(10);
		textCpfAcompanhante.setEnabled(false);
		GridBagConstraints gbc_textCpfAcompanhante = new GridBagConstraints();
		gbc_textCpfAcompanhante.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCpfAcompanhante.insets = new Insets(0, 0, 5, 5);
		gbc_textCpfAcompanhante.gridx = 4;
		gbc_textCpfAcompanhante.gridy = 2;
		panel.add(textCpfAcompanhante, gbc_textCpfAcompanhante);
		GridBagConstraints gbc_tglbtnAcompanhantes = new GridBagConstraints();
		gbc_tglbtnAcompanhantes.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnAcompanhantes.anchor = GridBagConstraints.SOUTH;
		gbc_tglbtnAcompanhantes.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnAcompanhantes.gridx = 1;
		gbc_tglbtnAcompanhantes.gridy = 3;
		panel.add(tglbtnAcompanhantes, gbc_tglbtnAcompanhantes);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAcompanhante();
			}
		});
		
		lblOcupacaoMax = new JLabel("");
		lblOcupacaoMax.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblOcupacaoMax = new GridBagConstraints();
		gbc_lblOcupacaoMax.anchor = GridBagConstraints.NORTH;
		gbc_lblOcupacaoMax.insets = new Insets(0, 0, 5, 5);
		gbc_lblOcupacaoMax.gridx = 2;
		gbc_lblOcupacaoMax.gridy = 3;
		panel.add(lblOcupacaoMax, gbc_lblOcupacaoMax);
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdicionar.anchor = GridBagConstraints.NORTH;
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdicionar.gridx = 4;
		gbc_btnAdicionar.gridy = 3;
		panel.add(btnAdicionar, gbc_btnAdicionar);

		table = new JTable();
		table.setModel(tableModel);
		barraRolagem = new JScrollPane(table);
		table.setEnabled(false);
		GridBagConstraints gbc_barraRolagem = new GridBagConstraints();
		gbc_barraRolagem.fill = GridBagConstraints.BOTH;
		gbc_barraRolagem.insets = new Insets(0, 0, 5, 5);
		gbc_barraRolagem.gridheight = 5;
		gbc_barraRolagem.gridwidth = 3;
		gbc_barraRolagem.gridx = 1;
		gbc_barraRolagem.gridy = 4;
		panel.add(barraRolagem, gbc_barraRolagem);

		JLabel lblNewLabel_1 = new JLabel("Digite o CPF do Cliente");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 4;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textCpfCliente = new JTextField();
		textCpfCliente.setColumns(10);
		GridBagConstraints gbc_textCpfCliente = new GridBagConstraints();
		gbc_textCpfCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCpfCliente.anchor = GridBagConstraints.NORTH;
		gbc_textCpfCliente.insets = new Insets(0, 0, 5, 5);
		gbc_textCpfCliente.gridx = 4;
		gbc_textCpfCliente.gridy = 5;
		panel.add(textCpfCliente, gbc_textCpfCliente);
		
		btnConfCliente = new JButton("Confirmar Cliente");
		btnConfCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarHospede();
			}
		});
		GridBagConstraints gbc_btnConfCliente = new GridBagConstraints();
		gbc_btnConfCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConfCliente.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfCliente.gridx = 4;
		gbc_btnConfCliente.gridy = 6;
		panel.add(btnConfCliente, gbc_btnConfCliente);
		
		btnConfirmar = new JButton("Confirmar hospedagem");
		btnConfirmar.setToolTipText("Precisa selecionar uma acomodação!");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarHospedagemAction();
			}
		});
		btnConfirmar.setBackground(new Color(0, 255, 64));
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConfirmar.anchor = GridBagConstraints.SOUTH;
		gbc_btnConfirmar.gridx = 4;
		gbc_btnConfirmar.gridy = 8;
		panel.add(btnConfirmar, gbc_btnConfirmar);
		
		tableModel.addRow(new String[4]);
	}

	private void confirmarHospedagemAction() {
		try {
			HospedagemController controller = MainController.getHospedagemController();
			String cpfHospede = textCpfCliente.getText();
			String numeroAcomodacao = comboBox_numeros.getSelectedItem().toString();
			String[] cpfAcompanhantes = acompanhantes.toArray(new String[0]);

			controller.criarHospedagem(numeroAcomodacao, cpfHospede, cpfAcompanhantes);
			JOptionPane.showMessageDialog(null, "Hospedagem criada com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente.", "ERRO!", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	private void confirmarHospede() {
		try {
			ClienteController controller = MainController.getClienteContoller();
			long cpf = Long.parseLong(textCpfCliente.getText());
			Hospede hospede = controller.getHospede(cpf);
			String[] linhaPrincipal = new String[4];
			linhaPrincipal[0] = hospede.getNome();
			linhaPrincipal[1] = Long.toString(hospede.getCpf());
			linhaPrincipal[2] = hospede.getEmail();
			linhaPrincipal[3] = Long.toString(hospede.getTelefone());
			tableModel.insertRow(0, linhaPrincipal);;
			tableModel.removeRow(1);
			tableModel.fireTableDataChanged();
			
			btnConfCliente.setEnabled(false);
			btnConfCliente.setVisible(false);
			textCpfCliente.setEditable(false);
			tglbtnAcompanhantes.setEnabled(true);
			tglbtnAcompanhantes.setToolTipText("");
			
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite um CPF válido!", "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {
			int input = JOptionPane.showConfirmDialog(null, "CPF não encontrado, deseja realizar o cadastro?");
			if(input == 0) {
				CadastroClienteView janela = new CadastroClienteView(0);
				janela.setVisible(rootPaneCheckingEnabled);
			}
			return;
			
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		} 
	}

	private void addAcompanhante() {
		// Pegando dados do acompanhante no controller
		try {
			if(textCpfCliente.getText().length() < 11) {
				JOptionPane.showMessageDialog(null, "Primeiro, insira um CPF válido para hóspede principal.", "Atenção", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(textCpfAcompanhante.getText().equals(textCpfCliente.getText())) {
				JOptionPane.showMessageDialog(null, "Hospede principal não pode ser acompanhante.", "Atenção", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(acompanhantes.contains(textCpfAcompanhante.getText())) {
				JOptionPane.showMessageDialog(null, "Este acompanhante já foi adicionado!", "Atenção", JOptionPane.WARNING_MESSAGE);
				return;
			}
			ClienteController controller = MainController.getClienteContoller();
			long cpf = Long.parseLong(textCpfAcompanhante.getText());
			Hospede acompanhante = controller.getHospede(cpf);
			String novaLinha[] = new String[4];
			novaLinha[0] = acompanhante.getNome();
			novaLinha[1] = Long.toString(acompanhante.getCpf());
			novaLinha[2] = acompanhante.getEmail();
			novaLinha[3] = Long.toString(acompanhante.getTelefone());
			tableModel.addRow(novaLinha);
			tableModel.fireTableDataChanged();
			acompanhantes.add(textCpfAcompanhante.getText());
			textCpfAcompanhante.setText("");

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insira um CPF válido!", "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {
			int input = JOptionPane.showConfirmDialog(null, "CPF não encontrado, deseja realizar o cadastro?");
			if(input == 0) {
				CadastroClienteView janela = new CadastroClienteView(0);
				janela.setVisible(rootPaneCheckingEnabled);
			}
			return;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}

	private String[] contentCombobox() {
		AptController controller = MainController.getAptController();

		String[][] tipos = controller.getTipos();
		return tipos[0];
	}

	private void buildComboboxApt(String tipo) {
		AptController controller = MainController.getAptController();
		String[] apartamentos = controller.getApartamentosDisponiveis(tipo);
		if (apartamentos.length == 0) {
			lblApt.setText("Não há apartamentos disponíveis para este tipo!");
			lblApt.setForeground(new Color(255, 0, 0));
			lblApt.setVisible(true);
			comboBox_numeros.setVisible(false);
			btnConfirmar.setEnabled(false);
			btnConfirmar.setToolTipText("Precisa selecionar uma acomodação!");
			lblOcupacaoMax.setVisible(false);
			return;
		}
		comboBox_numeros.setModel(new DefaultComboBoxModel<>(apartamentos));
		comboBox_numeros.setEnabled(true);
		comboBox_numeros.setVisible(true);
		lblApt.setForeground(new Color(0, 0, 0));
		lblApt.setText("Selecione um número");
		lblApt.setVisible(true);
		btnConfirmar.setEnabled(true);
		btnConfirmar.setToolTipText("Confirmar hospedagem com os dados informados.");
		verificarOcupacaoMax();
	}
	
	private void selectWindowAction() {
		if (tglbtnAcompanhantes.isSelected()) {
			textCpfAcompanhante.setEnabled(true);
			btnAdicionar.setEnabled(true);
			lblNewLabel_2.setEnabled(true);
		} else {
			textCpfAcompanhante.setEnabled(false);
			btnAdicionar.setEnabled(false);
			lblNewLabel_2.setEnabled(false);
		}
	}
	
	private void verificarOcupacaoMax() {
		AptController controller = MainController.getAptController();
		
		int numApt = Integer.parseInt(comboBox_numeros.getSelectedItem().toString());
		Acomodacao apt = controller.getApartamento(numApt);
		
		lblOcupacaoMax.setVisible(true);
		lblOcupacaoMax.setText("Ocupação max: " + Integer.toString(apt.getOcupacaoMax()));
	}
}
