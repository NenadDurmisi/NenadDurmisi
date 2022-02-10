package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField textFieldHeight;
	public JTextField textFieldWidth;
	
	private boolean cancel;
	private int check;
	public JTextField textFieldx;
	public JTextField textFieldy;
	private int one,two,three,four;
	
	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public JTextField getTextFieldx(){
		return textFieldx;
	}
	
	public JTextField getTextFieldy() {
		return textFieldy;
	}
	
	public boolean isCancel() {
		return cancel;
	}

	public int getCheck() {
		return check;
	}
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);{
	{
		JLabel lblNewLabel = new JLabel("Enter rectangle data");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 12;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
	}
	{
				JLabel lblHeight = new JLabel("Height");
				lblHeight.setFont(new Font("Tahoma", Font.BOLD, 20));
				GridBagConstraints gbc_lblHeight = new GridBagConstraints();
				gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
				gbc_lblHeight.gridx = 4;
				gbc_lblHeight.gridy = 1;
				contentPanel.add(lblHeight, gbc_lblHeight);
			}
	textFieldHeight = new JTextField();
	textFieldHeight.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldHeight.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent arg0) {
			char c = arg0.getKeyChar();
			if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE) {
				arg0.consume();
			}
		}
	});
	textFieldHeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
	GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
	gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldHeight.gridwidth = 7;
	gbc_textFieldHeight.insets = new Insets(0, 0, 5, 5);
	gbc_textFieldHeight.gridx = 7;
	gbc_textFieldHeight.gridy = 1;
	contentPanel.add(textFieldHeight, gbc_textFieldHeight);
	textFieldHeight.setColumns(10);
	{
		JLabel lblWidth = new JLabel("Width");
		lblWidth.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidth.gridx = 4;
		gbc_lblWidth.gridy = 2;
		contentPanel.add(lblWidth, gbc_lblWidth);
	}
	textFieldWidth = new JTextField();
	textFieldWidth.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldWidth.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent arg0) {
			char c = arg0.getKeyChar();
			if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE) {
				arg0.consume();
			}
		}
	});
	textFieldWidth.setFont(new Font("Tahoma", Font.PLAIN, 20));
	GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
	gbc_textFieldWidth.gridwidth = 7;
	gbc_textFieldWidth.insets = new Insets(0, 0, 5, 5);
	gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldWidth.gridx = 7;
	gbc_textFieldWidth.gridy = 2;
	contentPanel.add(textFieldWidth, gbc_textFieldWidth);
	textFieldWidth.setColumns(10);
	{
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 3;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}
}
{
	textFieldx = new JTextField();
	textFieldx.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent arg0) {
			char c = arg0.getKeyChar();
			if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE) {
				arg0.consume();
			}
		}
	});
	textFieldx.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldx.setFont(new Font("Tahoma", Font.PLAIN, 20));
	GridBagConstraints gbc_textFieldx = new GridBagConstraints();
	gbc_textFieldx.gridwidth = 7;
	gbc_textFieldx.insets = new Insets(0, 0, 5, 5);
	gbc_textFieldx.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldx.gridx = 7;
	gbc_textFieldx.gridy = 3;
	contentPanel.add(textFieldx, gbc_textFieldx);
	textFieldx.setColumns(10);
}
{
	JLabel lblNewLabel_2 = new JLabel("Y");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
	GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
	gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
	gbc_lblNewLabel_2.gridx = 4;
	gbc_lblNewLabel_2.gridy = 4;
	contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
}
{
	textFieldy = new JTextField();
	textFieldy.addKeyListener(new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent arg0) {
			char c = arg0.getKeyChar();
			if(c < '0' || c > '9' || c == KeyEvent.VK_SPACE) {
				arg0.consume();
			}
		}
	});
	textFieldy.setHorizontalAlignment(SwingConstants.CENTER);
	textFieldy.setFont(new Font("Tahoma", Font.PLAIN, 20));
	GridBagConstraints gbc_textFieldy = new GridBagConstraints();
	gbc_textFieldy.gridwidth = 7;
	gbc_textFieldy.insets = new Insets(0, 0, 5, 5);
	gbc_textFieldy.fill = GridBagConstraints.HORIZONTAL;
	gbc_textFieldy.gridx = 7;
	gbc_textFieldy.gridy = 4;
	contentPanel.add(textFieldy, gbc_textFieldy);
	textFieldy.setColumns(10);
}
		{
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							 one = Integer.parseInt(textFieldHeight.getText());
							 two = Integer.parseInt(textFieldWidth.getText());
							 three = Integer.parseInt(textFieldx.getText());
							 four = Integer.parseInt(textFieldy.getText());
							
							check = 3;
							dispose();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Unesite vrednosti u polja!", "Greska",JOptionPane.ERROR_MESSAGE);
						}
						
						if(one > 0 && one < 255 && two > 0 && two < 255)
						{
							dispose();
						}
						else {
							check = 2;
							JOptionPane.showMessageDialog(null, "Unesite vrednosti u rangu od 0 do 255", "Greska",JOptionPane.ERROR_MESSAGE);
							
						
					}
						
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancel = true;
						dispose();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
}

