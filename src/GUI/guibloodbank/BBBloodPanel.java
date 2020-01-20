package GUI.guibloodbank;

import MC.Blood;
import MC.BloodList;
import RMI.MyClientBB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class BBBloodPanel extends JPanel {
    private final JButton removeBlood;
    private Button listener;

    private JPanel boxPanel;
    private JPanel headerPanel;
    private JPanel radioPanel;
    private JPanel selectPanel;
    private JPanel idPanel;

    private JPanel totalPanel;
    private JPanel scrollPanel;
    private JPanel footerPanel;
    private JPanel leftPanel;

    private JLabel headerLabel;

    private JTextField totalText;

    private JButton selectButton;

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
    private JList idListArea;

    private ImageIcon logoIcon;
    private JLabel logoLabel;
    private JLabel totalLabel;
    private BloodList temp;

    private JButton logOutButton;
    private MyClientBB myClientBB;

    /**
     * Zero argument constructor, initializing all the variables
     * @throws RemoteException
     */
    public BBBloodPanel() throws RemoteException {
        myClientBB = new MyClientBB();
        listener = new Button();

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
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));
        radioPanel.setPreferredSize(new Dimension(1000, 64));

        bg.add(allType);
        bg.add(opType);
        bg.add(onType);
        bg.add(apType);
        bg.add(anType);
        bg.add(bpType);
        bg.add(bnType);
        bg.add(abpType);
        bg.add(abnType);


        selectPanel = new JPanel();
        selectButton = new JButton("Select");
        removeBlood = new JButton("Remove Blood");

        selectPanel.add(removeBlood);
        selectPanel.add(selectButton);
        selectPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        selectButton.addActionListener(listener);
        removeBlood.addActionListener(listener);

        // Create the scroll pane for id
        idListModel = new DefaultListModel<>();
        idListArea = new JList<>(idListModel);
        idListArea.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        idListArea.setVisibleRowCount(10);
        idScrollPane = new JScrollPane(idListArea);
        idScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        idScrollPane.setPreferredSize(new Dimension(990, 308));


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
        logoIcon = new ImageIcon("img/blodbank.gif");
        logoLabel = new JLabel();
        logoLabel.setIcon(logoIcon);
        logoLabel.setLayout(new FlowLayout(FlowLayout.LEFT));
        // footerPanel.add(totalPanel, BorderLayout.NORTH);
        logOutButton = new JButton("Log Out");
        footerPanel.add(logOutButton);
        logOutButton.addActionListener(listener);
        footerPanel.add(logoLabel);

        boxPanel.add(headerPanel);
        boxPanel.add(radioPanel);
        boxPanel.add(selectPanel);
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
     * returns a Blood Object from a BloodList
     *
     * @param index index int
     * @return Blood at the index
     */
    public Blood getBlood(int index) throws RemoteException {
        return myClientBB.getBlood().getBlood(index);
    }

    /**
     * Nested Class for the ButtonListener
     */
    private class Button implements ActionListener {

        /**
         * Implementation of every button on the Tab
         *
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {

            if (onType.isSelected() && e.getSource().equals(selectButton)) {
                try {
                    bloodList(myClientBB.getBloodByType("O-"));
                    totalText.setText(myClientBB.getBloodByType("O-").getCount() + " Bags");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource().equals(selectButton) && opType.isSelected()) {
                try {
                    bloodList(myClientBB.getBloodByType("O+"));
                    totalText.setText(myClientBB.getBloodByType("O+").getCount() + " Bags");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (anType.isSelected() && e.getSource().equals(selectButton)) {
                try {
                    bloodList(myClientBB.getBloodByType("A-"));
                    totalText.setText(myClientBB.getBloodByType("A-").getCount() + " Bags");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (apType.isSelected() && e.getSource().equals(selectButton)) {
                try {
                    bloodList(myClientBB.getBloodByType("A+"));
                    totalText.setText(myClientBB.getBloodByType("A+").getCount() + " Bags");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (bnType.isSelected() && e.getSource().equals(selectButton)) {
                try {
                    bloodList(myClientBB.getBloodByType("B-"));
                    totalText.setText(myClientBB.getBloodByType("B-").getCount() + " Bags");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (bpType.isSelected() && e.getSource().equals(selectButton)) {
                try {
                    bloodList(myClientBB.getBloodByType("B+"));
                    totalText.setText(myClientBB.getBloodByType("B+").getCount() + " Bags");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (abnType.isSelected() && e.getSource().equals(selectButton)) {
                try {
                    bloodList(myClientBB.getBloodByType("AB-"));
                    totalText.setText(myClientBB.getBloodByType("AB-").getCount() + " Bags");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (abpType.isSelected() && e.getSource().equals(selectButton)) {
                try {
                    bloodList(myClientBB.getBloodByType("AB+"));
                    totalText.setText(myClientBB.getBloodByType("AB+").getCount() + " Bags");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (allType.isSelected() && e.getSource().equals(selectButton)) {
                try {
                    bloodList(myClientBB.getBlood());
                    totalText.setText(myClientBB.getBlood().getCount() + " Bags");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource().equals(removeBlood)) {
                try {
                    myClientBB.removeBlood(getBlood(idListArea.getAnchorSelectionIndex()).getBloodID() + "");
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
