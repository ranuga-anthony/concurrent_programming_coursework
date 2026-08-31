package patientmanagementsystem;

import java.util.Random;

public class Consultant implements Runnable {
    private int consultantID;
    private String specialty;
    private PatientQueue queue;
    public volatile boolean running = true;
    public Consultant(int consultantID, String specialty, PatientQueue queue) {
        this.consultantID = consultantID;
        this.specialty = specialty;
        this.queue = queue;
    }
    @Override
    public void run() {

        try {
            while (running) {
                Patient patient = queue.getPatient();
                System.out.println("[NOW TREATING]: " + "Consultant " + specialty + " treating patient: " + patient.getPatientID());
                Random random = new Random();
                Thread.sleep(2000 + random.nextInt(500)); // simulate treatment time
                System.out.println("[DONE]: Patient: " + patient.getPatientID() + " treated by Consultant " + specialty);
            }
        } catch (InterruptedException e) {
            System.out.println("[SHIFT OVER]: Consultant " + specialty + " shift over");
            Thread.currentThread().interrupt();
        }

    }
}
