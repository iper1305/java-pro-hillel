package LambdaExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;

public class HeroManagerTest {

    private HeroManager heroManager;

    @BeforeEach
    void setUp() {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero(1, "Hero1", "Male", "Blue", "Human", "Blonde", 180.0, "Publisher1", "White", "Good", 80));
        heroes.add(new Hero(2, "Hero2", "Female", "Green", "Alien", "Black", 170.0, "Publisher2", "Green", "Evil", 70));
        heroes.add(new Hero(3, "Hero3", "Male", "Brown", "Human", "Brown", 171.0, "Publisher1", "White", "Good", 90));
        heroes.add(new Hero(4, "Hero4", "Female", "Blue", "Human", "Blonde", 160.0, "Publisher1", "White", "Good", 65));
        heroManager = new HeroManager(heroes);
    }

    @Test
    void testAverageHeightOfHeroes() {
        double averageHeight = heroManager.averageHeightOfHeroes();
        assertEquals(170.25, averageHeight, 0.01);
    }

    @Test
    void testNameOfTallestHero() {
        String tallestHero = heroManager.nameOfTallestHero();
        assertEquals("Hero1", tallestHero);
    }

    @Test
    void testNameOfHeaviestHero() {
        String heaviestHero = heroManager.nameOfHeaviestHero();
        assertEquals("Hero3", heaviestHero);
    }

    @Test
    void testCountHeroesByGender() {
        Map<String, Long> genderCount = heroManager.countHeroesByGender();
        assertEquals(2, genderCount.get("Male"));
        assertEquals(2, genderCount.get("Female"));
    }

    @Test
    void testCountHeroesByAlignment() {
        Map<String, Long> alignmentCount = heroManager.countHeroesByAlignment();
        assertEquals(3, alignmentCount.get("Good"));
        assertEquals(1, alignmentCount.get("Evil"));
    }

    @Test
    void testCountHeroesByRace() {
        Map<String, Long> raceCount = heroManager.countHeroesByRace();
        assertEquals(3, raceCount.get("Human"));
        assertEquals(1, raceCount.get("Alien"));
    }

    @Test
    void testCountHeroesBySkinColor() {
        Map<String, Long> skinColorCount = heroManager.countHeroesBySkinColor();
        assertEquals(3, skinColorCount.get("White"));
        assertEquals(1, skinColorCount.get("Green"));
    }

    @Test
    void testCountHeroesByHairColor() {
        Map<String, Long> hairColorCount = heroManager.countHeroesByHairColor();
        assertEquals(2, hairColorCount.get("Blonde"));
        assertEquals(1, hairColorCount.get("Black"));
        assertEquals(1, hairColorCount.get("Brown"));
    }

    @Test
    void testMostCommonEyeColor() {
        String mostCommonEyeColor = heroManager.mostCommonEyeColor();
        assertEquals("Blue", mostCommonEyeColor);
    }

    @Test
    void testTopPublishers() {
        List<String> topPublishers = heroManager.topPublishers(2);
        assertEquals(2, topPublishers.size());
        assertEquals("Publisher1", topPublishers.get(0));
        assertEquals("Publisher2", topPublishers.get(1));
    }

    @Test
    void testTopHairColors() {
        List<String> topHairColors = heroManager.topHairColors(2);
        assertEquals(2, topHairColors.size());
        assertEquals("Blonde", topHairColors.get(0));
        assertEquals("Brown", topHairColors.get(1));
    }
}


