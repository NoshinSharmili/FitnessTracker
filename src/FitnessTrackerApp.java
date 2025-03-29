import java.util.*;

// Workout and Sleep Tracker classes (unchanged)


// Main Application
public class FitnessTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "", password;
        boolean authenticated = false;

        while (!authenticated) {
            System.out.println(
                    "   ███████╗███████╗███╗   ██╗███████╗██╗████████╗\n" +
                    "   ╚══███╔╝██╔════╝████╗  ██║██╔════╝██║╚══██╔══╝\n" +
                    "     ███╔╝ █████╗  ██╔██╗ ██║█████╗  ██║   ██║   \n" +
                    "    ███╔╝  ██╔══╝  ██║╚██╗██║██╔══╝  ██║   ██║   \n" +
                    "   ███████╗███████╗██║ ╚████║██║     ██║   ██║   \n" +
                    "   ╚══════╝╚══════╝╚═╝  ╚═══╝╚═╝     ╚═╝   ╚═╝   \n" +
                    "                                              ");

            System.out.println("Welcome to ZENFIT - Your fitness journey starts here!\n");
            System.out.println("1. Login\n2. Register");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();

            if (choice == 1) {
                if (UserAuth.login(username, password)) {
                    authenticated = true;
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else if (choice == 2) {
                if (UserAuth.register(username, password)) {
                    System.out.println("Registration successful! You can now log in.");
                } else {
                    System.out.println("Username already exists.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }

        WorkoutTracker workoutTracker = new WorkoutTracker(username);
        SleepTracker sleepTracker = new SleepTracker(username);

        ProgressTracker progressTracker = new ProgressTracker(username);

        while (true) {
            System.out.println("1. Workout Tracker\n2. Sleep Tracker\n3. Progress Tracker\n4. BMI Calculator\n5. Daily Fitness Tip\n6. Exit");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    while (true) {
                        System.out.println("1. Add Workout\n2. Log Workout\n3. View Workout Logs\n4. Back");
                        int workoutChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (workoutChoice == 1) workoutTracker.addActivity();
                        else if (workoutChoice == 2) workoutTracker.logActivity();
                        else if (workoutChoice == 3) workoutTracker.viewLogs();
                        else if (workoutChoice == 4) break;
                        else System.out.println("Invalid choice");
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("1. Set Sleep Goal\n2. Log Sleep\n3. View Sleep Logs\n4. Back");
                        int sleepChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (sleepChoice == 1) sleepTracker.addActivity();
                        else if (sleepChoice == 2) sleepTracker.logActivity();
                        else if (sleepChoice == 3) sleepTracker.viewLogs();
                        else if (sleepChoice == 4) break;
                        else System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("1. Add Measurement\n2. Log Progress\n3. View Progress Logs\n4. Back");
                        int progressChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (progressChoice == 1) progressTracker.addActivity();
                        else if (progressChoice == 2) progressTracker.logActivity();
                        else if (progressChoice == 3) progressTracker.viewLogs();
                        else if (progressChoice == 4) break;
                        else System.out.println("Invalid choice");
                    }
                    break;
                case 4:
                    BMICalculator.calculateBMI();
                    break;
                case 5: FitnessTips.showRandomTip();
                break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
