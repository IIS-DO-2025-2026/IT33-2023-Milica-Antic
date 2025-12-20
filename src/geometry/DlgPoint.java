package geometry;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class DlgPoint extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private boolean isOk;
	private Color backColor;
	private JLabel lblChooseABorderColor;
	private JTextField txtFieldPointX;
	private JTextField txtFieldPointY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setTitle("Point properties");
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
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
			}
			{
				JLabel lblPointX = new JLabel("X coordinate:");
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
				JLabel lblPointY = new JLabel("Y coordinate:");
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
				lblChooseABorderColor = new JLabel("Cuurent color");
				GridBagConstraints gbc_lblChooseABorderColor = new GridBagConstraints();
				gbc_lblChooseABorderColor.insets = new Insets(0, 0, 0, 5);
				gbc_lblChooseABorderColor.gridx = 0;
				gbc_lblChooseABorderColor.gridy = 2;
				panel.add(lblChooseABorderColor, gbc_lblChooseABorderColor);
			}
			JButton btnBorderColor = new JButton("Border color");
			btnBorderColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					backColor = JColorChooser.showDialog(null, "Choose background color", Color.black);
					if (backColor != null) {
						lblChooseABorderColor.setForeground(backColor);

					}

				}
			});
			GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
			gbc_btnBorderColor.gridx = 1;
			gbc_btnBorderColor.gridy = 2;
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
}
