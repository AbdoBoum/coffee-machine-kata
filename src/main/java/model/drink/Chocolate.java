package model.drink;

public class Chocolate extends Drink {

    public Chocolate() {
        super(0, 0.5d);
    }

    public Chocolate(int sugarQuantity) {
        super(sugarQuantity, 0.5d);
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
