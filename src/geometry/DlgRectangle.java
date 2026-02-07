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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class DlgRectangle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldWidth;
	private JTextField txtFieldHeight;
	private Color backColor;
	private JLabel lblChooseASurfaceColor;
	private JLabel lblChooseABorderColor;
	private Color surfaceColor;
	private boolean isOk;
	private JTextField txtFieldPointX;
	private JTextField txtFieldPointY;
	private JButton btnBorderColor;
	private JButton btnSurfaceColor;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setTitle("Rectangle properties");
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
				{
				}
				{
					JLabel lblPointX = new JLabel("Upper left point X coordinate:");
					GridBagConstraints gbc_lblPointX = new GridBagConstraints();
					gbc_lblPointX.anchor = GridBagConstraints.EAST;
					gbc_lblPointX.insets = new Insets(0, 0, 5, 5);
					gbc_lblPointX.gridx = 0;
					gbc_lblPointX.gridy = 0;
					panel.add(lblPointX, gbc_lblPointX);
				}
				{
					txtFieldPointX = new JTextField();
					GridBagConstraints gbc_txtFieldPointX = new GridBagConstraints();
					gbc_txtFieldPointX.insets = new Insets(0, 0, 5, 0);
					gbc_txtFieldPointX.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtFieldPointX.gridx = 1;
					gbc_txtFieldPointX.gridy = 0;
					panel.add(txtFieldPointX, gbc_txtFieldPointX);
					txtFieldPointX.setColumns(10);
				}
				{
					JLabel lblPointY = new JLabel("Upper left point Y coordinate:");
					GridBagConstraints gbc_lblPointY = new GridBagConstraints();
					gbc_lblPointY.anchor = GridBagConstraints.EAST;
					gbc_lblPointY.insets = new Insets(0, 0, 5, 5);
					gbc_lblPointY.gridx = 0;
					gbc_lblPointY.gridy = 1;
					panel.add(lblPointY, gbc_lblPointY);
				}
				{
					txtFieldPointY = new JTextField();
					GridBagConstraints gbc_txtFieldPointY = new GridBagConstraints();
					gbc_txtFieldPointY.insets = new Insets(0, 0, 5, 0);
					gbc_txtFieldPointY.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtFieldPointY.gridx = 1;
					gbc_txtFieldPointY.gridy = 1;
					panel.add(txtFieldPointY, gbc_txtFieldPointY);
					txtFieldPointY.setColumns(10);
				}
				{
					JLabel lblWidth = new JLabel("Width:");
					GridBagConstraints gbc_lblWidth = new GridBagConstraints();
					gbc_lblWidth.anchor = GridBagConstraints.EAST;
					gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
					gbc_lblWidth.gridx = 0;
					gbc_lblWidth.gridy = 2;
					panel.add(lblWidth, gbc_lblWidth);
				}
				{
					txtFieldWidth = new JTextField();
					GridBagConstraints gbc_txtFieldWidth = new GridBagConstraints();
					gbc_txtFieldWidth.insets = new Insets(0, 0, 5, 0);
					gbc_txtFieldWidth.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtFieldWidth.gridx = 1;
					gbc_txtFieldWidth.gridy = 2;
					panel.add(txtFieldWidth, gbc_txtFieldWidth);
					txtFieldWidth.setColumns(10);
				}
			}
			 btnSurfaceColor = new JButton("");
			 btnSurfaceColor.setPreferredSize(new Dimension(100,30));
			btnSurfaceColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					surfaceColor = JColorChooser.showDialog(null, "Choose background color", Color.white);
					if (surfaceColor != null) {
			            btnSurfaceColor.setBackground(surfaceColor);
			            btnSurfaceColor.setSelected(false);


					}

				}
			});
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
			{
				JLabel lblHeight = new JLabel("Height:");
				GridBagConstraints gbc_lblHeight = new GridBagConstraints();
				gbc_lblHeight.anchor = GridBagConstraints.EAST;
				gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
				gbc_lblHeight.gridx = 0;
				gbc_lblHeight.gridy = 3;
				panel.add(lblHeight, gbc_lblHeight);
			}
			{
				txtFieldHeight = new JTextField();
				GridBagConstraints gbc_txtFieldHeight = new GridBagConstraints();
				gbc_txtFieldHeight.insets = new Insets(0, 0, 5, 0);
				gbc_txtFieldHeight.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFieldHeight.gridx = 1;
				gbc_txtFieldHeight.gridy = 3;
				panel.add(txtFieldHeight, gbc_txtFieldHeight);
				txtFieldHeight.setColumns(10);
			}
			{
				lblChooseABorderColor = new JLabel("Current border color");
				GridBagConstraints gbc_lblChooseABorderColor = new GridBagConstraints();
				gbc_lblChooseABorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblChooseABorderColor.gridx = 0;
				gbc_lblChooseABorderColor.gridy = 4;
				panel.add(lblChooseABorderColor, gbc_lblChooseABorderColor);
			}
			GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnBorderColor.gridx = 1;
			gbc_btnBorderColor.gridy = 4;
			panel.add(btnBorderColor, gbc_btnBorderColor);
			{
				lblChooseASurfaceColor = new JLabel("Current surface color");
				GridBagConstraints gbc_lblChooseASurfaceColor = new GridBagConstraints();
				gbc_lblChooseASurfaceColor.insets = new Insets(0, 0, 0, 5);
				gbc_lblChooseASurfaceColor.gridx = 0;
				gbc_lblChooseASurfaceColor.gridy = 5;
				panel.add(lblChooseASurfaceColor, gbc_lblChooseASurfaceColor);
			}
			GridBagConstraints gbc_btnSurfaceColor = new GridBagConstraints();
			gbc_btnSurfaceColor.gridx = 1;
			gbc_btnSurfaceColor.gridy = 5;
			panel.add(btnSurfaceColor, gbc_btnSurfaceColor);
		}
		{
			JPanel buttonPane = new JPanel();

			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Integer.parseInt(txtFieldWidth.getText());
							Integer.parseInt(txtFieldHeight.getText());
							if (Integer.parseInt(txtFieldWidth.getText()) > 0
									&& Integer.parseInt(txtFieldHeight.getText()) > 0) {
								isOk = true;
							} else {
								JOptionPane.showMessageDialog(null, "Width and height must be greater than 0",
										"Error Message", JOptionPane.INFORMATION_MESSAGE);
							}

						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Each field must be filled with whole numbers.",
									"Error Message", JOptionPane.INFORMATION_MESSAGE);
						}
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

	public JTextField getTxtFieldPointX() {
		return txtFieldPointX;
	}

	public void setTxtFieldPointX(JTextField txtFieldPointX) {
		this.txtFieldPointX = txtFieldPointX;
	}

	public JTextField getTxtFieldPointY() {
		return txtFieldPointY;
	}

	public void setTxtFieldPointY(JTextField txtFieldPointY) {
		this.txtFieldPointY = txtFieldPointY;
	}

	public JTextField getTxtFieldWidth() {
		return txtFieldWidth;
	}

	public void setTxtFieldWidth(JTextField txtFieldWidth) {
		this.txtFieldWidth = txtFieldWidth;
	}

	public JTextField getTxtFieldHeight() {
		return txtFieldHeight;
	}

	public void setTxtFieldHeight(JTextField txtFieldHeight) {
		this.txtFieldHeight = txtFieldHeight;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public JLabel getLblChooseASurfaceColor() {
		return lblChooseASurfaceColor;
	}

	public void setLblChooseASurfaceColor(JLabel lblChooseASurfaceColor) {
		this.lblChooseASurfaceColor = lblChooseASurfaceColor;
	}

	public JLabel getLblChooseABorderColor() {
		return lblChooseABorderColor;
	}

	public void setLblChooseABorderColor(JLabel lblChooseABorderColor) {
		this.lblChooseABorderColor = lblChooseABorderColor;
	}

	public Color getSurfaceColor() {
		return surfaceColor;
	}


	public Color getBackColor() {
		return backColor;
	}

	public void setBorderColor(Color color) {
	    this.backColor = color;
	    if (color != null) {
	        btnBorderColor.setBackground(color);
	    }
	}
	public void setSurfaceColor(Color color) {
	    this.surfaceColor = color;
	    if (color != null) {
	        btnSurfaceColor.setBackground(color);
	    }
	}
	public void setInitialBorderColor(Color color) {
	    this.backColor = color;
	    if (color != null) {
	        btnBorderColor.setBackground(color);
	    }
	}
	public void setInitialSurfaceColor(Color color) {
	    this.surfaceColor = color;
	    if (color != null) {
	        btnSurfaceColor.setBackground(color);
	    }
	}

}
