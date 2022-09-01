package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StackDialog extends JDialog {

	public boolean isOk;
	private boolean delete;
	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

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
			StackDialog dialog = new StackDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StackDialog() {
		setBackground(new Color(250, 235, 215));
		setModal(true);
		setBounds(100, 100, 280, 338);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBackground(new Color(188, 143, 143));
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		
		textX = new JTextField();
		textX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c>='0')&&(c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
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
				if (!(((c>='0')&&(c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
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
				if (!(((c>='0')&&(c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
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
				if (!(((c>='0')&&(c<='9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		textHeight.setColumns(10);
		
		JLabel x = new JLabel("x:");
		
		JLabel y = new JLabel("y:");
		
		JLabel width = new JLabel("width:");
		width.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel height = new JLabel("height:");
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addComponent(y, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(47))
						.addGroup(Alignment.LEADING, gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(height, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(width, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.LEADING, gl_pnlCenter.createSequentialGroup()
							.addComponent(x, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(40))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(y, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(x, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(width, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(height, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlButton = new JPanel();
			pnlButton.setBackground(new Color(188, 143, 143));
			getContentPane().add(pnlButton, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setForeground(new Color(0, 0, 0));
				okButton.setBackground(new Color(189, 183, 107));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textX.getText().trim().isEmpty() || textY.getText().trim().isEmpty() 
								|| textWidth.getText().trim().isEmpty()||
										textHeight.getText().trim().isEmpty()){
									isOk = false;
									getToolkit().beep();
							JOptionPane.showMessageDialog(null,"All blanks must be filled","Error",
							JOptionPane.ERROR_MESSAGE);
								} 
						else {
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
				cancelButton.setBackground(new Color(189, 183, 107));
				 cancelButton.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	setDelete(false);
	                        dispose();
	                    }
	                });
				cancelButton.setActionCommand("Cancel");
				
				
				
			}
			GroupLayout gl_pnlButton = new GroupLayout(pnlButton);
			gl_pnlButton.setHorizontalGroup(
				gl_pnlButton.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlButton.createSequentialGroup()
						.addGap(43)
						.addComponent(okButton)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(cancelButton)
						.addGap(270))
			);
			gl_pnlButton.setVerticalGroup(
				gl_pnlButton.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlButton.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_pnlButton.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
			);
			pnlButton.setLayout(gl_pnlButton);
		}
	}

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

	public JTextField getTextWidth() {
		return textWidth;
	}

	public void setTextWidth(JTextField textWidth) {
		this.textWidth = textWidth;
	}

	public JTextField getTextHeight() {
		return textHeight;
	}

	public void setTextHeight(JTextField textHeight) {
		this.textHeight = textHeight;
	}
}
