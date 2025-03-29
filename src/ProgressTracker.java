import java.util.*;

public class ProgressTracker extends Tracker {
    private FileHandler fileHandler;
    private Map<String, String> measurements;
    private List<String> progressLogs;

    public ProgressTracker(String user) {
        super(user);
        this.fileHandler = new FileHandler(user + "_progress.ser");
        Object data = fileHandler.readLogs();
        if (data instanceof Map) {
            measurements = (Map<String, String>) data;
        } else {
            measurements = new HashMap<>();
        }
        progressLogs = new ArrayList<>();
    }

    @Override
    public void addActivity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter measurement type (e.g., Weight, Waist size): ");
        String type = scanner.nextLine();
        System.out.print("Enter unit (e.g., kg, cm): ");
        String unit = scanner.nextLine();
        measurements.put(type, unit);
        fileHandler.writeLog(measurements);
        System.out.println("Measurement added successfully!");
    }

    @Override
    public void logActivity() {
        if (measurements.isEmpty()) {
            System.out.println("No measurements found. Add one first.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available measurements:");
        for (String type : measurements.keySet()) {
            System.out.println("- " + type + " (" + measurements.get(type) + ")");
        }
        System.out.print("Enter measurement type to log: ");
        String type = scanner.nextLine();
        if (!measurements.containsKey(type)) {
            System.out.println("Invalid measurement type.");
            return;
        }
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();
        scanner.nextLine();
        String logEntry = type + ": " + value + " " + measurements.get(type) + " on " + new Date();
        progressLogs.add(logEntry);
        fileHandler.writeLog(progressLogs);
        System.out.println("Progress logged successfully!");
    }

    @Override
    public void viewLogs() {
        if (progressLogs.isEmpty()) {
            System.out.println("No progress logs available.");
            return;
        }
        progressLogs.forEach(System.out::println);
    }
}
