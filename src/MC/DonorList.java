package MC;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ghost on 09/12/2016.
 */
public class DonorList implements Serializable {

    private ArrayList<Donor> donorList;
    private int count;

    /**
     * Zero Argument Constructor
     */
    public DonorList() {
        count = 0;
        donorList = new ArrayList<>();
    }

    /**
     * Adds a donor element to the arrayList
     *
     * @param donor type Donor
     */
    public void addDonor(Donor donor) {
        donorList.add(donor);
    }

    /**
     * @param index int
     * @return donor at index
     */
    public Donor getDonor(int index) {
        return donorList.get(index);
    }

    /**
     * get allDonors
     *
     * @return DonorList list
     */
    public DonorList getAllDonors() {

        DonorList list = new DonorList();

        for (Donor donor : donorList) {
            list.addDonor(donor);
        }
        return list;
    }

    /**
     * @param id int
     * @return list with donor with id
     */
    public DonorList getDonorsById(int id) {

        DonorList list = new DonorList();
        for (Donor donor : donorList) {
            if (id == donor.getiD())
                list.addDonor(donor);
        }
        return list;
    }

    /**
     * @param cpr String
     * @return a list with donor with cpr
     */
    public DonorList getDonorsByCpr(String cpr) {

        DonorList list = new DonorList();
        for (Donor donor : donorList) {
            if (cpr.equals(donor.getCpr()))
                list.addDonor(donor);
        }
        return list;
    }

    /**
     * @param id int
     * @return donor with id
     */
    public Donor getDonorById(int id) {

        Donor temp = new Donor();
        for (Donor donor : donorList) {
            if (id == donor.getiD())
                temp = donor;
        }
        return temp;
    }

    /**
     * @param cpr String
     * @return donor with cpr
     */
    public Donor getDonorByCPR(String cpr) {

        Donor temp = new Donor();
        for (Donor donor : donorList) {
            if (cpr.equals(donor.getCpr()))
                temp = donor;
        }
        return temp;
    }

    /**
     * gets count
     *
     * @return size if the list
     */
    public int getCount() {
        return donorList.size();
    }
}

