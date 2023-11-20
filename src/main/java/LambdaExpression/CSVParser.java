package LambdaExpression;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static List<Hero> parseCSV(String filePath) {
        List<Hero> heroes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(";");
                if (data.length == 11) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String gender = data[2];
                    String eyeColor = data[3];
                    String race = data[4];
                    String hairColor = data[5];
                    double height = Double.parseDouble(data[6].replace(",", "."));
                    String publisher = data[7];
                    String skinColor = data[8];
                    String alignment = data[9];
                    int weight = Integer.parseInt(data[10]);
                    Hero hero = new Hero(id, name, gender, eyeColor, race, hairColor, height, publisher, skinColor, alignment, weight);
                    heroes.add(hero);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return heroes;
    }

}
