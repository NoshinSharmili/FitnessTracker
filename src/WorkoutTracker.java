import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Workout Tracker
public class WorkoutTracker extends Tracker {
    private FileHandler fileHandler;
    private List<Workout> workouts;

    public WorkoutTracker(String user) {
        super(user);
        this.fileHandler = new FileHandler(user + "_workouts.ser");
        this.workouts = (List<Workout>) fileHandler.readLogs();
        if (workouts == null) {
            workouts = new ArrayList<>();
        }
    }

    @Override
    public void addActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter workout name: ");
        String name = scanner.nextLine();
        System.out.print("Enter sets: ");
        int sets = scanner.nextInt();
        System.out.print("Enter reps: ");
        int reps = scanner.nextInt();
        scanner.nextLine();

        workouts.add(new Workout(name, sets, reps));
        fileHandler.writeLog(workouts);
    }

    @Override
    public void logActivity() {
        Scanner scanner = new Scanner(System.in);
        if (workouts.isEmpty()) {
            System.out.println("No workouts found. Add a workout first.");
            return;
        }
        System.out.println("Select a workout to log:");
        for (int i = 0; i < workouts.size(); i++) {
            System.out.println((i + 1) + ". " + workouts.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= workouts.size()) {
            workouts.get(choice - 1).logWorkout();
            fileHandler.writeLog(workouts);
            System.out.println("Workout logged successfully!");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    @Override
    public void viewLogs() {
        if (workouts.isEmpty()) {
            System.out.println("No workouts logged yet.");
            return;
        }
        for (Workout workout : workouts) {
            System.out.println("Workout: " + workout);
            for (String log : workout.getLogs()) {
                System.out.println("  - " + log);
            }
        }
    }
}
