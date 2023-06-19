package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ItemController;
import controller.MainController;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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

public class CatalogoView extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	DefaultTableModel tableModel = new DefaultTableModel();
	private JComboBox comboBox;
	private JScrollPane barraRolagem;

	/**
	 * Create the frame.
	 */
	public CatalogoView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CatalogoView.class.getResource("/view/icone.png")));
		setTitle("Catálogo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
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

		table_1 = new JTable();
		table_1.setModel(tableModel);
		buildTable(comboBox.getSelectedItem().toString());
		tableModel.fireTableDataChanged();
		barraRolagem = new JScrollPane(table_1);

		JButton btnNewButton_1 = new JButton("Confirmar");
		btnNewButton_1.setToolTipText("Adicionar item selecionado à conta da hospedagem");

		
		//TODO: Realmente precisa desse botão?
		JButton btnNewButton_2_1 = new JButton("Listar");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarAction();
			}
		});
		btnNewButton_2_1.setToolTipText("Listar itens da categoria selecionada");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(17)
								.addGroup(gl_panel
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(comboBox, 0, 164, Short.MAX_VALUE))
										.addComponent(barraRolagem, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 286,
												Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_2_1, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(14)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2_1)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(barraRolagem, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE).addGap(11))
						.addGroup(gl_panel.createSequentialGroup().addComponent(btnNewButton_1).addGap(8)))));
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
