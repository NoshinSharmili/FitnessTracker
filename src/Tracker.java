import java.io.Serializable;

// Base Tracker Class
public abstract class Tracker implements Serializable {
    protected String user;

    public Tracker(String user) {
        this.user = user;
    }

    public abstract void addActivity();

    public abstract void logActivity();

    public abstract void viewLogs();
}
