import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Sleep Tracker
public class SleepTracker extends Tracker {
    private FileHandler fileHandler;
    private List<String> sleepLogs;
    private int targetSleepDuration;

    public SleepTracker(String user) {
        super(user);
        this.fileHandler = new FileHandler(user + "_sleep.ser");
        this.sleepLogs = (List<String>) fileHandler.readLogs();
        if (sleepLogs == null) {
            sleepLogs = new ArrayList<>();
        }
    }

    @Override
    public void addActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your target sleep duration (hours): ");
        targetSleepDuration = scanner.nextInt();
        scanner.nextLine();
        fileHandler.writeLog(sleepLogs);
    }

    @Override
    public void logActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sleep start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter wake-up time (HH:mm): ");
        String wakeTime = scanner.nextLine();
        System.out.print("Enter sleep duration (hours): ");
        int sleepDuration = scanner.nextInt();
        scanner.nextLine();

        String logEntry = "Sleep Log: " + new Date() + " - Start: " + startTime + " - Wake: " + wakeTime + " - Duration: " + sleepDuration + "h";
        sleepLogs.add(logEntry);
        fileHandler.writeLog(sleepLogs);

        if (sleepDuration >= targetSleepDuration) {
            System.out.println("Great job! You've met your sleep goal!");
        } else {
            System.out.println("You missed your goal by " + (targetSleepDuration - sleepDuration) + " hours.");
        }
    }

    @Override
    public void viewLogs() {
        if (sleepLogs.isEmpty()) {
            System.out.println("No sleep logs available.");
            return;
        }
        sleepLogs.forEach(System.out::println);
    }
}
