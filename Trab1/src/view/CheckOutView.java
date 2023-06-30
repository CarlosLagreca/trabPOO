package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HospedagemController;
import controller.MainController;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckOutView extends JFrame {

	private static final long serialVersionUID = -6623236853252917922L;
	private JPanel contentPane;
	private JLabel lblNumeroApt;
	private JLabel lblTipoApt;
	private JLabel lblNomeCliente;
	private JLabel lblCpfCliente;
	private JLabel lblPeriodoEstadia;
	private JLabel lblAcompanhantes;
	private JLabel lblDiaria;
	private JLabel lblPrecoAcomp;
	private JLabel lblPreçoTotal;
	private JLabel lblPreçoPago;
	private JLabel lblConta;
	private String[] infos;


	public CheckOutView(int numeroAcomodacao) {
		setTitle("Checkout");
		initialize();
		fillLabels(numeroAcomodacao);
	}
	
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CheckOutView.class.getResource("/view/icone.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 597, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 159, 0, 0, 31, 123, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 37, 40, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Número Apt:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNumeroApt = new JLabel("New label");
		GridBagConstraints gbc_lblNumeroApt = new GridBagConstraints();
		gbc_lblNumeroApt.anchor = GridBagConstraints.WEST;
		gbc_lblNumeroApt.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroApt.gridx = 2;
		gbc_lblNumeroApt.gridy = 1;
		panel.add(lblNumeroApt, gbc_lblNumeroApt);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo Apt:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 1;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblTipoApt = new JLabel("New label");
		GridBagConstraints gbc_lblTipoApt = new GridBagConstraints();
		gbc_lblTipoApt.anchor = GridBagConstraints.WEST;
		gbc_lblTipoApt.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoApt.gridx = 5;
		gbc_lblTipoApt.gridy = 1;
		panel.add(lblTipoApt, gbc_lblTipoApt);
		
		JLabel lblNewLabel_2 = new JLabel("Nome do Cliente:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblNomeCliente = new JLabel("New label");
		GridBagConstraints gbc_lblNomeCliente = new GridBagConstraints();
		gbc_lblNomeCliente.anchor = GridBagConstraints.WEST;
		gbc_lblNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeCliente.gridx = 2;
		gbc_lblNomeCliente.gridy = 2;
		panel.add(lblNomeCliente, gbc_lblNomeCliente);
		
		JLabel lblNewLabel_4 = new JLabel("Cpf do Cliente:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 2;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblCpfCliente = new JLabel("New label");
		GridBagConstraints gbc_lblCpfCliente = new GridBagConstraints();
		gbc_lblCpfCliente.anchor = GridBagConstraints.WEST;
		gbc_lblCpfCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpfCliente.gridx = 5;
		gbc_lblCpfCliente.gridy = 2;
		panel.add(lblCpfCliente, gbc_lblCpfCliente);
		
		JLabel lblNewLabel_1 = new JLabel("Período de estadia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblPeriodoEstadia = new JLabel("New label");
		GridBagConstraints gbc_lblPeriodoEstadia = new GridBagConstraints();
		gbc_lblPeriodoEstadia.anchor = GridBagConstraints.WEST;
		gbc_lblPeriodoEstadia.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeriodoEstadia.gridx = 2;
		gbc_lblPeriodoEstadia.gridy = 3;
		panel.add(lblPeriodoEstadia, gbc_lblPeriodoEstadia);
		
		JLabel lblNewLabel_5 = new JLabel("Acompanhantes:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 3;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		lblAcompanhantes = new JLabel("New label");
		GridBagConstraints gbc_lblAcompanhantes = new GridBagConstraints();
		gbc_lblAcompanhantes.anchor = GridBagConstraints.WEST;
		gbc_lblAcompanhantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcompanhantes.gridx = 5;
		gbc_lblAcompanhantes.gridy = 3;
		panel.add(lblAcompanhantes, gbc_lblAcompanhantes);
		
		JLabel lblNewLabel_6 = new JLabel("Total diárias:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 5;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		lblDiaria = new JLabel("New label");
		GridBagConstraints gbc_lblDiaria = new GridBagConstraints();
		gbc_lblDiaria.anchor = GridBagConstraints.WEST;
		gbc_lblDiaria.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiaria.gridx = 2;
		gbc_lblDiaria.gridy = 5;
		panel.add(lblDiaria, gbc_lblDiaria);
		
		JLabel lblNewLabel_12 = new JLabel("Total da Hospedagem:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 4;
		gbc_lblNewLabel_12.gridy = 5;
		panel.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("Valor Pago:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 5;
		gbc_lblNewLabel_14.gridy = 5;
		panel.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		JLabel lblNewLabel_9 = new JLabel("Total Acompanhantes:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 6;
		panel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		lblPrecoAcomp = new JLabel("New label");
		GridBagConstraints gbc_lblPrecoAcomp = new GridBagConstraints();
		gbc_lblPrecoAcomp.anchor = GridBagConstraints.WEST;
		gbc_lblPrecoAcomp.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecoAcomp.gridx = 2;
		gbc_lblPrecoAcomp.gridy = 6;
		panel.add(lblPrecoAcomp, gbc_lblPrecoAcomp);
		
		lblPreçoTotal = new JLabel("New label");
		lblPreçoTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPreçoTotal = new GridBagConstraints();
		gbc_lblPreçoTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreçoTotal.gridx = 4;
		gbc_lblPreçoTotal.gridy = 6;
		panel.add(lblPreçoTotal, gbc_lblPreçoTotal);
		
		lblPreçoPago = new JLabel("New label");
		lblPreçoPago.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPreçoPago = new GridBagConstraints();
		gbc_lblPreçoPago.anchor = GridBagConstraints.EAST;
		gbc_lblPreçoPago.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreçoPago.gridx = 5;
		gbc_lblPreçoPago.gridy = 6;
		panel.add(lblPreçoPago, gbc_lblPreçoPago);
		
		JLabel lblNewLabel_8 = new JLabel("Total Conta:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 7;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		lblConta = new JLabel("New label");
		GridBagConstraints gbc_lblConta = new GridBagConstraints();
		gbc_lblConta.anchor = GridBagConstraints.WEST;
		gbc_lblConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblConta.gridx = 2;
		gbc_lblConta.gridy = 7;
		panel.add(lblConta, gbc_lblConta);
		
		JButton btnVisualizar = new JButton("Visualizar Detalhes");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visualizarAction();
			}
		});
		GridBagConstraints gbc_btnVisualizar = new GridBagConstraints();
		gbc_btnVisualizar.insets = new Insets(0, 0, 5, 5);
		gbc_btnVisualizar.gridx = 4;
		gbc_btnVisualizar.gridy = 7;
		panel.add(btnVisualizar, gbc_btnVisualizar);
		
		JButton btnPagar = new JButton("Pagar");
		GridBagConstraints gbc_btnPagar = new GridBagConstraints();
		gbc_btnPagar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPagar.insets = new Insets(0, 0, 5, 5);
		gbc_btnPagar.gridx = 5;
		gbc_btnPagar.gridy = 7;
		panel.add(btnPagar, gbc_btnPagar);
		
		JButton btnCheckout = new JButton("CheckOut");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkoutAction();
			}
		});
		btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnCheckout = new GridBagConstraints();
		gbc_btnCheckout.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCheckout.gridwidth = 2;
		gbc_btnCheckout.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckout.gridx = 4;
		gbc_btnCheckout.gridy = 8;
		panel.add(btnCheckout, gbc_btnCheckout);
	}
	
	private void checkoutAction() {
		HospedagemController controller = MainController.getHospedagemController();
		controller.realizarCheckout(Integer.parseInt(infos[0]));
		JOptionPane.showMessageDialog(null, "Checkout realizado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}
	
	private void visualizarAction() {
		GerenciarHospedagemView janela = new GerenciarHospedagemView(Integer.parseInt(infos[0]), true);
		janela.setVisible(true);
	}
	
	private void fillLabels(int numeroAcomodacao) {
		HospedagemController controller = MainController.getHospedagemController();
		
		// Pegando array de informações do controller
		infos = controller.getDadosHospedagem(numeroAcomodacao);
		
		// Preechendo as labels com as informações recebidas
		lblNumeroApt.setText(infos[0]);
		lblNomeCliente.setText(infos[1]);
		lblPeriodoEstadia.setText(infos[2]);
		lblTipoApt.setText(infos[3]);
		lblCpfCliente.setText(infos[4]);
		lblAcompanhantes.setText(infos[5]);
		lblDiaria.setText(infos[6]);
		lblPrecoAcomp.setText(infos[7]);
		lblConta.setText(infos[8]);
		lblPreçoTotal.setText(infos[9]);
		lblPreçoPago.setText(infos[10]);
		
	}

}
