package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HospedagemController;
import controller.MainController;
import model.Pagamento.ETipoPagamento;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PagamentoView extends JDialog {
	static final long serialVersionUID = -5154384979178170870L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<ETipoPagamento> comboBox ;
	private JLabel labelid;
	private JLabel TotalValor;
	/**
	 * Create the frame.
	 */
	public PagamentoView(int id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PagamentoView.class.getResource("/view/icone.png")));
		setTitle("Pagamento");
		initialize();
		setDados(id);
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		setMinimumSize(new Dimension(320, 220));

		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{98, 188, 0};
		gbl_panel.rowHeights = new int[]{17, 0, 22, 20, 36, 30, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		JLabel lblNewLabel = new JLabel("Novo Pagamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("ID Hospedagem");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		labelid = new JLabel("Teste");
		GridBagConstraints gbc_labelid = new GridBagConstraints();
		gbc_labelid.anchor = GridBagConstraints.WEST;
		gbc_labelid.insets = new Insets(0, 0, 5, 0);
		gbc_labelid.gridx = 1;
		gbc_labelid.gridy = 1;
		panel.add(labelid, gbc_labelid);
		
		JLabel lblNewLabel_3 = new JLabel("Total a ser pago:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		TotalValor = new JLabel("teste");
		TotalValor.setToolTipText("Valor total da hospedagem até o momento atual.");
		GridBagConstraints gbc_TotalValor = new GridBagConstraints();
		gbc_TotalValor.anchor = GridBagConstraints.WEST;
		gbc_TotalValor.insets = new Insets(0, 0, 5, 0);
		gbc_TotalValor.gridx = 1;
		gbc_TotalValor.gridy = 2;
		panel.add(TotalValor, gbc_TotalValor);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de pagamento:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<ETipoPagamento>(ETipoPagamento.values()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Valor a pagar:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		panel.add(textField, gbc_textField);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmarAction();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 5;
		panel.add(btnNewButton, gbc_btnNewButton);
		setModal(true);
	}
	
	private void ConfirmarAction() {
		try {
			HospedagemController controller = MainController.getHospedagemController();
			ETipoPagamento tipo = (ETipoPagamento) comboBox.getSelectedItem();
			double valor = Double.parseDouble(textField.getText());
			int id = Integer.parseInt(labelid.getText());
			controller.realizarPagamento(tipo, valor, id);
			JOptionPane.showMessageDialog(null, "Pagamento realizado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado.", "Erro!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void setDados(int id) {
		HospedagemController controller = MainController.getHospedagemController();
//		Hospedagem hospedagem = controller.getHospedagem(id);
		double valor = controller.getValorTotal(id);
		labelid.setText(Integer.toString(id));
		TotalValor.setText(Double.toString(valor));
	}
}
