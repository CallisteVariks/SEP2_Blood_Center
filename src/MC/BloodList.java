package MC;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ghost on 06/12/2016.
 */
public class BloodList implements Serializable {

    private ArrayList<Blood> bloodList;

    public BloodList() {
        bloodList = new ArrayList<>();
    }

    /**
     * Gets all the elements inside the arrayList with a certain parameter as a filter
     *
     * @param type String
     * @return returns a list type BloodList filtered by the received parameter
     */
    public BloodList indexOfBlood(String type) {

        BloodList list = new BloodList();

        for (Blood blood : bloodList) {
            if (type.equals(blood.getBloodType()))
                list.addBlood(blood);
        }
        return list;
    }

    /**
     * Adds an Staff element to the arrayList
     *
     * @param blood type Blood
     */
    public void addBlood(Blood blood) {
        bloodList.add(blood);
    }

    /**
     * gets the size of the array list
     *
     * @return count arrayList size
     */
    public int getCount() {
        return bloodList.size();
    }

    /**
     * gets the size of the array list
     *
     * @return arrayList size
     */
    public int size() {
        return bloodList.size();
    }

    /**
     * gets all the elements inside the list
     *
     * @return a new list type BloodList
     */
    public BloodList getBloodList() {
        BloodList list = new BloodList();

        for (Blood blood : bloodList) {
            list.addBlood(blood);
        }
        return list;
    }

    /**
     * Gets the element at the specified index
     *
     * @param index int
     * @return returns element type Blood
     */
    public Blood getBlood(int index) {
        return bloodList.get(index);
    }

}
