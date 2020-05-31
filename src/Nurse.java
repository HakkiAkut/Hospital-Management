import java.util.Scanner;

public class Nurse extends Staff implements Operation,Login{
    /**
     * Constructor Method of Nurse
     * @param name
     * @param idNumber
     * @param age
     * @param gender
     * @param phone
     * @param department
     * @param position
     * @param password
     */
    public Nurse(String name, String idNumber, int age, String gender, String phone, String department, String position, String password) {
        super(name, idNumber, age, gender, phone, department, position, password);
    }

    /**
     * adds new operation to patientRecord.
     * @param patientRecord
     * @param explanation
     * @param date
     * @param operationCode
     */

    @Override
    public void Operation(PatientRecord patientRecord, String explanation, String date, int operationCode) {
        System.out.println(patientRecord.getPatient().getName());
        System.out.println("operation checkpoint");
        if (operationCode==1){
            patientRecord.PatientRecordAdd(OperationName[1],explanation,this,date,OperationCost[1]);
        }
        if (operationCode==2){
            patientRecord.PatientRecordAdd(OperationName[2],explanation,this,date,OperationCost[2]);
        }
    }

    /**
     * if Login of Nurse is successful(checking id and password with inputs), Nurse can do operation().
     */

    public void Login() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Operations: \n" +
                    "1. Blood Test\n" +
                    "2. Vaccination\n" +
                    "q. Quit");
            String selection =scanner.next();
            PatientRecord patientRecord;
            String explanation;
            String date;
            int opCode = 0;
            if (selection.equals("1")) {
                opCode = 1;
            }
            else if (selection.equals("2")){
                opCode = 2;
            }
            else if (selection.equals("q")){
                break;
            }
            else {
                System.out.println("Wrong Selection!");
            }
            if (opCode!=0) {
                System.out.print("Patient Identification Number: ");
                patientRecord = Hospital.patientRecordsSearch(scanner.next());
                if (patientRecord == null) {
                    System.out.println("There is no such that patient!");
                }
                else {
                    System.out.print("Add explanation: ");
                    explanation = scanner.next();
                    scanner.nextLine();
                    System.out.print("Date: ");
                    date = scanner.next();
                    Operation(patientRecord, explanation, date, opCode);
                }
            }
        }
    }
}
