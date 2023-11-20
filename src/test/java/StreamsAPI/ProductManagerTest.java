package StreamsAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductManagerTest {

    List<Product> products;

    @BeforeEach
    void setUp() {
        products = List.of(
                new Product(ProductCategory.BOOK, 50, false, LocalDate.of(2023, 1, 1)),
                new Product(ProductCategory.BOOK, 100, true, LocalDate.of(2023, 2, 1)),
                new Product(ProductCategory.FOOD, 80, true, LocalDate.of(2023, 3, 1)),
                new Product(ProductCategory.ELECTRONICS, 300, false, LocalDate.of(2022, 12, 31)),
                new Product(ProductCategory.BOOK, 75, true, LocalDate.of(2023, 1, 2))
        );
    }

    @Test
    void testGetFilteredProducts() {
        List<Product> result = ProductManager.getFilteredProducts(products);
        assertEquals(1, result.size());
        assertEquals(100, result.get(0).getPrice());
    }

    @Test
    void testGetDiscountedBooks() {
        List<Product> result = ProductManager.getDiscountedBooks(products);
        assertEquals(2, result.size());
        assertEquals(90, result.get(0).getPrice());
        assertEquals(67.5, result.get(1).getPrice());
    }

    @Test
    void testGetCheapestBook() {
        Product result = ProductManager.getCheapestBook(products);
        assertEquals(50, result.getPrice());
    }

    @Test
    void testGetCheapestBookThrowsException() {
        products.removeIf(p -> p.getCategory() == ProductCategory.BOOK);
        assertThrows(NoSuchElementException.class, () -> ProductManager.getCheapestBook(products));
    }

    @Test
    void testGetLastThreeAddedProducts() {
        List<Product> result = ProductManager.getLastThreeAddedProducts(products);
        assertEquals(3, result.size());
        assertEquals(LocalDate.of(2023, 3, 1), result.get(0).getDateAdded());
        assertEquals(LocalDate.of(2023, 2, 1), result.get(1).getDateAdded());
        assertEquals(LocalDate.of(2023, 1, 2), result.get(2).getDateAdded());
    }

    @Test
    void testCalculateTotalCost() {
        double result = ProductManager.calculateTotalCost(products);
        assertEquals(75, result);
    }

    @Test
    void testGroupByCategory() {
        Map<ProductCategory, List<Product>> result = ProductManager.groupByCategory(products);
        assertEquals(3, result.size());
        assertEquals(3, result.get(ProductCategory.BOOK).size());
        assertEquals(1, result.get(ProductCategory.FOOD).size());
        assertEquals(1, result.get(ProductCategory.ELECTRONICS).size());
    }
}
