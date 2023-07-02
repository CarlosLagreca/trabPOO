package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HospedagemController;
import controller.ItemController;
import controller.MainController;
import exceptions.OperationNotAllowedException;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;

// TODO: Zerar spin appós adicionar item.
public class CatalogoView extends JFrame {
	private static final long serialVersionUID = -2567542433679844732L;

	private JPanel contentPane;
	private JTable table_1;
	
	@SuppressWarnings("serial")
	DefaultTableModel tableModel = new DefaultTableModel(){

		@Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	
	private JComboBox<String> comboBox;
	private JScrollPane barraRolagem;
	private JTextField textNApt;
	JSpinner spinner;


	public CatalogoView() {
		initialize();
		
		// Inicializando tabela
		try {
			buildTable(comboBox.getSelectedItem().toString());
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível acessar os Itens!", "Erro!",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
	private void initialize(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(CatalogoView.class.getResource("/view/icone.png")));
		setTitle("Catálogo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setMinimumSize(new Dimension(450, 300));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Selecione uma Categoria");

		comboBox = new JComboBox<>();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel<>(contentCombobox()));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarAction();
			}
		});

		table_1 = new JTable();
		table_1.setModel(tableModel);
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
							.addComponent(barraRolagem, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
							.addGap(11))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNApt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
			// Pegando codigo do item da tabela
			int index = table_1.getSelectedRow();
			if(index < 0) {
				JOptionPane.showMessageDialog(null, "Selecione um produto na tabela!", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			int numeroAcomodacao = Integer.parseInt(textNApt.getText());
			String itemCodigo = tableModel.getValueAt(index, 0).toString();
			String categoria = comboBox.getSelectedItem().toString();
			int quantidade = Integer.parseInt(spinner.getValue().toString());
			controller.addItemConta(numeroAcomodacao, categoria, itemCodigo, quantidade);
			JOptionPane.showMessageDialog(null, "Produto inserido na conta!", "Sucesso!",
					JOptionPane.INFORMATION_MESSAGE);
			textNApt.setText("");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente", "Erro!",
					JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Erro de acesso!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch(OperationNotAllowedException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar o item na conta!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
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
		for (int i = 0; i < linhas.length; i++) {
			String[] linha = new String[3];
			linha[0] = linhas[i][0];
			linha[1] = linhas[i][1];
			linha[2] = linhas[i][2];
			tableModel.addRow(linha);
			tableModel.isCellEditable(i, 0);
		}

		tableModel.fireTableDataChanged();
	}

	private void listarAction() {
		String categoria = comboBox.getSelectedItem().toString();
		buildTable(categoria);
	}
}
