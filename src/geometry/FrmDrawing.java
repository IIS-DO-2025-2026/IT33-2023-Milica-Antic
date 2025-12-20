package geometry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stekSort.DlgDonutS;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmDrawing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PnlDrawing pnlDrawing=new PnlDrawing();
	private ButtonGroup group = new ButtonGroup();
	private String word="";
	private static FrmDrawing frame = new FrmDrawing();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setTitle("Antic Milica IT33/2023");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 300);
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
			
			word="point";
			if(pnlDrawing.getSelectedShape()!=null)
			{pnlDrawing.getSelectedShape().setSelected(false);
			pnlDrawing.setSelectedShape(null);
			pnlDrawing.repaint();
			}
		
			
			}});
	
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 0;
		pnlNorth.add(tglbtnPoint, gbc_tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			word="line";
			if(pnlDrawing.getSelectedShape()!=null)
			{pnlDrawing.getSelectedShape().setSelected(false);
			pnlDrawing.setSelectedShape(null);
			pnlDrawing.repaint();
			}
			}
			});
		group.add(tglbtnLine);
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnLine.gridx = 1;
		gbc_tglbtnLine.gridy = 0;
		pnlNorth.add(tglbtnLine, gbc_tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		group.add(tglbtnRectangle);
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			word="rectangle";
			if(pnlDrawing.getSelectedShape()!=null)
			{pnlDrawing.getSelectedShape().setSelected(false);
			pnlDrawing.setSelectedShape(null);
			pnlDrawing.repaint();
			}
			
			}});
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnRectangle.gridx = 2;
		gbc_tglbtnRectangle.gridy = 0;
		pnlNorth.add(tglbtnRectangle, gbc_tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		group.add(tglbtnCircle);
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			word="circle";
			if(pnlDrawing.getSelectedShape()!=null)
			{pnlDrawing.getSelectedShape().setSelected(false);
			pnlDrawing.setSelectedShape(null);
			pnlDrawing.repaint();
			}
			
			}});
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnCircle.gridx = 3;
		gbc_tglbtnCircle.gridy = 0;
		pnlNorth.add(tglbtnCircle, gbc_tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		group.add(tglbtnDonut);
		tglbtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			word="donut";
			if(pnlDrawing.getSelectedShape()!=null)
			{pnlDrawing.getSelectedShape().setSelected(false);
			pnlDrawing.setSelectedShape(null);
			pnlDrawing.repaint();
			}
			
			}});
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
            	if (pnlDrawing.getListOfShapes().size() > 0) {
            	
            	if(pnlDrawing.getSelectedShape()!=null)
    			{pnlDrawing.getSelectedShape().setSelected(false);
    			pnlDrawing.setSelectedShape(null);
    			pnlDrawing.repaint();
    			}
            	word="selected";}
            	else {
    				JOptionPane.showMessageDialog(null, "There are no drawn shapes", "Error Message", JOptionPane.INFORMATION_MESSAGE);
    			}
            	
            	
            }});
		
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 1;
		pnlSouth.add(tglbtnSelect, gbc_tglbtnSelect);
		
		JButton btnModify = new JButton("Modify");
		
		btnModify.addActionListener(new ActionListener() {
	           
            public void actionPerformed(ActionEvent e) {
            	
            	if (pnlDrawing.getListOfShapes().size() > 0) {
            	
            	if(pnlDrawing.getSelectedShape()!=null)
            		
    			{
            		pnlDrawing.getSelectedShape().setSelected(false);
    			pnlDrawing.modify();
    			word="selected";
    			
    			
    			}
            	
            	else  {
    				JOptionPane.showMessageDialog(null, "Nothing  is selected,",
    						"Error Message", JOptionPane.INFORMATION_MESSAGE);
    				tglbtnSelect.setSelected(true);
    				word="selected";
    				
            	}
    			}
            	else {
    				JOptionPane.showMessageDialog(null, "There are no drawn shapes", "Error Message", JOptionPane.INFORMATION_MESSAGE);
    			}
            	
            }});
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 0, 5);
		gbc_btnModify.gridx = 1;
		gbc_btnModify.gridy = 1;
		pnlSouth.add(btnModify, gbc_btnModify);
		
		JButton btnDelete = new JButton("Delete");
		
		btnDelete.addActionListener(new ActionListener() {
	           
            public void actionPerformed(ActionEvent e) {
            
            	if (pnlDrawing.getListOfShapes().size() > 0) {
            	if(pnlDrawing.getSelectedShape()!=null)
    			{pnlDrawing.getSelectedShape().setSelected(false);
            	pnlDrawing.delete();
            	word="selected";
    			}
            	else  {
    				JOptionPane.showMessageDialog(null, "Nothing  is selected,",
    						"Error Message", JOptionPane.INFORMATION_MESSAGE);
    				tglbtnSelect.setSelected(true);
    				word="selected";
    			}}
            	else {
    				JOptionPane.showMessageDialog(null, "There are no drawn shapes", "Error Message", JOptionPane.INFORMATION_MESSAGE);
    			}
            	
            }});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 1;
		pnlSouth.add(btnDelete, gbc_btnDelete);
		pnlDrawing.setBackground(new Color(255, 255, 255));
		
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
	  pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					pnlDrawing.drawing(e, frame);	
			}
		});
	}
	
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
