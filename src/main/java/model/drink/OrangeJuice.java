package model.drink;

public class OrangeJuice extends Drink{
    public OrangeJuice() {
        super(0, 0.6d, false);
    }

    public OrangeJuice(int sugarQuantity) {
        super(sugarQuantity, 0.6d);
    }

    @Override
    public String getDrinkShortName() {
        return "O";
    }

    @Override
    public String getDrinkFullName() {
        return "orange juice";
    }

    @Override
    public boolean canBeExtraHot() {
        return false;
    }
}
