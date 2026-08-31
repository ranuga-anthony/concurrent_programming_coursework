package patientmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShiftManager {
    private Map<String, PatientQueue> queue ;
    private int shiftDuration;
    private boolean dayShift = true;

    public ShiftManager(Map<String, PatientQueue> queue, int shiftDuration) {
        this.queue = queue;
        this.shiftDuration = shiftDuration;
    }

    public void runShift(int noOfShifts) throws InterruptedException {
        for (int i = 0; i < noOfShifts; i++) {
            System.out.println("\n===" + (dayShift?"DAY":"NIGHT") + " SHIFT START ===");
            List<Thread> consultants = startConsultants();
            Thread.sleep(shiftDuration);
            dayShift = !dayShift;
            stopConsultants(consultants);
        }

    }

    public List<Thread> startConsultants(){
        List<Thread> threads = new ArrayList<>();

        for( String speciality : queue.keySet()){
            Consultant consultant = new Consultant(1,speciality,queue.get(speciality));
            Thread consultantThread = new Thread(consultant);
            consultantThread.start();
            threads.add(consultantThread);
        }
        return threads;
    }

    public void stopConsultants(List<Thread> consultants) throws InterruptedException {
        for( Thread thread : consultants){
            thread.interrupt();
        }
        for( Thread thread : consultants){
            thread.join();
        }
    }
}
