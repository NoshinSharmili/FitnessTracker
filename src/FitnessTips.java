import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Fitness Tips Feature
public class FitnessTips {
    private static final String TIPS_FILE = "fitness_tips.txt";

    public static void showRandomTip() {
        List<String> tips = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TIPS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                tips.add(line);
            }
            if (!tips.isEmpty()) {
                Random rand = new Random();
                System.out.println("\nDaily Fitness Tip: " + tips.get(rand.nextInt(tips.size())));
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("No health tips available.");
        }
    }
}
