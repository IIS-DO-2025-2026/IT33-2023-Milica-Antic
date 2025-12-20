package gui;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmTest extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final ButtonGroup buttonGroupBoje = new ButtonGroup();
    private JLabel lblCrvenaBoja;
    private JLabel lblPlavaBoja;
    private JLabel lblZutaBoja;
    private DefaultListModel<String> dlm = new DefaultListModel<String>();
    private JTextField txtFieldDodatnaBoja;
    private JList<String> lstBoje;
    private DlgTest dlgTest;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FrmTest frame = new FrmTest();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FrmTest() {
        setTitle("Frame test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel pnlCenter = new JPanel();
        contentPane.add(pnlCenter, BorderLayout.CENTER);
        GridBagLayout gbl_pnlCenter = new GridBagLayout();
        gbl_pnlCenter.columnWidths = new int[] { 0, 0, 0, 0 };
        gbl_pnlCenter.rowHeights = new int[] { 0, 0, 0, 0, 0 };
        gbl_pnlCenter.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl_pnlCenter.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
        pnlCenter.setLayout(gbl_pnlCenter);

        // Dugmad za osnovne boje
        JToggleButton tglbtnCrvenBoja = new JToggleButton("Crvena");
        tglbtnCrvenBoja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblCrvenaBoja.setForeground(Color.red);
                lblPlavaBoja.setForeground(Color.black);
                lblZutaBoja.setForeground(Color.black);
                dlm.addElement(lblCrvenaBoja.getText());
            }
        });
        buttonGroupBoje.add(tglbtnCrvenBoja);
        GridBagConstraints gbc_tglbtnCrvenBoja = new GridBagConstraints();
        gbc_tglbtnCrvenBoja.fill = GridBagConstraints.HORIZONTAL;
        gbc_tglbtnCrvenBoja.insets = new Insets(0, 0, 5, 5);
        gbc_tglbtnCrvenBoja.gridx = 0;
        gbc_tglbtnCrvenBoja.gridy = 0;
        pnlCenter.add(tglbtnCrvenBoja, gbc_tglbtnCrvenBoja);

        lblCrvenaBoja = new JLabel("Crvena boja");
        GridBagConstraints gbc_lblCrvenaBoja = new GridBagConstraints();
        gbc_lblCrvenaBoja.anchor = GridBagConstraints.WEST;
        gbc_lblCrvenaBoja.insets = new Insets(0, 0, 5, 5);
        gbc_lblCrvenaBoja.gridx = 1;
        gbc_lblCrvenaBoja.gridy = 0;
        pnlCenter.add(lblCrvenaBoja, gbc_lblCrvenaBoja);

        JToggleButton tglbtnPlava = new JToggleButton("Plava");
        tglbtnPlava.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblPlavaBoja.setForeground(Color.red);
                lblCrvenaBoja.setForeground(Color.black);
                lblZutaBoja.setForeground(Color.black);
                dlm.addElement(lblPlavaBoja.getText());
            }
        });
        buttonGroupBoje.add(tglbtnPlava);
        GridBagConstraints gbc_tglbtnPlava = new GridBagConstraints();
        gbc_tglbtnPlava.fill = GridBagConstraints.HORIZONTAL;
        gbc_tglbtnPlava.insets = new Insets(0, 0, 5, 5);
        gbc_tglbtnPlava.gridx = 0;
        gbc_tglbtnPlava.gridy = 1;
        pnlCenter.add(tglbtnPlava, gbc_tglbtnPlava);

        lblPlavaBoja = new JLabel("Plava boja");
        GridBagConstraints gbc_lblPlavaBoja = new GridBagConstraints();
        gbc_lblPlavaBoja.anchor = GridBagConstraints.WEST;
        gbc_lblPlavaBoja.insets = new Insets(0, 0, 5, 5);
        gbc_lblPlavaBoja.gridx = 1;
        gbc_lblPlavaBoja.gridy = 1;
        pnlCenter.add(lblPlavaBoja, gbc_lblPlavaBoja);

        JToggleButton tglbtnZuta = new JToggleButton("Zuta");
        tglbtnZuta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblZutaBoja.setForeground(Color.red);
                lblPlavaBoja.setForeground(Color.black);
                lblCrvenaBoja.setForeground(Color.black);
                dlm.addElement(lblZutaBoja.getText());
            }
        });
        buttonGroupBoje.add(tglbtnZuta);
        GridBagConstraints gbc_tglbtnZuta = new GridBagConstraints();
        gbc_tglbtnZuta.insets = new Insets(0, 0, 5, 5);
        gbc_tglbtnZuta.fill = GridBagConstraints.HORIZONTAL;
        gbc_tglbtnZuta.gridx = 0;
        gbc_tglbtnZuta.gridy = 2;
        pnlCenter.add(tglbtnZuta, gbc_tglbtnZuta);

        lblZutaBoja = new JLabel("Zuta boja");
        GridBagConstraints gbc_lblZutaBoja = new GridBagConstraints();
        gbc_lblZutaBoja.insets = new Insets(0, 0, 5, 5);
        gbc_lblZutaBoja.anchor = GridBagConstraints.WEST;
        gbc_lblZutaBoja.gridx = 1;
        gbc_lblZutaBoja.gridy = 2;
        pnlCenter.add(lblZutaBoja, gbc_lblZutaBoja);

        JLabel lblDodatneBoje = new JLabel("Dodatne boje");
        GridBagConstraints gbc_lblDodatneBoje = new GridBagConstraints();
        gbc_lblDodatneBoje.insets = new Insets(0, 0, 5, 0);
        gbc_lblDodatneBoje.gridx = 2;
        gbc_lblDodatneBoje.gridy = 0;
        pnlCenter.add(lblDodatneBoje, gbc_lblDodatneBoje);

        // ComboBox dodatne boje
        JComboBox<String> comboBoxDodatneBoje = new JComboBox<String>();
        comboBoxDodatneBoje.setModel(new DefaultComboBoxModel<String>(new String[] { "Ljubicasta", "Zelena", "Narandzasta" }));
        comboBoxDodatneBoje.addActionListener(e -> {
            String choosenColor = comboBoxDodatneBoje.getSelectedItem().toString();
            dlm.addElement(choosenColor);
            switch (choosenColor) {
                case "Zelena": lblDodatneBoje.setForeground(Color.green); break;
                case "Ljubicasta": lblDodatneBoje.setForeground(Color.magenta); break;
                case "Narandzasta": lblDodatneBoje.setForeground(Color.orange); break;
            }
        });
        GridBagConstraints gbc_comboBoxDodatneBoje = new GridBagConstraints();
        gbc_comboBoxDodatneBoje.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxDodatneBoje.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxDodatneBoje.gridx = 2;
        gbc_comboBoxDodatneBoje.gridy = 1;
        pnlCenter.add(comboBoxDodatneBoje, gbc_comboBoxDodatneBoje);

        // Tekstualno polje za dodatnu boju
        txtFieldDodatnaBoja = new JTextField();
        txtFieldDodatnaBoja.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dlm.addElement(txtFieldDodatnaBoja.getText());
                    txtFieldDodatnaBoja.setText("");
                }
            }
        });
        GridBagConstraints gbc_txtFieldDodatnaBoja = new GridBagConstraints();
        gbc_txtFieldDodatnaBoja.insets = new Insets(0, 0, 5, 0);
        gbc_txtFieldDodatnaBoja.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFieldDodatnaBoja.gridx = 2;
        gbc_txtFieldDodatnaBoja.gridy = 2;
        pnlCenter.add(txtFieldDodatnaBoja, gbc_txtFieldDodatnaBoja);
        txtFieldDodatnaBoja.setColumns(10);

        // Scroll lista boja
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 2;
        gbc_scrollPane.gridy = 3;
        pnlCenter.add(scrollPane, gbc_scrollPane);

        lstBoje = new JList<String>();
        scrollPane.setViewportView(lstBoje);
        lstBoje.setModel(dlm);

        // Dugme Dodati boju
        JButton btnDodajBoju = new JButton("Dodati boju");
        btnDodajBoju.addActionListener(e -> {
            dlgTest = new DlgTest();
            dlgTest.setVisible(true);

            if (dlgTest.isOk()) {
                String stringColor = dlgTest.getTxtFieldRed().getText() + " " + dlgTest.getTxtFieldGreen().getText()
                        + " " + dlgTest.getTxtFieldBlue().getText();
                dlm.addElement(stringColor);

                Color color = new Color(Integer.parseInt(dlgTest.getTxtFieldRed().getText()),
                        Integer.parseInt(dlgTest.getTxtFieldGreen().getText()),
                        Integer.parseInt(dlgTest.getTxtFieldBlue().getText()));
                pnlCenter.setBackground(color);
            }
        });
        GridBagConstraints gbc_btnDodajBoju = new GridBagConstraints();
        gbc_btnDodajBoju.insets = new Insets(0, 0, 0, 5);
        gbc_btnDodajBoju.gridx = 0;
        gbc_btnDodajBoju.gridy = 3;
        pnlCenter.add(btnDodajBoju, gbc_btnDodajBoju);

        // Dugme Izmeni boju (ISPRAVLJENO)
        JButton btnIzmeniBoju = new JButton("Izmeni boju");
        btnIzmeniBoju.addActionListener(e -> {
            int indexSelectedColor = lstBoje.getSelectedIndex();
            if (indexSelectedColor == -1) {
                JOptionPane.showMessageDialog(null, "Odaberite boju iz liste za izmenu!", "Greška",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            String selectedColor = dlm.getElementAt(indexSelectedColor);
            String[] rgbColor = selectedColor.split(" ");

            // Ako nije RGB koordinata, obavesti korisnika
            if (rgbColor.length != 3) {
                JOptionPane.showMessageDialog(null, "Ova boja je tekstualna i ne može se menjati preko koordinata!", "Info",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            dlgTest = new DlgTest();
            try {
                dlgTest.getTxtFieldRed().setText(rgbColor[0]);
                dlgTest.getTxtFieldGreen().setText(rgbColor[1]);
                dlgTest.getTxtFieldBlue().setText(rgbColor[2]);
            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }

            dlgTest.setVisible(true);

            if (dlgTest.isOk()) {
                String stringColor = dlgTest.getTxtFieldRed().getText() + " " +
                        dlgTest.getTxtFieldGreen().getText() + " " +
                        dlgTest.getTxtFieldBlue().getText();

                dlm.set(indexSelectedColor, stringColor);

                try {
                    Color color = new Color(
                            Integer.parseInt(dlgTest.getTxtFieldRed().getText()),
                            Integer.parseInt(dlgTest.getTxtFieldGreen().getText()),
                            Integer.parseInt(dlgTest.getTxtFieldBlue().getText()));
                    pnlCenter.setBackground(color);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "RGB vrednosti moraju biti brojevi!", "Greška",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        GridBagConstraints gbc_btnIzmeniBoju = new GridBagConstraints();
        gbc_btnIzmeniBoju.insets = new Insets(0, 0, 0, 5);
        gbc_btnIzmeniBoju.gridx = 1;
        gbc_btnIzmeniBoju.gridy = 3;
        pnlCenter.add(btnIzmeniBoju, gbc_btnIzmeniBoju);

        // North panel
        JPanel pnlNorth = new JPanel();
        pnlNorth.setBackground(new Color(0, 255, 0));
        contentPane.add(pnlNorth, BorderLayout.NORTH);

        JLabel lblNaslov = new JLabel("Zadatak 1");
        lblNaslov.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pnlNorth.add(lblNaslov);

        // South panel
        JPanel pnlSouth = new JPanel();
        contentPane.add(pnlSouth, BorderLayout.SOUTH);

        JButton btnKlik = new JButton("Klikni me");
        btnKlik.addActionListener(e -> JOptionPane.showMessageDialog(null, "Antistres dugme :)", "Poruka",
                JOptionPane.INFORMATION_MESSAGE));

        JButton btnBojaPozadine = new JButton("Boja pozadine");
        btnBojaPozadine.addActionListener(e -> {
            Color backColor = JColorChooser.showDialog(null, "Choose background color", Color.black);
            if (backColor != null)
                pnlCenter.setBackground(backColor);
        });

        pnlSouth.add(btnBojaPozadine);
        pnlSouth.add(btnKlik);
    }
}
