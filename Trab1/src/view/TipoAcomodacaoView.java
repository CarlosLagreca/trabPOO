package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AptController;
import controller.MainController;

import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TipoAcomodacaoView extends JDialog{

	private static final long serialVersionUID = -541841408239843211L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textTarifaD;
	private JTextField textAdicionalAcmp;

	/**
	 * Create the frame.
	 */
	public TipoAcomodacaoView() {
		initialize();
	}
	
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TipoAcomodacaoView.class.getResource("/view/icone.png")));
		setTitle("Tipo Acomodação");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 147, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		textNome = new JTextField();
		textNome.setToolTipText("Insira o nome do tipo");
		GridBagConstraints gbc_textNome = new GridBagConstraints();
		gbc_textNome.gridwidth = 2;
		gbc_textNome.insets = new Insets(0, 0, 5, 0);
		gbc_textNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNome.gridx = 1;
		gbc_textNome.gridy = 0;
		contentPane.add(textNome, gbc_textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tarifa Diária:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textTarifaD = new JTextField();
		textTarifaD.setToolTipText("Tarifa diária cobrada pelas acomodações deste tipo.");
		GridBagConstraints gbc_textTarifaD = new GridBagConstraints();
		gbc_textTarifaD.gridwidth = 2;
		gbc_textTarifaD.insets = new Insets(0, 0, 5, 0);
		gbc_textTarifaD.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTarifaD.gridx = 1;
		gbc_textTarifaD.gridy = 1;
		contentPane.add(textTarifaD, gbc_textTarifaD);
		textTarifaD.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Adicional acompanhante:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textAdicionalAcmp = new JTextField();
		textAdicionalAcmp.setToolTipText("Valor adicional por acompanhante adicional.");
		GridBagConstraints gbc_textAdicionalAcmp = new GridBagConstraints();
		gbc_textAdicionalAcmp.gridwidth = 2;
		gbc_textAdicionalAcmp.insets = new Insets(0, 0, 5, 0);
		gbc_textAdicionalAcmp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAdicionalAcmp.gridx = 1;
		gbc_textAdicionalAcmp.gridy = 2;
		contentPane.add(textAdicionalAcmp, gbc_textAdicionalAcmp);
		textAdicionalAcmp.setColumns(10);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setVisible(false);
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 0;
		gbc_btnExcluir.gridy = 4;
		contentPane.add(btnExcluir, gbc_btnExcluir);

		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarAction();
			}
		});
		GridBagConstraints gbc_btnCriar = new GridBagConstraints();
		gbc_btnCriar.gridx = 2;
		gbc_btnCriar.gridy = 4;
		contentPane.add(btnCriar, gbc_btnCriar);
		
		setModal(true);
	}

	private void criarAction() {
		try {
			String nome = textNome.getText();
			double tarifaD = Double.parseDouble(textTarifaD.getText());
			double adicional = Double.parseDouble(textAdicionalAcmp.getText());
			AptController controller = MainController.getAptController();
			controller.addTipoAcomodacao(nome, tarifaD, adicional);
			dispose();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente!", "Erro!",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}

}
