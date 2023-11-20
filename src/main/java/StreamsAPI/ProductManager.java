package StreamsAPI;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class ProductManager {
    public static List<Product> getFilteredProducts(List<Product> products) {
        return products.stream()
                .filter(product -> ProductCategory.BOOK.equals(product.getCategory()))
                .filter(product -> product.getPrice() > 250)
                .toList();
    }

    public static List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(product -> ProductCategory.BOOK.equals(product.getCategory()))
                .filter(Product::isDiscountAvailable)
                .map(product -> new Product(
                        product.getCategory(),
                        product.getPrice() * 0.9,
                        product.isDiscountAvailable(),
                        product.getDateAdded())
                )
                .collect(toList());
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(product -> ProductCategory.BOOK.equals(product.getCategory()))
                .min(Comparator.comparing(Product::getPrice) )
                .orElseThrow(() -> new NoSuchElementException("No product with category 'Book' found."));
    }

    public static List<Product> getLastThreeAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .collect(toList());
    }

    public static double calculateTotalCost(List<Product> products) {
        return products.stream()
                .filter(product -> ProductCategory.BOOK.equals(product.getCategory()))
                .filter(product -> product.getDateAdded().getYear() == LocalDate.now().getYear())
                .filter(product -> product.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<ProductCategory, List<Product>> groupByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

}
