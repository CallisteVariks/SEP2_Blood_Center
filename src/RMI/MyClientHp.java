package RMI;

import MC.BloodList;
import MC.HpStaffList;
import MC.Notifications;
import MC.RequestMsg;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by Ghost on 30/11/2016.
 */
public class MyClientHp implements Serializable {

    private ServerInterface serverInterface;

    /**
     * Zero argument constructor
     *
     * @throws RemoteException {@link RemoteException} HI
     */
    public MyClientHp() throws RemoteException {
        super();

        try {
            serverInterface = (ServerInterface) Naming.lookup("rmi://localhost:1099/BBank");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the staff from the HospitalStaff, as a list
     *
     * @return HpStaffList
     * @throws RemoteException {@link RemoteException} HI
     */
    public HpStaffList getHospitalStaff() throws RemoteException {
        return serverInterface.getAllHospStaff();
    }

    /**
     * Gets the blood from the BloodList
     *
     * @return {@link BloodList}
     * @throws RemoteException {@link RemoteException} HI
     */
    public BloodList getBlood() throws RemoteException {
        return serverInterface.getAllBlood();
    }

    /**
     * Gets the blood from Hospital Table
     *
     * @return BloodList
     * @throws RemoteException {@link RemoteException} HI
     */
    public BloodList getBloodHpTable() throws RemoteException {
        return serverInterface.getAllBloodHpTable();
    }

    /**
     * Gets blood by type, from the hospital table
     *
     * @param type String
     * @return HpStaffList
     * @throws RemoteException {@link RemoteException} HI
     */
    public BloodList getBloodByTypeHpTable(String type) throws RemoteException {
        return serverInterface.getAllBloodByTypeHpTable(type);
    }

    /**
     * Gets the staff from the Hospitals, by id
     *
     * @param id int
     * @return HpStaffList
     * @throws RemoteException {@link RemoteException} HI
     */
    public HpStaffList getHospitalStaffByID(int id) throws RemoteException {
        return serverInterface.getHospitalStaffByID(id);
    }

    /**
     * Gets the staff from the Hospitals, by cpr
     *
     * @param cpr int
     * @return HpStaffList
     * @throws RemoteException {@link RemoteException} HI
     */
    public HpStaffList getHospitalStaffByCPR(int cpr) throws RemoteException {
        return serverInterface.getHospitalStaffByCPR(cpr);
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
    public boolean checkHospLogin(int user, String pass) throws RemoteException {
        return serverInterface.checkHospLogin(user, pass);
    }

    /**
     * Removes the blood object with the specified id
     *
     * @param id {@link String}
     * @throws RemoteException {@link RemoteException} HI
     */
    public void removeBlood(String id) throws RemoteException {
        serverInterface.removeBlood2(id);
    }

    /**
     * Sends a request msg to the server
     *
     * @param msg {@link RequestMsg}
     * @throws RemoteException
     */
    public void sendMsg(RequestMsg msg) throws RemoteException {
        serverInterface.saveRequestMsg(msg);
    }


    /**
     * Sends a notification msg to the server
     *
     * @param msg {@link RequestMsg}
     * @throws RemoteException
     */
    public void sendNotificationMsg(Notifications msg) throws RemoteException {
        serverInterface.saveNotificationMsg(msg);
    }

}
