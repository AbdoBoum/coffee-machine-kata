package model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.drink.Drink;

import java.util.StringJoiner;

@AllArgsConstructor
public class Order {
    @Getter
    private Drink drink;

    public boolean isStickNeeded() {
        return getSugarQuantity() > 0;
    }

    public int getSugarQuantity() {
        return drink.getSugarQuantity();
    }

    @Override
    public String toString() {
        StringJoiner order = new StringJoiner(":");
        order.add(drink.getDrinkShortName())
                .add(isStickNeeded() ? Integer.toString(getSugarQuantity()) : "")
                .add(isStickNeeded() ? "0" : "");
        return order.toString();
    }
}
