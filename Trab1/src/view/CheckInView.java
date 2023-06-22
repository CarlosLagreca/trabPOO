package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AptController;
import controller.ClienteController;
import controller.HospedagemController;
import controller.MainController;
import model.Hospede;

import java.awt.GridLayout;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
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

public class CheckInView extends JFrame {

	private JPanel contentPane;
	private JTextField textCpfCliente;
	private JTable table;
	private JTextField textCpfAcompanhante;
	private JScrollPane barraRolagem;
	JComboBox comboBox_numeros;
	JButton btnConfirmar;
	JLabel lblApt;
	DefaultTableModel tableModel = new DefaultTableModel();
	private List<String> acompanhantes = new ArrayList<String>();
	
	/*
	 * TODO: Dar dispose ao fechar janela;
	 * TODO: Melhorar tratamento de erros;
	 * TODO: Arrumar a gambiarra do controller;
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInView frame = new CheckInView();
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
	public CheckInView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CheckInView.class.getResource("/view/icone.png")));
		setTitle("CheckIn");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 511);
		setMinimumSize(new Dimension(490,300));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Selecione a Acomodação");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(contentCombobox()));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildComboboxApt(comboBox.getSelectedItem().toString());
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Digite o CPF do Cliente");
		
		textCpfCliente = new JTextField();
		textCpfCliente.setColumns(10);
		
		table = new JTable();
		table.setModel(tableModel);
		barraRolagem = new JScrollPane(table);
		tableModel.addColumn("Nome");
		tableModel.addColumn("Cpf");
		tableModel.addColumn("Email");
		tableModel.addColumn("Telefone");
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAcompanhante();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Digite o CPF do acompanhante");
		
		textCpfAcompanhante = new JTextField();
		textCpfAcompanhante.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar hospedagem");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarHospedagemAction();
			}
		});
		btnConfirmar.setBackground(new Color(0, 255, 64));
		textCpfAcompanhante.setEnabled(false);
		btnAdicionar.setEnabled(false);
		table.setEnabled(false);
		lblNewLabel_2.setEnabled(false);
		
		JToggleButton tglbtnAcompanhantes = new JToggleButton("Acompanhantes");
		tglbtnAcompanhantes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(tglbtnAcompanhantes.isSelected()) {
					lblNewLabel_2.setEnabled(true);
					textCpfAcompanhante.setEnabled(true);
					btnAdicionar.setEnabled(true);
					table.setEnabled(true);
				}
				else {
					lblNewLabel_2.setEnabled(false);
					textCpfAcompanhante.setEnabled(false);
					btnAdicionar.setEnabled(false);
					table.setEnabled(false);
				}
			}
		});
		
		comboBox_numeros = new JComboBox();
		comboBox_numeros.setEnabled(false);
		comboBox_numeros.setVisible(false);
		
		lblApt = new JLabel("Selecione o número");
		lblApt.setVisible(false);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(tglbtnAcompanhantes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(comboBox_numeros, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
									.addGap(203))
								.addComponent(lblApt, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(barraRolagem, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAdicionar, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textCpfAcompanhante, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnConfirmar, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCpfCliente, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(lblApt))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_numeros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(53)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textCpfAcompanhante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnAcompanhantes)
						.addComponent(btnAdicionar))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(barraRolagem, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(2)
							.addComponent(textCpfCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addComponent(btnConfirmar)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
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
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não deu certo", "ERRO!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void addAcompanhante() {
		//Pegando dados do acompanhante no controller
		// TODO: Verificar se o cpf do acompanhante já foi adicionado
		// TODO: Verificar se o cpf do acompanhante é o mesmo do Hospede (nao pode ne?)
		try {
			ClienteController controller = MainController.getClienteContoller();
			long cpf = Long.parseLong(textCpfAcompanhante.getText());
			Hospede acompanhante = controller.getHospede(cpf);
			acompanhantes.add(textCpfAcompanhante.getText());
			String novaLinha[] = new String[4];
			novaLinha[0] = acompanhante.getNome();
			novaLinha[1] = Long.toString(acompanhante.getCpf());
			novaLinha[2] = acompanhante.getEmail();
			novaLinha[3] = Long.toString(acompanhante.getTelefone());
			tableModel.addRow(novaLinha);
			tableModel.fireTableDataChanged();
			textCpfAcompanhante.setText("");
			
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Insira um CPF válido!", "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch(NullPointerException e) {
			//TODO: Fazer um showConfirmDialog perguntando se deseja cadastrar o CPF agora.
			JOptionPane.showMessageDialog(null, "CPF não encontrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private String[] contentCombobox(){
		AptController controller = MainController.getAptController();
		
		String[][] tipos = controller.getTipos();
		return tipos[0];
	}
	
	private void buildComboboxApt(String tipo) {
		AptController controller = MainController.getAptController();
		String[] apartamentos = controller.getApartamentosDisponiveis(tipo);
		if(apartamentos.length == 0) {
			lblApt.setText("Não há apartamentos disponíveis para este tipo!");
			lblApt.setForeground(new Color(255, 0, 0));
			lblApt.setVisible(true);
			comboBox_numeros.setVisible(false);
			btnConfirmar.setEnabled(false);
			btnConfirmar.setToolTipText("Precisa selecionar uma acomodação!");
			return;
		}
		comboBox_numeros.setModel(new DefaultComboBoxModel(apartamentos));
		comboBox_numeros.setEnabled(true);
		comboBox_numeros.setVisible(true);
		lblApt.setForeground(new Color(0, 0, 0));
		lblApt.setText("Selecione um número");
		lblApt.setVisible(true);
		btnConfirmar.setEnabled(true);
		btnConfirmar.setToolTipText("Confirmar hospedagem com os dados informados.");
	}
}
