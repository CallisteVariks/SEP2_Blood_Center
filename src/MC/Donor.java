package MC;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Ghost on 09/12/2016.
 */
public class Donor implements Serializable {

    private int iD;
    private String cpr;
    private String fName;
    private String lName;
    private int age;
    private int phone;
    private String address;
    private String email;
    private String location;
    private Date date;
    private String bloodType;

    /**
     * Zero Argument Constructor
     */
    public Donor() {
    }

    /**
     * sets the this.bloodType to the given bloodType
     *
     * @param bloodType String
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * sets the this.fName to the given fName
     *
     * @param fName String
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * sets the this.fName to the given fName
     *
     * @param fName String
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * sets the this.fName to the given fName
     *
     * @param fName String
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * sets the this.fName to the given fName
     *
     * @param fName String
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * sets the this.fName to the given fName
     *
     * @param fName String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * sets the this.fName to the given fName
     *
     * @param fName String
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * sets the this.fName to the given fName
     *
     * @param fName String
     */
    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    /**
     * sets the this.Datto the given fName
     *
     * @param date Date.sql
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * sets the this.email to the given email
     *
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * sets the this.location to the given location
     *
     * @param location String
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * gets the location
     *
     * @return String location
     */
    public String getLocation() {
        return location;
    }

    /**
     * gets the iD
     *
     * @return int iD
     */
    public int getiD() {
        return iD;
    }

    /**
     * gets the cpr
     *
     * @return String cpr
     */
    public String getCpr() {
        return cpr;
    }

    /**
     * gets the fName
     *
     * @return String fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * gets the lName
     *
     * @return String lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * gets the age
     *
     * @return int age
     */
    public int getAge() {
        return age;
    }

    /**
     * gets the phone
     *
     * @return int phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * gets the bloodType
     *
     * @return String bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * gets the address
     *
     * @return String address
     */
    public String getAddress() {
        return address;
    }

    /**
     * gets the email
     *
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * To String
     *
     * @return String toString
     */
    public String realToString() {
        return "ID: " + getiD() + "     Name: " + getfName() + " " + getlName() + "   CPR: " + cpr +
                "    Age: " + getAge() + "     Phone: " + getPhone() + "    Email: " + getEmail() +
                "   BloodType: " + getBloodType() + "     Center: " + getLocation();

    }
}
