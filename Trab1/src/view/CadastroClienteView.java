package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import controller.ClienteController;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroClienteView extends JDialog {

	private static final long serialVersionUID = -2682751366885232624L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textCpf;
	private JTextField textTelefone;
	private JTextField textEmail;

	public CadastroClienteView() {
		initialize();
	}
	
	private void initialize() {
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroClienteView.class.getResource("/view/icone.png")));
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 260);
		setMinimumSize(new Dimension(400, 200));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel_4 = new JLabel("Insira as informações do novo hospede");
		panel.add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 48, 0 };
		gbl_panel_1.rowHeights = new int[] { 40, 40, 40, 40 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 40, 40, 40, 40 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		panel_2.setLayout(gbl_panel_2);

		txtNome = new JTextField();
		txtNome.setToolTipText("Insira o nome do hospede.");
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.gridx = 0;
		gbc_txtNome.gridy = 0;
		panel_2.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		textCpf = new JTextField();
		textCpf.setToolTipText("Insira o CPF do hospede");
		GridBagConstraints gbc_textCpf = new GridBagConstraints();
		gbc_textCpf.insets = new Insets(0, 0, 5, 0);
		gbc_textCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCpf.gridx = 0;
		gbc_textCpf.gridy = 1;
		panel_2.add(textCpf, gbc_textCpf);
		textCpf.setColumns(10);

		textTelefone = new JTextField();
		textTelefone.setToolTipText("Insira o telefone do hospede");
		GridBagConstraints gbc_textTelefone = new GridBagConstraints();
		gbc_textTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_textTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefone.gridx = 0;
		gbc_textTelefone.gridy = 2;
		panel_2.add(textTelefone, gbc_textTelefone);
		textTelefone.setColumns(10);

		textEmail = new JTextField();
		textEmail.setToolTipText("Insira o email do hospede");
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 0;
		gbc_textEmail.gridy = 3;
		panel_2.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmarCadastro();
			}
		});
		btnCadastrar.setBackground(new Color(187, 255, 187));
		btnCadastrar.setToolTipText("Confirmar cadastro do hospede.");
		panel_4.add(btnCadastrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBackground(new Color(255, 153, 153));
		panel_4.add(btnCancelar);
		
		setModal(true);
	}

	private void ConfirmarCadastro() {
		try {
			ClienteController controller = MainController.getClienteContoller();
			String nome = txtNome.getText();
			Long cpf = Long.parseLong(textCpf.getText());
			Long telefone = Long.parseLong(textTelefone.getText());
			String email = textEmail.getText();
			int ret = controller.cadastrarCliente(nome, cpf, telefone, email);
			if (ret == 2) {
				JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null, "Cadastro feito!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente!", "Erro!",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}

	}
}
