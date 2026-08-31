package submissionsystem;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class SubmissionStats {
    private AtomicInteger successfulSubmissions; // no of successful submissions
    private AtomicInteger failedSubmissions; // no of failed submissions
    private AtomicInteger totalSubmissions; // no of total submissions
    private AtomicLong startTime;
    private AtomicLong endTime;

    public SubmissionStats() {
        this.successfulSubmissions = new AtomicInteger(0);
        this.failedSubmissions = new AtomicInteger(0);
        this.totalSubmissions = new AtomicInteger(0);
        this.startTime = new AtomicLong(0);
        this.endTime = new AtomicLong(0);
    }

    public void recordSuccess(){
        this.successfulSubmissions.incrementAndGet();
        this.totalSubmissions.incrementAndGet();
    }
    public void recordFailures(){
        this.failedSubmissions.incrementAndGet();
        this.totalSubmissions.incrementAndGet();
    }
    public int getSuccessfulSubmissions() {
        return successfulSubmissions.get();
    }
    public int getFailedSubmissions() {
        return failedSubmissions.get();
    }
    public int getTotalSubmissions(){
        return totalSubmissions.get();
    }
    public double getSuccessRate(){
        return (double) getSuccessfulSubmissions()/getTotalSubmissions() * 100;
    }
    public void setStartTime() {
        startTime.set(System.currentTimeMillis());
    }
    public void setEndTime() {
        endTime.set(System.currentTimeMillis());
    }
    public long getTotalTimeMillis() {
        return endTime.get() - startTime.get();
    }

    public void presentStats(){
        System.out.println("\n===== Submission Statistics =====");
        System.out.println("Total Submissions Processed : " + getTotalSubmissions());
        System.out.println("Successful Submissions   : " + getSuccessfulSubmissions());
        System.out.println("Failed Submissions       : " + getFailedSubmissions());
        System.out.printf("Success Rate             : %.2f%%\n", getSuccessRate());
        System.out.println("Total Time Taken         : " + getTotalTimeMillis() + " ms");
        System.out.println("=================================");
    }

}
