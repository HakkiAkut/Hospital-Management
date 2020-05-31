public class Patient extends Person {
    private String PatientRelativesPhone;

    /**
     * Constructor Method of Patient
     * @param name
     * @param idNumber
     * @param age
     * @param gender
     * @param phone
     * @param patientRelativesPhone
     */
    public Patient(String name, String idNumber, int age, String gender, String phone, String patientRelativesPhone) {
        super(name, idNumber, age, gender, phone);
        PatientRelativesPhone = patientRelativesPhone;
    }

    /**
     * Getter and Setter methods of Patient
     * @param patientRelativesPhone , phone number of relative of patients
     */
    public void setPatientRelativesPhone(String patientRelativesPhone) {
        PatientRelativesPhone = patientRelativesPhone;
    }

    public String getPatientRelativesPhone() {
        return PatientRelativesPhone;
    }
}

