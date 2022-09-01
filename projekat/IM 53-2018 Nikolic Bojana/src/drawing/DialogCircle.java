package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DialogCircle extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	public boolean isOk;
	private JTextField textX;
	private JTextField textY;
	private JTextField textRadius;
	private Color outline = Color.black;
	private Color area = Color.white;
	private boolean outlineBool;
	private boolean areaBool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogCircle dialog = new DialogCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogCircle() {
		setBackground(new Color(245, 255, 250));
		setTitle("IM53-2018 Nikolic Bojana");
		setModal(true);
		setBounds(100, 100, 289, 339);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBackground(new Color(188, 143, 143));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblX = new JLabel("X coordinate:");
		
		JLabel lblY = new JLabel("Y coordinate:");
		
		JLabel lblRadius = new JLabel("Radius:");
		
		textX = new JTextField();
		textX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});		
		textX.setColumns(10);
		
		textY = new JTextField();
		textY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});		
		textY.setColumns(10);
		
		textRadius = new JTextField();
		textRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});		
		textRadius.setColumns(10);
		
		JButton btnOutlineColor = new JButton("Outline color");
		btnOutlineColor.setBackground(new Color(245, 255, 250));
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outline = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
				outlineBool = true;	
			}
		});
		
		JButton btnAreaColor = new JButton("Area color");
		btnAreaColor.setBackground(new Color(245, 255, 250));
		btnAreaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				area = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
				areaBool = true;
			}
		});
		
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnOutlineColor)
							.addGap(39))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblY)
								.addComponent(lblX)
								.addComponent(lblRadius))))
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAreaColor))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblX))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRadius))
					.addGap(77)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOutlineColor)
						.addComponent(btnAreaColor))
					.addGap(115))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel btnPanel = new JPanel();
			btnPanel.setBackground(new Color(192, 192, 192));
			btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btnPanel, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(245, 255, 250));
				okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(textX.getText().trim().isEmpty() ||
							   textY.getText().trim().isEmpty() ||
							   textRadius.getText().trim().isEmpty()) {
								isOk = false;
						JOptionPane.showMessageDialog(null, "Enter in all the values", "Error", JOptionPane.ERROR_MESSAGE);
						getToolkit().beep();
							}else {
								for(Shape shape : PnlDrawing.shapesArrList) {
									if (shape.isSelected()) {
										shape.move(Integer.parseInt(textX.getText()),
												   Integer.parseInt(textY.getText()));
										((Circle)shape).setRadius(Integer.parseInt(textRadius.getText()));
										
										if(isOutlineBool() == true) {
											shape.setOutline(outline);
											setOutlineBool(false);
										}
										if(isAreaBool() == true) {
											shape.setFill(area);
											setAreaBool(false);
										}
									}
								}
								
								isOk = true;
								dispose();
							}
						}
					});
				okButton.setActionCommand("OK");
				btnPanel.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(245, 255, 250));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				btnPanel.add(cancelButton);
			}
		}
	}

	public JTextField getTxtXCoord() {
		return textX;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.textX = txtXCoord;
	}

	public JTextField getTxtYCoord() {
		return textY;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.textY = txtYCoord;
	}

	public JTextField getTxtRadius() {
		return textRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.textRadius = txtRadius;
	}

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getArea() {
		return area;
	}

	public void setArea(Color area) {
		this.area = area;
	}

	public boolean isOutlineBool() {
		return outlineBool;
	}

	public void setOutlineBool(boolean outlineBool) {
		this.outlineBool = outlineBool;
	}

	public boolean isAreaBool() {
		return areaBool;
	}

	public void setAreaBool(boolean areaBool) {
		this.areaBool = areaBool;
	}
	
	
}

