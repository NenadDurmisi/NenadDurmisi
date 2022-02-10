package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeft;
	private int height;
	private int width;
	
	public int area() {
		return height*width;
	}
	
	public int circumference() {
		return 2*height + 2*width;
	}
	
	@Override
	public String toString() {
		return "Upper left point: (" + this.upperLeft.getX() + ", " + this.upperLeft.getY() + "), width = " + this.width
				+ ", height = " + this.height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp =  (Rectangle) obj;
			if(this.upperLeft.equals(temp.upperLeft) && this.width == temp.width && this.height == temp.height) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return this.upperLeft.getX() <= x && this.upperLeft.getX()+width >= x
				&& this.upperLeft.getY()<= y && this.upperLeft.getY()+height >= y;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		if(getColor() == null){
			g.setColor(Color.BLACK);
		}else {
			g.setColor(super.getColor());
		}
		g.drawRect(this.upperLeft.getX(), this.upperLeft.getY(), width, height);
		g.fillRect(this.upperLeft.getX(), this.upperLeft.getY(), width, height);
		if(this.isSelected()) {
			g.drawRect(this.getUpperLeft().getX() - 3, this.getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3, this.getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() + width - 3, this.getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() + width - 3, this.getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3, this.getUpperLeft().getY() + height - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3, this.getUpperLeft().getY() + height - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() + width - 3, this.getUpperLeft().getY() + height - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() + width - 3, this.getUpperLeft().getY() + height - 3, 6, 6);
		}
		
	}
	
	@Override
	public void moveTo(int x, int y) {
		/*upperLeft.setX(x);
		upperLeft.setY(y);*/
		upperLeft.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return area() - ((Rectangle)o).area();
		}
		return 0;
	}

	
	//Konstruktori
	
	public Rectangle() {
		
	}
	
	public Rectangle(int height, int width, Point upperLeft) {
		this.height = height;
		this.width = width;
		this.upperLeft = upperLeft;
	}
	
	public Rectangle(int height, int width, Point upperLeft, boolean selected) {
		this(height,width, upperLeft);
		this.selected = selected;
	}
	
	//Get i set metode
	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	
	
	
}
