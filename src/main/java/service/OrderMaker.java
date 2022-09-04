package service;

import model.drink.Drink;
import model.order.Order;

/**
 * Order Maker is a component that build the messages that will be received by drink maker
 */
public class OrderMaker implements IOrderMaker {

    private CoffeeMachine coffeeMachine;

    /**
     * @param drink: drink ordered by customer
     * @return string commands to make the drink
     */
    @Override
    public String createOrderFromDrink(Drink drink) {
        Order order = new Order(drink);
        return order.toString();
    }

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

    /**
     * forwards any message received
     * 				onto the coffee machine interface
     * @param message: message to be forwarded to coffee machine
     */
    @Override
    public void forwardMessageToCoffeeMachine(String message) {
        coffeeMachine.receive("M:" + message);
    }
}
