package LambdaExpression;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroManager {
    private List<Hero> heroes;

    public HeroManager(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public double averageHeightOfHeroes() {
        return heroes.stream()
                .filter(hero -> hero.height() > 0)
                .mapToDouble(Hero::height)
                .average()
                .orElse(0);
    }

    public String nameOfTallestHero() {
        return heroes.stream()
                .max(Comparator.comparingDouble(Hero::height))
                .map(Hero::name)
                .orElse("");
    }

    public String nameOfHeaviestHero() {
        return heroes.stream()
                .max(Comparator.comparingInt(Hero::weight))
                .map(Hero::name)
                .orElse("");
    }

    public Map<String, Long> countHeroesByGender() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::gender, Collectors.counting()));
    }

    public Map<String, Long> countHeroesByAlignment() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::alignment, Collectors.counting()));
    }

    public Map<String, Long> countHeroesByRace() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::race, Collectors.counting()));
    }

    public Map<String, Long> countHeroesBySkinColor() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::skinColor, Collectors.counting()));
    }

    public Map<String, Long> countHeroesByHairColor() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::hairColor, Collectors.counting()));
    }

    public String mostCommonEyeColor() {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::eyeColor, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public List<String> topPublishers(int n) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::publisher, Collectors.counting()))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> topHairColors(int n) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::hairColor, Collectors.counting()))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}


