package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogDonut extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	public boolean isOk;
	private JTextField textX;
	private JTextField textY;
	public JTextField getTextX() {
		return textX;
	}

	public void setTextX(JTextField textX) {
		this.textX = textX;
	}

	public JTextField getTextY() {
		return textY;
	}

	public void setTextY(JTextField textY) {
		this.textY = textY;
	}

	public JTextField getTextRadius() {
		return textRadius;
	}

	public void setTextRadius(JTextField textRadius) {
		this.textRadius = textRadius;
	}

	public JTextField getTextInnerRadius() {
		return textInnerRadius;
	}

	public void setTextInnerRadius(JTextField textInnerRadius) {
		this.textInnerRadius = textInnerRadius;
	}

	private JTextField textRadius;
	private JTextField textInnerRadius;
	private Color outline = Color.black;
	private Color area = Color.white;
	private boolean outlineBool;
	private boolean areaBool;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogDonut dialog = new DialogDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogDonut() {
		setBackground(new Color(255, 222, 173));
		setTitle("IM53-2018 Nikolic Bojana");
		setModal(true);
		setBounds(100, 100, 374, 423);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setForeground(new Color(240, 230, 140));
		pnlCenter.setBackground(new Color(233, 150, 122));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblX = new JLabel("X coordinate:");
		
		JLabel lblY = new JLabel("Y Coordinate:");
		JLabel lblRadius = new JLabel("Radius:");
		JLabel lblInnerRadius = new JLabel("Inner radius:");
		textX = new JTextField();
		textX.setColumns(10);
		textY = new JTextField();
		textY.setColumns(10);
		textRadius = new JTextField();
		textRadius.setColumns(10);
		textInnerRadius = new JTextField();
		textInnerRadius.setColumns(10);
		
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
					.addGap(22)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblX)
						.addComponent(lblInnerRadius)
						.addComponent(lblY)
						.addComponent(lblRadius)
						.addComponent(btnOutlineColor))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAreaColor)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY))
					.addGap(35)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInnerRadius)
						.addComponent(textInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOutlineColor)
						.addComponent(btnAreaColor))
					.addGap(35))
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
					   textRadius.getText().trim().isEmpty() ||
					   textInnerRadius.getText().trim().isEmpty()) {
								isOk = false;
						JOptionPane.showMessageDialog(null, "Enter in all the values", "Error", JOptionPane.ERROR_MESSAGE);
						getToolkit().beep();
							}else {
								if(Integer.parseInt(textRadius.getText()) >
								   Integer.parseInt(textInnerRadius.getText())) {
									for (Shape shape : PnlDrawing.shapesArrList) {
										if(shape.isSelected()) {
											shape.move(Integer.parseInt(textX.getText()),
													   Integer.parseInt(textY.getText()));
											((Donut)shape).setRadius(Integer.parseInt(textRadius.getText()));
											((Donut)shape).setInnerRadius(Integer.parseInt(textInnerRadius.getText()));
											
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
								}else {
							    isOk = false;
							    JOptionPane.showMessageDialog(null, "The inner radius must be smaller than the outer radius!", 
							    		"Error", JOptionPane.ERROR_MESSAGE);
								}
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

	public JTextField getTxtInnerRadius() {
		return textInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.textInnerRadius = txtInnerRadius;
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
