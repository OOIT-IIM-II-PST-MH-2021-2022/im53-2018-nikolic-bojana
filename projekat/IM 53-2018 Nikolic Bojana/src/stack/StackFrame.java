package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StackFrame extends JFrame {

	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	Stack<Rectangle> stack = new Stack<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
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
	public StackFrame() {
		setTitle(" IM 53-2018 Nikolic Bojana ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel pnlDown = new JPanel();
		contentPane.add(pnlDown, BorderLayout.SOUTH);
		
		JButton buttonAdd = new JButton("Add");
		buttonAdd.setBackground(new Color(189, 183, 107));
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackDialog stackdlg = new StackDialog();
				stackdlg.setVisible(true);
				if (stackdlg.isOk==true) {
					Rectangle rectangle = new Rectangle(new Point
							(Integer.parseInt(stackdlg.getTextX().getText()),
							(Integer.parseInt(stackdlg.getTextY().getText()))),
							(Integer.parseInt(stackdlg.getTextWidth().getText())),
							(Integer.parseInt(stackdlg.getTextHeight().getText())));
					
					stack.push(rectangle);
					dlm.add(0, "X: " + rectangle.getUpperLeft().getX() + " , Y: "
							+ rectangle.getUpperLeft().getY() + " , Width: " +
							rectangle.getWidth() + " , Height: " + rectangle.getHeight());
							System.out.println(stack);
				}
			}
		});
	

		
		JButton buttonRemove = new JButton("Remove");
		buttonRemove.setBackground(new Color(189, 183, 107));
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to remove","Error",
					JOptionPane.ERROR_MESSAGE);
					getToolkit().beep();}
				else {
					StackDialog stackdlgrem = new StackDialog();
					Rectangle last = stack.peek();
					
					stackdlgrem.getTextX().setText(Integer.toString(last.getUpperLeft().getX()));
					stackdlgrem.getTextY().setText(Integer.toString(last.getUpperLeft().getY()));
					stackdlgrem.getTextWidth().setText(Integer.toString(last.getWidth()));
					stackdlgrem.getTextHeight().setText(Integer.toString(last.getHeight()));
					stackdlgrem.getTextX().setEnabled(false);
					stackdlgrem.getTextY().setEnabled(false);
					stackdlgrem.getTextWidth().setEnabled(false);
					stackdlgrem.getTextHeight().setEnabled(false);
					stackdlgrem.setVisible(true);
					if(stackdlgrem.isDelete()==true) {
						stack.pop();
						dlm.removeElementAt(0);
					}
				}
			}
		});
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlDown, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
					.addGap(10))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(pnlDown, GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
					.addContainerGap())
		);
		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addGap(180)
					.addComponent(buttonAdd)
					.addGap(55)
					.addComponent(buttonRemove))
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addComponent(buttonAdd)
				.addComponent(buttonRemove)
		);
		pnlDown.setLayout(gl_pnlDown);
		
		JList list = new JList();
		list.setBackground(new Color(189, 183, 107));
		scrollPane.setViewportView(list);
		pnlCenter.setLayout(gl_pnlCenter);
		list.setModel(dlm);
	}
}
