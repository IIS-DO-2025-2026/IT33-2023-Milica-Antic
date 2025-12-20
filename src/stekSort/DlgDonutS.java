package stekSort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
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

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class DlgDonutS extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFieldPointX;
	private JTextField txtFieldPointY;
	private JTextField txtFieldSmallerRadius;
	private JTextField txtFieldBiggerRadius;
	private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonutS dialog = new DlgDonutS();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonutS() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlCenter = new JPanel();
			contentPanel.add(pnlCenter, BorderLayout.CENTER);
			GridBagLayout gbl_pnlCenter = new GridBagLayout();
			gbl_pnlCenter.columnWidths = new int[] { 0, 0, 0 };
			gbl_pnlCenter.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
			gbl_pnlCenter.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_pnlCenter.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			pnlCenter.setLayout(gbl_pnlCenter);
			{
				JLabel lblPointX = new JLabel("X coordinate: ");
				GridBagConstraints gbc_lblPointX = new GridBagConstraints();
				gbc_lblPointX.anchor = GridBagConstraints.EAST;
				gbc_lblPointX.insets = new Insets(0, 0, 5, 5);
				gbc_lblPointX.gridx = 0;
				gbc_lblPointX.gridy = 0;
				pnlCenter.add(lblPointX, gbc_lblPointX);
			}
			{
				txtFieldPointX = new JTextField();
				GridBagConstraints gbc_txtFieldPointX = new GridBagConstraints();
				gbc_txtFieldPointX.insets = new Insets(0, 0, 5, 0);
				gbc_txtFieldPointX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFieldPointX.gridx = 1;
				gbc_txtFieldPointX.gridy = 0;
				pnlCenter.add(txtFieldPointX, gbc_txtFieldPointX);
				txtFieldPointX.setColumns(10);
			}
			{
				JLabel lblPointY = new JLabel("Y coordinate: ");
				GridBagConstraints gbc_lblPointY = new GridBagConstraints();
				gbc_lblPointY.anchor = GridBagConstraints.EAST;
				gbc_lblPointY.insets = new Insets(0, 0, 5, 5);
				gbc_lblPointY.gridx = 0;
				gbc_lblPointY.gridy = 1;
				pnlCenter.add(lblPointY, gbc_lblPointY);
			}
			{
				txtFieldPointY = new JTextField();
				GridBagConstraints gbc_txtFieldPointY = new GridBagConstraints();
				gbc_txtFieldPointY.insets = new Insets(0, 0, 5, 0);
				gbc_txtFieldPointY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFieldPointY.gridx = 1;
				gbc_txtFieldPointY.gridy = 1;
				pnlCenter.add(txtFieldPointY, gbc_txtFieldPointY);
				txtFieldPointY.setColumns(10);
			}
			{
				JLabel lblBiggerRadius = new JLabel("Bigger radius:");
				GridBagConstraints gbc_lblBiggerRadius = new GridBagConstraints();
				gbc_lblBiggerRadius.anchor = GridBagConstraints.EAST;
				gbc_lblBiggerRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblBiggerRadius.gridx = 0;
				gbc_lblBiggerRadius.gridy = 2;
				pnlCenter.add(lblBiggerRadius, gbc_lblBiggerRadius);
			}
			{
				txtFieldBiggerRadius = new JTextField();
				GridBagConstraints gbc_txtFieldBiggerRadius = new GridBagConstraints();
				gbc_txtFieldBiggerRadius.insets = new Insets(0, 0, 5, 0);
				gbc_txtFieldBiggerRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFieldBiggerRadius.gridx = 1;
				gbc_txtFieldBiggerRadius.gridy = 2;
				pnlCenter.add(txtFieldBiggerRadius, gbc_txtFieldBiggerRadius);
				txtFieldBiggerRadius.setColumns(10);
			}
			{
				JLabel lblSmallerRadius = new JLabel("Smaller radius:");
				GridBagConstraints gbc_lblSmallerRadius = new GridBagConstraints();
				gbc_lblSmallerRadius.insets = new Insets(0, 0, 5, 5);
				gbc_lblSmallerRadius.gridx = 0;
				gbc_lblSmallerRadius.gridy = 3;
				pnlCenter.add(lblSmallerRadius, gbc_lblSmallerRadius);
			}
			{
				txtFieldSmallerRadius = new JTextField();
				GridBagConstraints gbc_txtFieldSmallerRadius = new GridBagConstraints();
				gbc_txtFieldSmallerRadius.insets = new Insets(0, 0, 5, 0);
				gbc_txtFieldSmallerRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtFieldSmallerRadius.gridx = 1;
				gbc_txtFieldSmallerRadius.gridy = 3;
				pnlCenter.add(txtFieldSmallerRadius, gbc_txtFieldSmallerRadius);
				txtFieldSmallerRadius.setColumns(10);
			}
		}
		{
			JPanel pnlNorth = new JPanel();
			contentPanel.add(pnlNorth, BorderLayout.NORTH);
			{
				JLabel lblTitle = new JLabel("Properties of a circle with a hole");
				lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
				pnlNorth.add(lblTitle);
			}
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
							Integer.parseInt(txtFieldPointX.getText());
							Integer.parseInt(txtFieldPointY.getText());
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
							setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {// sta ovo tacno znaci i red ispod
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

	public JTextField getTxtFieldSmallerRadius() {
		return txtFieldSmallerRadius;
	}

	public void setTxtFieldSmallerRadius(JTextField txtFieldSmallerRadius) {
		this.txtFieldSmallerRadius = txtFieldSmallerRadius;
	}

	public JTextField getTxtFieldBiggerRadius() {
		return txtFieldBiggerRadius;
	}

	public void setTxtFieldBiggerRadius(JTextField txtFieldBiggerRadius) {
		this.txtFieldBiggerRadius = txtFieldBiggerRadius;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}
