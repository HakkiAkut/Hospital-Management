import java.util.Scanner;

public class Registrar extends Staff implements PatientRecordSearch, Login {

    /**
     * Constructor Method of Registrar
     * @param name
     * @param idNumber
     * @param age
     * @param gender
     * @param phone
     * @param department
     * @param position
     * @param password
     */
    public Registrar(String name, String idNumber, int age, String gender, String phone, String department, String position, String password) {
        super(name, idNumber, age, gender, phone, department, position, password);
    }

    /**
     * takes restricted information from patient record. Only patient name and bill.
     * @param patientRecord
     * @return
     */
    @Override
    public String patientRecordSearch(PatientRecord patientRecord) {
        if (patientRecord == null) {
            return "There is no patient bill!";
        }
        else{
            return  "Patient Name: "+patientRecord.getPatient().getName()+"\n" +
                    "Patient Bill: "+ Hospital.getTotalCost(patientRecord);
        }
    }

    /**
     * if Login of Nurse is succesful(checking id and password with inputs), Nurse can do patientRecordSearch() and Hospital.payBill().
     */
    @Override
    public void Login() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Operations: \n" +
                    "1. Patient Registration\n" +
                    "2. Patient Bill\n" +
                    "q. Quit");
            String selection =scanner.next();
            PatientRecord patientRecord;
            String date;
            if (selection.equals("1")) {
                System.out.print("Patient Name: ");
                String name= scanner.next();
                System.out.print("Patient ID: ");
                String id= scanner.next();
                System.out.print("Patient Age: ");
                int age= scanner.nextInt();
                System.out.print("Patient Gender: ");
                String gender= scanner.next();
                System.out.print("PatientPhone: ");
                String phone = scanner.next();
                System.out.print("Patient Relatives Phone: ");
                String relativePhone= scanner.next();
                System.out.print("Application Reason: ");
                String applicationReason= scanner.next();
                System.out.print("Date: ");
                date = scanner.next();
                Hospital.patients.add(new Patient(name,id,age,gender,phone,relativePhone));
                Hospital.patientRecords.add(new PatientRecord(Hospital.patientSearch(id),applicationReason,OperationName[0],"Transferring to Doctor.",this,date,OperationCost[0]));
            }
            else if (selection.equals("2")){
                System.out.print("Patient Identification Number: ");
                patientRecord = Hospital.patientRecordsSearch(scanner.next());
                System.out.println(patientRecordSearch(patientRecord));
                if(patientRecordSearch(patientRecord).equals("There is no patient bill!")){}
                    else{
                    System.out.println("Do you want to pay the bill?(y/n)");
                    String selection1= scanner.next();
                    if (selection1.equals("y")){
                        Hospital.payBill(patientRecord);
                    }
                }
            }
            else if (selection.equals("q")){
                break;
            }
            else {
                System.out.println("Select Again!");
            }
        }
    }
}
