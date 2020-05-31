public class Staff extends Person {
    /**
     * Attributes of Staff
     */

    private String Department;
    private String Position;
    private String Password;
    String OperationName[]= {"Registration","Blood Test","Vaccination","Medical Examination","Surgery"};
    Double OperationCost[] ={10.0,15.0,20.0,10.5,250.0};

    /**
     * Constructor Method of Staff
     * @param name
     * @param idNumber
     * @param age
     * @param gender
     * @param phone
     * @param department
     * @param position
     * @param password
     */
    public Staff(String name, String idNumber, int age, String gender, String phone, String department, String position, String password) {
        super(name, idNumber, age, gender, phone);
        Department = department;
        Position = position;
        Password = password;
    }

    /**
     * Getter and Setter method of Staff
     * @return Password, Departman ,position, password
     */
    public String getPassword() {
        return Password;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
