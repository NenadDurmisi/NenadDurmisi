package geometry;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String [] args) {
		JFrame frame = new JFrame();
		Drawing drawingPanel = new Drawing();
		frame.add(drawingPanel);
		frame.setSize(1066, 768);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		Point p1 = new Point(400, 400);
		//p1.draw(g);
		Point p2 = new Point(500,500);
		//p2.draw(g);
		Line l1 = new Line(p1,p2);
		//l1.draw(g);
		Circle c1 = new Circle(p1, 50);
		//c1.draw(g);
		Rectangle r2 = new Rectangle(100, 100, new Point(400,400));
		//r2.draw(g);
		Shape d1 = new Donut(new Point(r2.getUpperLeft().getX() + r2.getWidth()/2 ,
				r2.getUpperLeft().getY() + r2.getHeight()/2),80,(int)(r2.getHeight()*Math.sqrt(2))/2 );
		//d1.draw(g);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p1); // index 0
		shapes.add(l1); // index 1
		shapes.add(c1); // index 2
		shapes.add(d1);	// index 3
		shapes.add(r2); // index 4
		
		
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			it.next().moveBy(10,0);
		}
		
		System.out.println(p1);
		/*shapes.get(2).draw(g);
		shapes.get(shapes.size() - 1).draw(g);
		shapes.remove(1);
		shapes.get(1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, l1);*/
		
		//Baca exception
		/*Iterator<Shape> it2 = shapes.iterator();
		while(it2.hasNext()) {
			if(it2.next() instanceof Circle) {
				it2.next().draw(g);
			}*/
		
		/*for(Shape s: shapes) {
		if(s instanceof Circle) {
			s.draw(g);
		}
		else if(s instanceof Rectangle) {
			s.draw(g);
		}
			}*/
		
			/*for(Shape s: shapes) {
				if(s instanceof Point) {
					s.setSelected(true);
					s.draw(g);
				}
			}*/
			
			HashMap<String, Shape> hmShapes = new HashMap<String, Shape>();
			hmShapes.put("Point", shapes.get(0));
			hmShapes.put("Line", shapes.get(1));
			hmShapes.put("Circle", shapes.get(2));
			hmShapes.put("Donut", shapes.get(3));
			hmShapes.put("Rectangle", shapes.get(4));
			
			for(Map.Entry<String, Shape> me : hmShapes.entrySet()) {
				me.getValue().draw(g);
			}
		}
	}
