public class Person {
    /**
     * Attributes of Person
     */
    private String Name;
    private String IdNumber; // National Identification number
    private int Age;
    private String Gender;
    private String Phone;

    /**
     * Constructor Method
     * @param name
     * @param idNumber
     * @param age
     * @param gender
     * @param phone
     */
    public Person(String name, String idNumber, int age, String gender, String phone) {
        Name = name;
        IdNumber = idNumber;
        Age = age;
        Gender = gender;
        Phone = phone;
    }

    /**
     * Getter and setter methods
     * @return Name, IdNumber, Age, Gender, Phone of Person
     */
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(String idNumber) {
        IdNumber = idNumber;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
