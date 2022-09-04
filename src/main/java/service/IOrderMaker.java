package service;

import model.drink.Drink;

public interface IOrderMaker {
    String createOrderFromDrink(Drink drink);
    String createMessageForOrder(Drink drink);
    void forwardMessageToCoffeeMachine(String message);
}
