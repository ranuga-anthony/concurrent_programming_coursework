package submissionsystem;

public class SubmissionSystemSimulation {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Submission System Simulation");
        NewSubmissionSystem newSubmissionSystem = new NewSubmissionSystem( 300);
        newSubmissionSystem.processStudentSubmission();
        newSubmissionSystem.shutdown();
        System.out.println("Ending Submission System Simulation");
    }
}
