package GUI.guihospital;

import MC.Blood;
import MC.BloodList;
import MC.Notifications;
import MC.RequestMsg;
import RMI.MyClientHp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Enumeration;

import static java.lang.Integer.parseInt;

/**
 * Class for The Hp Tab
 */
public class HBloodPanel extends JPanel {

    private MyButtonListener buttonListener;

    private JPanel boxPanel;
    private JPanel headerPanel;
    private JPanel radioPanel;
    private JPanel updatePanel;
    private JPanel idPanel;
    private JPanel totalPanel;
    private JPanel scrollPanel;
    private JPanel footerPanel;
    private JPanel leftPanel;

    private JPanel upPanel;
    private JPanel buttonsPanel;
    private JLabel headerLabel;
    private JTextField totalText;

    private ButtonGroup bg;
    private JRadioButton allType;
    private JRadioButton opType;
    private JRadioButton onType;
    private JRadioButton apType;
    private JRadioButton anType;
    private JRadioButton bpType;
    private JRadioButton bnType;
    private JRadioButton abpType;
    private JRadioButton abnType;

    private JScrollPane idScrollPane;
    private DefaultListModel idListModel;
    private JList<Blood> idListArea;

    private ImageIcon logoIcon;
    private JLabel logoLabel;
    private JLabel totalLabel;

    private JButton selectButton;
    private JButton usedButton;
    private JPanel requestPanel;
    private JLabel amountLabel;
    private JTextField amountText;
    private JButton requestButton;
    private JPanel emptyPanel;

    private HGUI hgui;
    private MyClientHp myClientHp;
    private JButton logOutButton;
    private BloodList temp;

    /**
     * One argument constructor, initializing all objects on the GUI
     *
     * @param hgui HGUI
     * @throws RemoteException
     */
    public HBloodPanel(HGUI hgui) throws RemoteException {

        this.hgui = hgui;
        myClientHp = new MyClientHp();
        buttonListener = new MyButtonListener();


        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

        // The header
        headerPanel = new JPanel();
        headerLabel = new JLabel("Storage");
        Font headerFont = new Font(headerLabel.getFont().getFamily(), Font.PLAIN,
                26);
        headerLabel.setFont(headerFont);
        headerPanel.add(headerLabel);
        headerPanel.setPreferredSize(new Dimension(1000, 50));

        // Create the radio panel
        upPanel = new JPanel();
        radioPanel = new JPanel();
        bg = new ButtonGroup();
        allType = new JRadioButton("All blood types");

        opType = new JRadioButton("O+");

        onType = new JRadioButton("O-");

        apType = new JRadioButton("A+");

        anType = new JRadioButton("A-");

        bpType = new JRadioButton("B+");

        bnType = new JRadioButton("B-");

        abpType = new JRadioButton("AB+");

        abnType = new JRadioButton("AB-");

        radioPanel.add(allType);
        radioPanel.add(opType);
        radioPanel.add(onType);
        radioPanel.add(apType);
        radioPanel.add(anType);
        radioPanel.add(bpType);
        radioPanel.add(bnType);
        radioPanel.add(abpType);
        radioPanel.add(abnType);
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        bg.add(allType);
        bg.add(opType);
        bg.add(onType);
        bg.add(apType);
        bg.add(anType);
        bg.add(bpType);
        bg.add(bnType);
        bg.add(abpType);
        bg.add(abnType);


        emptyPanel = new JPanel();
        emptyPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        updatePanel = new JPanel();
        selectButton = new JButton("Select");
        usedButton = new JButton("Withdraw Blood");
        updatePanel.add(selectButton);
        selectButton.addActionListener(buttonListener);
        updatePanel.add(usedButton);
        usedButton.addActionListener(buttonListener);
        updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.Y_AXIS));
        updatePanel.setLayout(new GridLayout(6, 1, 12, 5));

        buttonsPanel = new JPanel();
        requestPanel = new JPanel();
        amountLabel = new JLabel("Amount: ");
        amountText = new JTextField(10);
        requestButton = new JButton("Request");
        requestPanel.add(amountLabel);
        requestPanel.add(amountText);
        requestPanel.add(requestButton);
        requestButton.addActionListener(buttonListener);
        requestPanel.setLayout(new BoxLayout(requestPanel, BoxLayout.Y_AXIS));
        requestPanel.setLayout(new GridLayout(8, 1, 12, 2));
        // requestPanel.setPreferredSize(new Dimension(150, 50));

        buttonsPanel.add(updatePanel, BorderLayout.WEST);
        buttonsPanel.add(emptyPanel, BorderLayout.WEST);
        emptyPanel.setPreferredSize(new Dimension(300, 50));
        buttonsPanel.add(requestPanel, BorderLayout.EAST);
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(300, 50));


        upPanel.add(radioPanel, BorderLayout.WEST);

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        upPanel.add(buttonsPanel);

        upPanel.setLayout(new GridLayout(1, 3, 30, 30));
        upPanel.setLayout(new BoxLayout(upPanel, BoxLayout.X_AXIS));


        // Create the scroll pane for id
        idListModel = new DefaultListModel<>();
        idListArea = new JList<>(idListModel);
        idListArea.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        idListArea.setVisibleRowCount(10);
        idScrollPane = new JScrollPane(idListArea);
        idScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        idScrollPane.setPreferredSize(new Dimension(1000, 176));


        // Create the scroll pane for date

        leftPanel = new JPanel();
        idPanel = new JPanel();

        leftPanel.add(idPanel, BorderLayout.NORTH);
        leftPanel.add(idScrollPane, BorderLayout.SOUTH);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        scrollPanel = new JPanel();
        scrollPanel.add(leftPanel);

        // Create the footer panel
        footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        totalPanel = new JPanel();
        totalLabel = new JLabel("Total: ");
        totalText = new JTextField(10);
        totalText.setEditable(false);
        totalPanel.add(totalLabel);
        totalPanel.add(totalText);
        totalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Create the logo
        logoIcon = new ImageIcon("img/sygehus.gif");
        logoLabel = new JLabel();
        logoLabel.setIcon(logoIcon);
        logoLabel.setLayout(new FlowLayout(FlowLayout.LEFT));
        // footerPanel.add(totalPanel, BorderLayout.NORTH);
        logOutButton = new JButton("Log Out");
        footerPanel.add(logOutButton);
        logOutButton.addActionListener(buttonListener);
        footerPanel.add(logoLabel);

        boxPanel.add(headerPanel);
        boxPanel.add(upPanel);
        boxPanel.add(scrollPanel);
        boxPanel.add(totalPanel);
        boxPanel.add(footerPanel);

        add(boxPanel);
        setSize(1200, 700);
        setVisible(true);
    }

    /**
     * receives a list and adds it's elements to a jList
     *
     * @param list type BloodList
     * @throws RemoteException
     */
    private void bloodList(BloodList list) throws RemoteException {
        temp = list;
        idListModel.removeAllElements();
        totalText.setText("");
        for (int i = 0; i < list.size(); i++) {
            idListModel.addElement(list.getBlood(i).getAllbloodTypesRad());
        }
        idListArea.setModel(idListModel);
    }

    /**
     * gets a bloodList list filtered by type
     *
     * @param type String
     */
    private void getBB(String type) {
        try {
            bloodList(myClientHp.getBloodByTypeHpTable(type));
            totalText.setText(myClientHp.getBloodByTypeHpTable(type).getCount() + " Bags");
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * returns a Blood Object from a BloodList
     *
     * @param index index int
     * @return Blood at the index
     */
    private Blood getBlood(int index) {
        return temp.getBlood(index);
    }

    /**
     * Nested Class for the ButtonListener
     */
    public class MyButtonListener implements ActionListener {

        /**
         * Implementation of every button on the Tab
         *
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            if (onType.isSelected() && e.getSource().equals(selectButton)) {
                getBB("O-");
            }
            if (e.getSource().equals(selectButton) && opType.isSelected()) {
                getBB("O+");
            }
            if (anType.isSelected() && e.getSource().equals(selectButton)) {
                getBB("A-");
            }
            if (apType.isSelected() && e.getSource().equals(selectButton)) {
                getBB("A+");
            }
            if (bnType.isSelected() && e.getSource().equals(selectButton)) {
                getBB("B-");
            }
            if (bpType.isSelected() && e.getSource().equals(selectButton)) {
                getBB("B+");
            }
            if (abnType.isSelected() && e.getSource().equals(selectButton)) {
                getBB("AB+");
            }
            if (abpType.isSelected() && e.getSource().equals(selectButton)) {
                getBB("AB-");
            }
            if (allType.isSelected() && e.getSource().equals(selectButton)) {
                try {
                    bloodList(myClientHp.getBloodHpTable());
                    totalText.setText(myClientHp.getBloodHpTable().getCount() + " Bags");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == usedButton) {
                try {
                    myClientHp.removeBlood(getBlood(idListArea.getAnchorSelectionIndex()).getBloodID() + "");

                    Notifications notifications = new Notifications(getBlood(idListArea.getAnchorSelectionIndex()).getBloodType(),
                            getBlood(idListArea.getAnchorSelectionIndex()).getBloodID());

                    myClientHp.sendNotificationMsg(notifications);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == requestButton) {
                try {
                    String temp = "";

                    Enumeration<AbstractButton> elements = bg.getElements();
                    while (elements.hasMoreElements()) {
                        AbstractButton button = elements.nextElement();
                        if (button.isSelected())
                            temp = button.getText();
                    }
                    System.out.println("LL" + temp);
                    RequestMsg requestMsg = new RequestMsg(parseInt(amountText.getText()), temp, "Horsens");

                    myClientHp.sendMsg(requestMsg);
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == logOutButton) {

                int choice = JOptionPane.showConfirmDialog(null,
                        "Do you really want to log out ?", "Log Out",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    hgui.getTabPane().setSelectedIndex(0);
                    hgui.getTabPane().setEnabledAt(0, true);
                    hgui.getTabPane().setEnabledAt(1, false);
                    hgui.getTabPane().setEnabledAt(2, false);
                }
            }
        }
    }
}


