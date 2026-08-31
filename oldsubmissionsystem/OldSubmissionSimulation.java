package oldsubmissionsystem;

public class OldSubmissionSimulation {
    public static void main(String[] args) {

        int numberOfStudents = 300;

        OldSubmissionSystem system = new OldSubmissionSystem(numberOfStudents);

        system.processSubmissions();
    }
}
