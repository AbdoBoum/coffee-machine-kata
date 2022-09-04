package model.drink;

import lombok.*;

public abstract class Drink {

    private String shortName;
    @Getter @Setter
    private int sugarQuantity;
    @Getter
    private double price; // for simplicity we use double instead of BigDecimal

    public Drink(int sugarQuantity, double price) {
        this.sugarQuantity = sugarQuantity;
        this.price = price;
    }

    public abstract String getDrinkShortName();

    public abstract String getDrinkFullName();

    public boolean isMoneyEnough(double money) {
        return money >= price;
    }
}
