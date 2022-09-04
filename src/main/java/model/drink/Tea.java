package model.drink;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Tea extends
        Drink {

    public Tea(int sugarQuantity) {
        super(sugarQuantity);
    }

    public String getDrinkShortName() {
        return "T";
    }

    @Override
    public String getDrinkFullName() {
        return "tea";
    }
}
