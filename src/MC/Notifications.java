package MC;

import java.io.Serializable;

/**
 * Created by Ghost on 13/12/2016.
 */
public class Notifications implements Serializable {

    private int id;
    private String bloodType;

    /**
     * Two Argument Constructor
     *
     * @param bloodType String
     * @param id        int
     */
    public Notifications(String bloodType, int id) {
        this.id = id;
        this.bloodType = bloodType;

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
     * gets the bloodType
     *
     * @return String bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * sets the this.id to the given id
     *
     * @param id int
     */
    public void setid(int id) {
        this.id = id;
    }

    /**
     * gets the id
     *
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * gets smallString
     *
     * @return String id+"of"+bloodType
     */
    public String smallString() {
        return getId() + " of " + getBloodType();
    }

}
