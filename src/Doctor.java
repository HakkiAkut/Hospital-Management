import java.util.Scanner;

public class Doctor extends Staff implements Operation, PatientRecordSearch,Login {
    private String Title;
    private String Profession;

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
     * @param title
     * @param profession
     */

    public Doctor(String name, String idNumber, int age, String gender, String phone, String department, String position, String password, String title, String profession) {
        super(name, idNumber, age, gender, phone, department, position, password);
        Title = title;
        Profession = profession;
    }

    /**
     * adds new operation to patientRecord.
     * @param patientRecord
     * @param explanation
     * @param date
     * @param operationCode
     */

    @Override
    public void Operation(PatientRecord patientRecord, String explanation, String date,int operationCode) {
        System.out.println(patientRecord.getPatient().getName());
        System.out.println("operation checkpoint");
        if (operationCode==1){
            patientRecord.PatientRecordAdd(OperationName[3],explanation,this,date,OperationCost[3]);
        }
        if (operationCode==2){
            patientRecord.PatientRecordAdd(OperationName[4],explanation,this,date,OperationCost[4]);
        }

    }

    /**
     *
     * @param patientRecord
     * @return message
     */
    @Override
    public String patientRecordSearch(PatientRecord patientRecord) {
        String message ="Patient Name: " + patientRecord.getPatient().getName()+"\n" +
                "Patient ID: " + patientRecord.getPatient().getIdNumber();
        for (int i=0;i<patientRecord.Operation.size();i++){
            message +="\n" + patientRecord.Operation.get(i)+" - "+patientRecord.Explanation.get(i)+" - " +patientRecord.Registration.get(i).getName()+ " - "+ patientRecord.Date.get(i);
        }
        return message;
    }

    /**
     * if Login of Doctor is successful(checking id and password with inputs), Doctor can do operation() and patientRecordSearch().
     */

    @Override
    public void Login() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Operations: \n" +
                    "0. Patient Record Search\n" +
                    "1. Medical Examination\n" +
                    "2. Surgery\n" +
                    "q. Quit");
            String selection =scanner.next();
            PatientRecord patientRecord;
            String explanation;
            String date;
            int opCode = -1;
            if (selection.equals("0")){
                opCode=0;
            }
            else if (selection.equals("1")) {
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
            if (opCode!=-1) {
                System.out.print("Patient Identification Number: ");
                patientRecord = Hospital.patientRecordsSearch(scanner.next());
                if (patientRecord == null) {
                    System.out.println("There is no such that patient!");
                }
                else if (patientRecord != null && selection.equals("0")) {
                    System.out.println(patientRecordSearch(patientRecord));
                }
                else {
                    System.out.print("Add explanation: ");
                    explanation = scanner.next();
                    System.out.print("Date: ");
                    date = scanner.next();
                    Operation(patientRecord, explanation, date, opCode);
                }
            }
        }
    }
}
