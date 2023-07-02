package view;

import controller.MainController;
import controller.AptController;
import model.Acomodacao;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class CriarAptView extends JFrame {

	private static final long serialVersionUID = -8004342113527068985L;
	private JPanel contentPane;
	private JTextField textNumero;
	private JTextField textOcupacaomax;
	private JComboBox<String> comboBox;
	private JLabel lblInfos;
	private JLabel lblTitulo;
	private JButton btnCriar;
	private JButton btnCriarTipo;
	private JLabel lblEstado;
	private ActionListener btnACCriar;
	String[][] tiposAcomodacao;

	/**
	 * Create the frame.
	 */
	public CriarAptView(int numeroAptVisu) {
		initialize(numeroAptVisu);
	}
	
	private void initialize(int numeroAptVisu) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CriarAptView.class.getResource("/view/icone.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 187);
		setMinimumSize(new Dimension(350,200));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 47, 0, 0};
		gbl_contentPane.rowHeights = new int[]{45, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblTitulo = new JLabel("Cadastrar nova Acomodação");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.EAST;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridwidth = 3;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 1;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("Numero:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textNumero = new JTextField();
		GridBagConstraints gbc_textNumero = new GridBagConstraints();
		gbc_textNumero.gridwidth = 2;
		gbc_textNumero.insets = new Insets(0, 0, 5, 5);
		gbc_textNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumero.gridx = 1;
		gbc_textNumero.gridy = 2;
		contentPane.add(textNumero, gbc_textNumero);
		textNumero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ocupacão Máxima:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textOcupacaomax = new JTextField();
		GridBagConstraints gbc_textOcupacaomax = new GridBagConstraints();
		gbc_textOcupacaomax.gridwidth = 2;
		gbc_textOcupacaomax.insets = new Insets(0, 0, 5, 5);
		gbc_textOcupacaomax.fill = GridBagConstraints.HORIZONTAL;
		gbc_textOcupacaomax.gridx = 1;
		gbc_textOcupacaomax.gridy = 3;
		contentPane.add(textOcupacaomax, gbc_textOcupacaomax);
		textOcupacaomax.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblInfos = new JLabel("Selecione um tipo para ver as informações");
		
		comboBox = new JComboBox<>();
		comboBox.setToolTipText("Selecione o tipo da acomodação. Informações do tipo mostradas abaixo.");
		
		try {
			attCombobox();
			comboBox.setSelectedIndex(0);
		} catch(Exception e) {
			e.printStackTrace();
			comboBox.setModel(new DefaultComboBoxModel<>(new String[] {}));
		}
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		contentPane.add(comboBox, gbc_comboBox);
		
		btnCriarTipo = new JButton("Criar novo");
		btnCriarTipo.setToolTipText("Criar novo tipo de acomodação.");
		btnCriarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoAcomodacaoView janela = new TipoAcomodacaoView();
				janela.setVisible(true);
				attCombobox();
			}
		});
		GridBagConstraints gbc_btnCriarTipo = new GridBagConstraints();
		gbc_btnCriarTipo.anchor = GridBagConstraints.WEST;
		gbc_btnCriarTipo.insets = new Insets(0, 0, 5, 5);
		gbc_btnCriarTipo.gridx = 2;
		gbc_btnCriarTipo.gridy = 4;
		contentPane.add(btnCriarTipo, gbc_btnCriarTipo);
		
		lblEstado = new JLabel("");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 5;
		contentPane.add(lblEstado, gbc_lblEstado);
		
		lblInfos.setToolTipText("Informações do tipo selecionado.");
		GridBagConstraints gbc_lblInfos = new GridBagConstraints();
		gbc_lblInfos.insets = new Insets(0, 0, 5, 0);
		gbc_lblInfos.gridwidth = 3;
		gbc_lblInfos.gridx = 1;
		gbc_lblInfos.gridy = 5;
		contentPane.add(lblInfos, gbc_lblInfos);
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	attCombobox();
		    }
		});
		
		btnACCriar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionCriar();
			}
		};
		
		btnCriar = new JButton("Criar");
		btnCriar.addActionListener(btnACCriar);
		GridBagConstraints gbc_btnCriar = new GridBagConstraints();
		gbc_btnCriar.anchor = GridBagConstraints.EAST;
		gbc_btnCriar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCriar.gridx = 1;
		gbc_btnCriar.gridy = 6;
		contentPane.add(btnCriar, gbc_btnCriar);
		
		
		// Formatando janela para Edição
		if(numeroAptVisu > 0) {
			editView(numeroAptVisu);
		}
		setVisible(true);
	}
	
	
	// TODO?: Atualizar atravez da janela de criar tipoAcomodacao
	private void attCombobox() {
		try {
			AptController controller = MainController.getAptController();
			String[][] content = controller.getTipos();
			int index = comboBox.getSelectedIndex();
			
			if(index < 0)
				index = 0;
			
	    	try {
				tiposAcomodacao = content;
				comboBox.setModel(new DefaultComboBoxModel<>(tiposAcomodacao[0]));
			} catch(Exception exp) {
				exp.printStackTrace();
				comboBox.setModel(new DefaultComboBoxModel<>(new String[] {}));
			}
	    	comboBox.setSelectedIndex(index);
	    	String textLabel = "Tarifa Diária: " + content[index+1][0] + "   | Adicional acomp.: " + content[index+1][1];
	    	lblInfos.setText(textLabel);
			
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado ao acessar categorias!", "Erro!", JOptionPane.ERROR_MESSAGE);
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
		else if(ret == 3) {
			JOptionPane.showMessageDialog(null, "Apartamento não cadastrado.", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void editView(int numeroAptVisu) {
		AptController controller = MainController.getAptController();
		lblTitulo.setText("Acomodação");
		Acomodacao apartamento = controller.getApartamento(numeroAptVisu);
		if(apartamento == null) {
			JOptionPane.showMessageDialog(null, "Apartamento não cadastrado!", "Erro!", JOptionPane.ERROR_MESSAGE);
			dispose();
			return;
		}
		textNumero.setText((String.format("%d", apartamento.getNumero())));
		textNumero.setEnabled(false);
		
		textOcupacaomax.setText((String.format("%d", apartamento.getOcupacaoMax())));
		textOcupacaomax.setEnabled(false);
		
		comboBox.setSelectedItem(apartamento.getTipo());
		
		btnCriarTipo.setEnabled(false);
		btnCriarTipo.setVisible(false);
		
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

}
