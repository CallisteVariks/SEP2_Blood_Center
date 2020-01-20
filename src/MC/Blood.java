package MC;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ghost on 06/12/2016.
 */

/**
 * Creates a Blood Object
 */
public class Blood implements Serializable {

    private String bloodType;
    private int SSN;
    private Date valDate;
    private int bloodID;

    /**
     * Zero Argument Constructor, initializing all the variables
     */
    public Blood() {
        bloodType="";
        SSN=-1;
        valDate =null;
        bloodID=-1;
    }

    /**
     * sets the this.bloodID to the bloodID
     * @param bloodID int
     */
    public void setBloodID(int bloodID) {
        this.bloodID = bloodID;
    }

    /**
     * sets the this.bloodType to the bloodType
     * @param bloodType String
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * sets the this.SSN to the given SSN
     * @param SSN int
     */
    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    /**
     * sets the this.valDate to the given valDate
     * @param valDate Date
     */
    public void setValDate(Date valDate) {
        this.valDate = valDate;
    }

    /**
     * gets the valDate
     * @return Date valDate
     */
    public Date getValDate() {
        return valDate;
    }

    /**
     * gets the bloodID
     * @return int bloodID
     */
    public int getBloodID() {
        return bloodID;
    }

    /**
     * gets the SSN
     * @return int SSN
     */
    public int getSSN() {
        return SSN;
    }

    /**
     * gets bloodType
     * @return  String bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * To String
     * @return String toString
     */
    public String getAllbloodTypesRad() {
        return "Blood Id: " + getBloodID() + "              Donor Id: " + getSSN()+"                Blood Type: "+getBloodType()+"              Validation Date: " + getValDate();
    }

}
