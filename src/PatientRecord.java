import java.util.ArrayList;

public class PatientRecord {
    private Patient patient;
    private String patientApplicationReason;
    private Boolean patientSituation=true;
    ArrayList<String> Operation= new ArrayList<>();
    ArrayList<String> Explanation = new ArrayList<>();
    ArrayList<Staff> Registration = new ArrayList<>();
    ArrayList<String> Date = new ArrayList<>();
    ArrayList<Double> Cost = new ArrayList<>();

    /**
     * Constructor Method
     * @param patient
     * @param patientApplicationReason
     * @param operation
     * @param explanation
     * @param registration
     * @param date
     * @param cost
     */
    public PatientRecord(Patient patient,String patientApplicationReason ,String operation,String explanation ,Staff registration,String date ,double cost) {
        this.patient = patient;
        this.patientApplicationReason= patientApplicationReason;
        Operation.add(operation);
        Registration.add(registration);
        Explanation.add(explanation);
        Date.add(date);
        Cost.add(cost);
    }

    /**
     * add new information to the lists.
     * @param operation
     * @param explanation
     * @param registration
     * @param date
     * @param cost
     */
    public void PatientRecordAdd(String operation, String explanation , Staff registration, String date , double cost){
        Operation.add(operation);
        Registration.add(registration);
        Explanation.add(explanation);
        Date.add(date);
        Cost.add(cost);
    }

    /**
     * Getter and Setter Methods of PatientRecord
     * @return patient, Operation, Registration, Cost, patientSituation
     */

    public Patient getPatient() {
        return patient;
    }


    public ArrayList<String> getOperation() {
        return Operation;
    }

    public void setOperation(ArrayList<String> operation) {
        Operation = operation;
    }

    public ArrayList<Staff> getRegistration() {
        return Registration;
    }

    public void setRegistration(ArrayList<Staff> registration) {
        Registration = registration;
    }

    public ArrayList<Double> getCost() {
        return Cost;
    }

    public void setCost(ArrayList<Double> cost) {
        Cost = cost;
    }

    public Boolean getPatientSituation() {
        return patientSituation;
    }

    public void setPatientSituation(Boolean patientSituation) {
        this.patientSituation = patientSituation;
    }
}
