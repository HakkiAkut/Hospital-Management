import java.util.ArrayList;
import java.util.Scanner;

public class Hospital implements Login{
    /**
     * Attributes of Hospital; Name, Address, Phone, Website
     */
    private String Name;
    private String Address;
    private String Phone;
    private String Website;
    static ArrayList<Doctor> DoctorsOfHospital= new ArrayList<>();
    static ArrayList<Registrar> RegistrarsOfHospital= new ArrayList<>();
    static ArrayList<Nurse> NursesOfHospital = new ArrayList<>();
    static ArrayList<PatientRecord> patientRecords = new ArrayList<>();
    static ArrayList<Patient> patients = new ArrayList<>();

    /**
     * Checking NursesOfHospital list with idNumber
     * @param idNumber of Nurse
     * @return Nurse, if there is such that nurse has idNumber
     */
    public static Nurse nurseCheck(String idNumber){
        for (int i=0;i<NursesOfHospital.size();i++) {
            if (NursesOfHospital.get(i).getIdNumber().equals(idNumber)) {
                return NursesOfHospital.get(i);
            }
        }
        return null;
    }
    /**
     * Checking RegistrarsOfHospital list with idNumber
     * @param idNumber of Registrar
     * @return Registrar, if there is such that registrar has idNumber
     */
    public static Registrar registrarCheck(String idNumber){
        for (int i=0;i<RegistrarsOfHospital.size();i++) {
            if (RegistrarsOfHospital.get(i).getIdNumber().equals(idNumber)) {
                return RegistrarsOfHospital.get(i);
            }
        }
        return null;
    }

    /**
     * Checking DoctorsOfHospital list with idNumber
     * @param idNumber of Doctor
     * @return Doctor, if there is such that doctor has idNumber
     */
    public static Doctor doctorCheck(String idNumber){
        for (int i=0;i<DoctorsOfHospital.size();i++) {
            if (DoctorsOfHospital.get(i).getIdNumber().equals(idNumber)) {
                return DoctorsOfHospital.get(i);
            }
        }
        return null;
    }


    /**
     * Checking HROfHospital list with idNumber
     * @param idNumber of Patient
     * @return Patient, if there is such that patient has idNumber
     */
    public static Patient patientSearch(String idNumber){
        for (int i=0;i<patients.size();i++) {
            if (patients.get(i).getIdNumber().equals(idNumber)) {
                System.out.println("patient found.");
                return patients.get(i);
            }
        }
        return null;
    }
    /**
     * Checking patientRecords list with idNumber
     * @param idNumber of Patient
     * @return PatientRecord, if there is such that patientRecord exist and continue(Patient Situation false means case closed!)
     */
    public static PatientRecord patientRecordsSearch(String idNumber){
        Patient patient = patientSearch(idNumber);
        for (int i=0;i<patientRecords.size();i++) {
            if (patientRecords.get(i).getPatient().equals(patient) && patientRecords.get(i).getPatientSituation()==true) {
                System.out.println("patient record found.");
                return patientRecords.get(i);
            }
        }
        return null;
    }


    /**
     * Checking patientRecords list with idNumber
     * @param patientRecord of Patient
     * @return totalCost, if there is such that patientRecord exist
     */
    public static double getTotalCost(PatientRecord patientRecord){
        double totalCost=0;
        if (patientRecord.getPatientSituation() == true){
            for (int i=0;i<patientRecord.getCost().size();i++){
                totalCost += patientRecord.getCost().get(i);
            }
        }
        return totalCost;
    }

    /**
     * Makes patentSituation false, that means case closed!
     * @param patientRecord of Patient
     */
    public static void payBill(PatientRecord patientRecord){
        System.out.println("Bill is payed!, " + getTotalCost(patientRecord));
        patientRecord.setPatientSituation(false);
    }

    /**
     *Main method of System,
     * takes input from user, about which staff is user(Registrar, Nurse or Doctor).
     * Takes input as id of user, if there is such a staff,
     * and takes another input as password and checks it is correct or not. If everything is okay, user login as which staff he choose
     * if doctor is chosen in the start, Doctor.Login() method starts to work
     */
    public void Login() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Staff Login: \n" +
                    "1. Registrar\n" +
                    "2. Nurse\n" +
                    "3. Doctor\n" +
                    "q. Quit");
            String selection = scanner.next();
            if (selection.equals("1")){
                System.out.print("Registrar ID: ");
                Registrar registrar = Hospital.registrarCheck(scanner.next());
                if (registrar!=null){
                    System.out.print("Password: ");
                    if(registrar.getPassword().equals(scanner.next())) {
                        registrar.Login();
                    }
                    else{
                        System.out.println("Wrong Password!");
                    }
                }
                else {
                    System.out.println("Wrong ID!");
                }
            }
            if (selection.equals("2")){
                System.out.print("Nurse ID: ");
                Nurse nurse = Hospital.nurseCheck(scanner.next());
                if (nurse !=null){
                    System.out.print("Password: ");
                    if(nurse.getPassword().equals(scanner.next())) {
                        nurse.Login();
                    }
                    else{
                        System.out.println("Wrong Password!");
                    }
                }
                else {
                    System.out.println("Wrong ID!");
                }
            }
            if (selection.equals("3")){
                System.out.print("Doctor ID: ");
                Doctor doctor = Hospital.doctorCheck(scanner.next());
                if (doctor!=null){
                    System.out.print("Password: ");
                    if(doctor.getPassword().equals(scanner.next())) {
                        doctor.Login();
                    }
                    else{
                        System.out.println("Wrong Password!");
                    }
                }
                else {
                    System.out.println("Wrong ID!");
                }
            }
            if(selection.equals("q")){
                System.out.println("System Closing!");
                break;
            }
            else {
                System.out.println("Choose again!");
            }

        }
    }

}
