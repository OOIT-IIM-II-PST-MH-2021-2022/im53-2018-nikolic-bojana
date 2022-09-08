package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;

public class DrawFrame extends JFrame {

	private JPanel contentPane;
	private PnlDrawing pnlDrawing = new PnlDrawing();
	static Color outline = Color.black;
	static Color area = Color.white;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawFrame frame = new DrawFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawFrame() {
		setBackground(new Color(221, 160, 221));
		setTitle("IM53-2018 Nikolic Bojana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 622);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		pnlDrawing.setBackground(Color.WHITE);
		pnlDrawing.setBorder(null);
		contentPane.add(pnlDrawing,BorderLayout.CENTER);
		
		JPanel pnlButton = new JPanel();
		pnlButton.setBackground(new Color(188, 143, 143));
		contentPane.add(pnlButton, BorderLayout.EAST);
		
		JButton btnPoint = new JButton("Point");
		btnPoint.setBackground(new Color(189, 183, 107));
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PnlDrawing.obj = Shapes.POINT;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnLine = new JButton("Line");
		btnLine.setBackground(new Color(189, 183, 107));
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PnlDrawing.obj = Shapes.LINE;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.setBackground(new Color(189, 183, 107));
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PnlDrawing.obj = Shapes.RECTANGLE;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.setBackground(new Color(189, 183, 107));
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PnlDrawing.obj = Shapes.CIRCLE;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnDonut = new JButton("Donut");
		btnDonut.setBackground(new Color(189, 183, 107));
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PnlDrawing.obj = Shapes.DONUT;
				for (Shape shape : PnlDrawing.shapesArrList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnSelect = new JButton("Select");
		btnSelect.setBackground(new Color(128, 128, 0));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to select!", "Information", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					PnlDrawing.obj = Shapes.SELECT;
				}
			}
		});
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBackground(new Color(128, 128, 0));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to modify!", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				for(Shape shape : PnlDrawing.shapesArrList) {
					if(shape.isSelected()) {
						PnlDrawing.obj = Shapes.POINT;
						shape.DialogEdit();
						return;
						}
					}
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(128, 128, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(PnlDrawing.shapesArrList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to delete!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				for (Shape shape : PnlDrawing.shapesArrList) {
					if(shape.isSelected()) {
						int ans = JOptionPane.showConfirmDialog(null, 
								"Are you sure you want to delete the selected object?",
								"Warning", JOptionPane.YES_NO_OPTION);
						if(ans == 0) {
							PnlDrawing.shapesArrList.remove(shape);
						}
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Please select an object", "Error", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.setBackground(new Color(128, 128, 0));
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
				if(outline == null) {
					outline = Color.BLACK;
				}
			}
		});
		
		JButton btnAreaColor = new JButton("Area Color");
		btnAreaColor.setBackground(new Color(128, 128, 0));
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
				if(area == null) {
					area = Color.WHITE;
				}
			}
		});
		
		GroupLayout gl_pnlButton = new GroupLayout(pnlButton);
		gl_pnlButton.setHorizontalGroup(
			gl_pnlButton.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlButton.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlButton.createParallelGroup(Alignment.LEADING)
						.addComponent(btnModify, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnSelect, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnDonut, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnCircle, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnRectangle, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnLine, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnDelete, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnOutlineColor, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnAreaColor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addComponent(btnPoint, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlButton.setVerticalGroup(
			gl_pnlButton.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlButton.createSequentialGroup()
					.addContainerGap(103, Short.MAX_VALUE)
					.addComponent(btnPoint)
					.addGap(18)
					.addComponent(btnLine)
					.addGap(18)
					.addComponent(btnRectangle)
					.addGap(18)
					.addComponent(btnCircle)
					.addGap(18)
					.addComponent(btnDonut)
					.addGap(18)
					.addComponent(btnSelect)
					.addGap(18)
					.addComponent(btnModify)
					.addGap(18)
					.addComponent(btnDelete)
					.addGap(18)
					.addComponent(btnOutlineColor)
					.addGap(18)
					.addComponent(btnAreaColor)
					.addGap(100))
		);
		pnlButton.setLayout(gl_pnlButton);
	}
}
