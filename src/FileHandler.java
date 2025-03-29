import java.io.*;

// Serializable FileHandler
public class FileHandler implements Logger {
    private String filename;

    public FileHandler(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeLog(Object data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }
    }

    @Override
    public Object readLogs() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
