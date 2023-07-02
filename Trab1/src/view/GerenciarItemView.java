package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ItemController;
import controller.MainController;

import java.awt.Dimension;
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
import java.awt.Toolkit;

public class GerenciarItemView extends JFrame {

	private static final long serialVersionUID = 527190976211931832L;
	private JPanel contentPane;
	private JTable table;
	@SuppressWarnings("serial")
	DefaultTableModel tableModel = new DefaultTableModel(){

		@Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	private JTextField textField_1;
	private JComboBox<String> comboBox;
	private JScrollPane barraRolagem;

	/**
	 * Create the frame.
	 */
	public GerenciarItemView() {
		setTitle("Listagem Itens");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GerenciarItemView.class.getResource("/view/icone.png")));
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
		setMinimumSize(new Dimension(450, 280));

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
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, 0, 189, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(barraRolagem, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(Listar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField_1)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(Listar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(barraRolagem, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(1)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(7))
		);
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
			int index = table.getSelectedRow();
			if(index < 0) {
				JOptionPane.showMessageDialog(null, "Selecione um produto na tabela!", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			long codigo = Long.parseLong(tableModel.getValueAt(index, 0).toString());
			double preco = Double.parseDouble(textField_1.getText().replace(',', '.'));
			controller.editPreco(codigo, preco);
			JOptionPane.showMessageDialog(null, "Preço alterado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			listarAction();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente!", "Erro!",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Preço não pode ser alterado.\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void removerAction() {
		try {
			ItemController controller = MainController.getItemController();
			String categoria = (String) comboBox.getSelectedItem();
			int index = table.getSelectedRow();
			if(index < 0) {
				JOptionPane.showMessageDialog(null, "Selecione um produto na tabela!", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			long codigo = Long.parseLong(tableModel.getValueAt(index, 0).toString());
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
