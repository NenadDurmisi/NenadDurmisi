package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;
	
	
	@Override
	public double area() {
		return super.area() - innerRadius*innerRadius*Math.PI;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return super.contains(x, y) && super.center.distance(new Point(x,y))>= innerRadius;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		
		g.drawOval(center.getX()-innerRadius, center.getY()-innerRadius, innerRadius*2, innerRadius*2);
		//g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		//super.setColor(Color.RED);
		//g.fillOval(center.getX()-innerRadius, center.getY()-innerRadius, innerRadius*2, innerRadius*2);
		
		
		
		
		//g.fillOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		
		 
		if(super.isSelected()) {
			g.drawRect(this.getCenter().getX() - this.innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
		    g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.innerRadius - 3, 6, 6);
		    g.drawRect(this.getCenter().getX() + this.innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
		    g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.innerRadius - 3, 6, 6);
		}
		    
	       // g.drawRect(this.getCenter().getX() - this.radius - 3, this.getCenter().getY() - 3, 6, 6);
	       // g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.radius - 3, 6, 6);
	       // g.drawRect(this.getCenter().getX() + this.radius - 3, this.getCenter().getY() - 3, 6, 6);
	       // g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.radius - 3, 6, 6);
		
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			return (int)(area() - ((Donut)o).area());
		}
		return 0;
	}
	
	//Konstruktori
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius , int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		this.selected = selected;
	}
	
	//Get i set metode
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	
}
