package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestFrame extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private ButtonGroup group = new ButtonGroup();
	private JTextField txtField;
	//private DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		
		JButton btnAntristres = new JButton("Antistres dugme");
		btnAntristres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)", "Vas stres je nestao",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAntristres.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panelSouth.add(btnAntristres);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{85, 84, 0, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 0, 0, 25, 25, 0};
		gbl_panelCenter.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JButton btnDodavanjeBoje = new JButton("Dodaj boju");
		btnDodavanjeBoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgDodavanjeBoje dlg = new DlgDodavanjeBoje();
				dlg.setVisible(true);
				if(!dlg.isChecked()) {
					dlm.add(0, dlg.getTextFieldCrveno().getText() + "," + dlg.getTextFieldZeleno().getText()+ "," + dlg.getTextFieldPlavo().getText());
					panelCenter.setBackground(new Color(dlg.getOne(),dlg.getTwo(),dlg.getThree()));
				}
				
			}
		});
		btnDodavanjeBoje.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panelSouth.add(btnDodavanjeBoje);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		panelCenter.add(scrollPane, gbc_scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
		
		JButton btnIzmena = new JButton("Izmeni boju");
		btnIzmena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgDodavanjeBoje dlg = new DlgDodavanjeBoje();
				try {
				String[] strings = dlm.get(list.getSelectedIndex()).split(",");
				dlg.getTextFieldCrveno().setText(strings[0]);
				dlg.getTextFieldZeleno().setText(strings[1]);
				dlg.getTextFieldPlavo().setText(strings[2]);
				dlg.setVisible(true);
				}catch(ArrayIndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(null, "Morate odabrati stavku iz liste", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				dlm.add(list.getSelectedIndex(), dlg.getTextFieldCrveno().getText() + "," + dlg.getTextFieldZeleno().getText()+ "," + dlg.getTextFieldPlavo().getText());
				dlm.remove(list.getSelectedIndex()+1);
				panelCenter.setBackground(new Color(dlg.getOne(),dlg.getTwo(),dlg.getThree()));
			}
		});
		btnIzmena.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panelSouth.add(btnIzmena);
		
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblPlavo = new JLabel("Plavo");
		lblPlavo.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblPlavo = new GridBagConstraints();
		gbc_lblPlavo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlavo.gridx = 1;
		gbc_lblPlavo.gridy = 0;
		panelCenter.add(lblPlavo, gbc_lblPlavo);
		
		JToggleButton btnPlavo = new JToggleButton("Plavo");
		btnPlavo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.add(0, lblPlavo.getText());
				panelCenter.setBackground(Color.BLUE);
				panelNorth.setBackground(Color.BLUE);
				panelSouth.setBackground(Color.BLUE);
			}
		});
		GridBagConstraints gbc_btnPlavo = new GridBagConstraints();
		gbc_btnPlavo.fill = GridBagConstraints.BOTH;
		gbc_btnPlavo.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlavo.gridx = 0;
		gbc_btnPlavo.gridy = 0;
		panelCenter.add(btnPlavo, gbc_btnPlavo);
		group.add(btnPlavo);
		
		
		JLabel lblCrveno = new JLabel("Crveno");
		lblCrveno.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblCrveno = new GridBagConstraints();
		gbc_lblCrveno.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrveno.gridx = 1;
		gbc_lblCrveno.gridy = 1;
		panelCenter.add(lblCrveno, gbc_lblCrveno);
		
		JToggleButton btnCrveno = new JToggleButton("Crveno");
		btnCrveno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dlm.add(0, lblCrveno.getText());
				panelCenter.setBackground(Color.RED);
				panelNorth.setBackground(Color.RED);
				panelSouth.setBackground(Color.RED);
			}
		});
		GridBagConstraints gbc_btnCrveno = new GridBagConstraints();
		gbc_btnCrveno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCrveno.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrveno.gridx = 0;
		gbc_btnCrveno.gridy = 1;
		panelCenter.add(btnCrveno, gbc_btnCrveno);
		group.add(btnCrveno);
		
		JLabel lblZuto = new JLabel("Zuto");
		lblZuto.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblZuto = new GridBagConstraints();
		gbc_lblZuto.insets = new Insets(0, 0, 5, 5);
		gbc_lblZuto.gridx = 1;
		gbc_lblZuto.gridy = 2;
		panelCenter.add(lblZuto, gbc_lblZuto);
		
		
		JToggleButton btnZuto = new JToggleButton("Zuto");
		btnZuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.add(0, lblZuto.getText());
				panelCenter.setBackground(Color.YELLOW);
				panelNorth.setBackground(Color.YELLOW);
				panelSouth.setBackground(Color.YELLOW);
			}
		});
		GridBagConstraints gbc_btnZuto = new GridBagConstraints();
		gbc_btnZuto.fill = GridBagConstraints.BOTH;
		gbc_btnZuto.insets = new Insets(0, 0, 5, 5);
		gbc_btnZuto.gridx = 0;
		gbc_btnZuto.gridy = 2;
		panelCenter.add(btnZuto, gbc_btnZuto);
		group.add(btnZuto);
		
		JLabel lblIzborBoje = new JLabel("Odaberite boju");
		GridBagConstraints gbc_lblIzborBoje = new GridBagConstraints();
		gbc_lblIzborBoje.anchor = GridBagConstraints.EAST;
		gbc_lblIzborBoje.insets = new Insets(0, 0, 5, 5);
		gbc_lblIzborBoje.gridx = 0;
		gbc_lblIzborBoje.gridy = 3;
		panelCenter.add(lblIzborBoje, gbc_lblIzborBoje);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(comboBox.getSelectedItem().toString()) {
				case "Zelena":
					dlm.add(0, "Zelena");
					panelCenter.setBackground(Color.GREEN);
					break;
				case "Narandzasta":
					dlm.add(0, "Narandzasta");
					panelCenter.setBackground(Color.ORANGE);
					break;
				case "Ljubicasta":
					dlm.add(0, "Ljubicasta");
					panelCenter.setBackground(Color.MAGENTA);
					break;
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Zelena", "Narandzasta", "Ljubicasta"}));
		//comboBox.setModel(dcm);
		//dcm.addElement("Zelena");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		panelCenter.add(comboBox, gbc_comboBox);
		
		JLabel lblUnosBoje = new JLabel("Unesi boju");
		GridBagConstraints gbc_lblUnosBoje = new GridBagConstraints();
		gbc_lblUnosBoje.anchor = GridBagConstraints.EAST;
		gbc_lblUnosBoje.insets = new Insets(0, 0, 0, 5);
		gbc_lblUnosBoje.gridx = 0;
		gbc_lblUnosBoje.gridy = 4;
		panelCenter.add(lblUnosBoje, gbc_lblUnosBoje);
		
		txtField = new JTextField();
		txtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.add(0, txtField.getText());
					txtField.setText("");
				}
			}
		});
		GridBagConstraints gbc_txtField = new GridBagConstraints();
		gbc_txtField.gridwidth = 2;
		gbc_txtField.insets = new Insets(0, 0, 0, 5);
		gbc_txtField.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtField.gridx = 1;
		gbc_txtField.gridy = 4;
		panelCenter.add(txtField, gbc_txtField);
		txtField.setColumns(10);
		
		
		
		
		JLabel lblNaslov = new JLabel("NASLOV");
		lblNaslov.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panelNorth.add(lblNaslov);
	}

}
