import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Workout Class to store details
public class Workout implements Serializable {
    private String name;
    private int sets;
    private int reps;
    private List<String> logs;

    public Workout(String name, int sets, int reps) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.logs = new ArrayList<>();
    }

    public void logWorkout() {
        String logEntry = name + ": " + new Date() + " - Sets: " + sets + " - Reps: " + reps;
        logs.add(logEntry);
    }

    public List<String> getLogs() {
        return logs;
    }

    @Override
    public String toString() {
        return name + " (" + sets + " sets, " + reps + " reps)";
    }
}
