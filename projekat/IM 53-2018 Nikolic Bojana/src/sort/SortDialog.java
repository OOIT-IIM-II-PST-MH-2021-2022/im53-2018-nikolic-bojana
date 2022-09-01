package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SortDialog extends JDialog {
	
	public boolean isOk;
	private boolean delete;
	private final JPanel pnlCenter = new JPanel();
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textX;
	private JTextField textY;
	private JTextField textWidth;
	private JTextField textHeight;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SortDialog dialog = new SortDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SortDialog() {
		setTitle("Bojana Nikolic IM 53-2018");
		setModal(true);
		setBounds(100, 100, 298, 366);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBackground(new Color(222, 184, 135));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
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
		
		textWidth = new JTextField();
		textWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		textWidth.setColumns(10);
		
		textHeight = new JTextField();
		textHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0') && (c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		textHeight.setColumns(10);
		
		JLabel x = new JLabel("x:");
		
		JLabel y = new JLabel("y:");
		
		JLabel width = new JLabel("Width:");
		
		JLabel height = new JLabel("Height:");
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(width, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(height, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(y)
						.addComponent(x, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(76))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(x))
					.addGap(34)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(y))
					.addGap(34)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(width))
					.addGap(35)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(height))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlBtn = new JPanel();
			getContentPane().add(pnlBtn, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setBackground(new Color(205, 133, 63));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textX.getText().trim().isEmpty() ||
								textY.getText().trim().isEmpty() || textWidth.getText().trim().isEmpty()
								|| textHeight.getText().trim().isEmpty()) {
									isOk = false;
									getToolkit().beep();
								JOptionPane.showMessageDialog(null, "Fill in all the blanks!", "Error",
								JOptionPane.ERROR_MESSAGE);
								}else {
									isOk = true;
									setDelete(true);
									dispose();
								}
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(205, 133, 63));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_pnlBtn = new GroupLayout(pnlBtn);
			gl_pnlBtn.setHorizontalGroup(
				gl_pnlBtn.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlBtn.createSequentialGroup()
						.addGap(105)
						.addComponent(okButton)
						.addGap(18)
						.addComponent(cancelButton)
						.addGap(67))
			);
			gl_pnlBtn.setVerticalGroup(
				gl_pnlBtn.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnlBtn.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pnlBtn.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap())
			);
			pnlBtn.setLayout(gl_pnlBtn);
		}
	}
	
	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
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

	public JTextField getTxtWidth() {
		return textWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.textWidth = txtWidth;
	}

	public JTextField getTxtHeight() {
		return textHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.textHeight = txtHeight;
	}
	

}
