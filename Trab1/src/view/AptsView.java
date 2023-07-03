package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.AptController;
import controller.MainController;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AptsView extends JFrame {
	private static final long serialVersionUID = -8187103615057378282L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JScrollPane barraRolagem;
	private JButton btnDetalhes;
	@SuppressWarnings("serial")
	private DefaultTableModel tableModel = new DefaultTableModel(){
		
		@Override
		public boolean isCellEditable(int row, int column) {
			//all cells false
			return false;
		}
	};

	public AptsView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AptsView.class.getResource("/view/icone.png")));
		setTitle("Lista de Apartamentos");
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 114, 71, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblNewLabel = new JLabel("Apartamentos existentes");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		table = new JTable();
		barraRolagem = new JScrollPane(table);
		table.setModel(tableModel);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 2;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 1;
		panel.add(barraRolagem, gbc_table);
		
		btnDetalhes = new JButton("Detalhes");
		btnDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detalhesAction();
			}
		});
		GridBagConstraints gbc_btnDetalhes = new GridBagConstraints();
		gbc_btnDetalhes.gridx = 2;
		gbc_btnDetalhes.gridy = 2;
		panel.add(btnDetalhes, gbc_btnDetalhes);
		setTable();
	}
	
	private void setTable() {
		AptController controller = MainController.getAptController();
		
		tableModel.setColumnCount(0);
		tableModel.setRowCount(0);
		tableModel.addColumn("Túmero");
		tableModel.addColumn("Tipo");
		tableModel.addColumn("Estado");
		String[][] tabela = controller.getApts();
		for (String[] linha : tabela) {
			tableModel.addRow(linha);
		}
		tableModel.fireTableDataChanged();
	}
	
	private void detalhesAction() {
		try {
			int index = table.getSelectedRow();
			if(index < 0) {
				JOptionPane.showMessageDialog(null, "Selecione um produto na tabela!", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			int numero = Integer.parseInt(tableModel.getValueAt(index, 0).toString());
			new CriarAptView(numero);
			setTable();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!\n" + e.getMessage(), "Erro!",
					JOptionPane.ERROR_MESSAGE);
			
		}
	}

}
