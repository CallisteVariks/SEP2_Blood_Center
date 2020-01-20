package RMI;

import MC.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Ghost on 30/11/2016.
 */
public interface ServerInterface extends Remote {

    DonorList getAllDonors() throws RemoteException;

    ArrayList<String> getBloodLocations() throws RemoteException;

    HpStaffList getAllHospStaff() throws RemoteException;

    HpStaffList getHospitalStaffByID(int id) throws RemoteException;

    HpStaffList getHospitalStaffByCPR(int cpr) throws RemoteException;

    BBStaffList getAllBbStaff() throws RemoteException;

    BBStaffList getBBStaffByID(int id) throws RemoteException;

    BBStaffList getBBStaffByCPR(String cpr) throws RemoteException;

    BloodList getAllBlood() throws RemoteException;

    BloodList getAllBloodHpTable() throws RemoteException;

    BloodList getAllBloodByType(String type) throws RemoteException;

    BloodList getAllBloodByTypeHpTable(String type) throws RemoteException;

    int searchCPR(String cpr) throws RemoteException;

    void addDonor(String fName, String lName, String cpr, int age, String address, int phoneno,
                  String email, String bloodType, String location, java.sql.Date date) throws RemoteException;

    boolean checkHospLogin(int user, String pass) throws RemoteException;

    boolean checkBBLogin(int user, String pass) throws RemoteException;

    void removeBlood2(String id) throws RemoteException;

    void removeBlood(String id)throws RemoteException;

    void transferBlood(String bloodType, int amount) throws RemoteException;

    void saveRequestMsg(RequestMsg msg) throws RemoteException;

    MsgList getRequestMsgs() throws RemoteException;

    void saveNotificationMsg(Notifications msg) throws RemoteException;

    MsgList getNotificationMsgs() throws RemoteException;

    boolean searchCPRByBoolean(String cpr) throws RemoteException;

    boolean searchIDByBoolean(int id) throws RemoteException;

    DonorList getDonorsById(int id) throws RemoteException;

    DonorList getDonorsByCpr(String cpr) throws RemoteException;

    Donor getDonorByCpr(String cpr) throws RemoteException;

    Donor getDonorById(int id) throws RemoteException;
}