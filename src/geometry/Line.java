package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	private Point startPoint;
	private Point endPoint;
	
	public double length() {
		return startPoint.distance(endPoint);
	}
	
	@Override
	public String toString() {
		return "(" + this.startPoint.getX() + ", " + this.startPoint.getY() + ")" +" --> (" + this.endPoint.getX()+ ", "
				+ this.endPoint.getY() + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line temp = (Line) obj;
			if(this.startPoint.equals(temp.startPoint) && this.endPoint.equals(temp.endPoint)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return (this.startPoint.distance(new Point(x,y)) + this.endPoint.distance(new Point(x,y)) -
				length()) <= 2;
	}
	
	@Override
	public void draw(Graphics g) {
		if(getColor() == null){
			g.setColor(Color.BLACK);
		}else {
			g.setColor(super.getColor());
		}
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
		
		if(this.isSelected()) {
			g.drawRect(this.getStartPoint().getX() - 3, this.startPoint.getY() - 3, 6, 6);
			g.drawRect(this.getStartPoint().getX() - 3, this.startPoint.getY() - 3, 6, 6);
			g.drawRect(this.getEndPoint().getX() - 3, this.getEndPoint().getY() - 3, 6, 6);
			g.drawRect(this.getEndPoint().getX() - 3, this.getEndPoint().getY() - 3, 6, 6);
		}
	}
	
	@Override
	public void moveTo(int x, int y) {
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		startPoint.setX(startPoint.getX()+byX);
		startPoint.setY(startPoint.getY()+byY);
		
		endPoint.setX(endPoint.getX()+byX);
		endPoint.setX(endPoint.getY()+byY);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			return (int)(length() - ((Line)o).length());
		}
		return 0;
	}
	
	//Konstruktori
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	//Get i set metode
	public Point getStartPoint() {
		return startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	

}
