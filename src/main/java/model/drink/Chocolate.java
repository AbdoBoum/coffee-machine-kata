package model.drink;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Chocolate extends Drink {
    public Chocolate(int sugarQuantity){
        super(sugarQuantity);
    }

    @Override
    public String getDrinkShortName() {
        return "H";
    }

    @Override
    public String getDrinkFullName() {
        return "chocolate";
    }
}
