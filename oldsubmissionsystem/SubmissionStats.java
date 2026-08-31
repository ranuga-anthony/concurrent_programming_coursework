package oldsubmissionsystem;

public class SubmissionStats {

    private int successful;
    private int failed;
    private long startTime;
    private long endTime;

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public void endTimer() {
        endTime = System.currentTimeMillis();
    }

    public void recordSuccess() {
        successful++;
    }

    public void recordFailure() {
        failed++;
    }

    public int getTotal() {
        return successful + failed;
    }

    public long getTotalTime() {
        return endTime - startTime;
    }

    public void printStats() {
        System.out.println("\n=== OLD SUBMISSION SYSTEM STATS ===");
        System.out.println("Total submissions : " + getTotal());
        System.out.println("Successful        : " + successful);
        System.out.println("Failed            : " + failed);
        System.out.println("Time taken (ms)   : " + getTotalTime());
    }
}

