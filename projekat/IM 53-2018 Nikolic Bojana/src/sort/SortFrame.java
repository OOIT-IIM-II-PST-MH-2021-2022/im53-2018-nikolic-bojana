package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;
import stack.StackDialog;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SortFrame extends JFrame {

	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	List<Rectangle> arrayRect = new ArrayList<Rectangle>();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrame frame = new SortFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SortFrame() {
		setTitle("IM53-2018 Nikolic Bojana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList<String> list = new JList<String>();
		list.setBackground(new Color(216, 191, 216));
		scrollPane.setViewportView(list);
		pnlCenter.setLayout(gl_pnlCenter);
		list.setModel(dlm);
		
		JPanel pnlDown = new JPanel();
		contentPane.add(pnlDown, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(147, 112, 219));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortDialog sortdlg = new SortDialog();
				sortdlg.setVisible(true);
				if(sortdlg.isOk == true) {
					Rectangle rec = new Rectangle(new Point
					(Integer.parseInt(sortdlg.getTxtXCoord().getText()),
					(Integer.parseInt(sortdlg.getTxtYCoord().getText()))),
					(Integer.parseInt(sortdlg.getTxtWidth().getText())),
					(Integer.parseInt(sortdlg.getTxtHeight().getText())));
					arrayRect.add(rec);
					List<Rectangle> sortedList = arrayRect.stream().sorted().collect(Collectors.toList());     
					dlm.add(sortedList.indexOf(rec), "X: " + rec.getUpperLeft().getX() + " , Y: "
					+ rec.getUpperLeft().getY() + " , Width: " +
					rec.getWidth() + " , Height: " + rec.getHeight());
				}
			}
		});
		GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
		gl_pnlDown.setHorizontalGroup(
			gl_pnlDown.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(btnAdd)
					.addGap(140))
		);
		gl_pnlDown.setVerticalGroup(
			gl_pnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDown.createSequentialGroup()
					.addComponent(btnAdd)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlDown.setLayout(gl_pnlDown);
	}
}
