package GUI.guihospital;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class HGUI extends JFrame {
    public JTabbedPane tabPane;

    private HLogInPanel logInPanel;
    private HBloodPanel bloodPanel;
    private HStaffPanel staffPanel;

    private MyButtonListener buttonListener;

    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu aboutMenu;

    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;

    private JCheckBoxMenuItem editRentFieldsMenuItem;
    private JCheckBoxMenuItem editReturnFieldsMenuItem;


    /**
     * No-argument constructor initializing the GUI components
     */
    public HGUI() throws RemoteException {
        super("Hospital");
        buttonListener = new MyButtonListener();

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(buttonListener);

        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(buttonListener);

        editRentFieldsMenuItem = new JCheckBoxMenuItem("Edit rent fiels", false);
        editRentFieldsMenuItem.addActionListener(buttonListener);

        editReturnFieldsMenuItem = new JCheckBoxMenuItem("Edit return fields",
                false);
        editReturnFieldsMenuItem.addActionListener(buttonListener);

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        aboutMenu = new JMenu("About");

        fileMenu.add(exitMenuItem);

        editMenu.add(editRentFieldsMenuItem);
        editMenu.add(editReturnFieldsMenuItem);

        aboutMenu.add(aboutMenuItem);

        menuBar = new JMenuBar();

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);

        logInPanel = new HLogInPanel(this);
        bloodPanel = new HBloodPanel(this);
        staffPanel = new HStaffPanel(this);


        tabPane = new JTabbedPane();

        tabPane.addTab("LogIn", logInPanel);
        tabPane.addTab("Storage", bloodPanel);
        tabPane.addTab("Staff", staffPanel);


        add(tabPane);
        setSize(1200, 700);
        setVisible(true);
        setResizable(false);
        tabPane.setEnabledAt(1, false);
        tabPane.setEnabledAt(2, false);

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

            if (e.getSource() == editRentFieldsMenuItem) {
                if (editRentFieldsMenuItem.isSelected()) {
                } else {
                }
            }

            if (e.getSource() == editReturnFieldsMenuItem) {
                if (editReturnFieldsMenuItem.isSelected()) {

                } else {

                }
            }

            if (e.getSource() == aboutMenuItem) {
                JOptionPane.showMessageDialog(null,
                        "LALALALA", "About",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    /**
     * gets the TabPane
     * @return JTabbedPane
     */
    public JTabbedPane getTabPane() {
        return tabPane;
    }

    public static void main(String[] args) throws RemoteException {
        HGUI GUI = new HGUI();
    }

}