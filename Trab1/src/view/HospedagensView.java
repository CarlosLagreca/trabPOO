package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;

public class HospedagensView extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table_2;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public HospedagensView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hospedagens Ativas", null, panel_1, null);
		
		JLabel lblNewLabel_3 = new JLabel("Itens da Hospedagem");
		
		JButton btnNewButton = new JButton("Visualizar Hospedagem");
		
		table_2 = new JTable();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(209)
					.addComponent(lblNewLabel_3)
					.addGap(210))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(194, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(189))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addComponent(table_2, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addGap(14)
					.addComponent(table_2, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Hospedagens Antigas", null, panel, null);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1_1 = new JPanel();
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Itens da Hospedagem");
		
		JButton btnNewButton_1 = new JButton("Visualizar Hospedagem");
		
		table = new JTable();
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 524, Short.MAX_VALUE)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(209)
					.addComponent(lblNewLabel_3_1)
					.addGap(210))
				.addGroup(Alignment.TRAILING, gl_panel_1_1.createSequentialGroup()
					.addContainerGap(194, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(189))
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(30)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 305, Short.MAX_VALUE)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3_1)
					.addGap(14)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
	}
}
