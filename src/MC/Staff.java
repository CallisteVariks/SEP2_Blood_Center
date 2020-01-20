package MC;

import java.io.Serializable;

/**
 * Created by Ghost on 07/12/2016.
 */
public class Staff implements Serializable {

    private String fName;
    private String lName;
    private int iD;
    private int age;
    private int phone;
    private String address;
    private String email;
    private int cvr;
    private int cpr;
    private String pass;

    /**
     * No Argument Constructor
     */
    public Staff() {
    }

    /**
     * sets the this.address to the given address
     *
     * @param address String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * sets the this.age to the given age
     *
     * @param age int
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * sets the this.cpr to the given cpr
     *
     * @param cpr int
     */
    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    /**
     * sets the this.cvr to the given cvr
     *
     * @param cvr int
     */
    public void setCvr(int cvr) {
        this.cvr = cvr;
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
     * sets the this.fName to the given fName
     *
     * @param fName String
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * sets the this.iD to the given iD
     *
     * @param iD int
     */
    public void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * sets the this.lName to the given lName
     *
     * @param lName String
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * sets the this.pass to the given pass
     *
     * @param pass String
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * sets the this.phone to the given phone
     *
     * @param phone int
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * gets the cpr
     *
     * @return int cpr
     */
    public int getCpr() {
        return cpr;
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
     * gets the name
     *
     * @return String fName+" "+lName
     */
    public String getName() {
        return fName + " " + lName;
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
     * gets the cvr
     *
     * @return int cvr
     */
    public int getCvr() {
        return cvr;
    }

    /**
     * To String
     *
     * @return String smallToString
     */
    public String smallToString() {
        return "ID: " + getiD() + "         Name: " + getName();
    }

    /**
     * To String
     *
     * @return String bigToString
     */
    public String bigToString() {
        return "ID: " + getiD() + "             Name: " + getName() + "         Age: " + getAge() + "       Phone: " + getPhone() + "       Address: " + getAddress() +
                "       E-mail: " + getEmail() + "      CVR: " + getCvr() + "       CPR: " + getCpr();
    }

}
