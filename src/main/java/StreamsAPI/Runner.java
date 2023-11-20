package StreamsAPI;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import static StreamsAPI.ProductGenerator.generateRandomProducts;
import static StreamsAPI.ProductManager.*;

public class Runner {
    public static void main(String[] args) {
        // 1. Реалізувати метод отримання всіх продуктів у вигляді списку, категорія яких
        // еквівалентна “Book” та ціна більш ніж 250.

        List<Product> products = generateRandomProducts(20);
        List<Product> filteredProducts = getFilteredProducts(products);
        filteredProducts.forEach(System.out::println);

        // 2. Реалізувати метод отримання всіх продуктів як списку, категорія яких еквівалентна “Book”
        // і з можливістю застосування знижки. Фінальний список повинен містити продукти з застосованою знижкою 10%.

        List<Product> discountedBooks = getDiscountedBooks(products);
        discountedBooks.forEach(System.out::println);

        // 3. Реалізувати метод отримання найдешевшого продукту з категорії “Book”

        try {
            Product cheapestBook = getCheapestBook(products);
            System.out.println("The cheapest book is: " + cheapestBook);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        // 4. Реалізувати метод отримання трьох останніх доданих продуктів

        List<Product> lastThreeAdded = getLastThreeAddedProducts(products);
        lastThreeAdded.forEach(System.out::println);

        // 5. Реалізувати метод калькуляції загальної вартості продуктів, які відповідають наступним критеріям:
        //- продукт додано протягом поточного року
        //- продукт має тип “Book”
        //- ціна продукту не перевищує 75

        double totalCost = calculateTotalCost(products);
        System.out.println("The total cost of products added this year of type 'Book' and price not exceeding 75 is: " + totalCost);

        //  6. Реалізувати метод групування об'єктів за типом продукту.
        //  Таким чином результатом виконання методу буде тип даних “Словник”, що зберігає пару ключ-значення: {тип: список_продуктів}

        Map<ProductCategory, List<Product>> groupedByCategory = groupByCategory(products);
        groupedByCategory.forEach((key, value) -> {
            System.out.println("Category: " + key);
            value.forEach(System.out::println);
        });
    }

}
