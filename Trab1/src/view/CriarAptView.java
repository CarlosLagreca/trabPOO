package view;

import controller.MainController;
import controller.AptController;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.Pagamento.ETipoPagamento;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CriarAptView extends JFrame {

	private JPanel contentPane;
	private JTextField textNumero;
	private JTextField textOcupacaomax;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public CriarAptView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 47, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Cadastrar nova Acomodação");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textNumero = new JTextField();
		GridBagConstraints gbc_textNumero = new GridBagConstraints();
		gbc_textNumero.insets = new Insets(0, 0, 5, 0);
		gbc_textNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumero.gridx = 1;
		gbc_textNumero.gridy = 1;
		contentPane.add(textNumero, gbc_textNumero);
		textNumero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ocupacaomax");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textOcupacaomax = new JTextField();
		GridBagConstraints gbc_textOcupacaomax = new GridBagConstraints();
		gbc_textOcupacaomax.insets = new Insets(0, 0, 5, 0);
		gbc_textOcupacaomax.fill = GridBagConstraints.HORIZONTAL;
		gbc_textOcupacaomax.gridx = 1;
		gbc_textOcupacaomax.gridy = 2;
		contentPane.add(textOcupacaomax, gbc_textOcupacaomax);
		textOcupacaomax.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Suite", "naosei", "casa"}));
		
		//TODO: Resolver combobox de categoria
		
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		contentPane.add(comboBox, gbc_comboBox);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnCriar = new GridBagConstraints();
		gbc_btnCriar.gridwidth = 2;
		gbc_btnCriar.gridx = 0;
		gbc_btnCriar.gridy = 5;
		contentPane.add(btnCriar, gbc_btnCriar);
	}
	
	private void ActionCriar() {
		AptController controller = MainController.getAptController();
		int numero = Integer.parseInt(textNumero.getText());
		int ocupacaomax = Integer.parseInt(textOcupacaomax.getText());
		String tipo = comboBox.getSelectedItem().toString();
		controller.addApartamento(numero, ocupacaomax, tipo);
		
		
	}

}
