package RMI;

import MC.*;
import Singleton.SingletonRegistry;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Ghost on 30/11/2016.
 */

public class MyServer extends UnicastRemoteObject implements ServerInterface,
        Serializable {

    private Connections connections;
    private MsgList msgList;

    protected MyServer() throws RemoteException {
        connections = new Connections();
        msgList = new MsgList();
    }

    public static void main(String args[]) {
        try {
            Registry registry = SingletonRegistry.getInstance().getRegistry();
            ServerInterface rmiServer = new MyServer();
            Naming.rebind("BBank", rmiServer);
            System.err.println("Server Ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    /**
     * @return returns a list type DonorList filed with element type Donor from
     * the database
     */
    @Override
    public DonorList getAllDonors() throws RemoteException {
        return connections.getDonors();
    }

    /**
     * @return an ArrayList<String> with bloodCenters (Location) from the
     * database
     */
    @Override
    public ArrayList<String> getBloodLocations() throws RemoteException {
        return connections.getBloodCenters();
    }

    /**
     * Gets the staff from the Hospitals, as a list
     *
     * @return HpStaffList
     */
    @Override
    public HpStaffList getAllHospStaff() throws RemoteException {
        return connections.getHospitalStaff();
    }

    /**
     * Gets a list filled with an HpStaff object with the id as a parameter
     *
     * @param id int
     * @return HpStaffList
     */
    @Override
    public HpStaffList getHospitalStaffByID(int id) throws RemoteException {
        return connections.getHospitalStaffByID(id);
    }

    /**
     * Gets a list filled with an HpStaff object with the cpr as a parameter
     *
     * @param cpr int
     * @return HpStaffList
     */
    @Override
    public HpStaffList getHospitalStaffByCPR(int cpr) throws RemoteException {
        return connections.getHospitalStaffByCPR(cpr);
    }

    /**
     * gets all blood from the bloodCenter
     *
     * @return BloodList
     */
    @Override
    public BloodList getAllBlood() throws RemoteException {
        return connections.getBlood();
    }

    /**
     * gets all blood from the hospital
     *
     * @return BloodList
     */
    @Override
    public BloodList getAllBloodHpTable() throws RemoteException {
        return connections.getBloodHpTable();
    }

    /**
     * Gets a list filled with Blood objects of that type, from the bloodCenter
     *
     * @param type String
     * @return BloodList
     */
    @Override
    public BloodList getAllBloodByType(String type) throws RemoteException {
        return connections.getBloodByType(type);
    }

    /**
     * Gets a list filled with Blood objects of that type, from the Hospital
     *
     * @param type String
     * @return BloodList
     */
    @Override
    public BloodList getAllBloodByTypeHpTable(String type)
            throws RemoteException {
        return connections.getBloodByTypeHpTable(type);
    }

    /**
     * uses the cpr to return the matching id
     *
     * @param cpr String
     * @return int
     */
    @Override
    public int searchCPR(String cpr) throws RemoteException {
        return connections.searchCPR(cpr);
    }

    /**
     * returns true if the id exist on the table
     *
     * @param id int
     * @return boolean
     */
    @Override
    public boolean searchIDByBoolean(int id) {
        return connections.searchIdBoolean(id);
    }

    /**
     * Gets donor from the database with a certain Id, as a list
     *
     * @param id int
     * @return DonorList
     */
    @Override
    public DonorList getDonorsById(int id) throws RemoteException {
        return connections.getDonorsById(id);
    }

    /**
     * Gets donor from the database with a certain cpr, as a list
     *
     * @param cpr String4
     * @return DonorList
     */
    @Override
    public DonorList getDonorsByCpr(String cpr) throws RemoteException {
        return connections.getDonorsByCpr(cpr);
    }

    /**
     * Returns a donor according to the parameter
     *
     * @param cpr String
     * @return Donor
     */
    @Override
    public Donor getDonorByCpr(String cpr) {
        return connections.getDonorByCpr(cpr);
    }

    /**
     * Returns a donor according to the parameter
     *
     * @param id int
     * @return Donor
     */
    @Override
    public Donor getDonorById(int id) {
        return connections.getDonorById(id);
    }

    /**
     * returns true if the cpr exist on the table
     *
     * @param cpr String
     * @return boolean
     */
    @Override
    public boolean searchCPRByBoolean(String cpr) throws RemoteException {
        return connections.searchCPRBoolean(cpr);
    }

    /**
     * Adds a donor to the database and makes a blood donation
     *
     * @param fName     String
     * @param lName     String
     * @param cpr       String
     * @param age       int
     * @param address   String
     * @param phoneno   int
     * @param email     String
     * @param bloodType String
     * @param location  String
     * @param date      Date
     * @throws RemoteException {@link RemoteException} HI
     */
    @Override
    public void addDonor(String fName, String lName, String cpr, int age,
                         String address, int phoneno, String email, String bloodType,
                         String location, Date date) throws RemoteException {

        connections.addDonor(fName, lName, cpr, age, address, phoneno, email,
                bloodType, location, date);
    }

    /**
     * returns true if both username a and password matches the ones from the
     * database
     *
     * @param user int
     * @param pass String
     * @return boolean
     * @throws RemoteException {@link RemoteException} HI
     */
    @Override
    public boolean checkHospLogin(int user, String pass) throws RemoteException {
        return connections.checkLoginCredentialsHP(user, pass);
    }

    /**
     * returns true if both username a and password matches the ones from the
     * database
     *
     * @param user int
     * @param pass String
     * @return boolean
     */
    @Override
    public boolean checkBBLogin(int user, String pass) throws RemoteException {
        return connections.checkLoginCredentialsBB(user, pass);
    }

    /**
     * Removes blood from the hospital table
     *
     * @param id String
     */
    @Override
    public void removeBlood2(String id) throws RemoteException {
        connections.removeBloodHpTable(id);
    }

    /**
     * Removes blood from the hospital table
     *
     * @param id String
     */
    @Override
    public void removeBlood(String id) throws RemoteException {
        connections.removeBloodBB(id);
    }

    /**
     * Moves the blood from the bloodCenter to the hospital and deletes the
     * blood from the bloodcenter
     *
     * @param bloodType String
     * @param amount    int
     */
    @Override
    public void transferBlood(String bloodType, int amount)
            throws RemoteException {
        System.out.println("Hello World");
        connections.transferBlood(bloodType, amount);
    }

    /**
     * Gets all the staff from the bloodCenter
     *
     * @return BBStaffList
     */
    @Override
    public BBStaffList getAllBbStaff() throws RemoteException {
        return connections.getBloodCenterStaff();
    }

    /**
     * Gets the staff from the bloodCenter with the id, as a list
     *
     * @param id int
     * @return BBStaffList
     */
    @Override
    public BBStaffList getBBStaffByID(int id) throws RemoteException {
        return connections.getBBStaffById(id);
    }

    /**
     * Gets the staff from the bloodCenter with the cpr, as a list
     *
     * @param cpr String
     * @return BBStaffList
     */
    @Override
    public BBStaffList getBBStaffByCPR(String cpr) throws RemoteException {
        return connections.getBBStaffByCPR(cpr);
    }

    /**
     * Adds a msg element to the arrayList
     *
     * @param msg type RequestMsg
     */
    @Override
    public void saveRequestMsg(RequestMsg msg) throws RemoteException {
        msgList.addRequestMsg(msg);
    }

    /**
     * gets allRequestedMsgs
     *
     * @return list with AllRequestedMsgs
     */

    @Override
    public MsgList getRequestMsgs() throws RemoteException {
        return msgList.getAllRequestMsgs();
    }

    /**
     * Adds a msg element to the arrayList
     *
     * @param msg type Notifications
     */
    @Override
    public void saveNotificationMsg(Notifications msg) throws RemoteException {
        msgList.addMsg(msg);
    }

    /**
     * gets allNotificationMsgs
     *
     * @return list with allNotificationMsgs
     */
    @Override
    public MsgList getNotificationMsgs() {
        return msgList.getAllNotificationMsgs();
    }
}
