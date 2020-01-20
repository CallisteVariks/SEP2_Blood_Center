package MC;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ghost on 12/12/2016.
 */
public class BBStaffList implements Serializable {

    private ArrayList<Staff> staffList;

    /**
     * No argument constructor
     * Initializes the ArrayList
     */
    public BBStaffList() {
        staffList = new ArrayList<>();
    }

    /**
     * Adds an Staff element to the arrayList
     * @param staff type Staff
     */
    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    /**
     * Gets the element inside the arrayList at the given index
     *
     * @param index Integer
     * @return returns the element type Staff
     */
    public Staff getStaff(int index) {
        return staffList.get(index);
    }

    /**
     * Gets all the elements inside the arrayList
     *
     * @return new arrayList type BBStaffLIst
     */
    public BBStaffList getAllStaff() {

        BBStaffList list = new BBStaffList();

        for (Staff staff : staffList) {
            list.addStaff(staff);
        }
        return list;
    }

    /**
     * Gets all the elements inside the arrayList with a certain parameter as a filter
     *
     * @param id Integer
     * @return new arrayList type BBStaffLIst filtered by the id given as a parameter
     */
    public BBStaffList getStaffListById(int id) {
        BBStaffList list = new BBStaffList();

        for (Staff staff : staffList) {
            if (id == staff.getiD())
                list.addStaff(staff);
        }
        return list;
    }

    /**
     * Gets all the elements inside the arrayList with a certain parameter as a filter
     *
     * @param cpr String
     * @return new arrayList type BBStaffLIst filtered by the cpr given as a parameter
     */
    public BBStaffList getStaffListByCPR(String cpr) {
        BBStaffList list = new BBStaffList();

        for (Staff staff : staffList) {
            if (cpr.equals(staff.getCpr() + ""))
                list.addStaff(staff);
        }
        return list;
    }

    /**
     * Gets the size of the arrayList
     *
     * @return new arrayList type BBStaffLIst filtered by the id given as a parameter
     */
    public int getCount() {
        return staffList.size();
    }
}
