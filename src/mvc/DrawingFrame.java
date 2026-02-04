package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import observer.ModelObserver;

public class DrawingFrame extends JFrame implements ModelObserver{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DrawingView view = new DrawingView();
	private DrawingController controller;
	private ButtonGroup group = new ButtonGroup();
	private String word = "";
	private JButton btnModify ;
	private JButton btnDelete;

	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlNorth = new JPanel();
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		GridBagLayout gbl_pnlNorth = new GridBagLayout();
		gbl_pnlNorth.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlNorth.rowHeights = new int[]{0, 0};
		gbl_pnlNorth.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlNorth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlNorth.setLayout(gbl_pnlNorth);

	
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		group.add(tglbtnPoint);
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				word = "point";
				controller.onModeChanged();
			}
		});
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 0;
		pnlNorth.add(tglbtnPoint, gbc_tglbtnPoint);

		JToggleButton tglbtnLine = new JToggleButton("Line");
		group.add(tglbtnLine);
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				word = "line";
				controller.onModeChanged();

			}
		});
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnLine.gridx = 1;
		gbc_tglbtnLine.gridy = 0;
		pnlNorth.add(tglbtnLine, gbc_tglbtnLine);

		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		group.add(tglbtnRectangle);
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				word = "rectangle";
				controller.onModeChanged();

			}
		});
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnRectangle.gridx = 2;
		gbc_tglbtnRectangle.gridy = 0;
		pnlNorth.add(tglbtnRectangle, gbc_tglbtnRectangle);

		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		group.add(tglbtnCircle);
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				word = "circle";
				controller.onModeChanged();

			}
		});
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnCircle.gridx = 3;
		gbc_tglbtnCircle.gridy = 0;
		pnlNorth.add(tglbtnCircle, gbc_tglbtnCircle);

		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		group.add(tglbtnDonut);
		tglbtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				word = "donut";
				controller.onModeChanged();

			}
		});
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.gridx = 4;
		gbc_tglbtnDonut.gridy = 0;
		pnlNorth.add(tglbtnDonut, gbc_tglbtnDonut);

		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSouth = new GridBagLayout();
		gbl_pnlSouth.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlSouth.rowHeights = new int[]{0, 0, 0};
		gbl_pnlSouth.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSouth.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlSouth.setLayout(gbl_pnlSouth);

		JToggleButton tglbtnSelect = new JToggleButton("Select");
		group.add(tglbtnSelect);
		tglbtnSelect.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
					word = "selected";
					controller.selectMode();
			}
			
		});
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 1;
		pnlSouth.add(tglbtnSelect, gbc_tglbtnSelect);

		 btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			;
						word = "selected";
						controller.modifyRequest();

			}
		});
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 0, 5);
		gbc_btnModify.gridx = 1;
		gbc_btnModify.gridy = 1;
		pnlSouth.add(btnModify, gbc_btnModify);

		 btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						word = "selected";
						controller.deleteRequest();

			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 1;
		pnlSouth.add(btnDelete, gbc_btnDelete);
		view.setBackground(new Color(255, 255, 255));
		
		btnModify.setVisible(false);
		btnDelete.setVisible(false);

		contentPane.add(view, BorderLayout.CENTER);
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.drawing(e);
			}
		});
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public DrawingView getView() {
		return view;
	}
	public void setController(DrawingController controller) {
		this.controller = controller;
	}
	
	@Override
	public void update() {
	    int selectedCount = controller.getSelectedCount();

	    btnModify.setVisible(selectedCount == 1);
	    btnDelete.setVisible(selectedCount >= 1);
	}

}