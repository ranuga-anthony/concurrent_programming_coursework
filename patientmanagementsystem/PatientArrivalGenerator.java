package patientmanagementsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PatientArrivalGenerator implements Runnable {
    private Map<String, PatientQueue> queues; // to store the 3 queues
    private final String[] specialities = {"Paediatrician", "Surgeon", "Cardiologist"}; // fixed specialty types
    private volatile boolean running;
    private int patientId = 1;

    public PatientArrivalGenerator(Map<String, PatientQueue> queues) {
        this.queues = queues;
        this.running = true;
    }

    public void stop(){
        running = false;
    }

    @Override
    public void run(){
        Random random = new Random(); // to create random patient arrivals

        try {
            while (running) {
                String speciality = specialities[random.nextInt(specialities.length)]; // to randomly get a speciality from the specialities array
                Patient patient = new Patient(patientId++,speciality);
                queues.get(speciality).putPatient(patient);
                System.out.println("[ARRIVAL]: Patient " + patient.getPatientID() + " -> " + speciality);
                Thread.sleep(500 + random.nextInt(500)); // random arrivals
            }
        } catch (InterruptedException e) {
            System.out.println("[ARRIVAL] Patient arrival interrupted.");
            Thread.currentThread().interrupt();
        }

    }
}
