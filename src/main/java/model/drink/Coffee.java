package model.drink;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Coffee extends Drink{
    public Coffee(int sugarQuantity) {
        super(sugarQuantity);
    }

    @Override
    public String getDrinkShortName() {
        return "C";
    }

    @Override
    public String getDrinkFullName() {
        return "coffee";
    }
}
