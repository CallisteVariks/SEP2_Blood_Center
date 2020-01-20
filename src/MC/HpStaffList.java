package MC;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ghost on 07/12/2016.
 */
public class HpStaffList implements Serializable {

    private ArrayList<Staff> staffList;

    /**
     * No argument constructor
     * Initializes the ArrayList
     */
    public HpStaffList() {
        staffList = new ArrayList<>();
    }

    /**
     * Adds a staff element to the arrayList
     *
     * @param staff type Staff
     */
    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    /**
     * @param index int
     * @return staff at the index
     */
    public Staff getStaff(int index) {
        return staffList.get(index);
    }

    /**
     * gets allStaff
     *
     * @return HpStaffList allStaff
     */
    public HpStaffList getAllStaff() {

        HpStaffList list = new HpStaffList();

        for (Staff staff : staffList) {
            list.addStaff(staff);
        }
        return list;
    }

    /**
     * @param id int
     * @return list with staff with id
     */
    public HpStaffList getStaffListById(int id) {
        HpStaffList list = new HpStaffList();

        for (Staff staff : staffList) {
            if (id == staff.getiD())
                list.addStaff(staff);
        }
        return list;
    }

    /**
     * @param cpr int
     * @return list with staff with cpr
     */
    public HpStaffList getStaffListByCPR(int cpr) {
        HpStaffList list = new HpStaffList();

        for (Staff staff : staffList) {
            if (cpr == staff.getCpr())
                list.addStaff(staff);
        }
        return list;
    }

    /**
     * gets count
     *
     * @return size
     */
    public int getCount() {
        return staffList.size();
    }

    /**
     * To String
     *
     * @return String toString
     */
    public String toStrings() {
        String rtStr = "";

        for (Staff staff : staffList) {
            rtStr += "\n" + staff.smallToString() + "\n";
        }
        return rtStr;

    }
}




