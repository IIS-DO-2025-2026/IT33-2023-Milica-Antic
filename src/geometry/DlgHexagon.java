package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DlgHexagon extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldYcoordinate;
	
	private JTextField textFieldXcoordinate;
	private JTextField textFieldRadius;
	private Color backColor;
	private JButton btnBorderColor ;
	private Color surfaceColor;
	private JButton btnSurfaceColor;
	private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgHexagon dialog = new DlgHexagon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgHexagon() {
		setModal(true);
		setTitle("Hexagon Properties");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			
			
			
					{
						JLabel lblXcoordinate = new JLabel("X coordinate: ");
						GridBagConstraints gbc_lblXcoordinate = new GridBagConstraints();
						gbc_lblXcoordinate.anchor = GridBagConstraints.EAST;
						gbc_lblXcoordinate.insets = new Insets(0, 0, 5, 5);
						gbc_lblXcoordinate.gridx = 0;
						gbc_lblXcoordinate.gridy = 0;
						panel.add(lblXcoordinate, gbc_lblXcoordinate);
					}
				
				{
					textFieldXcoordinate = new JTextField();
					GridBagConstraints gbc_textFieldXcoordinate = new GridBagConstraints();
					gbc_textFieldXcoordinate.insets = new Insets(0, 0, 5, 0);
					gbc_textFieldXcoordinate.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldXcoordinate.gridx = 1;
					gbc_textFieldXcoordinate.gridy = 0;
					panel.add(textFieldXcoordinate, gbc_textFieldXcoordinate);
					textFieldXcoordinate.setColumns(10);
				}
				{
					JLabel lblYcoordinate = new JLabel("Y coordinate:");
					GridBagConstraints gbc_lblYcoordinate = new GridBagConstraints();
					gbc_lblYcoordinate.insets = new Insets(0, 0, 5, 5);
					gbc_lblYcoordinate.gridx = 0;
					gbc_lblYcoordinate.gridy = 1;
					panel.add(lblYcoordinate, gbc_lblYcoordinate);
				}
				{
					textFieldYcoordinate = new JTextField();
					GridBagConstraints gbc_textFieldYcoordinate = new GridBagConstraints();
					gbc_textFieldYcoordinate.insets = new Insets(0, 0, 5, 0);
					gbc_textFieldYcoordinate.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldYcoordinate.gridx = 1;
					gbc_textFieldYcoordinate.gridy = 1;
					panel.add(textFieldYcoordinate, gbc_textFieldYcoordinate);
					textFieldYcoordinate.setColumns(10);
				}
				{
					JLabel lblRadius = new JLabel("Radius: ");
					GridBagConstraints gbc_lblRadius = new GridBagConstraints();
					gbc_lblRadius.anchor = GridBagConstraints.EAST;
					gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
					gbc_lblRadius.gridx = 0;
					gbc_lblRadius.gridy = 2;
					panel.add(lblRadius, gbc_lblRadius);
				}
				{
					textFieldRadius = new JTextField();
					GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
					gbc_textFieldRadius.insets = new Insets(0, 0, 5, 0);
					gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
					gbc_textFieldRadius.gridx = 1;
					gbc_textFieldRadius.gridy = 2;
					panel.add(textFieldRadius, gbc_textFieldRadius);
					textFieldRadius.setColumns(10);
				}
				{
					JLabel lblBorderColor = new JLabel("Current border color: ");
					GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
					gbc_lblBorderColor.insets = new Insets(0, 0, 5, 5);
					gbc_lblBorderColor.gridx = 0;
					gbc_lblBorderColor.gridy = 3;
					panel.add(lblBorderColor, gbc_lblBorderColor);
				}
				{
					 btnBorderColor = new JButton("");
					 btnBorderColor.setPreferredSize(new Dimension(100,30));
					btnBorderColor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							backColor = JColorChooser.showDialog(null, "Choose background color", Color.black);
							if (backColor != null) {
					            btnBorderColor.setBackground(backColor);
					            btnBorderColor.setSelected(false);
						}}
					});
					GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
					gbc_btnBorderColor.insets = new Insets(0, 0, 5, 0);
					gbc_btnBorderColor.gridx = 1;
					gbc_btnBorderColor.gridy = 3;
					panel.add(btnBorderColor, gbc_btnBorderColor);
				}
				{
					JLabel lblSurfaceColor = new JLabel("Current surface color");
					GridBagConstraints gbc_lblSurfaceColor = new GridBagConstraints();
					gbc_lblSurfaceColor.insets = new Insets(0, 0, 5, 5);
					gbc_lblSurfaceColor.gridx = 0;
					gbc_lblSurfaceColor.gridy = 4;
					panel.add(lblSurfaceColor, gbc_lblSurfaceColor);
				}
				{
					btnSurfaceColor = new JButton("");
				 btnSurfaceColor.setPreferredSize(new Dimension(100,30));
				btnSurfaceColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						surfaceColor = JColorChooser.showDialog(null, "Choose background color", Color.black);
						if (surfaceColor != null) {
							btnSurfaceColor.setBackground(surfaceColor);
							btnSurfaceColor.setSelected(false);
						}}
				});
				GridBagConstraints gbc_btnSurfaceColor = new GridBagConstraints();
				gbc_btnSurfaceColor.insets = new Insets(0, 0, 5, 0);
				gbc_btnSurfaceColor.gridx = 1;
				gbc_btnSurfaceColor.gridy = 4;
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
							Integer.parseInt(textFieldXcoordinate.getText());
							Integer.parseInt(textFieldYcoordinate.getText());
							if (Integer.parseInt(textFieldXcoordinate.getText()) > 0
									&& Integer.parseInt(textFieldYcoordinate.getText()) > 0
									&& Integer.parseInt(textFieldRadius.getText()) > 0) {
								isOk = true;
							} else {
								JOptionPane.showMessageDialog(null, "All parameters must be larger than 0",
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
				getRootPane().setDefaultButton(okButton);}
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
		}}}
		public JTextField getTextFieldYcoordinate() {
			return textFieldYcoordinate;
		}

		public void setTextFieldYcoordinate(JTextField textFieldYcoordinate) {
			this.textFieldYcoordinate = textFieldYcoordinate;
		}

		public JTextField getTextFieldXcoordinate() {
			return textFieldXcoordinate;
		}

		public void setTextFieldXcoordinate(JTextField textFieldXcoordinate) {
			this.textFieldXcoordinate = textFieldXcoordinate;
		}

		public JTextField getTextFieldRadius() {
			return textFieldRadius;
		}

		public void setTextFieldRadius(JTextField textFieldRadius) {
			this.textFieldRadius = textFieldRadius;
		}

		public Color getBackColor() {
			return backColor;
		}

		public void setBackColor(Color backColor) {
			this.backColor = backColor;
		}

		public JButton getBtnBorderColor() {
			return btnBorderColor;
		}

		public void setBtnBorderColor(JButton btnBorderColor) {
			this.btnBorderColor = btnBorderColor;
		}

		public Color getSurfaceColor() {
			return surfaceColor;
		}

		public void setSurfaceColor(Color surfaceColor) {
			this.surfaceColor = surfaceColor;
		}

		public JButton getBtnSurfaceColor() {
			return btnSurfaceColor;
		}

		public void setBtnSurfaceColor(JButton btnSurfaceColor) {
			this.btnSurfaceColor = btnSurfaceColor;
		}

		public boolean isOk() {
			return isOk;
		}

		public void setOk(boolean isOk) {
			this.isOk = isOk;
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


