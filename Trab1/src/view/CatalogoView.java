package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HospedagemController;
import controller.ItemController;
import controller.MainController;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

public class CatalogoView extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	DefaultTableModel tableModel = new DefaultTableModel();
	private JComboBox comboBox;
	private JScrollPane barraRolagem;
	private JTextField textCodigo;
	private JTextField textNApt;
	JSpinner spinner;

	/**
	 * Create the frame.
	 */
	public CatalogoView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CatalogoView.class.getResource("/view/icone.png")));
		setTitle("Catálogo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setMinimumSize(new Dimension(300,300));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Selecione uma Categoria");

		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(contentCombobox()));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarAction();
			}
		});

		table_1 = new JTable();
		table_1.setModel(tableModel);
		try {
			buildTable(comboBox.getSelectedItem().toString());
		} catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível acessar os Itens!", "Erro!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		tableModel.fireTableDataChanged();
		barraRolagem = new JScrollPane(table_1);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarAction();
			}
		});
		btnConfirmar.setToolTipText("Adicionar item selecionado à conta da hospedagem");
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade:");
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo item:");
		
		textNApt = new JTextField();
		textNApt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nº Apt.:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, 0, 314, Short.MAX_VALUE))
						.addComponent(barraRolagem, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnConfirmar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(spinner, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
						.addComponent(lblNewLabel_1)
						.addComponent(textCodigo, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2)
						.addComponent(textNApt, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(barraRolagem, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
							.addGap(11))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(1)
							.addComponent(textNApt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2)
							.addGap(1)
							.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addGap(1)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnConfirmar)
							.addGap(8))))
		);
		panel.setLayout(gl_panel);
	}
	
	private void confirmarAction() {
		try {
			HospedagemController controller = MainController.getHospedagemController();
			int numeroAcomodacao = Integer.parseInt(textNApt.getText());
			String itemCodigo = textCodigo.getText();
			String categoria = comboBox.getSelectedItem().toString();
			int quantidade = Integer.parseInt(spinner.getValue().toString());
			int ret = controller.addItemConta(numeroAcomodacao, categoria, itemCodigo, quantidade);
			if(ret == 2) {
				JOptionPane.showMessageDialog(null, "Insira um código de item válido!", "Erro!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(ret == 3) {
				JOptionPane.showMessageDialog(null, "Não há hospedagens nessa acomodação!", "Erro!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null, "Produto inserido na conta!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
			textNApt.setText("");
			textCodigo.setText("");
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente", "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private String[] contentCombobox() {
		ItemController controller = MainController.getItemController();
		String[] categorias = controller.getCategorias();
		return categorias;
	}
	
	private void buildTable(String categoria) {
		ItemController controller = MainController.getItemController();
		tableModel.setColumnCount(0);
		tableModel.setRowCount(0);
		tableModel.addColumn("Codigo");
		tableModel.addColumn("Descrição");
		tableModel.addColumn("Preço");
		String[][] linhas = controller.getItens(categoria);
		for(int i = 0; i<linhas.length; i++) {
			String[] linha = new String[3];
			linha[0] = linhas[i][0];
			linha[1] = linhas[i][1];
			linha[2] = linhas[i][2];
			tableModel.addRow(linha);
		}
		
		tableModel.fireTableDataChanged();
	}
	
	private void listarAction() {
		String categoria = comboBox.getSelectedItem().toString();
		buildTable(categoria);
	}
}
