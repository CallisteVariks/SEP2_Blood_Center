package MC;

/**
 * Created by Ghost on 29/11/2016.
 */

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class Connections implements Serializable {

    private Connection connection = null;

    /**
     * No Argument Constructor
     * Creates the connection with the data-Base
     */
    public Connections() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "ever20");
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");
            System.out.println();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * @return an ArrayList<String> with bloodCenters (Location) from the database
     */
    public ArrayList<String> getBloodCenters() {

        ArrayList<String> bloodCenters = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bloodcenter;");

            while (resultSet.next()) {
                String location = resultSet.getString("location");
                bloodCenters.add(location);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Database table ok");
        return bloodCenters;
    }

    public ArrayList<String> getHospitals() {

        ArrayList<String> hospitals = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hospital;");

            while (resultSet.next()) {
                int cvr = resultSet.getInt("cvr");
                int phoneNumber = resultSet.getInt("phonenumber");
                String location = resultSet.getString("location");

                String str = "CVR: " + cvr + "\nPhone Number: " + phoneNumber + "\nLocation: " + location;
                hospitals.add(str);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Database table ok");
        return hospitals;
    }

    /**
     * @return returns a list type DonorList filed with element type Donor from the database
     */
    public DonorList getDonors() {
        DonorList donors = new DonorList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donors;");

            while (resultSet.next()) {
                Donor donor = new Donor();
                donor.setiD(resultSet.getInt("id"));
                donor.setfName(resultSet.getString("fname"));
                donor.setlName(resultSet.getString("lname"));
                donor.setCpr(resultSet.getString("cpr"));
                donor.setAge(resultSet.getInt("age"));
                donor.setAddress(resultSet.getString("address"));
                donor.setPhone(resultSet.getInt("phoneno"));
                donor.setEmail(resultSet.getString("email"));
                donor.setBloodType(resultSet.getString("bloodtype"));
                donor.setLocation(resultSet.getString("bloodlocation"));
                donor.setDate(resultSet.getDate("date"));

                donors.addDonor(donor);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Database table ok");
        return donors;
    }

    /**
     * Gets donor from the database with a certain Id, as a list
     *
     * @param id int
     * @return DonorList
     */
    public DonorList getDonorsById(int id) {
        DonorList donors = new DonorList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donors;");

            while (resultSet.next()) {
                Donor donor = new Donor();
                donor.setiD(resultSet.getInt("id"));
                donor.setfName(resultSet.getString("fname"));
                donor.setlName(resultSet.getString("lname"));
                donor.setCpr(resultSet.getString("cpr"));
                donor.setAge(resultSet.getInt("age"));
                donor.setAddress(resultSet.getString("address"));
                donor.setPhone(resultSet.getInt("phoneno"));
                donor.setEmail(resultSet.getString("email"));
                donor.setBloodType(resultSet.getString("bloodtype"));
                donor.setLocation(resultSet.getString("bloodlocation"));
                donor.setDate(resultSet.getDate("date"));

                donors.addDonor(donor);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Database table ok");
        return donors.getDonorsById(id);
    }

    /**
     * Gets donor from the database with a certain cpr, as a list
     *
     * @param cpr String4
     * @return DonorList
     */
    public DonorList getDonorsByCpr(String cpr) {
        DonorList donors = new DonorList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donors;");

            while (resultSet.next()) {
                Donor donor = new Donor();
                donor.setiD(resultSet.getInt("id"));
                donor.setfName(resultSet.getString("fname"));
                donor.setlName(resultSet.getString("lname"));
                donor.setCpr(resultSet.getString("cpr"));
                donor.setAge(resultSet.getInt("age"));
                donor.setAddress(resultSet.getString("address"));
                donor.setPhone(resultSet.getInt("phoneno"));
                donor.setEmail(resultSet.getString("email"));
                donor.setBloodType(resultSet.getString("bloodtype"));
                donor.setLocation(resultSet.getString("bloodlocation"));
                donor.setDate(resultSet.getDate("date"));

                donors.addDonor(donor);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Database table ok");
        return donors.getDonorsByCpr(cpr);
    }

    /**
     * Gets all the staff from the bloodCenter
     *
     * @return BBStaffList
     */
    public BBStaffList getBloodCenterStaff() {
        BBStaffList staffList = new BBStaffList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bloodcenterstaff;");

            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setfName(resultSet.getString("firstname"));
                staff.setlName(resultSet.getString("lastname"));
                staff.setAge(resultSet.getInt("age"));
                staff.setiD(resultSet.getInt("id"));
                staff.setPhone(resultSet.getInt("phone"));
                staff.setAddress(resultSet.getString("address"));
                staff.setEmail(resultSet.getString("e_mail"));
                staff.setCvr(resultSet.getInt("location"));
                staff.setCpr(resultSet.getInt("cpr"));
                staff.setPass(resultSet.getString("pass"));

                staffList.addStaff(staff);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return staffList.getAllStaff();
    }

    /**
     * Gets the staff from the bloodCenter with the id, as a list
     *
     * @param id int
     * @return BBStaffList
     */
    public BBStaffList getBBStaffById(int id) {
        BBStaffList staffList = new BBStaffList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bloodcenterstaff;");
            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setfName(resultSet.getString("firstname"));
                staff.setlName(resultSet.getString("lastname"));
                staff.setAge(resultSet.getInt("age"));
                staff.setiD(resultSet.getInt("id"));
                staff.setPhone(resultSet.getInt("phone"));
                staff.setAddress(resultSet.getString("address"));
                staff.setEmail(resultSet.getString("e_mail"));
                staff.setCvr(resultSet.getInt("location"));
                staff.setCpr(resultSet.getInt("cpr"));
                staff.setPass(resultSet.getString("pass"));

                staffList.addStaff(staff);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }

        return staffList.getStaffListById(id);
    }

    /**
     * Gets the staff from the bloodCenter with the cpr, as a list
     *
     * @param cpr String
     * @return BBStaffList
     */
    public BBStaffList getBBStaffByCPR(String cpr) {
        BBStaffList staffList = new BBStaffList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bloodcenterstaff;");

            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setfName(resultSet.getString("firstname"));
                staff.setlName(resultSet.getString("lastname"));
                staff.setAge(resultSet.getInt("age"));
                staff.setiD(resultSet.getInt("id"));
                staff.setPhone(resultSet.getInt("phone"));
                staff.setAddress(resultSet.getString("address"));
                staff.setEmail(resultSet.getString("e_mail"));
                staff.setCvr(resultSet.getInt("location"));
                staff.setCpr(resultSet.getInt("cpr"));
                staff.setPass(resultSet.getString("pass"));

                staffList.addStaff(staff);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }

        return staffList.getStaffListByCPR(cpr);
    }

    /**
     * Gets the staff from the hospitalStaff DataBase
     *
     * @return HpStaffList
     */
    public HpStaffList getHospitalStaff() {
        HpStaffList staffList = new HpStaffList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hospitalStaff;");

            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setfName(resultSet.getString("firstname"));
                staff.setlName(resultSet.getString("lastname"));
                staff.setAge(resultSet.getInt("age"));
                staff.setiD(resultSet.getInt("id"));
                staff.setPhone(resultSet.getInt("phone"));
                staff.setAddress(resultSet.getString("address"));
                staff.setEmail(resultSet.getString("e_mail"));
                staff.setCvr(resultSet.getInt("location"));
                staff.setCpr(resultSet.getInt("cpr"));
                staff.setPass(resultSet.getString("pass"));

                staffList.addStaff(staff);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return staffList.getAllStaff();
    }

    /**
     * Gets a list filled with an HpStaff object with the id as a parameter
     *
     * @param id int
     * @return HpStaffList
     */
    public HpStaffList getHospitalStaffByID(int id) {
        HpStaffList staffList = new HpStaffList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hospitalStaff;");

            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setfName(resultSet.getString("firstname"));
                staff.setlName(resultSet.getString("lastname"));
                staff.setAge(resultSet.getInt("age"));
                staff.setiD(resultSet.getInt("id"));
                staff.setPhone(resultSet.getInt("phone"));
                staff.setAddress(resultSet.getString("address"));
                staff.setEmail(resultSet.getString("e_mail"));
                staff.setCvr(resultSet.getInt("location"));
                staff.setCpr(resultSet.getInt("cpr"));
                staff.setPass(resultSet.getString("pass"));

                staffList.addStaff(staff);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }

        return staffList.getStaffListById(id);
    }

    /**
     * Gets a list filled with an HpStaff object with the cpr as a parameter
     *
     * @param cpr int
     * @return HpStaffList
     */
    public HpStaffList getHospitalStaffByCPR(int cpr) {
        HpStaffList staffList = new HpStaffList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hospitalStaff;");

            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setfName(resultSet.getString("firstname"));
                staff.setlName(resultSet.getString("lastname"));
                staff.setAge(resultSet.getInt("age"));
                staff.setiD(resultSet.getInt("id"));
                staff.setPhone(resultSet.getInt("phone"));
                staff.setAddress(resultSet.getString("address"));
                staff.setEmail(resultSet.getString("e_mail"));
                staff.setCvr(resultSet.getInt("location"));
                staff.setCpr(resultSet.getInt("cpr"));
                staff.setPass(resultSet.getString("pass"));

                staffList.addStaff(staff);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }

        return staffList.getStaffListByCPR(cpr);
    }

    /**
     * Gets a list filled with Blood objects of that type, from the bloodCenter
     *
     * @param type String
     * @return BloodList
     */
    public BloodList getBloodByType(String type) {
        BloodList bloodPool = new BloodList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donorblood;");

            while (resultSet.next()) {
                Blood blood = new Blood();
                blood.setBloodType(resultSet.getString("bloodtype"));
                blood.setBloodID(resultSet.getInt("bloodid"));
                blood.setSSN(resultSet.getInt("donorssn"));
                blood.setValDate(resultSet.getDate("validationdate"));

                bloodPool.addBlood(blood);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return bloodPool.indexOfBlood(type);
    }

    /**
     * Gets a list filled with Blood objects of that type, from the Hospital
     *
     * @param type String
     * @return BloodList
     */
    public BloodList getBloodByTypeHpTable(String type) {
        BloodList bloodPool = new BloodList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hpblood;");

            while (resultSet.next()) {
                Blood blood = new Blood();
                blood.setBloodType(resultSet.getString("bloodtype"));
                blood.setBloodID(resultSet.getInt("bloodid"));
                blood.setSSN(resultSet.getInt("donorssn"));
                blood.setValDate(resultSet.getDate("validationdate"));

                bloodPool.addBlood(blood);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return bloodPool.indexOfBlood(type);
    }

    /**
     * gets all blood from the bloodCenter
     *
     * @return BloodList
     */
    public BloodList getBlood() {
        BloodList bloodPool = new BloodList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donorblood;");

            while (resultSet.next()) {
                Blood blood = new Blood();
                blood.setBloodType(resultSet.getString("bloodtype"));
                blood.setSSN(resultSet.getInt("donorssn"));
                blood.setValDate(resultSet.getDate("validationdate"));
                blood.setBloodID(resultSet.getInt("bloodid"));

                bloodPool.addBlood(blood);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return bloodPool.getBloodList();
    }

    /**
     * gets all blood from the hospital
     *
     * @return BloodList
     */
    public BloodList getBloodHpTable() {
        BloodList bloodPool = new BloodList();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hpblood;");

            while (resultSet.next()) {
                Blood blood = new Blood();
                blood.setBloodType(resultSet.getString("bloodtype"));
                blood.setSSN(resultSet.getInt("donorssn"));
                blood.setValDate(resultSet.getDate("validationdate"));
                blood.setBloodID(resultSet.getInt("bloodid"));

                bloodPool.addBlood(blood);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return bloodPool.getBloodList();
    }

    /**
     * Adds a donor to the database and makes a blood donation
     *
     * @param fName     String
     * @param lName     String
     * @param cpr       String
     * @param age       int
     * @param address   String
     * @param phoneno   int
     * @param email     String
     * @param bloodType String
     * @param location  String
     * @param date      Date
     */
    public void addDonor(String fName, String lName, String cpr, int age, String address, int phoneno,
                         String email, String bloodType, String location, Date date) {

        try {
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO donors(id, fname, lname, cpr, age, address, phoneno, email, bloodtype, bloodlocation, date)" +
                    " " + "VALUES (nextval('incrementing'),'" + fName + "','" + lName + "','" + cpr + "','" + age + "','" + address +
                    "','" + phoneno + "','" + email + "','" + bloodType + "','" + location + "','" + date + "');";

            statement.executeUpdate(sql);
            connection.commit();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM donors;");
            int ID = 0;
            while (resultSet.next()) {
                if (cpr.equals(resultSet.getString("cpr"))) {
                    ID = resultSet.getInt("id");
                }
            }
            addDonorBlood(bloodType, ID);
            statement.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Records created successfully");
    }

    /**
     * Makes a Blood Donation
     *
     * @param bloodType String
     * @param ID        int
     */
    private void addDonorBlood(String bloodType, int ID) {
        try {
            Statement statement = connection.createStatement();

            String sql2 = "INSERT INTO donorblood(bloodtype, donorssn, validationdate, bloodid) VALUES ('" + bloodType +
                    "','" + ID + "', CURRENT_DATE + INTERVAL '42 days',nextval('incrementing2'))";

            statement.executeUpdate(sql2);
            statement.close();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();

        }
        System.out.println("Records created successfully");
    }

    /**
     * Removes blood from the hospital table
     *
     * @param id String
     */
    public void removeBloodHpTable(String id) {
        try {
            Statement statement = connection.createStatement();
            String delete = "DELETE FROM hpblood WHERE bloodid='" + id + "' ";

            statement.executeUpdate(delete);

            statement.close();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Removes blood from the blood Center table
     *
     * @param id String
     */
    public void removeBloodBB(String id) {
        try {
            Statement statement = connection.createStatement();
            String delete = "DELETE FROM donorblood WHERE bloodid='" + id + "' ";

            statement.executeUpdate(delete);

            statement.close();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Moves the blood from the bloodCenter to the hospital and deletes the blood from the bloodcenter
     *
     * @param type   String
     * @param amount int
     */
    public void transferBlood(String type, int amount) {
        try {
            Statement statement = connection.createStatement();

            String transfer = "INSERT INTO hpblood(bloodtype, donorssn, validationdate, bloodid) " +
                    "SELECT bloodtype,donorssn,validationdate,bloodid FROM donorblood WHERE bloodtype ='" + type + "' LIMIT " + amount + "";

            String delete = "DELETE FROM donorblood WHERE bloodid IN(SELECT bloodid FROM hpblood WHERE hpblood.bloodid=donorblood.bloodid)";

            statement.executeUpdate(transfer);
            statement.execute(delete);

            statement.close();
            connection.commit();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * uses the cpr to return the matching id
     *
     * @param cpr String
     * @return int
     */
    public int searchCPR(String cpr) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donors;");

            while (resultSet.next()) {
                if (cpr.equals(resultSet.getString("cpr"))) {

                    int id = resultSet.getInt("id");
                    resultSet.close();
                    statement.close();
                    return id;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Returns a donor according to the parameter
     *
     * @param cpr String
     * @return Donor
     */
    public Donor getDonorByCpr(String cpr) {

        DonorList donors = new DonorList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donors;");

            while (resultSet.next()) {
                Donor donor = new Donor();
                donor.setiD(resultSet.getInt("id"));
                donor.setfName(resultSet.getString("fname"));
                donor.setlName(resultSet.getString("lname"));
                donor.setCpr(resultSet.getString("cpr"));
                donor.setAge(resultSet.getInt("age"));
                donor.setAddress(resultSet.getString("address"));
                donor.setPhone(resultSet.getInt("phoneno"));
                donor.setEmail(resultSet.getString("email"));
                donor.setBloodType(resultSet.getString("bloodtype"));
                donor.setLocation(resultSet.getString("bloodlocation"));
                donor.setDate(resultSet.getDate("date"));

                donors.addDonor(donor);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Database table ok");
        return donors.getDonorByCPR(cpr);
    }

    /**
     * Returns a donor according to the parameter
     *
     * @param id int
     * @return Donor
     */
    public Donor getDonorById(int id) {

        DonorList donors = new DonorList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donors;");

            while (resultSet.next()) {
                Donor donor = new Donor();
                donor.setiD(resultSet.getInt("id"));
                donor.setfName(resultSet.getString("fname"));
                donor.setlName(resultSet.getString("lname"));
                donor.setCpr(resultSet.getString("cpr"));
                donor.setAge(resultSet.getInt("age"));
                donor.setAddress(resultSet.getString("address"));
                donor.setPhone(resultSet.getInt("phoneno"));
                donor.setEmail(resultSet.getString("email"));
                donor.setBloodType(resultSet.getString("bloodtype"));
                donor.setLocation(resultSet.getString("bloodlocation"));
                donor.setDate(resultSet.getDate("date"));

                donors.addDonor(donor);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {

            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Database table ok");
        return donors.getDonorById(id);
    }

    /**
     * returns true if the cpr exist on the table
     *
     * @param cpr String
     * @return boolean
     */
    public boolean searchCPRBoolean(String cpr) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donors;");

            while (resultSet.next()) {
                if (cpr.equals(resultSet.getString("cpr"))) {
                    resultSet.close();
                    statement.close();
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
        return false;
    }

    /**
     * returns true if the id exist on the table
     *
     * @param id int
     * @return boolean
     */
    public boolean searchIdBoolean(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM donors;");

            while (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
                    resultSet.close();
                    statement.close();
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * returns true if both username a and password matches the ones from the database
     *
     * @param id       username
     * @param password password
     * @return boolean
     */
    public boolean checkLoginCredentialsBB(int id, String password) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bloodcenterstaff;");

            while (resultSet.next()) {
                if (id == resultSet.getInt("id") && password.equals(resultSet.getString("pass"))) {
                    resultSet.close();
                    statement.close();
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return false;
    }

    /**
     * returns true if both username a and password matches the ones from the database
     *
     * @param id       username
     * @param password password
     * @return boolean
     */
    public boolean checkLoginCredentialsHP(int id, String password) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hospitalstaff;");

            while (resultSet.next()) {
                if (password.equals(resultSet.getString("pass")) && id == resultSet.getInt("id")) {
                    resultSet.close();
                    statement.close();
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] Args) {
        Connections connections = new Connections();
        connections.transferBlood("O+", 1);
    }
}