# Hospital-Management
system for controlling patients’ records for Hospitals; adding new patient records, adding new operation information(blood test, medical exam etc.) about patient, checking total cost of this operations etc. 

Interfaces 
1. Login a. Methods Login(): Void, explained in classes which this method exist. 
 
2. Operation a. Methods Operation(): Void, explained in classes which this method exist. 
 
3. PatientRecordSearch a. Methods patientRecordSearch(): String, explained in classes which this method exist. 
 
Classes 
1. Hospital Holds information of Hospital and list of patients, patient records, doctors, nurses and registrars of hospital. Implements Login interface. a. Variables Name: Name of Hospital. Address: Address of Hospital. Phone: Phone number of Hospital. Website: Website of Hospital. DoctorsOfHospital: ArrayList<Doctor> List of Doctors in Hospital RegistrarsOfHospital: ArrayList<Registrar> List of Registrars of Hospital NursesOfHospital: ArrayList<Nurse>  List of Nurses of Hospital patientRecords: ArrayList<PatientRecord> List of Patient Records of Hospital patients: ArrayList<Patient> List of Patients of Hospital 
 
b. Methods Getter, setter and constructor methods of variables. 
 
nurseCheck(String idNumber): Nurse, checks list of NursesOfHospital with idNumber. If there is such a nurse, returns this nurse. Else, return null. 

 registrarCheck(String idNumber): Registrar, checks list of Registrar OfHospital with idNumber. If there is such a registrar, returns this registrar. Else, return null. 
 
doctorCheck(String idNumber): Doctor, checks list of DoctorsOfHospital with idNumber. If there is such a doctor, returns this doctor. Else, return null. 
 
patientCheck(String idNumber): Patient, checks list of patients with idNumber. If there is such a patient, returns this patient. Else, return null. 
 
patientRecordsCheck(String idNumber): PatientRecord, checks list of patientRecords with idNumber. If there is such a patientRecord, returns this patientRecord. Else, return null. This patientRecordsCheck() is different from patientRecordCheck() method of patientRecordCheck interace. 
 
getTotalCost(PatientRecord patientRecord): double, if there is such a patientRecord in the list and patientSituation is true returns sum of Cost list variables in patientRecord class. if there is not such a patient record or patientSituation is false(means, bill payed and case closed), returns 0. 
 
payBill(PatientRecord patientRecord): Void, makes patientSituation in patientRecord false. 
 
Login(): Void, This Method is our main method, takes input from user, about which staff is user(Registrar, Nurse or Doctor). Takes input as id of user, if there is such a staff(for example, user decide to login as doctor checks his id with doctorCheck() method) and takes another input as password and checks it is correct or not. If everything is okay, user login as which staff he choose(if doctor is chosen in the start, Doctor.Login() method starts to work). Login() methods of staffs explained in their part.  
 
2. Person Holds information of person. 
 
a. Variables Name: String, Name of Person. IdNumber: String, National Identification number of Person. Age: int, Age of Person. Gender: String, Gender of Person. Phone: String, Phone number of Person. 
 
b.  Methods Getter, setter and constructor methods of variables. 
 
3. Patient Child of Person Class. Holds information of Patient. 
 

 
a. Variables PatientRelativesPhone: String, Phone number of patients relatives. 
 
b. Methods Getter, setter and constructor methods of variables. 
 
4. PatientRecord Holds information of patient record. 
 
a. Variables patient: Patient, patient of patient record. patientApplicationReason: String, application reason of patient. patientSituation=true: Boolean, situation of patient record(if payBill method activated this turns false, means case closed). Operation: ArrayList<String>, Operation list that happens. Explanation: ArrayList<String>, Explanation of this operations. Registration: ArrayList<Staff>, Staffs that do this operations. Date: ArrayList<String>, date of this operations. Cost: ArrayList<Double>, cost of this operations. 
 
b.  Methods Getter, setter and constructor methods of variables. 
 
patientRecordAdd(String operation, String explanation , Staff registration, String date , double cost): Void, this method is not create new patient record, this method adds new operations to the patient record(for example if new operation happens adds this operation to the Operation list).  operation: name of operation.  explanation: explanation of operation(symptoms seen etc.).  registration: Staff that do this operation.  date:  date of operation.  cost: cost of operation. 
 
5. Staff Child of Person. Holds information of Staffs. 
 
a. Variables  Department: String, departman of Staff. Position: String, position of Staff. Password: String, password of Staff. OperationName[]: String, Operations names(blood test etc.) that staff can able to do. OperationCost[]: Double, Costs of this operations. 
 
b. Methods Getter, setter and constructor methods of variables. 
 
6. Doctor Child of Staff. Implements Operation, patientRecordSearch and Login interfaces. Hold information of Doctors. Doctors can login system with password. They can do new operations and add this to patient Records. Also They can check patient Records. 

 a. Variables Title: String, title of Doctor(prof. etc.). Profession: String, Profession of doctor(neurology etc.). 
 
b.  Methods Getter, setter and constructor methods of variables. 
 
Operation(PatientRecord patientRecord, String explanation, String date,int operationCode): Void, adds new operation to patientRecord.  patientRecord: needs for adding new operation to spesific patient record.    explanation: explanation of operation(symptoms seen etc.).  date:  date of operation.  operationCode: with this code, system take an Operation name and cost from Staff Class. 
 
patientRecordSearch(PatientRecord patientRecord): String, takes information from patient record. 
 
 patientRecord: needs for taking spesific patient record information. Login(): Void, if Login of Doctor is succesful(checking id and password with inputs), Doctor can do operation() and patientRecordSearch().  
 
7. Nurse Child of Staff. Implements Operation and Login interfaces. Hold information of Nurses. Nurses can login system with password. They can do new restricted operations(can do blood test but not surgery) and add this to patient Records. They can’t check patient Records because of patient-doctor privacy. 
 
a. Variables Nothing new. 
 
b. Methods Operation(PatientRecord patientRecord, String explanation, String date,int operationCode): Void, adds new operation to patientRecord.  patientRecord: needs for adding new operation to spesific patient record.    explanation: explanation of operation(symptoms seen etc.).  date:  date of operation.  operationCode: with this code, system take an Operation name and cost from Staff Class. Nurses are restricted, they can only choose certain operation Codes. 
 
Login(): Void, if Login of Nurse is succesful(checking id and password with inputs), Nurse can do operation(). 
 
8. Registrar Child of Staff. Implements patientRecordCheck and Login interfaces. Hold information of Registrar. Registrar can login system with password. They can add new patient record but can’t do operation. They can only check patient name and total cost of patient because of patient-doctor privacy. Also if patient pay the bill they can change patientSituation to false(means case closed). 
 

 a. Variables Nothing new. 
 
b. Methods patientRecordSearch(PatientRecord patientRecord): String, takes restricted information from patient record. Only patient name and bill.   patientRecord: needs for taking spesific patient record information. 
 
Login(): Void, if Login of Nurse is succesful(checking id and password with inputs), Nurse can do patientRecordSearch() and Hospital.payBill(). 
 
 
