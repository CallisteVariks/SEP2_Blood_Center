package GUI.guibloodbank;

import MC.Blood;
import MC.MsgList;
import RMI.MyClientBB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import static java.lang.Integer.parseInt;

public class BBNotificationPanel extends JPanel {

    private final JTextField amountText;
    private final JPanel amountPanel;
    private JLabel amountLabel;
    private Button listenner;

    private JPanel boxPanel;
    private JPanel headerPanel;
    private JPanel radioPanel;

    private JPanel scrollPanel;
    private JPanel footerPanel;

    private JLabel headerLabel;

    private ButtonGroup bg;
    private JRadioButton requestType;
    private JRadioButton notifyType;

    private JScrollPane smallScrollPane;
    private DefaultListModel<String> smallListModel;
    private JList smallListArea;

    private JScrollPane bigScrollPane;
    private DefaultListModel bigListModel;
    private JList bigListArea;

    private ImageIcon logoIcon;
    private JLabel logoLabel;
    private JButton selectButton;
    private JButton updateButton;
    private JButton sendButton;
    private MyClientBB myClientBB;

    /**
     * Zero argument constructor
     * @throws RemoteException {@link RemoteException}
     */
    public BBNotificationPanel() throws RemoteException {
        listenner = new Button();
        myClientBB = new MyClientBB();
        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

        //The header
        headerPanel = new JPanel();
        headerLabel = new JLabel("Notification");
        Font headerFont = new Font(headerLabel.getFont().getFamily(), Font.PLAIN,
                26);
        headerLabel.setFont(headerFont);
        headerPanel.add(headerLabel);
        headerPanel.setPreferredSize(new Dimension(1000, 90));

        //Create the radio panel
        radioPanel = new JPanel();
        amountPanel = new JPanel();
        bg = new ButtonGroup();
        selectButton = new JButton("Select");
        selectButton.addActionListener(listenner);
        updateButton = new JButton("Show Message");
        updateButton.addActionListener(listenner);
        sendButton = new JButton("Send Blood");
        sendButton.addActionListener(listenner);
        amountText = new JTextField(5);
        amountLabel = new JLabel("Amount: ");
        requestType = new JRadioButton("Requests");
        amountPanel.setLayout(new GridLayout(1, 2));
        amountPanel.add(amountLabel);
        amountPanel.add(amountText);
        notifyType = new JRadioButton("Notifications");

        bg.add(requestType);
        bg.add(notifyType);

        radioPanel.add(requestType);
        radioPanel.add(notifyType);
        radioPanel.add(selectButton);
        radioPanel.add(updateButton);
        radioPanel.add(amountPanel);
        radioPanel.add(sendButton);
        radioPanel.setLayout(new GridLayout(6, 1, 10, 10));
        radioPanel.setPreferredSize(new Dimension(150, 200));


        //Create the scroll bar which will display few information
        smallListModel = new DefaultListModel<>();
        smallListArea = new JList<>(smallListModel);
        smallListArea.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        smallListArea.setVisibleRowCount(10);
        smallScrollPane = new JScrollPane(smallListArea);
        smallScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        smallScrollPane.setPreferredSize(new Dimension(275, 408));

        //Create the big scroll bar which will display all the information
        bigListModel = new DefaultListModel<Object>();
        bigListArea = new JList<Object>(bigListModel);
        bigListArea.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        bigListArea.setVisibleRowCount(10);
        bigScrollPane = new JScrollPane(bigListArea);
        bigScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        bigScrollPane.setPreferredSize(new Dimension(555, 408));

        scrollPanel = new JPanel();
        scrollPanel.add(radioPanel, BorderLayout.WEST);
        scrollPanel.add(smallScrollPane, BorderLayout.WEST);
        scrollPanel.add(bigScrollPane, BorderLayout.EAST);


        //Create the footer panel
        footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));


        //Create the logo
        logoIcon = new ImageIcon("img/blodbank.gif");
        logoLabel = new JLabel();
        logoLabel.setIcon(logoIcon);

        footerPanel.add(logoLabel);

        boxPanel.add(headerPanel);
        boxPanel.add(scrollPanel);
        boxPanel.add(footerPanel);

        add(boxPanel);
        setSize(1200, 700);
        setVisible(true);
    }

    /**
     * Adds a the a msg from the list to the listModel (Request message)
     * @param list {@link MsgList}
     * @throws RemoteException {@link RemoteException} HI
     */
    public void addRequestMsgToList(MsgList list) throws RemoteException {
        smallListModel.removeAllElements();
        for (int i = 0; i < list.rqCount(); i++) {
            smallListModel.addElement(list.getMsg(i).smallString());
        }
        smallListArea.setModel(smallListModel);
    }

    /**
     * Adds a the a msg from the list to the listModel(Notification Message)
     * @param list {@link MsgList}
     * @throws RemoteException {@link RemoteException} HI
     */
    public void addNotificationMsgToList(MsgList list) throws RemoteException {
        smallListModel.removeAllElements();
        for (int i = 0; i < list.ntCount(); i++) {
            smallListModel.addElement(list.getNotificationMsg(i).smallString());
        }
        smallListArea.setModel(smallListModel);
    }

    /**
     * Gets Blood at the specified index given as a parameter
     * @param index int
     * @return Blood at the index
     * @throws RemoteException {@link RemoteException}
     */
    public Blood getBlood(int index) throws RemoteException {
        return myClientBB.getBlood().getBlood(index);
    }

    /**
     * private Nested class
     */
    private class Button implements ActionListener {
        /**
         * implementation of the buttons
         * @param e ActionEvent HI
         */
        public void actionPerformed(ActionEvent e) {
            if (requestType.isSelected() && e.getSource() == selectButton) {
                try {
                    addRequestMsgToList(myClientBB.getRequestMsg());
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (notifyType.isSelected() && e.getSource() == selectButton) {
                try {
                    addNotificationMsgToList(myClientBB.getNotificationMsg());
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
            if (e.getSource() == sendButton) {
                try {
                    myClientBB.transferBlood(getBlood(smallListArea.getAnchorSelectionIndex()).getBloodType()
                            + "",parseInt(amountText.getText()));
                } catch (RemoteException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
