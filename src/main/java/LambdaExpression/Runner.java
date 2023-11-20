package LambdaExpression;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {
        List<Hero> heroes = CSVParser.parseCSV("src/main/resources/heroes.csv");
        HeroManager heroManager = new HeroManager(heroes);

        double averageHeight = heroManager.averageHeightOfHeroes();
        System.out.println("Average height: " + averageHeight);

        String tallestHero = heroManager.nameOfTallestHero();
        System.out.println("The tallest: " + tallestHero);

        String heaviestHero = heroManager.nameOfHeaviestHero();
        System.out.println("The heaviest: " + heaviestHero);

        Map<String, Long> genderCounts = heroManager.countHeroesByGender();
        System.out.println("Gender counts: " + genderCounts);

        Map<String, Long> alignmentCounts = heroManager.countHeroesByAlignment();
        System.out.println("Alignment counts: " + alignmentCounts);

        List<String> topPublishers = heroManager.topPublishers(5);
        System.out.println("5 most popular publisher: " + topPublishers);

        List<String> topHairColors = heroManager.topHairColors(3);
        System.out.println("3 most popular hair color: " + topHairColors);

        String mostCommonEyeColor = heroManager.mostCommonEyeColor();
        System.out.println("The most popular eye color: " + mostCommonEyeColor);
    }
}
