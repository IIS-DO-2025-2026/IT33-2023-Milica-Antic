package stekSort;

import java.awt.EventQueue;
import java.util.Collections;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stekSort.Donut;
import stekSort.Point;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class FrmSort extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DlgDonutS dlgDonut = new DlgDonutS();
	private DefaultListModel<Donut> dlm = new DefaultListModel<Donut>();
	private JList<Donut> lstDonut = new JList<Donut>();;

	// private Stack<Donut> stek=new Stack<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setTitle("Antic Milica IT33/2023");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgDonut  = new DlgDonutS();
				dlgDonut.setVisible(true);
				if(dlgDonut.isOk()) {
					Point point1=new Point(Integer.parseInt(dlgDonut.getTxtFieldPointX().getText()),Integer.parseInt(dlgDonut.getTxtFieldPointY().getText()));
					Donut element=new Donut( point1,
							Integer.parseInt(dlgDonut.getTxtFieldBiggerRadius().getText())
							,Integer.parseInt(dlgDonut.getTxtFieldSmallerRadius().getText()));
					
					
					dlm.insertElementAt(element,0);

				}
			}});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 0;
		panel.add(btnAdd, gbc_btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
					 try {
				            if (dlm.isEmpty()) {
				                throw new Exception("The list is empty");
				            } else if (dlm.size() < 2) {
				                throw new Exception("There must be at least 2 elements in the list for sorting to be possible.");
				            } else {
				            	for(int i=0;i<dlm.size()-1;i++)
								{ 
									for(int j=0;j<dlm.size()-1-i;j++)//trazi najmanji element i stavlja ga na kraj liste i tako svaki put
									{
										Donut firstElement=dlm.elementAt(j);
										Donut secondElement=dlm.elementAt(j+1);
										Donut temp;
										if(firstElement.compareTo(secondElement)<0)
										{  
											temp=firstElement;
											dlm.set(j,secondElement);
											dlm.set(j+1,temp);
										}
										
									}
								}
									
									lstDonut.setModel(dlm);
				            }
				        } catch (Exception e1) {
				        	JOptionPane.showMessageDialog(null,
									e1.getMessage(), "Error Message",
									JOptionPane.INFORMATION_MESSAGE);}}
		});
				
			
			
	
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.insets = new Insets(0, 0, 5, 0);
		gbc_btnSort.gridx = 2;
		gbc_btnSort.gridy = 0;
		panel.add(btnSort, gbc_btnSort);
		
		JScrollPane scrollPaneSort = new JScrollPane();
		GridBagConstraints gbc_scrollPaneSort = new GridBagConstraints();
		gbc_scrollPaneSort.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneSort.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneSort.gridx = 1;
		gbc_scrollPaneSort.gridy = 1;
		panel.add(scrollPaneSort, gbc_scrollPaneSort);
		
		 
		scrollPaneSort.setViewportView(lstDonut);
		lstDonut.setModel(dlm);
	}
	}
