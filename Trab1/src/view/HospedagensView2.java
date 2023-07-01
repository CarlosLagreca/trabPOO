package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HospedagemController;
import controller.MainController;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class HospedagensView2 extends JFrame {
	private static final long serialVersionUID = 5052628961516283573L;
	private JPanel contentPane;
	private JTable tableNew;
	private JTable tableOld;
	private DefaultTableModel tableModelOld = new DefaultTableModel();
	private DefaultTableModel tableModelCurrent = new DefaultTableModel();
	private JScrollPane barraRolagem1;

	/**
	 * Create the frame.
	 */
	public HospedagensView2() {
		initialize();
		tableCurrent();
		tableOld();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 787, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		tableNew = new JTable();
		tableNew.setModel(tableModelCurrent);
		tableModelCurrent.fireTableDataChanged();
		
		barraRolagem1 = new JScrollPane(tableNew);
		contentPane.add(barraRolagem1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testeAction();
			}
		});
		contentPane.add(btnNewButton);
		setMinimumSize(new Dimension(500, 350));
		
	}
	
	private void testeAction() {
		int index = tableNew.getSelectedRow();
		System.out.println(index);
	}
	
	private void vizualizarCurrentAction() {
		try {
			String input = JOptionPane.showInputDialog("Insira a Acomodação");
			if (input == null || (input != null && ("".equals(input)))) {
				return;
			}
			GerenciarHospedagemView janela = new GerenciarHospedagemView(Integer.parseInt(input), false);
			janela.setVisible(true);
		} catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para visualizar", "Atenção", JOptionPane.WARNING_MESSAGE);
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Orroceu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void tableCurrent() {
		HospedagemController controller = MainController.getHospedagemController();
		tableNew = new JTable();
		
		
		tableModelCurrent.addColumn("Numero Apt.");
		tableModelCurrent.addColumn("ID");
		tableModelCurrent.addColumn("Nome Hospede");
		
		String[][] linhas = controller.getHospedagensAtuais();
		
		for(String[] linha : linhas) {
			tableModelCurrent.addRow(linha);
		}
		
		tableModelCurrent.fireTableDataChanged();
	}
	
	private void tableOld() {
		HospedagemController controller = MainController.getHospedagemController();
		tableOld = new JTable();
		
		
		tableModelOld.addColumn("Numero Apt.");
		tableModelOld.addColumn("ID");
		tableModelOld.addColumn("Nome Hospede");
		
		String[][] linhas = controller.getHospedagensAntigas();
		
		for(String[] linha : linhas) {
			tableModelOld.addRow(linha);
		}
		
		tableModelOld.fireTableDataChanged();
	}
}
