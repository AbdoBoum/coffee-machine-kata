package service;

import lombok.NoArgsConstructor;
import model.drink.Drink;
import model.order.Order;

/**
 * Order Maker is a component that build the messages that will be received by drink maker
 */
@NoArgsConstructor
public class OrderMaker implements IOrderMaker {

    private IMessageMaker messageMaker;
    private CoffeeMachine coffeeMachine;

    public OrderMaker(IMessageMaker messageMaker, CoffeeMachine coffeeMachine) {
        this.messageMaker = messageMaker;
        this.coffeeMachine = coffeeMachine;
    }

    /**
     * @param drink: drink ordered by customer
     * @return string commands to make the drink
     */
    @Override
    public String createOrderFromDrink(Drink drink) {
        Order order = new Order(drink);
        return order.toString();
    }

    @Override
    public String createPaidOrderFromDrink(Drink drink, double money) {
        if (drink.isMoneyEnough(money)) {
            return createOrderFromDrink(drink);
        }
        return messageMaker.createNotEnoughMoneyProvidedMessage(drink, money);
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
