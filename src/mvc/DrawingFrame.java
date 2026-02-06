package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JToggleButton  btnBorderColor;
	private JToggleButton btnSurfaceColor;
	private JToggleButton btnSelect;
	private JButton btnUndo;
	private JButton btnRedo;



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
		gbc_tglbtnCircle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnDonut.gridx = 4;
		gbc_tglbtnDonut.gridy = 0;
		pnlNorth.add(tglbtnDonut, gbc_tglbtnDonut);
		
		JToggleButton tglbtnHexagon = new JToggleButton("Hexagon");
		group.add(tglbtnHexagon);
		tglbtnHexagon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        word = "hexagon";      
		        controller.onModeChanged();
		    }
		});
		GridBagConstraints gbc_tglbtnHexagon = new GridBagConstraints();
		gbc_tglbtnHexagon.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnHexagon.gridx = 5;  
		gbc_tglbtnHexagon.gridy = 0;
		pnlNorth.add(tglbtnHexagon, gbc_tglbtnHexagon);
		
		JLabel lblBorder = new JLabel("Border:");
		GridBagConstraints gbc_lblBorder = new GridBagConstraints();
		gbc_lblBorder.anchor = GridBagConstraints.EAST;
		gbc_lblBorder.insets = new Insets(0, 0, 0, 5);
		gbc_lblBorder.gridx = 6;
		gbc_lblBorder.gridy = 0;
		pnlNorth.add(lblBorder, gbc_lblBorder);
		
		 btnBorderColor = new JToggleButton("");
		btnBorderColor.setBackground(Color.black);
		btnBorderColor.setPreferredSize(new Dimension(20,20));
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			    Color newColor = JColorChooser.showDialog(null,"Choose border color",btnBorderColor.getBackground() );

			    if (newColor != null) {
		            btnBorderColor.setBackground(newColor);
		            controller.changeBorderColor(newColor);
		        }
		        btnBorderColor.setSelected(false);


			}
		});
		GridBagConstraints gbc_tglbtnBorderColor = new GridBagConstraints();
		gbc_tglbtnBorderColor.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnBorderColor.gridx = 7;
		gbc_tglbtnBorderColor.gridy = 0;
		pnlNorth.add(btnBorderColor, gbc_tglbtnBorderColor);
		
		JLabel lblSurface = new JLabel("Surface:");
		GridBagConstraints gbc_lblSurface = new GridBagConstraints();
		gbc_lblSurface.anchor = GridBagConstraints.EAST;
		gbc_lblSurface.insets = new Insets(0, 0, 0, 5);
		gbc_lblSurface.gridx = 8;
		gbc_lblSurface.gridy = 0;
		pnlNorth.add(lblSurface, gbc_lblSurface);
		
		
		btnSurfaceColor = new JToggleButton("");
		btnSurfaceColor.setBackground(Color.white);
		btnSurfaceColor.setPreferredSize(new Dimension(20,20));
		btnSurfaceColor.addActionListener(e -> {
		    Color newColor = JColorChooser.showDialog(this,"Choose surface color",btnSurfaceColor.getBackground() );
		        if (newColor != null) {
		            btnSurfaceColor.setBackground(newColor);
		            controller.changeSurfaceColor(newColor);
		        }
		        btnSurfaceColor.setSelected(false);


		    });
		GridBagConstraints gbc_tglbtnSurfaceColor = new GridBagConstraints();
		gbc_tglbtnSurfaceColor.insets = new Insets(0, 0, 0, 6);
		gbc_tglbtnSurfaceColor.gridx = 9;
		gbc_tglbtnSurfaceColor.gridy = 0;
		pnlNorth.add(btnSurfaceColor, gbc_tglbtnSurfaceColor);



		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSouth = new GridBagLayout();
		gbl_pnlSouth.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlSouth.rowHeights = new int[]{0, 0, 0};
		gbl_pnlSouth.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSouth.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlSouth.setLayout(gbl_pnlSouth);

		btnSelect = new JToggleButton("Select");
		group.add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
					word = "selected";
					controller.onModeChanged();


			}
			
		});
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 1;
		pnlSouth.add(btnSelect, gbc_tglbtnSelect);

		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			;
						word = "selected";
						controller.modify();

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
						controller.delete();

			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 1;
		pnlSouth.add(btnDelete, gbc_btnDelete);
		
		  btnUndo = new JButton("Undo");
			btnUndo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
							controller.undo();

				}
			});
			GridBagConstraints gbc_btnUndo = new GridBagConstraints();
			gbc_btnUndo.gridx = 3;
			gbc_btnUndo.gridy = 1;
			pnlSouth.add(btnUndo, gbc_btnUndo);
			
			
			 btnRedo = new JButton("Redo");
			btnRedo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								controller.redo();

					}
				});
				GridBagConstraints gbc_btnRedo = new GridBagConstraints();
				gbc_btnRedo.gridx = 4;
				gbc_btnRedo.gridy = 1;
				pnlSouth.add(btnRedo, gbc_btnRedo);
		
				btnModify.setEnabled(false);
			    btnDelete.setEnabled(false);
			    btnSelect.setEnabled(false);
			    btnUndo.setEnabled(false);
			    btnRedo.setEnabled(false);
		
		view.setBackground(new Color(255, 255, 255));
		
	

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

	    btnModify.setEnabled(selectedCount == 1);
	    btnDelete.setEnabled(selectedCount >= 1);
	    btnSelect.setEnabled(controller. hasShapes());
	    btnUndo.setEnabled(!controller.getUndoStack().isEmpty());
	    btnRedo.setEnabled(!controller.getRedoStack().isEmpty());
	    view.repaint();

	}
	

}