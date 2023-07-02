package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import model.IHospede;
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
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JButton btnCadastrar;
	private ActionListener btnACConfirmar;
	private JLabel lblTitulo;

	public CadastroClienteView(long cpf) {
		initialize(cpf);
	}
	
	private void initialize(long cpf) {
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

		lblTitulo = new JLabel("Insira as informações do novo hospede");
		panel.add(lblTitulo);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 48, 0 };
		gbl_panel_1.rowHeights = new int[] { 40, 40, 40, 40 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.fill = GridBagConstraints.VERTICAL;
		gbc_lblNome.insets = new Insets(0, 0, 5, 0);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panel_1.add(lblNome, gbc_lblNome);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCPF = new GridBagConstraints();
		gbc_lblCPF.anchor = GridBagConstraints.WEST;
		gbc_lblCPF.fill = GridBagConstraints.VERTICAL;
		gbc_lblCPF.insets = new Insets(0, 0, 5, 0);
		gbc_lblCPF.gridx = 0;
		gbc_lblCPF.gridy = 1;
		panel_1.add(lblCPF, gbc_lblCPF);

		JLabel lblTelefone = new JLabel("Telefone:");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.WEST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 2;
		panel_1.add(lblTelefone, gbc_lblTelefone);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		panel_1.add(lblEmail, gbc_lblEmail);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 40, 40, 40, 40 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		panel_2.setLayout(gbl_panel_2);

		textNome = new JTextField();
		textNome.setToolTipText("Insira o nome do hospede.");
		GridBagConstraints gbc_textNome = new GridBagConstraints();
		gbc_textNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNome.insets = new Insets(0, 0, 5, 0);
		gbc_textNome.gridx = 0;
		gbc_textNome.gridy = 0;
		panel_2.add(textNome, gbc_textNome);
		textNome.setColumns(10);

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
		
		btnACConfirmar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmarCadastro();
			}
		};
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(btnACConfirmar);
		
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
		
		getRootPane().setDefaultButton(btnCadastrar);
		
		setModal(true);
		
		if (cpf > 0) {
			editTela(cpf);
		}
		setVisible(true);
	}

	private void ConfirmarCadastro() {
		try {
			ClienteController controller = MainController.getClienteContoller();
			String nome = textNome.getText();
			long cpf = Long.parseLong(textCpf.getText());
			long telefone = Long.parseLong(textTelefone.getText());
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
	
	private void actionConfirmarEdit() {
		try {
			ClienteController controller = MainController.getClienteContoller();
			String nome = textNome.getText();
			long cpf = Long.parseLong(textCpf.getText());
			long telefone = Long.parseLong(textTelefone.getText());
			String email = textEmail.getText();
			controller.editCliente(nome, cpf, email, telefone);
			JOptionPane.showMessageDialog(null, "Edição feita!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		
	}
	
	private void editTela(long cpf) {
		ClienteController controller = MainController.getClienteContoller();
		IHospede cliente = controller.getHospede(cpf);
		lblTitulo.setText("Modifique os dados do hospede");
		textNome.setText(cliente.getNome());
		textCpf.setText(Long.toString(cpf));
		textCpf.setEditable(false);
		textEmail.setText(cliente.getEmail());
		textTelefone.setText(Long.toString(cliente.getTelefone()));
		btnCadastrar.setToolTipText("Confirmar edição do cliente.");
		btnCadastrar.removeActionListener(btnACConfirmar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionConfirmarEdit();
			}
		});
	}
}
