package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	private Point upperLeft;
	private int width;
	private int height;
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int area() {
		return width*height;
	}
	public Rectangle() {
	}
	
	public Rectangle (Point upperLeft, int width, int height) {
		this.upperLeft=upperLeft;
		this.width=width;
		this.height=height;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected=selected;
	}
	
	public String toString() {
		return "Rectangle [ulp= " + this.upperLeft + " , width= " + this.width + 
				" , height= " + this.height + " , selected= " + isSelected() + "]";
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return (int)(this.area()-((Rectangle)o).area());
		}
		return 0;
	}
	@Override
	public void draw(Graphics g) {
		
		g.drawRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.getWidth(), this.getHeight());
		if(isSelected()==true) {
			g.setColor(getOutline());
			g.drawRect(this.getUpperLeft().getX()-3, this.getUpperLeft().getY()-3, 6, 6);
			g.drawRect(this.getUpperLeft().getX()+this.getWidth()-3, this.getUpperLeft().getY()-3, 6, 6);
			g.drawRect(this.getUpperLeft().getX()-3, this.getUpperLeft().getY()+this.getHeight()-3, 6, 6);
			g.drawRect(this.getUpperLeft().getX()+this.getWidth()-3, this.getUpperLeft().getY()+this.getHeight()-3, 6, 6);
		}
	}
	@Override
	public boolean contains(int x, int y) {
		return (this.upperLeft.getX() <= x &&
				x <= this.upperLeft.getX() + width &&
				this.upperLeft.getY() <= y &&
				y <= this.upperLeft.getY() + height);
	}
	@Override
	public void DialogEdit() {
		DialogRectangle dlgRectangle = new DialogRectangle();
		for (Shape shape : PnlDrawing.shapesArrList) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				dlgRectangle.getTxtXCoord().setText(split[4]);
				dlgRectangle.getTxtYCoord().setText(split[7]);
				dlgRectangle.getTxtWidth().setText(split[14]);
				dlgRectangle.getTxtHeight().setText(split[17]);
			}
		}
		dlgRectangle.setVisible(true);
	}
	@Override
	public void move(int newX, int newY) {
		upperLeft.move(newX, newY);
		

}
	@Override
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.getWidth(), this.getHeight());
	}
		
	
}
