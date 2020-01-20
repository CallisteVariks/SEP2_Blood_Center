package GUI.guibloodbank;

import MC.BBStaffList;
import RMI.MyClientBB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import static java.lang.Integer.parseInt;

public class BBStaffPanel extends JPanel {
    private MyButton listener;
    private JPanel boxPanel;
    private JPanel box1;
    private JPanel box2;

    private JPanel headerPanel;
    private JPanel searchPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;

    private JPanel buttonsPanel;
    private JPanel footerPanel;

    private JLabel headerLabel;

    private JPanel radioPanel;
    private ButtonGroup group;
    private JRadioButton idType;
    private JPanel idPanel;
    private JPanel cprPanel;
    private JRadioButton cprType;

    private JTextField idText;
    private JTextField cprText;

    private JButton searchButton;
    private JButton allButton;

    private JButton selectButton;
    private JButton exitButton;

    private ImageIcon logoIcon;
    private JLabel logoLabel;

    private JScrollPane scrollPane;
    private DefaultListModel listModel;
    private JList listArea;
    private MyClientBB myClientBB;

    /**
     * Zero Argument constructor
     * @throws RemoteException
     */

    public BBStaffPanel() throws RemoteException {
        listener = new MyButton();
        myClientBB = new MyClientBB();
        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

        // The header
        headerPanel = new JPanel();
        headerLabel = new JLabel("Staff search");
        Font headerFont = new Font(headerLabel.getFont().getFamily(), Font.PLAIN,
                26);
        headerLabel.setFont(headerFont);
        headerPanel.add(headerLabel);
        headerPanel.setPreferredSize(new Dimension(1000, 90));

        // Create the searchPanel
        searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1, 2, 8, 8));

        // Create the left side of the searchPanel
        leftPanel = new JPanel();

        box1 = new JPanel();

        idPanel = new JPanel();
        idType = new JRadioButton("ID:    ");
        idType.addActionListener(listener);
        idText = new JTextField(20);
        idText.setEditable(false);
        idPanel.add(idType);
        idPanel.add(idText);
        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));

        cprPanel = new JPanel();
        cprType = new JRadioButton("CPR: ");
        cprType.addActionListener(listener);
        cprText = new JTextField(20);
        cprText.setEditable(false);
        cprPanel.add(cprType);
        cprPanel.add(cprText);
        cprPanel.setLayout(new BoxLayout(cprPanel, BoxLayout.X_AXIS));

        group = new ButtonGroup();
        group.add(idType);
        group.add(cprType);

        radioPanel = new JPanel();
        radioPanel.add(idPanel);
        radioPanel.add(cprPanel);

        leftPanel.add(radioPanel, BorderLayout.CENTER);
        leftPanel.setPreferredSize(new Dimension(400, 150));
        leftPanel.setLayout(new GridLayout(2, 2, 15, 15));

        box1.add(leftPanel);

        // Create the right side of the searchPanel
        rightPanel = new JPanel();
        Font buttonsFont = new Font(rightPanel.getFont().getFamily(), Font.PLAIN,
                16);

        box2 = new JPanel();

        searchButton = new JButton("Search");
        searchButton.setFont(buttonsFont);
        searchButton.addActionListener(listener);

        allButton = new JButton("Show all staff");
        allButton.setFont(buttonsFont);
        allButton.addActionListener(listener);

        rightPanel.add(searchButton, BorderLayout.CENTER);
        rightPanel.add(allButton, BorderLayout.CENTER);
        rightPanel.setPreferredSize(new Dimension(150, 80));
        rightPanel.setLayout(new GridLayout(2, 1, 8, 8));

        box2.add(rightPanel);

        searchPanel.add(box1, BorderLayout.WEST);
        searchPanel.add(box2, BorderLayout.EAST);

        // Create the scroll pane which will show the donation history
        listModel = new DefaultListModel<Object>();
        listArea = new JList<Object>(listModel);
        listArea.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listArea.setVisibleRowCount(10);
        scrollPane = new JScrollPane(listArea);
        scrollPane
                .setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1000, 258));

        // Create the footer panel
        footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Create the buttons panel
        buttonsPanel = new JPanel();
        exitButton = new JButton("Exit");
        exitButton.addActionListener(listener);

        buttonsPanel.add(exitButton);

        // Create the logo
        logoIcon = new ImageIcon("img/blodbank.gif");
        logoLabel = new JLabel();
        logoLabel.setIcon(logoIcon);

        footerPanel.add(buttonsPanel);
        footerPanel.add(logoLabel);

        boxPanel.add(headerPanel);
        boxPanel.add(searchPanel);
        boxPanel.add(scrollPane);
        boxPanel.add(footerPanel);

        add(boxPanel);
        setSize(1200, 700);
        setVisible(true);

    }

    /**
     * receives a list and adds it's elements to a jList
     *
     * @param list BBStaffList
     * @throws RemoteException
     */
    private void staffList(BBStaffList list) throws RemoteException {
        listModel.removeAllElements();
        for (int i = 0; i < list.getCount(); i++) {
            listModel.addElement(list.getStaff(i).bigToString());
        }
        listArea.setModel(listModel);
    }

    private class MyButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (idType.isSelected()) {
                idText.setEditable(true);
                cprText.setEditable(false);

                if (e.getSource() == searchButton) {
                    try {
                        staffList(myClientBB.getBbStaffListById(parseInt(idText.getText())));
                        idText.setText("");
                    } catch (RemoteException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            if (cprType.isSelected()) {
                idText.setEditable(false);
                cprText.setEditable(true);
                if (e.getSource() == searchButton) {
                    try {
                        staffList(myClientBB.getBBStaffByCPR(cprText.getText()));
                        cprText.setText("");
                    } catch (RemoteException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            if (e.getSource() == allButton) {
                try {
                    staffList(myClientBB.getAllBBStaff());
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == exitButton) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Do you really want to exit the program?", "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        }
    }
}
