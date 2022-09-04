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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderMakerTest {

    @InjectMocks
    private IOrderMaker orderMaker = new OrderMaker();

    @Mock
    private CoffeeMachine coffeeMachine;

    @ParameterizedTest(name = "when order {0} should return {1}")
    @MethodSource("orders")
    public void should_return_instruction_when_ordering_drink(Drink drink, String command) {
        String returnCommande = orderMaker.createOrderFromDrink(drink);
        assertEquals(command, returnCommande);
    }

    @ParameterizedTest(name = "when order {0} should return {1}")
    @MethodSource("messages")
    public void should_return_message_for_ordering_drink(Drink drink, String orderMessage) {
        String returnCommande = orderMaker.createMessageForOrder(drink);
        assertEquals(orderMessage, returnCommande);
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

    private static Stream<Arguments> messages() {
        return Stream.of(
                Arguments.of(new Tea(1), "Drink maker makes 1 tea with 1 sugar and a stick"),
                Arguments.of(new Chocolate(), "Drink maker makes 1 chocolate with no sugar and therefore no stick"),
                Arguments.of(new Coffee(2), "Drink maker makes 1 coffee with 2 sugars and a stick"),
                Arguments.of(new Tea(), "Drink maker makes 1 tea with no sugar and therefore no stick")
        );
    }

}
