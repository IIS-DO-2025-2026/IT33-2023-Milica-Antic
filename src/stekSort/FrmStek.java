package stekSort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmStek extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DlgDonutS dlgStek;
	private DefaultListModel<Donut> dlm = new DefaultListModel<Donut>();
	private JList<Donut> lstDonut;
	//private Stack<Donut> stack=new Stack<Donut>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStek frame = new FrmStek();
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
	public FrmStek() {
		setTitle("Antic Milica IT33/2023");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlCenter.rowHeights = new int[]{0, 0, 0};
		gbl_pnlCenter.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JButton btnAddDonut = new JButton("Add donut");
		btnAddDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgStek = new DlgDonutS();
				dlgStek.setVisible(true);
				
				if(dlgStek.isOk()) {
					Point point1=new Point(Integer.parseInt(dlgStek.getTxtFieldPointX().getText()),Integer.parseInt(dlgStek.getTxtFieldPointY().getText()));
					Donut element=new Donut( point1,
							Integer.parseInt(dlgStek.getTxtFieldBiggerRadius().getText())
							,Integer.parseInt(dlgStek.getTxtFieldSmallerRadius().getText()));
					
					//stack.push(element);
					dlm.insertElementAt(element,0);
					
				} 
			}
		});
		GridBagConstraints gbc_btnAddDonut = new GridBagConstraints();
		gbc_btnAddDonut.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddDonut.gridx = 0;
		gbc_btnAddDonut.gridy = 0;
		pnlCenter.add(btnAddDonut, gbc_btnAddDonut);
		
		JButton btnDeleteDonut = new JButton("Delete donut");
		btnDeleteDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.size()<1)
				{ JOptionPane.showMessageDialog(null,
						"There is nothing to delete.", "Error Message",
						JOptionPane.INFORMATION_MESSAGE); 
				return;
						}
				dlgStek = new DlgDonutS();
				dlgStek.setTitle("Delete donut");
				//Donut donut=stack.peek();
				Donut ElementToDelete=dlm.getElementAt(0);
				/*dlgStek.getTxtFieldPointX().setText(String.valueOf(donut.getCenter().getX()));
				dlgStek.getTxtFieldPointY().setText(String.valueOf(donut.getCenter().getY()));
				dlgStek.getTxtFieldBiggerRadius().setText(String.valueOf(donut.getRadius()));
				dlgStek.getTxtFieldSmallerRadius().setText(String.valueOf(donut.getInnerRadius()));*/
				
				dlgStek.getTxtFieldPointX().setText(String.valueOf(ElementToDelete.getCenter().getX()));
				dlgStek.getTxtFieldPointY().setText(String.valueOf(ElementToDelete.getCenter().getY()));
				dlgStek.getTxtFieldBiggerRadius().setText(String.valueOf(ElementToDelete.getRadius()));
				dlgStek.getTxtFieldSmallerRadius().setText(String.valueOf(ElementToDelete.getInnerRadius()));
				dlgStek.getTxtFieldPointX().setEditable(false);   //ne moze da se edituje textfield
				dlgStek.getTxtFieldPointY().setEditable(false);
				dlgStek.getTxtFieldBiggerRadius().setEditable(false);
				dlgStek.getTxtFieldSmallerRadius().setEditable(false);
				dlgStek.setVisible(true);
				if(dlgStek.isOk()) {
				//stack.pop();
					dlm.remove(0);}
				
			}
		});
		GridBagConstraints gbc_btnDeleteDonut = new GridBagConstraints();
		gbc_btnDeleteDonut.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteDonut.gridx = 2;
		gbc_btnDeleteDonut.gridy = 0;
		pnlCenter.add(btnDeleteDonut, gbc_btnDeleteDonut);
		
		JScrollPane scrollPaneStek = new JScrollPane();
		GridBagConstraints gbc_scrollPaneStek = new GridBagConstraints();
		gbc_scrollPaneStek.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPaneStek.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneStek.gridx = 1;
		gbc_scrollPaneStek.gridy = 1;
		pnlCenter.add(scrollPaneStek, gbc_scrollPaneStek);
		
		/*while(stack.size!=0)
		{
			dlm.add(stack.peek()):
		}*/
		lstDonut = new JList<Donut>();   //lista za prikazivanje
		scrollPaneStek.setViewportView(lstDonut);
		lstDonut.setModel(dlm);
	}
}
