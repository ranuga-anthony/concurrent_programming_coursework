package patientmanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class HospitalSimulation {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Welcome to the Royal Manchester Hospital PATIENT MANAGEMENT SYSTEM Simulator!");

        int shiftDurationMs = 12000;

        Map<String,PatientQueue> queues = new HashMap<>();
        queues.put("Paediatrician",new PatientQueue());
        queues.put("Surgeon",new PatientQueue());
        queues.put("Cardiologist",new PatientQueue());

        PatientArrivalGenerator patientArrivalGenerator = new PatientArrivalGenerator(queues);
        Thread patientArrivalThread = new Thread(patientArrivalGenerator);
        patientArrivalThread.start();

        ShiftManager manager = new ShiftManager(queues, shiftDurationMs);

        manager.runShift(4); // simulate 2 days

        patientArrivalGenerator.stop();
        patientArrivalThread.interrupt();
        patientArrivalThread.join();

        System.out.println("\n================================================");
        System.out.println("           PATIENT MANAGEMENT SYSTEM SIMULATION COMPLETE");
        System.out.println("================================================");
        queues.forEach((k, v) ->
                System.out.println("Remaining in "+ k + " queue : " + v.size()));
    }


}
