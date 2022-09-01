package drawing;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import java.util.Iterator;

public class PnlDrawing extends JPanel implements MouseListener {
	
	static int obj = 0;
	int mx, my;
	Point startLine;
	static ArrayList<Shape> shapesArrList = new ArrayList<Shape>(); 
	
	public PnlDrawing() {
		addMouseListener(this);	
	}
	
	public ArrayList<Shape> getShapes() {
		return shapesArrList;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapesArrList = shapes;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		mx=arg0.getX();
		my=arg0.getY();
		
		switch(obj) {
		case 1: 
		Point p = new Point(mx,my,false);
		p.setOutline(DrawFrame.outline);
		shapesArrList.add(p);
		System.out.println(shapesArrList);
		break;

		case 2: 
		if (startLine == null) {
			startLine = new Point (mx,my,false);
		} else {
			Point endLine = new Point(mx,my);
			Line line = new Line (startLine, endLine, false);
			line.setOutline(DrawFrame.outline);
			shapesArrList.add(line);
			startLine=null;
		}
		break; 
		
		case 3: 
		DialogRectangle dlgRectangle = new DialogRectangle();
		dlgRectangle.getTxtXCoord().setText(String.valueOf(mx));
		dlgRectangle.getTxtXCoord().setEditable(false);
		dlgRectangle.getTxtYCoord().setText(String.valueOf(my));
		dlgRectangle.getTxtYCoord().setEditable(false);
		dlgRectangle.setVisible(true);
			if(dlgRectangle.isOk == true) {
				Rectangle r = new Rectangle(new Point(mx,my),
				Integer.parseInt(dlgRectangle.getTxtWidth().getText()),
				Integer.parseInt(dlgRectangle.getTxtHeight().getText()), false);
				r.setOutline(DrawFrame.outline);
				r.setFill(DrawFrame.area);
				
				if(dlgRectangle.isOutlineBool()) {
					r.setOutline(dlgRectangle.getOutline());
				}
				if(dlgRectangle.isAreaBool()) {
					r.setFill(dlgRectangle.getArea());
				}
				
				System.out.println(r);
				shapesArrList.add(r);
			}
		break; 
		
		case 4: 
			DialogCircle dlgCircle = new DialogCircle();
			dlgCircle.getTxtXCoord().setText(String.valueOf(mx));
			dlgCircle.getTxtXCoord().setEditable(false);
			dlgCircle.getTxtYCoord().setText(String.valueOf(my));
			dlgCircle.getTxtYCoord().setEditable(false);
			dlgCircle.setVisible(true);
				if(dlgCircle.isOk == true) {
					Circle c = new Circle(new Point(mx, my),
					Integer.parseInt(dlgCircle.getTxtRadius().getText()), false);
					c.setOutline(DrawFrame.outline);
					c.setFill(DrawFrame.area);
					if(dlgCircle.isOutlineBool()) {
						c.setOutline(dlgCircle.getOutline());
					}
					if(dlgCircle.isAreaBool()) {
						c.setFill(dlgCircle.getArea());
					}
					shapesArrList.add(c);
				}
			break;
		
		case 5: 
		DialogDonut dlgDonut = new DialogDonut();
		dlgDonut.getTextX().setText(String.valueOf(mx));
		dlgDonut.getTextY().setText(String.valueOf(my));
		dlgDonut.getTextX().setEditable(false);
		dlgDonut.getTextY().setEditable(false);
		dlgDonut.setVisible(true);
		if(dlgDonut.isOk == true) {
			Donut d = new Donut(new Point(mx, my), Integer.parseInt(dlgDonut.getTxtRadius().getText()), Integer.parseInt(dlgDonut.getTxtInnerRadius().getText()), false);
			d.setOutline(DrawFrame.outline);
			d.setFill(DrawFrame.area);
			
			if(dlgDonut.isOutlineBool()) {
				d.setOutline(dlgDonut.getOutline());
			}
			if(dlgDonut.isAreaBool()) {
				d.setFill(dlgDonut.getArea());
			}
			
			shapesArrList.add(d);
		}
		break;
		
		case 6: 
		boolean match = false;
		Collections.reverse(shapesArrList);
		for (Shape shape : shapesArrList) {
			shape.setSelected(false);
			if(match == false) {
				if(shape.contains(mx, my)) {
					shape.setSelected(true);
					match = true;
				}
			}
		}
		Collections.reverse(shapesArrList);
		break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Shape shape : shapesArrList) {
			shape.AreaPainter(g);
			shape.draw(g);
		}
		repaint();
	}
	
}
