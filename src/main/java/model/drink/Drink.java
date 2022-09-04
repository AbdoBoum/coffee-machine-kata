package model.drink;

import lombok.*;

public abstract class Drink {

    private String shortName;
    @Getter @Setter
    private int sugarQuantity;
    @Getter
    private double price; // for simplicity we use double instead of BigDecimal
    @Getter
    private boolean extraHot;

    public Drink(int sugarQuantity, double price) {
        this.sugarQuantity = sugarQuantity;
        this.price = price;
        this.extraHot = false;
    }

    public Drink(int sugarQuantity, double price, boolean extraHot) {
        this.sugarQuantity = sugarQuantity;
        this.price = price;
        this.extraHot = extraHot;
    }

    public abstract String getDrinkShortName();

    public abstract String getDrinkFullName();

    public boolean canBeExtraHot() {
        return true;
    }

    public boolean isMoneyEnough(double money) {
        return money >= price;
    }

    public void setExtraHot() {
        if (canBeExtraHot())
            extraHot = true;
    }

    public String getNameWithTemperature() {
        return getDrinkShortName() + (extraHot ? "h":"");
    }
}
