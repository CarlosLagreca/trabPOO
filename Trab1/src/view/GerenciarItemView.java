package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ItemController;
import controller.MainController;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GerenciarItemView extends JFrame {

	private static final long serialVersionUID = 527190976211931832L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel = new DefaultTableModel();
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<String> comboBox;
	private JScrollPane barraRolagem;

	/**
	 * Create the frame.
	 */
	public GerenciarItemView() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Seleciona uma categoria");

		comboBox = new JComboBox<>();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel<>(contentCombobox()));

		table = new JTable();
		table.setModel(tableModel);
		buildTable(comboBox.getSelectedItem().toString());
		tableModel.fireTableDataChanged();
		barraRolagem = new JScrollPane(table);

		JButton Listar = new JButton("Listar");
		Listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarAction();
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Digite o ID do item");

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Alterar preço");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarPrecoAction();
			}
		});

		JLabel lblNewLabel_2 = new JLabel("Digite um novo preço");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("Remover Item");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerAction();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup().addGap(8).addComponent(barraRolagem,
										GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)))
						.addGap(18, 34, Short.MAX_VALUE)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField, Alignment.TRAILING)
										.addComponent(Listar, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
										.addComponent(textField_1).addComponent(lblNewLabel_2, Alignment.TRAILING,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(Alignment.TRAILING,
												gl_panel.createSequentialGroup()
														.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(13)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(24)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(
										comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(Listar))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(23).addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton_1)
										.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton))
								.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(barraRolagem, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
						.addGap(7)));
		panel.setLayout(gl_panel);
	}

	private String[] contentCombobox() {
		ItemController controller = MainController.getItemController();
		return controller.getCategorias();
	}

	private void buildTable(String categoria) {
		ItemController controller = MainController.getItemController();
		tableModel.setColumnCount(0);
		tableModel.setRowCount(0);
		tableModel.addColumn("Codigo");
		tableModel.addColumn("Descrição");
		tableModel.addColumn("Preço");
		String[][] linhas = controller.getItens(categoria);
		for (int i = 0; i < linhas.length; i++) {
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

	private void alterarPrecoAction() {
		try {
			ItemController controller = MainController.getItemController();
			String categoria = (String) comboBox.getSelectedItem();
			long codigo = Long.parseLong(textField.getText());
			double preco = Double.parseDouble(textField_1.getText());
			controller.editPreco(categoria, codigo, preco);
			JOptionPane.showMessageDialog(null, "Preço alterado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			listarAction();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente!", "Erro!",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void removerAction() {
		try {
			ItemController controller = MainController.getItemController();
			String categoria = (String) comboBox.getSelectedItem();
			long codigo = Long.parseLong(textField.getText());
			controller.removeItem(categoria, codigo);
			JOptionPane.showMessageDialog(null, "Item removido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			listarAction();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente!", "Erro!",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}

}
