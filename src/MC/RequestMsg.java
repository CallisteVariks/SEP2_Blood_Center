package MC;

import java.io.Serializable;

/**
 * Created by Ghost on 12/12/2016.
 */
public class RequestMsg implements Serializable {

    private int amount;
    private String bloodType;
    private String location;

    /**
     * Three Argument Constructor
     *
     * @param amount int
     * @param bloodType String
     * @param location String
     */
    public RequestMsg(int amount, String bloodType, String location) {
        this.amount = amount;
        this.bloodType = bloodType;
        this.location = location;
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
     * sets the this.location to the given location
     *
     * @param location String
     */
    public void setLocation(String location) {
        this.location = location;
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
     * sets the this.amount to the given amount
     *
     * @param amount int
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * gets the amount
     *
     * @return int amount
     */
    public int getAmount() {
        return amount;
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
     * gets smallString
     *
     * @return String amount+"of"+bloodType
     */
    public String smallString() {
        return getAmount() + " of " + getBloodType();
    }

}
