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
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DlgDonut extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldBiggerRadius;
	private JTextField txtFieldSmallerRadius;
	private boolean isOk;
	private JLabel lblChooseABorderColor;
	private JLabel lblChooseASurfaceColor;
	private Color backColor;
	private Color surfaceColor;
	private JTextField txtFieldPointX;
	private JTextField txtFieldPointY;
	private JButton btnBorderColor;
	private JButton btnSurfaceColor;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setTitle("Donut properties");
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
				JLabel lblPointX = new JLabel("Center X coordinate:");
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
				JLabel lblPointY = new JLabel("Center Y coordinate:");
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
				JLabel lblBiggerRadius = new JLabel("Bigger radius:");
				GridBagConstraints gbc_lblBiggerRadius = new GridBagConstraints();
				gbc_lblBiggerRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblBiggerRadius.anchor = GridBagConstraints.EAST;
				gbc_lblBiggerRadius.gridx = 0;
				gbc_lblBiggerRadius.gridy = 2;
				panel.add(lblBiggerRadius, gbc_lblBiggerRadius);
			}
			{
				txtFieldBiggerRadius = new JTextField();
				GridBagConstraints gbc_txtFieldBiggerRadius = new GridBagConstraints();
				gbc_txtFieldBiggerRadius.insets = new Insets(0, 0, 5, 0);
				gbc_txtFieldBiggerRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFieldBiggerRadius.gridx = 1;
				gbc_txtFieldBiggerRadius.gridy = 2;
				panel.add(txtFieldBiggerRadius, gbc_txtFieldBiggerRadius);
				txtFieldBiggerRadius.setColumns(10);
			}
			 btnSurfaceColor = new JButton("");
			 btnSurfaceColor.setPreferredSize(new Dimension(100,30));
			btnSurfaceColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					surfaceColor = JColorChooser.showDialog(null, "Choose background color", Color.black);

					if (surfaceColor != null) {
			            btnSurfaceColor.setBackground(surfaceColor);
			            btnSurfaceColor.setSelected(false);


					}

				}
			});
			{
				 btnBorderColor = new JButton("");
				 btnBorderColor.setPreferredSize(new Dimension(100,30));
				btnBorderColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						backColor = JColorChooser.showDialog(null, "Choose background color", Color.white);

						if (backColor != null) {
				            btnBorderColor.setBackground(backColor);
				            btnBorderColor.setSelected(false);


						}

					}
				});
				{
					JLabel lblSmallerRadius = new JLabel("Smaller radius:");
					GridBagConstraints gbc_lblSmallerRadius = new GridBagConstraints();
					gbc_lblSmallerRadius.anchor = GridBagConstraints.EAST;
					gbc_lblSmallerRadius.insets = new Insets(0, 0, 5, 5);
					gbc_lblSmallerRadius.gridx = 0;
					gbc_lblSmallerRadius.gridy = 3;
					panel.add(lblSmallerRadius, gbc_lblSmallerRadius);
				}
				{
					txtFieldSmallerRadius = new JTextField();
					GridBagConstraints gbc_txtFieldSmallerRadius = new GridBagConstraints();
					gbc_txtFieldSmallerRadius.insets = new Insets(0, 0, 5, 0);
					gbc_txtFieldSmallerRadius.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtFieldSmallerRadius.gridx = 1;
					gbc_txtFieldSmallerRadius.gridy = 3;
					panel.add(txtFieldSmallerRadius, gbc_txtFieldSmallerRadius);
					txtFieldSmallerRadius.setColumns(10);
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
			}
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
							if (Integer.parseInt(txtFieldBiggerRadius.getText()) > 0
									&& Integer.parseInt(txtFieldSmallerRadius.getText()) > 0) {
								if (Integer.parseInt(txtFieldBiggerRadius.getText()) > Integer
										.parseInt(txtFieldSmallerRadius.getText())) {
									isOk = true;
								} else {
									JOptionPane.showMessageDialog(null,
											"The outer radius must be larger than the innerradius.", "Error Message",
											JOptionPane.INFORMATION_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Both radii must be greater than 0",
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

	public JTextField getTxtFieldBiggerRadius() {
		return txtFieldBiggerRadius;
	}

	public void setTxtFieldBiggerRadius(JTextField txtFieldBiggerRadius) {
		this.txtFieldBiggerRadius = txtFieldBiggerRadius;
	}

	public JTextField getTxtFieldSmallerRadius() {
		return txtFieldSmallerRadius;
	}

	public void setTxtFieldSmallerRadius(JTextField txtFieldSmallerRadius) {
		this.txtFieldSmallerRadius = txtFieldSmallerRadius;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Color getBackColor() {
		return backColor;
	}

	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}

	public Color getSurfaceColor() {
		return surfaceColor;
	}

	public JLabel getLblChooseABorderColor() {
		return lblChooseABorderColor;
	}

	public void setLblChooseABorderColor(JLabel lblChooseABorderColor) {
		this.lblChooseABorderColor = lblChooseABorderColor;
	}

	public JLabel getLblChooseASurfaceColor() {
		return lblChooseASurfaceColor;
	}

	public void setLblChooseASurfaceColor(JLabel lblChooseASurfaceColor) {
		this.lblChooseASurfaceColor = lblChooseASurfaceColor;
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
