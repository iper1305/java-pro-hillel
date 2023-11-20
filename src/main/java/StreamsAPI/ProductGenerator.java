package StreamsAPI;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProductGenerator {
    private static final ProductCategory[] CATEGORIES = ProductCategory.values();
    private static final Random RANDOM = new Random();

    public static List<Product> generateRandomProducts(int numProducts) {
        return IntStream.range(0, numProducts)
                .mapToObj(i -> createRandomProduct())
                .collect(Collectors.toList());
    }

    private static Product createRandomProduct() {
        ProductCategory category = CATEGORIES[RANDOM.nextInt(CATEGORIES.length)];
        double price = 100 + RANDOM.nextDouble() * 400;
        boolean discountAvailable = RANDOM.nextBoolean();
        LocalDate dateAdded = LocalDate.now().minusDays(RANDOM.nextInt(30));

        return new Product(category, price, discountAvailable, dateAdded);
    }

}
