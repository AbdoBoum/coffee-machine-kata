package service;


import model.drink.Chocolate;
import model.drink.Coffee;
import model.drink.Drink;
import model.drink.Tea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class OrderMakerTest {

    @InjectMocks
    private IOrderMaker orderMaker = new OrderMaker();

    @Mock
    private CoffeeMachine coffeeMachine;

    @Mock
    private IMessageMaker messageMaker;

    @ParameterizedTest(name = "when order {0} should return {1}")
    @MethodSource("orders")
    public void should_return_instruction_when_ordering_drink(Drink drink, String command) {
        String returnCommande = orderMaker.createOrderFromDrink(drink);
        assertEquals(command, returnCommande);
    }

    @ParameterizedTest(name = "when order {0} and pay {1} should return {2}")
    @MethodSource("paidOrders")
    public void should_return_instruction_when_ordering_paid_drink(Drink drink, double money, String command) {
        Mockito.when(messageMaker.createNotEnoughMoneyProvidedMessage(drink, money)).thenReturn(String.format("%.1f euro is missing to order 1 %s", (drink.getPrice() - money), drink.getDrinkFullName()));
        String returnCommande = orderMaker.createPaidOrderFromDrink(drink, money);
        assertEquals(command, returnCommande);
    }

    @Test
    public void should_forward_message_to_coffee_machine() {
        orderMaker.forwardMessageToCoffeeMachine("message received");
        verify(coffeeMachine).receive("M:message received");
    }

    private static Stream<Arguments> orders() {
        return Stream.of(
                Arguments.of(new Tea(1), "T:1:0"),
                Arguments.of(new Chocolate(), "H::"),
                Arguments.of(new Coffee(2), "C:2:0"),
                Arguments.of(new Tea(), "T::")
        );
    }

    private static Stream<Arguments> paidOrders() {
        return Stream.of(
                Arguments.of(new Tea(1), 0.4d, "T:1:0"),
                Arguments.of(new Chocolate(), 0.7d, "H::"),
                Arguments.of(new Coffee(2), 0.1d, "0,5 euro is missing to order 1 coffee"),
                Arguments.of(new Tea(), 0.5d, "T::"),
                Arguments.of(new Chocolate(), 0.2d, "0,3 euro is missing to order 1 chocolate")
        );
    }

}
