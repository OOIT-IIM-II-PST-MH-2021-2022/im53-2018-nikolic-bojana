package drawing;

public class Test {
	public static void main(String[] args) {
		Point p1 = new Point();
		System.out.println(p1);
		
		p1.setX(5);
		p1.setY(10);
		p1.setSelected(true);
		System.out.println(p1);
	
		Point p2 = new Point(5,10);
		p2.setSelected(true);
		System.out.println(p2);	
		
		Point p3 = new Point(5,6,true);
		System.out.println(p3);
	
		Line l1 = new Line();
		System.out.println(l1);
		
		l1.setStartPoint(p1);
		l1.setEndPoint(p3);
		l1.setSelected(true);
		
		System.out.println(l1);
		
		Line l2 = new Line(p2,p1);
		System.out.println(l2);
		
		Line l3 = new Line(p3,p2,true);
		System.out.println(l3);
		
		Line l4 = new Line(new Point(5,9), new Point(7,3), false);
		System.out.println(l4);
		
		Rectangle r1 = new Rectangle(p1, 60, 30, true);
		System.out.println(r1);
		
		Circle c1 = new Circle (p1, 30, true);
		System.out.println(c1);
		Circle c2 = new Circle (new Point(6,5,true), 35, false);
		System.out.println(c2);
		
		Donut d1 = new Donut();
		d1.setCenter(new Point(5,5));
		d1.setRadius(30);
		d1.setInnerRadius(20);
		System.out.println(d1);
		
		
		
		
		
	}
	
}
