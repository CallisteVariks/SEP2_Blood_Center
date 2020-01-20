package GUI.guibloodbank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class BBMenuPanel extends JPanel {

    private final JButton notificationButton;
    private MyButtonListener buttonListener;
    private JPanel mainPanel;
    private JPanel boxPanel;
    private JPanel headerPanel;
    private JPanel box2;

    private JPanel menuPanel;
    private JPanel downPanel;

    private JPanel buttonsPanel;
    private JPanel footerPanel;

    private JLabel headerLabel;

    private JButton donationButton;
    private JButton historyButton;
    private JButton bloodButton;
    private JButton staffButton;
    private JButton logOutButton;
    private JButton exitButton;

    private ImageIcon logoIcon;
    private JLabel logoLabel;
    private BBGUI bbGui;

    /**
     * One argument Constructor
     * @param bbgui {@link BBGUI}
     * @throws RemoteException {@link RemoteException} HI
     */
    public BBMenuPanel(BBGUI bbgui) throws RemoteException {
        this.bbGui = bbgui;

        buttonListener = new MyButtonListener();

        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));

        // The header
        headerPanel = new JPanel();
        headerLabel = new JLabel("Menu");
        Font headerFont = new Font(headerLabel.getFont().getFamily(), Font.PLAIN, 26);
        headerLabel.setFont(headerFont);
        headerPanel.add(headerLabel);
        headerPanel.setPreferredSize(new Dimension(1000, 140));

        // Create the mainPanel that contains all the information
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3, 30, 30));

        box2 = new JPanel();


        // Create the menuPanel
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(5, 1, 10, 10));

        Font menuFont = new Font(menuPanel.getFont().getFamily(), Font.PLAIN, 16);

        donationButton = new JButton("Donation");
        donationButton.setFont(menuFont);
        donationButton.addActionListener(buttonListener);

        historyButton = new JButton("History");
        historyButton.addActionListener(buttonListener);
        historyButton.setFont(menuFont);

        bloodButton = new JButton("Storage");
        bloodButton.addActionListener(buttonListener);
        bloodButton.setFont(menuFont);

        staffButton = new JButton("Staff");
        staffButton.addActionListener(buttonListener);
        staffButton.setFont(menuFont);

        notificationButton = new JButton("Notification");
        notificationButton.addActionListener(buttonListener);
        notificationButton.setFont(menuFont);

        menuPanel.add(donationButton);
        menuPanel.add(historyButton);
        menuPanel.add(bloodButton);
        menuPanel.add(staffButton);
        menuPanel.add(notificationButton);
        menuPanel.setPreferredSize(new Dimension(250, 270));


        box2.add(menuPanel);

        mainPanel.add(box2, BorderLayout.CENTER);


        downPanel = new JPanel();
        downPanel.setPreferredSize(new Dimension(100, 88));

        footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));


        buttonsPanel = new JPanel();
        logOutButton = new JButton("Log out");
        logOutButton.addActionListener(buttonListener);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(buttonListener);
        buttonsPanel.add(logOutButton);
        buttonsPanel.add(exitButton);


        logoIcon = new ImageIcon("img/blodbank.gif");
        logoLabel = new JLabel();
        logoLabel.setIcon(logoIcon);


        footerPanel.add(buttonsPanel, BorderLayout.NORTH);
        footerPanel.add(logoLabel, BorderLayout.SOUTH);


        boxPanel.add(headerPanel);
        boxPanel.add(mainPanel);
        boxPanel.add(downPanel);
        boxPanel.add(footerPanel);


        add(boxPanel);
        setSize(1200, 700);
        setVisible(true);

    }

    /**
     * Menu Implementing Class
     */
    private class MyButtonListener implements ActionListener {
        /**
         * Implementation of all the buttons
         * @param e ActionEvent
         */
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == donationButton) {
                bbGui.getTabPane().setSelectedIndex(2);
            }

            if (e.getSource() == historyButton) {
                bbGui.getTabPane().setSelectedIndex(3);
            }

            if (e.getSource() == bloodButton) {
                bbGui.getTabPane().setSelectedIndex(4);
            }

            if (e.getSource() == staffButton) {
                bbGui.getTabPane().setSelectedIndex(5);
            }

            if (e.getSource() == notificationButton) {
                bbGui.getTabPane().setSelectedIndex(6);
            }
            if (e.getSource() == logOutButton) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Do you really want to log out?", "Log out",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    bbGui.getTabPane().setSelectedIndex(0);
                    bbGui.getTabPane().setEnabledAt(0, true);
                    bbGui.getTabPane().setEnabledAt(1, false);
                    bbGui.getTabPane().setEnabledAt(2, false);
                    bbGui.getTabPane().setEnabledAt(3, false);
                    bbGui.getTabPane().setEnabledAt(4, false);
                    bbGui.getTabPane().setEnabledAt(5, false);
                    bbGui.getTabPane().setEnabledAt(6, false);

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
