package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class DlgLine extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private boolean isOk;
	private Color backColor;
	private JLabel lblChooseABorderColor;
	private JTextField txtFieldStartPointX;
	private JTextField txtFieldStartPointY;
	private JTextField txtFieldEndPointY;
	private JTextField txtFieldEndPointX;
	private JButton btnBorderColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setTitle("Line properties");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
			}
			{
				JLabel lblStartPointX = new JLabel("Start point x coordinate:");
				GridBagConstraints gbc_lblStartPointX = new GridBagConstraints();
				gbc_lblStartPointX.anchor = GridBagConstraints.EAST;
				gbc_lblStartPointX.insets = new Insets(0, 0, 5, 5);
				gbc_lblStartPointX.gridx = 0;
				gbc_lblStartPointX.gridy = 0;
				panel.add(lblStartPointX, gbc_lblStartPointX);
			}
			{
				txtFieldStartPointX = new JTextField();
				GridBagConstraints gbc_txtFieldStartPointX = new GridBagConstraints();
				gbc_txtFieldStartPointX.insets = new Insets(0, 0, 5, 0);
				gbc_txtFieldStartPointX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFieldStartPointX.gridx = 1;
				gbc_txtFieldStartPointX.gridy = 0;
				panel.add(txtFieldStartPointX, gbc_txtFieldStartPointX);
				txtFieldStartPointX.setColumns(10);
			}
			{
				JLabel lblStartPointY = new JLabel("Start point Y coordinate:");
				GridBagConstraints gbc_lblStartPointY = new GridBagConstraints();
				gbc_lblStartPointY.anchor = GridBagConstraints.EAST;
				gbc_lblStartPointY.insets = new Insets(0, 0, 5, 5);
				gbc_lblStartPointY.gridx = 0;
				gbc_lblStartPointY.gridy = 1;
				panel.add(lblStartPointY, gbc_lblStartPointY);
			}
			{
				txtFieldStartPointY = new JTextField();
				GridBagConstraints gbc_txtFieldStartPointY = new GridBagConstraints();
				gbc_txtFieldStartPointY.insets = new Insets(0, 0, 5, 0);
				gbc_txtFieldStartPointY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFieldStartPointY.gridx = 1;
				gbc_txtFieldStartPointY.gridy = 1;
				panel.add(txtFieldStartPointY, gbc_txtFieldStartPointY);
				txtFieldStartPointY.setColumns(10);
			}
			{
				JLabel lblEndPointX = new JLabel("End point x coordinate:");
				GridBagConstraints gbc_lblEndPointX = new GridBagConstraints();
				gbc_lblEndPointX.anchor = GridBagConstraints.EAST;
				gbc_lblEndPointX.insets = new Insets(0, 0, 5, 5);
				gbc_lblEndPointX.gridx = 0;
				gbc_lblEndPointX.gridy = 2;
				panel.add(lblEndPointX, gbc_lblEndPointX);
			}
			{
				txtFieldEndPointX = new JTextField();
				GridBagConstraints gbc_txtFieldEndPointX = new GridBagConstraints();
				gbc_txtFieldEndPointX.insets = new Insets(0, 0, 5, 0);
				gbc_txtFieldEndPointX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFieldEndPointX.gridx = 1;
				gbc_txtFieldEndPointX.gridy = 2;
				panel.add(txtFieldEndPointX, gbc_txtFieldEndPointX);
				txtFieldEndPointX.setColumns(10);
			}
			{
				JLabel lblEndPointY = new JLabel("End point y coordinate");
				GridBagConstraints gbc_lblEndPointY = new GridBagConstraints();
				gbc_lblEndPointY.anchor = GridBagConstraints.EAST;
				gbc_lblEndPointY.insets = new Insets(0, 0, 5, 5);
				gbc_lblEndPointY.gridx = 0;
				gbc_lblEndPointY.gridy = 3;
				panel.add(lblEndPointY, gbc_lblEndPointY);
			}
			{
				txtFieldEndPointY = new JTextField();
				GridBagConstraints gbc_txtFieldEndPointY = new GridBagConstraints();
				gbc_txtFieldEndPointY.insets = new Insets(0, 0, 5, 0);
				gbc_txtFieldEndPointY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFieldEndPointY.gridx = 1;
				gbc_txtFieldEndPointY.gridy = 3;
				panel.add(txtFieldEndPointY, gbc_txtFieldEndPointY);
				txtFieldEndPointY.setColumns(10);
			}
			{
				lblChooseABorderColor = new JLabel("Current color");
				GridBagConstraints gbc_lblChooseABorderColor = new GridBagConstraints();
				gbc_lblChooseABorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblChooseABorderColor.gridx = 0;
				gbc_lblChooseABorderColor.gridy = 4;
				panel.add(lblChooseABorderColor, gbc_lblChooseABorderColor);
			}
			 btnBorderColor = new JButton("");
			 btnBorderColor.setPreferredSize(new Dimension(100,30));
			btnBorderColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					backColor = JColorChooser.showDialog(null, "Choose background color", Color.black);
					if (backColor != null) {
			            btnBorderColor.setBackground(backColor);
			            btnBorderColor.setSelected(false);



					}

				}
			});
			GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnBorderColor.gridx = 1;
			gbc_btnBorderColor.gridy = 4;
			panel.add(btnBorderColor, gbc_btnBorderColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOk = true;
						if (isOk)

						{
							setVisible(false);

						}
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JLabel getLblChooseABorderColor() {
		return lblChooseABorderColor;
	}

	public void setLblChooseABorderColor(JLabel lblChooseABorderColor) {
		this.lblChooseABorderColor = lblChooseABorderColor;
	}

	public JTextField getTxtFieldStartPointX() {
		return txtFieldStartPointX;
	}

	public void setTxtFieldStartPointX(JTextField txtFieldStartPointX) {
		this.txtFieldStartPointX = txtFieldStartPointX;
	}

	public JTextField getTxtFieldStartPointY() {
		return txtFieldStartPointY;
	}

	public void setTxtFieldStartPointY(JTextField txtFieldStartPointY) {
		this.txtFieldStartPointY = txtFieldStartPointY;
	}

	public JTextField getTxtFieldEndPointY() {
		return txtFieldEndPointY;
	}

	public void setTxtFieldEndPointY(JTextField txtFieldEndPointY) {
		this.txtFieldEndPointY = txtFieldEndPointY;
	}

	public JTextField getTxtFieldEndPointX() {
		return txtFieldEndPointX;
	}

	public void setTxtFieldEndPointX(JTextField txtFieldEndPointX) {
		this.txtFieldEndPointX = txtFieldEndPointX;
	}

	public Color getBackColor() {
		return backColor;
	}

	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	public void setBorderColor(Color color) {
	    this.backColor = color;
	    if (color != null) {
	        btnBorderColor.setBackground(color);
	    }
	}

	public void setInitialBorderColor(Color color) {
	    this.backColor = color;
	    if (color != null) {
	        btnBorderColor.setBackground(color);
	    }
	}


}
