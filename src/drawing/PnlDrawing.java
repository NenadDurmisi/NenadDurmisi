
package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel {
	
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	
	@Override
	public void paint(Graphics g) {
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			it.next().draw(g);
		}
	}
	
	public PnlDrawing() {
		
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}
}
