package StreamsAPI;
import lombok.*;
import java.time.LocalDate;

@Getter
@ToString
public class Product {
    private ProductCategory category;
    private double price;
    private boolean discountAvailable;
    private LocalDate dateAdded;

    public Product(ProductCategory category, double price, boolean discountAvailable, LocalDate dateAdded) {
        this.category = category;
        this.price = price;
        this.discountAvailable = discountAvailable;
        this.dateAdded = dateAdded;
    }

}
