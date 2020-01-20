package RMI;

import MC.*;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ghost on 08/12/2016.
 */
public class MyClientBB implements Serializable {

    private ServerInterface serverInterface;

    /**
     * Zero argument constructor
     *
     * @throws RemoteException {@link RemoteException} HI
     */
    public MyClientBB() throws RemoteException {
        super();
        try {
            serverInterface = (ServerInterface) Naming.lookup("rmi://localhost:1099/BBank");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the id from the Donor, using the cpr
     *
     * @param cpr String
     * @return int Donor id
     * @throws RemoteException
     */
    public int searchByCPR(String cpr) throws RemoteException {
        return serverInterface.searchCPR(cpr);
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
    public void addDonor(String fName, String lName, String cpr, int age, String address, int phoneno,
                         String email, String bloodType, String location, Date date) throws RemoteException {

        serverInterface.addDonor(fName, lName, cpr, age, address, phoneno, email, bloodType, location, date);
    }

    /**
     * @return returns a list type DonorList filed with element type Donor from the database
     * @throws RemoteException {@link RemoteException} HI
     */
    public DonorList getAllDonors() throws RemoteException {
        return serverInterface.getAllDonors();
    }

    /**
     * returns true if the cpr exist on the table
     *
     * @param cpr String
     * @return boolean
     * @throws RemoteException {@link RemoteException} HI
     */
    public boolean searchCprByBoolean(String cpr) throws RemoteException {
        return serverInterface.searchCPRByBoolean(cpr);
    }

    /**
     * @return an Array<String> with bloodCenters (Location) from the database
     * @throws RemoteException {@link RemoteException} HI
     */
    public String[] getBloodCenters() throws RemoteException {
        ArrayList<String> arrayList = serverInterface.getBloodLocations();
        Object[] objects = arrayList.toArray();

        return Arrays.copyOf(objects, objects.length, String[].class);
    }

    /**
     * gets blood by type
     *
     * @param type {@link String}
     * @return BloodList {@link BloodList}
     * @throws RemoteException {@link RemoteException} HI
     */
    public BloodList getBloodByType(String type) throws RemoteException {
        return serverInterface.getAllBloodByType(type);
    }

    /**
     * gets all the blood
     *
     * @return BloodList {@link BloodList}
     * @throws RemoteException {@link RemoteException} HI
     */
    public BloodList getBlood() throws RemoteException {
        return serverInterface.getAllBlood();
    }

    /**
     * returns true if both username a and password matches the ones from the database
     *
     * @param user username int
     * @param pass password String
     * @return boolean
     * @throws RemoteException
     */
    public boolean checkBBLogin(int user, String pass) throws RemoteException {
        return serverInterface.checkBBLogin(user, pass);
    }

    /**
     * returns true if the id exist on the table
     *
     * @param id int
     * @return boolean
     * @throws RemoteException {@link RemoteException} Hi
     */
    public boolean searchIDByBoolean(int id) throws RemoteException {
        return serverInterface.searchIDByBoolean(id);
    }

    /**
     * gets all the staff in Blood Center
     *
     * @return BBStaffList {@link BBStaffList}
     * @throws RemoteException {@link RemoteException} Hi
     */
    public BBStaffList getAllBBStaff() throws RemoteException {
        return serverInterface.getAllBbStaff();
    }

    /**
     * gets the stff by Id , from the bloodCenter
     *
     * @param id int
     * @return BBStaffList {@link BBStaffList}
     * @throws RemoteException {@link RemoteException} HI
     */
    public BBStaffList getBbStaffListById(int id) throws RemoteException {
        return serverInterface.getBBStaffByID(id);
    }

    /**
     * Gets the staff from the bloodCenter with the cpr, as a list
     *
     * @param cpr String
     * @return BBStaffList
     */
    public BBStaffList getBBStaffByCPR(String cpr) throws RemoteException {
        return serverInterface.getBBStaffByCPR(cpr);
    }

    /**
     * Returns a donor according to the parameter
     *
     * @param cpr String
     * @return Donor
     */
    public Donor getDonorByCpr(String cpr) throws RemoteException {
        return serverInterface.getDonorByCpr(cpr);
    }

    /**
     * Returns a donor according to the parameter
     *
     * @param id int
     * @return Donor
     */
    public Donor getDonorById(int id) throws RemoteException {
        return serverInterface.getDonorById(id);
    }

    /**
     * Gets donor from the database with a certain Id, as a list
     *
     * @param id int
     * @return DonorList
     */
    public DonorList getDonorsById(int id) throws RemoteException {
        return serverInterface.getDonorsById(id);
    }

    /**
     * Gets donor from the database with a certain cpr, as a list
     *
     * @param cpr String4
     * @return DonorList
     */
    public DonorList getDonorsByCpr(String cpr) throws RemoteException {
        return serverInterface.getDonorsByCpr(cpr);
    }

    /**
     * gets allRequestedMsgs
     *
     * @return list with AllRequestedMsgs
     */
    public MsgList getRequestMsg() throws RemoteException {
        return serverInterface.getRequestMsgs();
    }

    /**
     * gets allNotificationMsgs
     *
     * @return list with allNotificationMsgs
     */
    public MsgList getNotificationMsg() throws RemoteException {
        return serverInterface.getNotificationMsgs();
    }

    /**
     * Moves the blood from the bloodCenter to the hospital and deletes the
     * blood from the bloodcenter
     *
     * @param bloodType String
     * @param amount    int
     */
    public void transferBlood(String bloodType, int amount) throws RemoteException {
        serverInterface.transferBlood(bloodType, amount);
    }

    /**
     * Removes blood from the hospital table
     *
     * @param id String
     */
    public void removeBlood(String id) throws RemoteException {
        serverInterface.removeBlood(id);
    }
}
