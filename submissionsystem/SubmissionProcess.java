package submissionsystem;

import java.util.concurrent.CountDownLatch;

public class SubmissionProcess implements Runnable {
    private Student student;
    private SubmissionStats stats;
    private CountDownLatch latch;

    public SubmissionProcess(Student student, SubmissionStats stats, CountDownLatch latch) {
        this.student = student;
        this.stats = stats;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            boolean success = student.submitAssignment();

            if (success) {
                System.out.println("Student :  " + student.getName() + " with student id : "
                       + student.getStudentId() + ", submitted assignment successfully.");
                stats.recordSuccess();
            } else {
                System.out.println("Student :  " + student.getName() + " with student id : "
                        + student.getStudentId() + ", submission failed");
                stats.recordFailures();
            }

        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.out.println("Submission process interrupted.");
        } finally {
            latch.countDown();
        }
    }


}
