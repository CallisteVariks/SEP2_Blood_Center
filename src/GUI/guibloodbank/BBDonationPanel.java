package GUI.guibloodbank;

import MC.Donor;
import RMI.MyClientBB;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class BBDonationPanel extends JPanel {
    private final JPanel sndPanel;
    private final JPanel comboxPanel;
    private final JLabel fname2Label;
    private JLabel lname2Label;
    private JLabel age2Label;
    private JLabel address2Label;
    private JLabel phone2Label;
    private JLabel email2Label;
    private JLabel bloodtype2Label;
    private JLabel bloodcenter2Label;
    private JLabel date2Label;


    private JTextField fname2Text;
    private JTextField lname2Text;
    private JTextField age2Text;
    private JTextField address2Text;
    private JTextField phone2Text;
    private JTextField email2Text;
    private JTextField bloodtype2Text;
    private JTextField bloodcenter2Text;
    private MyButtonListener buttonListener;

    private JPanel boxPanel;
    private JPanel box1Panel;
    private JPanel box2Panel;
    private JPanel upPanel;
    private JPanel radioPanel;
    private JPanel headerPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel mainPanel;
    private JPanel footerPanel;
    private JPanel buttonsPanel;

    private JLabel headerLabel;
    private JLabel cprLabel;
    private JLabel idLabel;
    private JLabel id2Label;
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JLabel ageLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel bloodtypeLabel;
    private JLabel bloodcenterLabel;
    private JLabel dateLabel;

    private JTextField cprText;
    private JTextField idText;
    private JTextField fnameText;
    private JTextField lnameText;
    private JTextField ageText;
    private JTextField addressText;
    private JTextField phoneText;
    private JTextField emailText;
    private JTextField bloodtypeText;
    private JComboBox<String> bloodcenterBox;

    private JButton donateButton;
    private JButton exitButton;
    private JRadioButton user1;
    private JRadioButton user2;
    private ButtonGroup usergroup;

    private JPanel radio2Panel;
    private ButtonGroup bg;
    public JRadioButton idType;
    public JRadioButton cprType;
    private JPanel idPanel;
    private JPanel cprPanel;
    public JTextField id2Text;
    public JTextField cpr2Text;

    private ImageIcon logoIcon;
    private JLabel logoLabel;
    private MyClientBB myClientBb;
    private DateFormat dateFormat;
    private Date date;
    private java.sql.Date sqlDate;

    /**
     * Zero argument Constructor
     *
     * @throws RemoteException
     */
    public BBDonationPanel() throws RemoteException {
        buttonListener = new MyButtonListener();
        myClientBb = new MyClientBB();

        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

        //Header
        upPanel = new JPanel();
        headerPanel = new JPanel();
        headerLabel = new JLabel("Donate now");
        Font headerFont = new Font(headerLabel.getFont().getFamily(), Font.PLAIN, 26);
        headerLabel.setFont(headerFont);
        headerPanel.add(headerLabel);


        user1 = new JRadioButton("New user");
        user1.addActionListener(buttonListener);
        user2 = new JRadioButton("Already existing");
        user2.addActionListener(buttonListener);
        usergroup = new ButtonGroup();
        usergroup.add(user1);
        usergroup.add(user2);

        radioPanel = new JPanel();
        radioPanel.add(user1);
        radioPanel.add(user2);

        upPanel.add(headerPanel, BorderLayout.NORTH);
        upPanel.add(radioPanel, BorderLayout.SOUTH);
        upPanel.setLayout(new BoxLayout(upPanel, BoxLayout.Y_AXIS));


        //Create the main panel of the GUI for donation 
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2, 50, 50));

        //Create the mainPanel that contains the text fields for new donors
        leftPanel = new JPanel();
        leftPanel.setBorder(new TitledBorder("New donor"));

        box1Panel = new JPanel();
        box1Panel.setLayout(new BoxLayout(box1Panel, BoxLayout.Y_AXIS));

        fnameLabel = new JLabel("First name: ");
        fnameText = new JTextField(25);
        fnameText.setEditable(false);

        lnameLabel = new JLabel("Last name: ");
        lnameText = new JTextField(25);
        lnameText.setEditable(false);

        cprLabel = new JLabel("CPR: ");
        cprText = new JTextField(25);
        cprText.setEditable(false);

        ageLabel = new JLabel("Age: ");
        ageText = new JTextField(25);
        ageText.setEditable(false);

        addressLabel = new JLabel("Address: ");
        addressText = new JTextField(25);
        addressText.setEditable(false);

        phoneLabel = new JLabel("Phone: ");
        phoneText = new JTextField(25);
        phoneText.setEditable(false);

        emailLabel = new JLabel("Email: ");
        emailText = new JTextField(25);
        emailText.setEditable(false);

        bloodtypeLabel = new JLabel("Blood type: ");
        bloodtypeText = new JTextField(25);
        bloodtypeText.setEditable(false);

        comboxPanel = new JPanel();
        bloodcenterLabel = new JLabel("Blood center: ");
        bloodcenterBox = new JComboBox<>(myClientBb.getBloodCenters());
        bloodcenterBox.setEditable(false);
        bloodcenterBox.setEnabled(true);
        comboxPanel.add(bloodcenterBox);
        comboxPanel.setLayout(new GridLayout(1, 1, 2, 2));

        dateFormat = new SimpleDateFormat("dd/MM/yyy");
        date = new Date();
        sqlDate = new java.sql.Date(date.getTime());
        dateLabel = new JLabel("Date: " + dateFormat.format(date));

        idLabel = new JLabel("ID: ");
        idText = new JTextField(25);
        idText.setEditable(false);

        box1Panel.add(fnameLabel);
        box1Panel.add(fnameText);
        box1Panel.add(lnameLabel);
        box1Panel.add(lnameText);
        box1Panel.add(cprLabel);
        box1Panel.add(cprText);
        box1Panel.add(ageLabel);
        box1Panel.add(ageText);
        box1Panel.add(addressLabel);
        box1Panel.add(addressText);
        box1Panel.add(phoneLabel);
        box1Panel.add(phoneText);
        box1Panel.add(emailLabel);
        box1Panel.add(emailText);
        box1Panel.add(bloodtypeLabel);
        box1Panel.add(bloodtypeText);
        box1Panel.add(bloodcenterLabel);
        box1Panel.add(comboxPanel);
        box1Panel.add(dateLabel);
        box1Panel.add(idLabel);
        box1Panel.add(idText);

        leftPanel.add(box1Panel);
        box1Panel.setLayout(new GridLayout(21, 1));
        box1Panel.setPreferredSize(new Dimension(300, 397));

        //Create the second column of the GUI for already existent donors        
        rightPanel = new JPanel();
        rightPanel.setBorder(new TitledBorder("Already existent"));

        box2Panel = new JPanel();

        idPanel = new JPanel();
        idType = new JRadioButton("ID:     ");
        idType.addActionListener(buttonListener);
        id2Text = new JTextField(25);
        id2Text.setEditable(false);
        idPanel.add(idType);
        idPanel.add(id2Text);
        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));

        cprPanel = new JPanel();
        cprType = new JRadioButton("CPR: ");
        cprType.addActionListener(buttonListener);
        cpr2Text = new JTextField(25);
        cpr2Text.setEditable(false);
        cprPanel.add(cprType);
        cprPanel.add(cpr2Text);
        cprPanel.setLayout(new BoxLayout(cprPanel, BoxLayout.X_AXIS));

        bg = new ButtonGroup();
        bg.add(idType);
        bg.add(cprType);

        radio2Panel = new JPanel();
        radio2Panel.add(idPanel);
        radio2Panel.add(cprPanel);

        fname2Label = new JLabel("First name: ");
        fname2Text = new JTextField(25);
        fname2Text.setEditable(false);

        lname2Label = new JLabel("Last name: ");
        lname2Text = new JTextField(25);
        lname2Text.setEditable(false);

        age2Label = new JLabel("Age: ");
        age2Text = new JTextField(25);
        age2Text.setEditable(false);

        address2Label = new JLabel("Address: ");
        address2Text = new JTextField(25);
        address2Text.setEditable(false);

        phone2Label = new JLabel("Phone: ");
        phone2Text = new JTextField(25);
        phone2Text.setEditable(false);

        email2Label = new JLabel("Email: ");
        email2Text = new JTextField(25);
        email2Text.setEditable(false);

        bloodtype2Label = new JLabel("Blood type: ");
        bloodtype2Text = new JTextField(25);
        bloodtype2Text.setEditable(false);

        bloodcenter2Label = new JLabel("Blood center: ");
        bloodcenter2Text = new JTextField(25);
        bloodcenter2Text.setEditable(false);

        date2Label = new JLabel("Date: " + dateFormat.format(date));

        sndPanel = new JPanel();

        sndPanel.add(fname2Label);
        sndPanel.add(fname2Text);
        sndPanel.add(lname2Label);
        sndPanel.add(lname2Text);
        sndPanel.add(age2Label);
        sndPanel.add(age2Text);
        sndPanel.add(address2Label);
        sndPanel.add(address2Text);
        sndPanel.add(phone2Label);
        sndPanel.add(phone2Text);
        sndPanel.add(email2Label);
        sndPanel.add(email2Text);
        sndPanel.add(bloodtype2Label);
        sndPanel.add(bloodtype2Text);
        sndPanel.add(bloodcenter2Label);
        sndPanel.add(bloodcenter2Text);
        sndPanel.add(date2Label);

        sndPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        sndPanel.setLayout(new GridLayout(17, 1));


        radio2Panel.setLayout(new GridLayout(2, 2, 5, 5));

        box2Panel.add(radio2Panel);
        box2Panel.add(sndPanel);

        box2Panel.setLayout(new GridLayout(2, 1, 2, 2));
        box2Panel.setLayout(new BoxLayout(box2Panel, BoxLayout.Y_AXIS));
        rightPanel.add(box2Panel);


        //Add columns to the mainPanel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        //Create the footerPanel and the buttons
        footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        footerPanel.setPreferredSize(new Dimension(1000, 400));

        buttonsPanel = new JPanel();
        donateButton = new JButton("Donate");
        donateButton.addActionListener(buttonListener);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(buttonListener);
        buttonsPanel.add(donateButton);
        buttonsPanel.add(exitButton);

        logoIcon = new ImageIcon("img/blodbank.gif");
        logoLabel = new JLabel();
        logoLabel.setIcon(logoIcon);

        footerPanel.add(buttonsPanel, BorderLayout.NORTH);
        footerPanel.add(logoLabel, BorderLayout.SOUTH);

        //Add all the panels to the boxPanel
        boxPanel.add(upPanel);
        boxPanel.add(mainPanel);
        boxPanel.add(footerPanel);
        add(boxPanel);

        setSize(1200, 700);
        setVisible(true);

        KeyListener listener = new KeyListener() {
            /**
             * KeyBoard pressing method
             * @param e KeyEvent
             */
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        if (myClientBb.searchIDByBoolean(parseInt(id2Text.getText())) && idType.isSelected()) {
                            Donor donor = myClientBb.getDonorById(parseInt(id2Text.getText()));

                            System.out.println(donor.realToString());
                            idText.setText(donor.getiD() + "");
                            cprText.setText(donor.getCpr());
                            fnameText.setText(donor.getfName());
                            lnameText.setText(donor.getlName());
                            ageText.setText(donor.getAge() + "");
                            addressText.setText(donor.getAddress());
                            phoneText.setText(donor.getPhone() + "");
                            emailText.setText(donor.getEmail());
                            bloodtypeText.setText(donor.getBloodType());

                            //BBDonationConfirm confirm = new BBDonationConfirm();
                        } else if (idType.isSelected()) {
                            JOptionPane.showMessageDialog(null,
                                    "ID does not exist!", "Warning message",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                        if (myClientBb.searchCprByBoolean(cpr2Text.getText()) && cprType.isSelected()) {
                            Donor donor = myClientBb.getDonorByCpr(cpr2Text.getText());

                            System.out.println(donor.realToString());
                            id2Text.setText(donor.getiD() + "");
                            cpr2Text.setText(donor.getCpr());
                            fname2Text.setText(donor.getfName());
                            lname2Text.setText(donor.getlName());
                            age2Text.setText(donor.getAge() + "");
                            address2Text.setText(donor.getAddress());
                            phone2Text.setText(donor.getPhone() + "");
                            email2Text.setText(donor.getEmail());

                        } else if (cprType.isSelected()) {
                            JOptionPane.showMessageDialog(null,
                                    "CPR does not exist!", "Warning message",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException f) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter reservation number as an integer",
                                "Warning message", JOptionPane.WARNING_MESSAGE);
                    } catch (RemoteException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        };
        id2Text.addKeyListener(listener);
        cpr2Text.addKeyListener(listener);
    }


    /**
     * Nested private class
     */
    private class MyButtonListener implements ActionListener {
        /**
         * Implementation of every button on the Tab
         *
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            if (user1.isSelected()) {
                fnameText.setEditable(true);
                lnameText.setEditable(true);
                cprText.setEditable(true);
                ageText.setEditable(true);
                addressText.setEditable(true);
                phoneText.setEditable(true);
                emailText.setEditable(true);
                bloodtypeText.setEditable(true);
                bloodcenterBox.setEnabled(true);
                bg.clearSelection();


            } else {
                fnameText.setEditable(false);
                lnameText.setEditable(false);
                cprText.setEditable(false);
                ageText.setEditable(false);
                addressText.setEditable(false);
                phoneText.setEditable(false);
                emailText.setEditable(false);
                bloodcenterBox.setEditable(false);
            }

            if (user2.isSelected()) {
                id2Text.setEditable(true);
            } else {
                id2Text.setEditable(false);
            }

            if (idType.isSelected()) {
                id2Text.setEditable(true);
            } else {
                id2Text.setEditable(false);
            }

            if (cprType.isSelected()) {
                cpr2Text.setEditable(true);
            } else {
                cpr2Text.setEditable(false);
            }

            if (e.getSource() == donateButton) {
                if (user1.isSelected()) {
                    try {
                        myClientBb.addDonor(fnameText.getText(), lnameText.getText(), cprText.getText(), parseInt(ageText.getText()),
                                addressText.getText(), parseInt(phoneText.getText()), emailText.getText(), bloodtypeText.getText(),
                                (String) bloodcenterBox.getSelectedItem(), sqlDate);
                        fnameText.setText("");
                        lnameText.setText("");
                        cprText.setText("");
                        ageText.setText("");
                        addressText.setText("");
                        phoneText.setText("");
                        emailText.setText("");
                        bloodtypeText.setText("");
                    } catch (RemoteException e1) {
                        e1.printStackTrace();
                    }
                }
                try {
                    idText.setText(myClientBb.searchByCPR(cprText.getText()) + "");
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
