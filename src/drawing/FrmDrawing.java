package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dialogs.DlgRectangle;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import geometry.Circle;
import geometry.Donut;
import dialogs.DlgCircle;
import dialogs.DlgDonut;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnl = new PnlDrawing();
	private ButtonGroup shapesGroup = new ButtonGroup();
	private ButtonGroup actionsGroup = new ButtonGroup();
	private Point startPoint;
	private boolean check;
	private String a;
	private DefaultListModel<Shape> dlm = new DefaultListModel<Shape>();
	private ArrayList<Shape> list = new ArrayList<Shape>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
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
	public FrmDrawing() {
		setTitle("Durmisi Nenad SP18-2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelActions = new JPanel();
		contentPane.add(panelActions, BorderLayout.NORTH);
		GridBagLayout gbl_panelActions = new GridBagLayout();
		gbl_panelActions.columnWidths = new int[]{0, 0, 0, 0, 54, 91, 47, 81, 0, 0, 0, 0};
		gbl_panelActions.rowHeights = new int[]{31, 0};
		gbl_panelActions.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelActions.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelActions.setLayout(gbl_panelActions);
		
		JLabel lblActions = new JLabel("Actions");
		lblActions.setHorizontalAlignment(SwingConstants.CENTER);
		lblActions.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblActions = new GridBagConstraints();
		gbc_lblActions.insets = new Insets(0, 0, 0, 5);
		gbc_lblActions.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblActions.gridx = 5;
		gbc_lblActions.gridy = 0;
		panelActions.add(lblActions, gbc_lblActions);
		
		JToggleButton tglDraw = new JToggleButton("Draw");
		tglDraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglDraw = new GridBagConstraints();
		gbc_tglDraw.insets = new Insets(0, 0, 0, 5);
		gbc_tglDraw.fill = GridBagConstraints.VERTICAL;
		gbc_tglDraw.gridx = 7;
		gbc_tglDraw.gridy = 0;
		panelActions.add(tglDraw, gbc_tglDraw);
		actionsGroup.add(tglDraw);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		actionsGroup.add(tglbtnSelect);
		tglbtnSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnSelect.gridx = 8;
		gbc_tglbtnSelect.gridy = 0;
		panelActions.add(tglbtnSelect, gbc_tglbtnSelect);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tglbtnDelete.isSelected()) {
					//JOptionPane.showConfirmDialog(null, "Potvrda");
					int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Remove this object?","Warning",JOptionPane.YES_NO_CANCEL_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						for(int i = pnl.getShapes().size()-1; i>=0; i--) {
							if(pnl.getShapes().get(i).isSelected() == true) {
								pnl.getShapes().remove(i);
								repaint();
								break;
							}
							
						}
					}
					
					
					
				
					
				
					
				
				
					
				}
				
				
			}
		});
		actionsGroup.add(tglbtnDelete);
		tglbtnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnDelete = new GridBagConstraints();
		gbc_tglbtnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnDelete.gridx = 9;
		gbc_tglbtnDelete.gridy = 0;
		panelActions.add(tglbtnDelete, gbc_tglbtnDelete);
		
		JButton btnColor = new JButton("");
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tglbtnModify.isSelected()) {
																		
					
					for(int i = pnl.getShapes().size()-1; i>=0; i--) {
						if(pnl.getShapes().get(i).isSelected() == true) {
											
														 
								DlgCircle dlg = new DlgCircle();
								dlg.setVisible(true);
								if(dlg.isCancel() == false) {
									
									pnl.getShapes().remove(i);
									Point Center = new Point(0,0);
									int Radius = Integer.parseInt(dlg.getTextFieldRadius().getText());
									Circle temp = new Circle(Center,Radius);
									temp.setColor(btnColor.getBackground());
									pnl.getShapes().add(temp);
									repaint();
																				
															
							
						}
						
					}
					
					
				}
				
			}
			}
		});
		actionsGroup.add(tglbtnModify);
		tglbtnModify.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnModify = new GridBagConstraints();
		gbc_tglbtnModify.gridx = 10;
		gbc_tglbtnModify.gridy = 0;
		panelActions.add(tglbtnModify, gbc_tglbtnModify);
		
		JPanel panelShapes = new JPanel();
		contentPane.add(panelShapes, BorderLayout.WEST);
		GridBagLayout gbl_panelShapes = new GridBagLayout();
		gbl_panelShapes.columnWidths = new int[]{90, 0};
		gbl_panelShapes.rowHeights = new int[]{0, 0, 0, 31, 0, 0, 0, 0, 60, 0};
		gbl_panelShapes.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelShapes.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelShapes.setLayout(gbl_panelShapes);
		
		JLabel lblShapes = new JLabel("Shapes");
		lblShapes.setHorizontalAlignment(SwingConstants.CENTER);
		lblShapes.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblShapes = new GridBagConstraints();
		gbc_lblShapes.insets = new Insets(0, 0, 5, 0);
		gbc_lblShapes.anchor = GridBagConstraints.NORTH;
		gbc_lblShapes.gridx = 0;
		gbc_lblShapes.gridy = 0;
		panelShapes.add(lblShapes, gbc_lblShapes);
		
		JToggleButton tglPoint = new JToggleButton("Point");
		tglPoint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglPoint = new GridBagConstraints();
		gbc_tglPoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglPoint.insets = new Insets(0, 0, 5, 0);
		gbc_tglPoint.gridx = 0;
		gbc_tglPoint.gridy = 2;
		panelShapes.add(tglPoint, gbc_tglPoint);
		shapesGroup.add(tglPoint);
		
		JToggleButton tglLine = new JToggleButton("Line");
		tglLine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglLine = new GridBagConstraints();
		gbc_tglLine.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglLine.insets = new Insets(0, 0, 5, 0);
		gbc_tglLine.gridx = 0;
		gbc_tglLine.gridy = 3;
		panelShapes.add(tglLine, gbc_tglLine);
		shapesGroup.add(tglLine);
		
		JToggleButton tglRectangle = new JToggleButton("Rectangle");
		tglRectangle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglRectangle = new GridBagConstraints();
		gbc_tglRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_tglRectangle.gridx = 0;
		gbc_tglRectangle.gridy = 4;
		panelShapes.add(tglRectangle, gbc_tglRectangle);
		shapesGroup.add(tglRectangle);
		
		JToggleButton tglCircle = new JToggleButton("Circle");
		tglCircle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglCircle = new GridBagConstraints();
		gbc_tglCircle.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglCircle.insets = new Insets(0, 0, 5, 0);
		gbc_tglCircle.gridx = 0;
		gbc_tglCircle.gridy = 5;
		panelShapes.add(tglCircle, gbc_tglCircle);
		shapesGroup.add(tglCircle);
		
		JToggleButton tglDonut = new JToggleButton("Donut");
		tglDonut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglDonut = new GridBagConstraints();
		gbc_tglDonut.insets = new Insets(0, 0, 5, 0);
		gbc_tglDonut.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglDonut.gridx = 0;
		gbc_tglDonut.gridy = 6;
		panelShapes.add(tglDonut, gbc_tglDonut);
		shapesGroup.add(tglDonut);
		
		
		btnColor.setBackground(Color.WHITE);
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnColor.setBackground(JColorChooser.showDialog(null, "Choose color of the shape", Color.WHITE));
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.fill = GridBagConstraints.BOTH;
		gbc_btnColor.gridx = 0;
		gbc_btnColor.gridy = 8;
		panelShapes.add(btnColor, gbc_btnColor);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		pnl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tglbtnSelect.isSelected()) {
					
					
					for(int i = pnl.getShapes().size()-1; i>=0; i--) {
						pnl.getShapes().get(i).setSelected(false);
					}
					
					
					for(int i = pnl.getShapes().size()-1; i>=0; i--) {
						if(pnl.getShapes().get(i).contains(arg0.getX(), arg0.getY())) {
							pnl.getShapes().get(i).setSelected(true);
							break;
						}
					}
					repaint();
					
					
					
				} 
				else
				if(tglDraw.isSelected()) {
					if(tglPoint.isSelected()) {
						Point temp = new Point(arg0.getX(), arg0.getY());
						temp.setColor(btnColor.getBackground());
						pnl.getShapes().add(temp);
					}
					else if(tglLine.isSelected()) {
						if(check == false) {
							startPoint = new Point(arg0.getX(), arg0.getY());
							check = true;
						}
						else if(check == true) {
							Point endPoint = new Point(arg0.getX(), arg0.getY());
							Line temp = new Line(startPoint,endPoint);
							temp.setColor(btnColor.getBackground());
							pnl.getShapes().add(temp);
							check = false;
						}
					}
					else if(tglRectangle.isSelected()) {
						DlgRectangle dlg = new DlgRectangle();
						dlg.getTextFieldx().setText(String.valueOf(arg0.getX()));
						dlg.getTextFieldy().setText(String.valueOf(arg0.getY()));
						dlg.getTextFieldx().setEditable(false);
						dlg.getTextFieldy().setEditable(false);
						
						dlg.setVisible(true);
						if(dlg.isCancel() == false) {
							Rectangle temp = new Rectangle(Integer.parseInt(dlg.getTextFieldHeight().getText()),
									Integer.parseInt(dlg.getTextFieldWidth().getText()),new Point(arg0.getX(),arg0.getY()));
							temp.setColor(btnColor.getBackground());
							pnl.getShapes().add(temp);
						}
					}
					else if(tglCircle.isSelected()) {
						DlgCircle dlg = new DlgCircle();
						dlg.setVisible(true);
						if(dlg.isCancel() == false) {
							Point Center = new Point(arg0.getX(),arg0.getY());
							int Radius = Integer.parseInt(dlg.getTextFieldRadius().getText());
							Circle temp = new Circle(Center, Radius);
							temp.setColor(btnColor.getBackground());
							pnl.getShapes().add(temp);
						}
					}
					else if(tglDonut.isSelected()) {
						DlgDonut dlg = new DlgDonut();
						dlg.setVisible(true);
						if(dlg.isCancel() == false) {
							Point Center = new Point(arg0.getX(),arg0.getY());
							int Radius = Integer.parseInt(dlg.getTextFieldRadius().getText());
							int innerRadius = Integer.parseInt(dlg.getTextFieldInnerRadius().getText());
							Donut temp = new Donut(Center, Radius, innerRadius);
							temp.setColor(btnColor.getBackground());
							pnl.getShapes().add(temp);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "You have to select a shape","Shape is not selected", JOptionPane.WARNING_MESSAGE);
					}
					
					repaint();
				}
				
				
				
				
				else {
					JOptionPane.showMessageDialog(null, "Choose an action", "Action not selected", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		contentPane.add(pnl, BorderLayout.CENTER);
	}

}
