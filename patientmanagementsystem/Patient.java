package patientmanagementsystem;

public class Patient {
    private int patientID;
    private String specialty;
    private long arrivalTime;

    public Patient(int patientID, String specialty) {
        this.patientID = patientID;
        this.specialty = specialty;
        this.arrivalTime = System.currentTimeMillis();
    }
    public int getPatientID() {
        return patientID;
    }
    public String getSpecialty() {
        return specialty;
    }
    public long getArrivalTime() {
        return arrivalTime;
    }
}
