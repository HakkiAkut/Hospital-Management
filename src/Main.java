/**
 * @version 1.0.0 April 15, 2020
 * @author Hakkı Can Akut
 */
public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Nurse nurse = new Nurse("Nurse h","1212",21,"Female","1212","Radyoterapi","Nurse","1212");
        hospital.NursesOfHospital.add(nurse);
        Doctor doctor = new Doctor("Doc H","2222",26,"Male","2222","Nörology","prof","2222","prof.","nörons");
        hospital.DoctorsOfHospital.add(doctor);
        Registrar registrar = new Registrar("Registar h","3333",24,"Female","3333","HR","HR staff","3333");
        hospital.RegistrarsOfHospital.add(registrar);
        Patient patient = new Patient("Joseph","1111",30,"Male","1111","12912312123");
        PatientRecord patientRecord = new PatientRecord(patient,"Headache","registration","Transferring to doctor.",registrar,"12may",10.0);
        hospital.patients.add(patient);
        hospital.patientRecords.add(patientRecord);
        hospital.Login();
    }
}
