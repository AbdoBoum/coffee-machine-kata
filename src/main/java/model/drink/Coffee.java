package model.drink;

public class Coffee extends Drink {
    public Coffee() {
        super(0, 0.6d);
    }

    public Coffee(int sugarQuantity) {
        super(sugarQuantity, 0.6d);
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
