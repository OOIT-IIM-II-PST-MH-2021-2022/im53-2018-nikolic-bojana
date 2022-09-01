package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	

	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint( Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint= endPoint;
	}
	
	public Point middleOfLine() {
		int middleX = (this.getStartPoint().getX() + this.getEndPoint().getX())/2;
		int middleY = (this.getStartPoint().getY() + this.getEndPoint().getY())/2;
		Point middle = new Point(middleX, middleY);
		return middle;
	}
	
	public double lenght() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	public Line() {
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected=selected;
	}
	
	public String toString() {
		return "Line [start= " + startPoint + " , end= " + endPoint + " , selected= " + isSelected() + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), 
				this.getEndPoint().getX(), this.getEndPoint().getY());
		if(isSelected()==true) {
			g.setColor(Color.black);
			g.drawRect(this.getStartPoint().getX()-3, this.getStartPoint().getY()-3, 6, 6);
			g.setColor(Color.black);
			g.drawRect(this.getEndPoint().getX()-3, this.getEndPoint().getY()-3, 6, 6);
			g.setColor(Color.black);
			g.drawRect(this.middleOfLine().getX()-3, this.middleOfLine().getY()-3, 6, 6);
		}
		
	}
	@Override
	public boolean contains(int x, int y) {
		return (startPoint.distance(x, y) + endPoint.distance(x, y)) - lenght() < 0.1;
	}
	@Override
	public void move(int newX, int newY) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DialogEdit() {
		DialogLine dlgLine = new DialogLine();
		for (Shape shape : PnlDrawing.shapesArrList) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				dlgLine.getTxtXStart().setText(split[4]);
				dlgLine.getTxtYStart().setText(split[7]);
				dlgLine.getTxtXEnd().setText(split[16]);
				dlgLine.getTxtYEnd().setText(split[19]);
			}
		}
		dlgLine.setVisible(true);
		
	}
	@Override
	public void AreaPainter(Graphics g) {
		// TODO Auto-generated method stub
		
	}	
	
	
}
