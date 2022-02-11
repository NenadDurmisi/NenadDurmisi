package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import geometry.Circle;
import geometry.Point;
import javax.swing.JComboBox;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	
	private boolean cancel;
	private JButton okButton;
	
	private JTextField textFieldRadius;
	
	
	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	

	



	public boolean isCancel() {
		return cancel;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{64, 0, 209, 91, 0};
		gbl_contentPanel.rowHeights = new int[]{33, 37, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		textFieldRadius = new JTextField();
		textFieldRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent Arg0) {
				char c = Arg0.getKeyChar();
				if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE) {
					Arg0.consume();
				}
			}
		});
		{
			JLabel lblNewLabel_2 = new JLabel("Enter circle data :");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.gridwidth = 4;
			gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 0;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JLabel lblNewLabel = new JLabel("Radius :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 2;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}

		textFieldRadius.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		contentPanel.add(textFieldRadius, gbc_textField_1);
		textFieldRadius.setColumns(10);
		{
			JLabel lblNewLabel_1 = new JLabel("Boja ivice :");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 3;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
						btnNewButton.setBackground(JColorChooser.showDialog(null, "Choose color of the shape", Color.WHITE));
					
				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.gridwidth = 3;
			gbc_btnNewButton.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 1;
			gbc_btnNewButton.gridy = 3;
			contentPanel.add(btnNewButton, gbc_btnNewButton);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Boja unutrasnjosti :");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 4;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
						btnNewButton_1.setBackground(JColorChooser.showDialog(null, "Choose color of the shape", Color.WHITE));
					
				}
			});
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.gridwidth = 3;
			gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton_1.gridx = 1;
			gbc_btnNewButton_1.gridy = 4;
			contentPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		}
		{
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent Arg0) {
						try {
							Integer.parseInt(textFieldRadius.getText());
							
							dispose();
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "Radius have to be number", "Blank text fields", JOptionPane.ERROR_MESSAGE);
						}
					
						
					}
				});
				
				
				
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent Arg0) {
						cancel = true;
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
				cancelButton.setActionCommand("Cancel");
			
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(131)
						.addComponent(okButton)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton)
						.addGap(127))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(cancelButton)
							.addComponent(okButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
	}

}
