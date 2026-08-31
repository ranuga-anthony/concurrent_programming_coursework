package oldsubmissionsystem;

public class Student {

    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean submitExam() {
        try {
            // Simulate time taken to submit exam
            Thread.sleep(200);

            // 95% chance of success
            return Math.random() < 0.95;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

