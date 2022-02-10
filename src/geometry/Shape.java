package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable<Object> {

	protected boolean selected;
	
	protected Color color;

	public boolean setSelected;
	
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
	
	//Konstruktori
	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	//Metode pristupa
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
