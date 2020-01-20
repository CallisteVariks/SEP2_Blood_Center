package GUI.guibloodbank;

import RMI.MyClientBB;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;

import static java.lang.Integer.parseInt;

public class BBLogInPanel extends JPanel {
    private MyButtonListener buttonListener;
    private JPanel boxPanel;
    private JPanel headerPanel;
    private JPanel box1;
    private JPanel box2;
    private JPanel box3;

    private JPanel mainPanel;

    private JPanel leftPanel;
    private JPanel loginPanel;
    private JPanel updatePanel;

    private JPanel downPanel;
    private JPanel footerPanel;
    private JPanel buttonsPanel;

    private JLabel userLabel;
    private JLabel passLabel;

    private JTextField userField;
    private JTextField passField;

    private JButton logInButton;
    private JButton exitButton;


    private ImageIcon logoIcon;
    private JLabel logoLabel;
    private MyClientBB myClientBB;
    private BBGUI bbGui;

    /**
     * One Argument constructor
     * @param bbgui {@link BBGUI}
     * @throws RemoteException {@link RemoteException} HI
     */
    public BBLogInPanel(BBGUI bbgui) throws RemoteException {
        buttonListener = new MyButtonListener();
        myClientBB = new MyClientBB();
        this.bbGui = bbgui;

        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

        // The header
        headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(100, 200));

        // Create the mainPanel that contains all the information
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3, 30, 30));

        // Create the first column of the GUI
        box1 = new JPanel();

        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        box1.add(leftPanel);


        // Create the second column of the GUI
        box2 = new JPanel();
        box2.setBorder(new TitledBorder("LOG IN"));


        //Create the loginPanel
        loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        userLabel = new JLabel("User: ");
        userField = new JTextField(20);

        passLabel = new JLabel("Password: ");
        passField = new JTextField(20);

        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);

        box2.add(loginPanel, BorderLayout.NORTH);
        box2.add(leftPanel, BorderLayout.SOUTH);


        box3 = new JPanel();

        updatePanel = new JPanel();
        updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.Y_AXIS));


        mainPanel.add(box1, BorderLayout.WEST);
        mainPanel.add(box2, BorderLayout.CENTER);
        mainPanel.add(box3, BorderLayout.EAST);

        downPanel = new JPanel();
        downPanel.setPreferredSize(new Dimension(100, 203));

        footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        buttonsPanel = new JPanel();
        logInButton = new JButton("Log in");
        logInButton.addActionListener(buttonListener);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(buttonListener);
        buttonsPanel.add(logInButton);
        buttonsPanel.add(exitButton);

        logoIcon = new ImageIcon("img/blodbank.gif");
        logoLabel = new JLabel();
        logoLabel.setIcon(logoIcon);


        footerPanel.add(buttonsPanel, BorderLayout.NORTH);
        footerPanel.add(logoLabel, BorderLayout.SOUTH);
        footerPanel.setPreferredSize(new Dimension(1000, 215));

        boxPanel.add(headerPanel);
        boxPanel.add(mainPanel);
        boxPanel.add(downPanel);
        boxPanel.add(footerPanel);

        add(boxPanel);
        setSize(1200, 700);
        setVisible(true);

      /*
       * Reading information from the keyboard using the enter button. 
       * Checking if the keycode exists in the database.
       */
        KeyListener listener = new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        if (myClientBB.checkBBLogin(parseInt(userField.getText()), passField.getText())) {
                            bbGui.getTabPane().setSelectedIndex(1);
                            bbGui.getTabPane().setEnabledAt(0, false);
                            bbGui.getTabPane().setEnabledAt(1, true);
                            bbGui.getTabPane().setEnabledAt(2, true);
                        }
                    } catch (NumberFormatException f) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter user as an integer", "Warning message",
                                JOptionPane.WARNING_MESSAGE);
                    } catch (RemoteException e1) {
                        e1.printStackTrace();
                    }
                    //Pop Up when the user doesn't Exist
                    userField.setText("");
                    passField.setText("");
                }
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        };
        userField.addKeyListener(listener);
    }

    /**
     * Nested private Class
     */
        private class MyButtonListener implements ActionListener {
        /**
         * Implements all the buttons
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == logInButton) {
                    if (e.getSource() == logInButton) {
                        try {
                            if (myClientBB.checkBBLogin(parseInt(userField.getText()), passField.getText())) {
                                bbGui.getTabPane().setSelectedIndex(1);
                                bbGui.getTabPane().setEnabledAt(0, false);
                                bbGui.getTabPane().setEnabledAt(1, true);
                                bbGui.getTabPane().setEnabledAt(2, true);
                                bbGui.getTabPane().setEnabledAt(3, true);
                                bbGui.getTabPane().setEnabledAt(4, true);
                                bbGui.getTabPane().setEnabledAt(5, true);
                                bbGui.getTabPane().setEnabledAt(6, true);
                            }
                        } catch (RemoteException e1) {
                            e1.printStackTrace();
                        }
                        userField.setText("");
                        passField.setText("");
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
