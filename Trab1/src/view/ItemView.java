package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import exceptions.CannotCreateModelException;
import controller.ItemController;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemView extends JFrame {

	private static final long serialVersionUID = -4391183686279732571L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private JComboBox<String> comboBox;

	/**
	 * Create the frame.
	 */
	public ItemView() {
		initialize();
	}
	
	private void initialize() {
		setTitle("Adicionar Item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 360);
		setMinimumSize(new Dimension(300,200));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{85, 250, 86, 0};
		gbl_panel.rowHeights = new int[]{17, 20, 31, 20, 0, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Insira as informações do novo item");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Código");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.gridwidth = 2;
		gbc_txtCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_txtCodigo.gridx = 1;
		gbc_txtCodigo.gridy = 1;
		panel.add(txtCodigo, gbc_txtCodigo);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.gridwidth = 2;
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescricao.gridx = 1;
		gbc_txtDescricao.gridy = 2;
		panel.add(txtDescricao, gbc_txtDescricao);
		
		JLabel lblNewLabel_3 = new JLabel("Preço");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		GridBagConstraints gbc_txtPreco = new GridBagConstraints();
		gbc_txtPreco.gridwidth = 2;
		gbc_txtPreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPreco.insets = new Insets(0, 0, 5, 0);
		gbc_txtPreco.gridx = 1;
		gbc_txtPreco.gridy = 3;
		panel.add(txtPreco, gbc_txtPreco);
		
		JLabel lblNewLabel_4 = new JLabel("Categoria");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		comboBox = new JComboBox<>();
		attComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		panel.add(comboBox, gbc_comboBox);
		
		JButton btnNewButton = new JButton("Criar Categoria");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarCategoriaAction();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarAction();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 3;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 5;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
	}
	
	private void attComboBox() {
		ItemController controller = MainController.getItemController();
		String[] nomesCategorias;
		try {
			nomesCategorias = controller.getCategorias();
			comboBox.setModel(new DefaultComboBoxModel<>(nomesCategorias));
		} catch(Exception exp) {
			comboBox.setModel(new DefaultComboBoxModel<>(new String[] {}));
		}
	}
	
	private void confirmarAction() {
		try {
			ItemController controller = MainController.getItemController();
			long codigo = Long.parseLong(txtCodigo.getText());
			String descricao = txtDescricao.getText();
			double preco = Double.parseDouble(txtPreco.getText().replace(',', '.'));
			String categoria = comboBox.getSelectedItem().toString();
			controller.addItem(categoria, codigo, descricao, preco);
			JOptionPane.showMessageDialog(null, "Cadastro feito!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	
			dispose();
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente!", "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch(CannotCreateModelException e) {
			JOptionPane.showMessageDialog(null, "Item não pode ser criado.\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void criarCategoriaAction() {
		try {
			ItemController controller = MainController.getItemController();
			String input = JOptionPane.showInputDialog("Insira o nome da Categoria");
			if (input == null || (input != null && ("".equals(input)))) {
				return;
			}
			controller.addCategoria(input);
			attComboBox();
		} catch(CannotCreateModelException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível criar a categoria!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
