package drawing;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable, Moveable {

	protected boolean selected;
	private Color outline = Color.black;
	private Color fill = Color.white;
	
	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}


	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected=selected;
	}
	
	public Shape() {
		
	}
	
	public Shape( boolean selected) {
		this.selected=selected;
	}
	
	public abstract void AreaPainter(Graphics g);
	public abstract void DialogEdit();
	public abstract void draw(Graphics g);
	public abstract boolean contains(int x, int y);
	public void move(int newX, int newY) {
		// TODO Auto-generated method stub
		
	}
}
