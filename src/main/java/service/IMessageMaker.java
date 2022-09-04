package service;

import model.drink.Drink;

public interface IMessageMaker {
    String createMessageForOrder(Drink drink);
    String createNotEnoughMoneyProvidedMessage(Drink drink, double money);
}
