package service;

import model.drink.Drink;

import static java.math.BigDecimal.ROUND_FLOOR;

public class MessageMaker implements IMessageMaker{
    /**
     * @param drink: drink ordered by customer
     * @return string message to be delivered to the customer
     */
    @Override
    public String createMessageForOrder(Drink drink) {
        String sugarSentence = drink.getSugarQuantity() > 0 ? String.valueOf(drink.getSugarQuantity()) : "no";
        sugarSentence += drink.getSugarQuantity() > 1 ? " sugars" : " sugar";
        String stickSentence = drink.getSugarQuantity() > 0 ? "a stick" : "therefore no stick";
        return String.format("Drink maker makes 1 %s with %s and %s", drink.getDrinkFullName(), sugarSentence, stickSentence);
    }

    @Override
    public String createNotEnoughMoneyProvidedMessage(Drink drink, double money) {
        return String.format("%.1f euro is missing to order 1 %s", (drink.getPrice() - money), drink.getDrinkFullName());
    }
}
