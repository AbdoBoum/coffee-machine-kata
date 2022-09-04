package model.drink;

public class Tea extends Drink {
    public Tea() {
        super(0, 0.4d);
    }

    public Tea(int sugarQuantity) {
        super(sugarQuantity, 0.4d);
    }

    public String getDrinkShortName() {
        return "T";
    }

    @Override
    public String getDrinkFullName() {
        return "tea";
    }
}
