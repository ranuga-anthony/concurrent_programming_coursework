package submissionsystem;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewSubmissionSystem {
    private final int numOfStudents;
    private final int poolSize = Runtime.getRuntime().availableProcessors() * 2;
    private SubmissionStats stats;
    private ExecutorService executor;

    public NewSubmissionSystem( int numOfStudents) {
        this.stats = new SubmissionStats();
        this.numOfStudents = numOfStudents;
    }

    public void processStudentSubmission(){
        executor = Executors.newFixedThreadPool(poolSize);
        CountDownLatch latch = new CountDownLatch(numOfStudents);

        stats.setStartTime();

        for (int i = 1; i <= numOfStudents; i++) {
            Student student = new Student(i,"Student "+i);
            SubmissionProcess task = new SubmissionProcess(student, stats, latch);
            executor.submit(task);
        }
        try{
            System.out.println("Waiting for all submissions to be finished...");
            latch.await(); // Wait until countDownLatch = 0
            System.out.println("All submissions finished");
            stats.setEndTime();
            stats.presentStats();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public int getNumOfStudents() {
        return numOfStudents;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void shutdown() throws InterruptedException {
        System.out.println("Shutting down...");
        executor.shutdown();
        if(!executor.awaitTermination(30, TimeUnit.SECONDS)){
            executor.shutdownNow();
        }
        System.out.println("Submission System shut down");
    }
}
