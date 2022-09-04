package model.drink;

import lombok.*;

@NoArgsConstructor
public abstract class Drink {

    private String shortName;
    @Getter @Setter
    private int sugarQuantity;

    public Drink(int sugarQuantity) {
        this.sugarQuantity = sugarQuantity;
    }

    public abstract String getDrinkShortName();

    public abstract String getDrinkFullName();
}
