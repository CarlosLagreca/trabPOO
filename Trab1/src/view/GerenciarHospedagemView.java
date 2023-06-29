package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HospedagemController;
import controller.MainController;
import model.Hospedagem;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerenciarHospedagemView extends JFrame {
	private static final long serialVersionUID = -8666884440398223144L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JLabel lblIdHosp;
	private JLabel lblNumeroAcm;
	private JLabel lblNomeCliente;
	private JLabel lblPreco;

	/**
	 * Create the frame.
	 */
	public GerenciarHospedagemView(int numeroAcomodacao, boolean janelaCheckout) {
		initialize(numeroAcomodacao, janelaCheckout);
		buildInfos(numeroAcomodacao);
	}

	private void initialize(int numeroAcomodacao, boolean janelaCheckout) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(GerenciarHospedagemView.class.getResource("/view/icone.png")));
		setTitle("Listagem de Hospedagens");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);

		JLabel lblNmeroDaHospedagem = new JLabel("Número da hospedagem");

		JLabel lblNewLabel_1 = new JLabel("Numero da acomodação");

		JLabel lblNewLabel_2 = new JLabel("Nome do Cliente");

		JLabel lblNewLabel_3 = new JLabel("Informações");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JLabel lblPagamento = new JLabel("Preço a ser pago");

		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PagamentoView janela = new PagamentoView(numeroAcomodacao);
				janela.setVisible(true);
			}
		});

		lblPreco = new JLabel("R$: Preço");

		lblIdHosp = new JLabel("New label");

		lblNumeroAcm = new JLabel("New label");

		lblNomeCliente = new JLabel("New label");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(32)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 410,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_3))
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
												.addComponent(lblNmeroDaHospedagem, GroupLayout.PREFERRED_SIZE, 151,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNumeroAcm).addComponent(lblNewLabel_1,
																GroupLayout.PREFERRED_SIZE, 145,
																GroupLayout.PREFERRED_SIZE))
												.addGap(55)))
								.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblIdHosp).addGap(370)))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnPagar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblPreco, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblPagamento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomeCliente))
						.addGap(79)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNmeroDaHospedagem)
						.addComponent(lblNewLabel_2).addComponent(lblNewLabel_1))
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addGap(2)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblIdHosp)
										.addComponent(lblNumeroAcm).addComponent(lblNomeCliente))
								.addGap(18).addComponent(lblNewLabel_3).addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addGap(82).addComponent(lblPagamento)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblPreco)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnPagar)))
				.addGap(24)));

		JPanel panel = new JPanel();
		tabbedPane.addTab("Itens", null, panel, null);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		table = new JTable();
		panel.add(table);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Acompanhantes", null, panel_2, null);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		table_1 = new JTable();
		panel_2.add(table_1);
		panel_1.setLayout(gl_panel_1);
		
		// Caso a janela tenha sido chamada pela janela de checkout, desabilitar opções de pagamento
		if(janelaCheckout) {
			lblPagamento.setVisible(false);
			lblPreco.setVisible(false);
			btnPagar.setEnabled(false);
			btnPagar.setVisible(false);
		}
		
	}

	private void buildInfos(int numApt) {
		HospedagemController controller = MainController.getHospedagemController();
		Hospedagem hospedagem = controller.getHospedagem(numApt);
		lblIdHosp.setText(Integer.toString(numApt));
		lblNomeCliente.setText(hospedagem.getHospede().getNome());
		lblNumeroAcm.setText(Integer.toString(numApt));
		lblPreco.setText(Double.toString(controller.getValorItens(numApt)));
	}
}
