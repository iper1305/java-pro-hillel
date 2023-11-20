package Lombok;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Data
public class HeroLombok {
    private String name;
    private String gender;
    private String eyeColor;
    private String race;
    private String hairColor;
    private double height;
    private String publisher;
    private String skinColor;
    private String alignment;
    private int weight;
}
