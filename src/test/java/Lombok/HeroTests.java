package Lombok;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTests {

    @Test
    public void testHeroBuilder() {
        HeroBuilder hero = HeroBuilder.builder()
                .name("Superman")
                .gender("Male")
                .eyeColor("Blue")
                .race("Kryptonian")
                .hairColor("Black")
                .height(6.2)
                .publisher("DC Comics")
                .skinColor("Fair")
                .alignment("Good")
                .weight(225)
                .build();

        assertEquals("Superman", hero.getName());
        assertEquals("Male", hero.getGender());
        assertEquals("Blue", hero.getEyeColor());
        assertEquals("Kryptonian", hero.getRace());
        assertEquals("Black", hero.getHairColor());
        assertEquals(6.2, hero.getHeight());
        assertEquals("DC Comics", hero.getPublisher());
        assertEquals("Fair", hero.getSkinColor());
        assertEquals("Good", hero.getAlignment());
        assertEquals(225, hero.getWeight());
    }

    @Test
    public void testHeroLombok() {
        HeroLombok hero = new HeroLombok(
                "Wonder Woman",
                "Female",
                "Blue",
                "Amazonian",
                "Black",
                6.0,
                "DC Comics",
                "Fair",
                "Good",
                140
        );

        assertEquals("Wonder Woman", hero.getName());
        assertEquals("Female", hero.getGender());
        assertEquals("Blue", hero.getEyeColor());
        assertEquals("Amazonian", hero.getRace());
        assertEquals("Black", hero.getHairColor());
        assertEquals(6.0, hero.getHeight());
        assertEquals("DC Comics", hero.getPublisher());
        assertEquals("Fair", hero.getSkinColor());
        assertEquals("Good", hero.getAlignment());
        assertEquals(140, hero.getWeight());
    }

    @Test
    public void testHeroValue() {
        HeroValue hero = new HeroValue(
                "Spider-Man",
                "Male",
                "Hazel",
                "Human",
                "Brown",
                5.10,
                "Marvel Comics",
                "Fair",
                "Neutral",
                167
        );

        assertEquals("Spider-Man", hero.getName());
        assertEquals("Male", hero.getGender());
        assertEquals("Hazel", hero.getEyeColor());
        assertEquals("Human", hero.getRace());
        assertEquals("Brown", hero.getHairColor());
        assertEquals(5.10, hero.getHeight());
        assertEquals("Marvel Comics", hero.getPublisher());
        assertEquals("Fair", hero.getSkinColor());
        assertEquals("Neutral", hero.getAlignment());
        assertEquals(167, hero.getWeight());
    }
}


