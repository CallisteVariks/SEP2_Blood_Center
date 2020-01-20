package GUI.guibloodbank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class BBGUI extends JFrame {
    private JTabbedPane tabPane;

    private BBLogInPanel logInPanel;
    private BBMenuPanel menuPanel;
    private BBDonationPanel donationPanel;
    private BBHistoryPanel historyPanel;
    private BBBloodPanel bloodPanel;
    private BBStaffPanel staffPanel;
    private BBNotificationPanel notificationPanel;


    private MyButtonListener buttonListener;

    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu aboutMenu;

    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;


    /**
     * No-argument constructor initializing the GUI components
     */
    public BBGUI() throws RemoteException {
        super("Blodbank");
        buttonListener = new MyButtonListener();


        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(buttonListener);

        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(buttonListener);

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        aboutMenu = new JMenu("About");

        fileMenu.add(exitMenuItem);

        aboutMenu.add(aboutMenuItem);

        menuBar = new JMenuBar();

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);

        logInPanel = new BBLogInPanel(this);
        menuPanel = new BBMenuPanel(this);
        donationPanel = new BBDonationPanel();
        historyPanel = new BBHistoryPanel();
        bloodPanel = new BBBloodPanel();
        staffPanel = new BBStaffPanel();
        notificationPanel = new BBNotificationPanel();


        tabPane = new JTabbedPane();

        tabPane.addTab("LogIn", logInPanel);
        tabPane.addTab("Menu", menuPanel);
        tabPane.addTab("Donation", donationPanel);
        tabPane.addTab("History", historyPanel);
        tabPane.addTab("Storage", bloodPanel);
        tabPane.addTab("Staff", staffPanel);
        tabPane.addTab("Notifications", notificationPanel);

        add(tabPane);
        setSize(1200, 700);
        setVisible(true);
        setResizable(false);
        tabPane.setEnabledAt(1, false);
        tabPane.setEnabledAt(2, false);
        tabPane.setEnabledAt(3, false);
        tabPane.setEnabledAt(4, false);
        tabPane.setEnabledAt(5, false);
        tabPane.setEnabledAt(6, false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Inner action listener class
     *
     * @author Group One
     */
    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitMenuItem) {
                int choice = JOptionPane.showConfirmDialog(null,
                        "Do you really want to exit the program?", "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            if (e.getSource() == aboutMenuItem) {
                JOptionPane.showMessageDialog(null,
                        "LALALALA", "About",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public JTabbedPane getTabPane() {
        return tabPane;
    }

    public static void main(String[] args) throws RemoteException {
        BBGUI GUI = new BBGUI();
    }

}