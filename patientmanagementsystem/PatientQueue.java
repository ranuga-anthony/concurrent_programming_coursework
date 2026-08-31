package patientmanagementsystem;

import java.sql.SQLOutput;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PatientQueue {
    private BlockingQueue<Patient> queue = new LinkedBlockingQueue<>();

    public void putPatient(Patient patient) throws InterruptedException {
        queue.put(patient); // producer - patientarrivalgenerator
        System.out.println("[APPOINTMENT PLACED] : "+ patient.getPatientID() + " has placed an appointment and has been added to the queue.");

    }
    public Patient getPatient() throws InterruptedException {
        return queue.take(); //  consumer - consultant

    }
    public int size() {
        return queue.size();
    }
}
