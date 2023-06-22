package view;

import controller.MainController;
import controller.AptController;
import model.Acomodacao;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	String[][] tiposAcomodacao;

	/**
	 * Create the frame.
	 */
	public CriarAptView(int numeroAptVisu) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 240);
		setMinimumSize(new Dimension(450,240));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 47, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel("Cadastrar nova Acomodação");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("Numero:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textNumero = new JTextField();
		GridBagConstraints gbc_textNumero = new GridBagConstraints();
		gbc_textNumero.gridwidth = 2;
		gbc_textNumero.insets = new Insets(0, 0, 5, 5);
		gbc_textNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumero.gridx = 1;
		gbc_textNumero.gridy = 1;
		contentPane.add(textNumero, gbc_textNumero);
		textNumero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ocupacão Máxima:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textOcupacaomax = new JTextField();
		GridBagConstraints gbc_textOcupacaomax = new GridBagConstraints();
		gbc_textOcupacaomax.gridwidth = 2;
		gbc_textOcupacaomax.insets = new Insets(0, 0, 5, 5);
		gbc_textOcupacaomax.fill = GridBagConstraints.HORIZONTAL;
		gbc_textOcupacaomax.gridx = 1;
		gbc_textOcupacaomax.gridy = 2;
		contentPane.add(textOcupacaomax, gbc_textOcupacaomax);
		textOcupacaomax.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setToolTipText("Selecione o tipo da acomodação. Informações do tipo mostradas abaixo.");
		
		try {
			tiposAcomodacao = attCombobox();
			comboBox.setModel(new DefaultComboBoxModel(tiposAcomodacao[0]));
		} catch(Exception e) {
			comboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		}
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		contentPane.add(comboBox, gbc_comboBox);
		
		JButton btnCriarTipo = new JButton("Criar novo");
		btnCriarTipo.setToolTipText("Criar novo tipo de acomodação.");
		btnCriarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoAcomodacaoView janela = new TipoAcomodacaoView();
				janela.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCriarTipo = new GridBagConstraints();
		gbc_btnCriarTipo.insets = new Insets(0, 0, 5, 5);
		gbc_btnCriarTipo.gridx = 2;
		gbc_btnCriarTipo.gridy = 3;
		contentPane.add(btnCriarTipo, gbc_btnCriarTipo);
		
		JLabel lblEstado = new JLabel("");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 4;
		contentPane.add(lblEstado, gbc_lblEstado);
		
		JLabel lblInfos = new JLabel("Selecione um tipo para ver as informações");
		lblInfos.setToolTipText("Informações do tipo selecionado.");
		GridBagConstraints gbc_lblInfos = new GridBagConstraints();
		gbc_lblInfos.insets = new Insets(0, 0, 5, 0);
		gbc_lblInfos.gridwidth = 3;
		gbc_lblInfos.gridx = 1;
		gbc_lblInfos.gridy = 4;
		contentPane.add(lblInfos, gbc_lblInfos);
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	int index = comboBox.getSelectedIndex();
		    	try {
					tiposAcomodacao = attCombobox();
					comboBox.setModel(new DefaultComboBoxModel(tiposAcomodacao[0]));
				} catch(Exception exp) {
					comboBox.setModel(new DefaultComboBoxModel(new String[] {}));
				}
		    	comboBox.setSelectedIndex(index);
		    	String textLabel = "Tarifa Diária: " + tiposAcomodacao[index+1][0] + "   | Adicional acomp.: " + tiposAcomodacao[index+1][1];
		    	lblInfos.setText(textLabel);
		    }
		});
		
		ActionListener btnACCriar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionCriar();
			}
		};
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(btnACCriar);
		GridBagConstraints gbc_btnCriar = new GridBagConstraints();
		gbc_btnCriar.gridheight = 2;
		gbc_btnCriar.gridwidth = 4;
		gbc_btnCriar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCriar.gridx = 0;
		gbc_btnCriar.gridy = 5;
		contentPane.add(btnCriar, gbc_btnCriar);
		
		
		// Formatando janela para Edição
		if(numeroAptVisu > 0) {
			AptController controller = MainController.getAptController();
			lblTitulo.setText("Acomodação");
			Acomodacao apartamento = controller.getApartamento(numeroAptVisu);
			if(apartamento == null) {
				dispose();
				return;
			}
			textNumero.setText((String.format("%d", apartamento.getNumero())));
			textNumero.setEnabled(false);
			
			textOcupacaomax.setText((String.format("%d", apartamento.getOcupacaoMax())));
			textOcupacaomax.setEnabled(false);
			
			comboBox.setEnabled(false);
			
			lblEstado.setText("Estado: " + apartamento.getEstadoOcupacao().toString());
			
			btnCriar.setText("Excluir");
			btnCriar.removeActionListener(btnACCriar);
			btnCriar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ActionExcluir(apartamento.getNumero(), controller);
				}
			});
			
			
		}
		
		setVisible(true);
		
	}
	
	
	// TODO: Fazer protected (ou public) para atualizar atravez da janela de criar tipoAcomodacao
	private String[][] attCombobox() {
		try {
			AptController controller = MainController.getAptController();
			return controller.getTipos();
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado ao acessar categorias!", "Erro!", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	private void ActionCriar() {
		try {
			AptController controller = MainController.getAptController();
			int numero = Integer.parseInt(textNumero.getText());
			int ocupacaomax = Integer.parseInt(textOcupacaomax.getText());
			String tipo = comboBox.getSelectedItem().toString();
			controller.addApartamento(numero, ocupacaomax, tipo);
			JOptionPane.showMessageDialog(null, "Cadastro feito!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Informações inseridas incorretamente!", "Erro!", JOptionPane.ERROR_MESSAGE);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void ActionExcluir(int numero, AptController controller) {
		
		int input = JOptionPane.showConfirmDialog(null, "Apartamento será excluído.\nDeseja Continuar?");
		
		if(input > 0) {
			return;
		}
		
		int ret = controller.deleteApartamento(numero);
		
		if(ret == 0) {
			JOptionPane.showMessageDialog(null, "Acomodação removida!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		else if(ret == 1) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		else if(ret == 2) {
			JOptionPane.showMessageDialog(null, "Apartamento não está disponível!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
