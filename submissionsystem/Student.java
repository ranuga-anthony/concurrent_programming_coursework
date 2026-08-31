package submissionsystem;

import java.util.Random;

public class Student {
    private int studentId;
    private String name;
    private Random random;
    private static final int simulatedTime = 100;
    private static final double rate = 0.95;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.random = new Random();
    }

    public int getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }

    public boolean submitAssignment() throws InterruptedException {
        int processTimeSimulation = random.nextInt(simulatedTime);
        System.out.println("Submission being processed....");
        Thread.sleep(processTimeSimulation); // Simulate the time that took for the student submission.
        return Math.random() < rate;
    }

}
