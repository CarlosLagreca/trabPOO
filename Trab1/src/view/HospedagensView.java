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
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HospedagensView extends JFrame {
	private static final long serialVersionUID = 5052628961516283573L;
	private JPanel contentPane;
	private JTable tableNew;
	private JTable tableOld;
	DefaultTableModel tableModelOld = new DefaultTableModel();
	DefaultTableModel tableModelCurrent = new DefaultTableModel();
	private JScrollPane barraRolagem1;
	private JScrollPane barraRolagem2;

	/**
	 * Create the frame.
	 */
	public HospedagensView() {
		initialize();
		tableOld();
		tableCurrent();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hospedagens Ativas", null, panel_1, null);
		setMinimumSize(new Dimension(500, 350));
		
		JButton btnNewButton = new JButton("Visualizar Hospedagem");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vizualizarCurrentAction();
			}
		});
		
		tableNew = new JTable();
		tableNew.setModel(tableModelCurrent);
		
		barraRolagem1 = new JScrollPane(tableNew);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
						.addComponent(barraRolagem1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
					.addGap(28))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(barraRolagem1, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Hospedagens Antigas", null, panel, null);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1_1 = new JPanel();
		panel.add(panel_1_1);
		
		JButton btnNewButton_1 = new JButton("Visualizar Hospedagem");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vizualizarOldAction();
			}
		});
		
		tableOld = new JTable();
		tableOld.setModel(tableModelOld);
		barraRolagem2 = new JScrollPane(tableOld);
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
						.addComponent(barraRolagem2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
					.addGap(28))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(barraRolagem2, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		panel_1_1.setLayout(gl_panel_1_1);		
		
	}
	
	private void vizualizarOldAction() {
//		try {
//			String input = JOptionPane.showInputDialog("Insira a Acomodação");
//			if (input == null || (input != null && ("".equals(input)))) {
//				return;
//			}
//			GerenciarHospedagemView janela = new GerenciarHospedagemView(input.toString());
//			janela.setVisible(true);
//		} catch(ArrayIndexOutOfBoundsException e) {
//			JOptionPane.showMessageDialog(null, "Selecione uma linha para visualizar", "Atenção", JOptionPane.WARNING_MESSAGE);
//		} catch(Exception e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Orroceu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
//		}
		try {
			int index = tableNew.getSelectedRow();
			System.out.println(index);
			if(index <0) {
				JOptionPane.showMessageDialog(null, "Selecione um produto na tabela!", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			String idHospedagem = tableModelOld.getValueAt(index, 1).toString();
			GerenciarHospedagemView janela = new GerenciarHospedagemView(idHospedagem);		
			janela.setVisible(true);
			
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Orroceu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void vizualizarCurrentAction() {

		try {
			int index = tableNew.getSelectedRow();
			System.out.println(index);
			if(index <0) {
				JOptionPane.showMessageDialog(null, "Selecione um produto na tabela!", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			int numApt = Integer.parseInt(tableModelCurrent.getValueAt(index, 0).toString());
			GerenciarHospedagemView janela = new GerenciarHospedagemView(numApt, false);		
			janela.setVisible(true);
			
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Orroceu um erro inesperado!", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void tableCurrent() {
		HospedagemController controller = MainController.getHospedagemController();
		
		tableModelCurrent.setColumnCount(0);
		tableModelCurrent.setRowCount(0);
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
		
		tableModelCurrent.setColumnCount(0);
		tableModelCurrent.setRowCount(0);
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
