package oldsubmissionsystem;

public class OldSubmissionSystem {
    private final int numberOfStudents;
    private final SubmissionStats stats;

    public OldSubmissionSystem(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        this.stats = new SubmissionStats();
    }

    public void processSubmissions() {

        stats.startTimer();

        for (int i = 1; i <= numberOfStudents; i++) {

            Student student = new Student(i, "Student " + i);
            boolean success = student.submitExam();

            if (success) {
                stats.recordSuccess();
                System.out.println("Student " + i + " submitted successfully");
            } else {
                stats.recordFailure();
                System.out.println("Student " + i + " submission failed");
            }
        }

        stats.endTimer();
        stats.printStats();
    }
}
