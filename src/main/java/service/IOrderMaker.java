package service;

import model.drink.Drink;

public interface IOrderMaker {
    String createOrderFromDrink(Drink drink);
    String createPaidOrderFromDrink(Drink drink, double money);
    void forwardMessageToCoffeeMachine(String message);
}
