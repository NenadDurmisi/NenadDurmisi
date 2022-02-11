package stek;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;
import geometry.Rectangle;
import dialogs.DlgRectangle;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRectangle extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	private int one,two,three,four;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRectangle frame = new FrmRectangle();
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
	public FrmRectangle() {
		setTitle("Durmisi Nenad SP 18-2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("STEK");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelNorth.add(lblNewLabel);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Push");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgRectangle dlg = new DlgRectangle();
				dlg.setVisible(true);
				if(dlg.getCheck() == 3) {
					Rectangle r1 = new Rectangle(Integer.parseInt(dlg.getTextFieldHeight().getText()),Integer.parseInt(dlg.getTextFieldWidth().getText()), new Point(Integer.parseInt(dlg.getTextFieldx().getText()),Integer.parseInt(dlg.getTextFieldy().getText())));
					
					dlm.add(0, r1);
					
				}
			}
		});
		panelSouth.add(btnNewButton);
		JList<Rectangle> list = new JList<Rectangle>(dlm);
		JButton btnNewButton_1 = new JButton("Pop");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					if (!dlm.isEmpty()) {
						
						DlgRectangle dlg = new DlgRectangle();
						
							
							dlg.getTextFieldHeight().setText(String.valueOf(dlm.get(0).getHeight()));
							dlg.getTextFieldWidth().setText(String.valueOf(dlm.get(0).getWidth()));
							dlg.getTextFieldx().setText(String.valueOf(dlm.get(0).getUpperLeft().getX()));
							dlg.getTextFieldy().setText(String.valueOf(dlm.get(0).getUpperLeft().getY()));
							dlg.getTextFieldHeight().setEditable(false);
							dlg.getTextFieldWidth().setEditable(false);
							dlg.getTextFieldx().setEditable(false);
							dlg.getTextFieldy().setEditable(false);
						dlg.setVisible(true);
						if(!dlg.isCancel() == true) {
							dlm.remove(0);
						}
						
						
						
						
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Stek je prazan", "Greska", JOptionPane.WARNING_MESSAGE);
					}
					
					
				} catch (Exception e)
				{
					
					JOptionPane.showMessageDialog(null, "Stek je prazan", "Greska", JOptionPane.WARNING_MESSAGE);
				}
			
				
				//dlm.getElementAt(0);
				
				//DlgRectangle dlg = new DlgRectangle();
				//dlg.setVisible(true);
				
			}
		});
		panelSouth.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		
		list.setModel(dlm);
		list.setBackground(Color.GRAY);
		scrollPane.setViewportView(list);
	}

}
