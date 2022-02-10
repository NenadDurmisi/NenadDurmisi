package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDodavanjeBoje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCrveno;
	private JTextField textFieldZeleno;
	private JTextField textFieldPlavo;
	private int one,two,three;
	private boolean check;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDodavanjeBoje dialog = new DlgDodavanjeBoje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDodavanjeBoje() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 54, 0, 57, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 35, 35, 35, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCrvena = new JLabel("Crvena");
			lblCrvena.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
			gbc_lblCrvena.anchor = GridBagConstraints.EAST;
			gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
			gbc_lblCrvena.gridx = 1;
			gbc_lblCrvena.gridy = 1;
			contentPanel.add(lblCrvena, gbc_lblCrvena);
		}
		{
			textFieldCrveno = new JTextField();
			textFieldCrveno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					char c = arg0.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE) {
						arg0.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldCrveno = new GridBagConstraints();
			gbc_textFieldCrveno.gridwidth = 2;
			gbc_textFieldCrveno.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldCrveno.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCrveno.gridx = 2;
			gbc_textFieldCrveno.gridy = 1;
			contentPanel.add(textFieldCrveno, gbc_textFieldCrveno);
			textFieldCrveno.setColumns(10);
		}
		{
			JLabel lblZelena = new JLabel("Zelena");
			lblZelena.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblZelena = new GridBagConstraints();
			gbc_lblZelena.anchor = GridBagConstraints.EAST;
			gbc_lblZelena.insets = new Insets(0, 0, 5, 5);
			gbc_lblZelena.gridx = 1;
			gbc_lblZelena.gridy = 2;
			contentPanel.add(lblZelena, gbc_lblZelena);
		}
		{
			textFieldZeleno = new JTextField();
			textFieldZeleno.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					char c = arg0.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE) {
						arg0.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldZeleno = new GridBagConstraints();
			gbc_textFieldZeleno.gridwidth = 2;
			gbc_textFieldZeleno.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldZeleno.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldZeleno.gridx = 2;
			gbc_textFieldZeleno.gridy = 2;
			contentPanel.add(textFieldZeleno, gbc_textFieldZeleno);
			textFieldZeleno.setColumns(10);
		}
		{
			JLabel lblPlava = new JLabel("Plava");
			lblPlava.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblPlava = new GridBagConstraints();
			gbc_lblPlava.anchor = GridBagConstraints.EAST;
			gbc_lblPlava.insets = new Insets(0, 0, 0, 5);
			gbc_lblPlava.gridx = 1;
			gbc_lblPlava.gridy = 3;
			contentPanel.add(lblPlava, gbc_lblPlava);
		}
		{
			textFieldPlavo = new JTextField();
			textFieldPlavo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					char c = arg0.getKeyChar();
					if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE) {
						arg0.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldPlavo = new GridBagConstraints();
			gbc_textFieldPlavo.gridwidth = 2;
			gbc_textFieldPlavo.insets = new Insets(0, 0, 0, 5);
			gbc_textFieldPlavo.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPlavo.gridx = 2;
			gbc_textFieldPlavo.gridy = 3;
			contentPanel.add(textFieldPlavo, gbc_textFieldPlavo);
			textFieldPlavo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							one = Integer.parseInt(textFieldCrveno.getText());
							two = Integer.parseInt(textFieldZeleno.getText());
							three = Integer.parseInt(textFieldPlavo.getText());
							if(one >= 0 && one <= 255 && two >= 0 && two <= 255 && three >= 0 && three <= 255) {
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Unete vrednosti moraju biti u intervalu od 0 do 255", "Greska", JOptionPane.WARNING_MESSAGE);
							}
						}catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Tekstualna polja ne smeju biti prazna", "Greska", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						check = true;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextFieldCrveno() {
		return textFieldCrveno;
	}

	public JTextField getTextFieldZeleno() {
		return textFieldZeleno;
	}

	public JTextField getTextFieldPlavo() {
		return textFieldPlavo;
	}

	public int getOne() {
		return one;
	}

	public int getTwo() {
		return two;
	}

	public int getThree() {
		return three;
	}

	public boolean isChecked() {
		return check;
	}
}
