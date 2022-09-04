package service;

import model.drink.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageMakerTest {
    private IMessageMaker messageMaker;

    @BeforeEach
    public void init() {
        messageMaker = new MessageMaker();
    }

    @ParameterizedTest(name = "when order {0} should return {1}")
    @MethodSource("messages")
    public void should_return_message_for_ordering_drink(Drink drink, String orderMessage) {
        String returnCommande = messageMaker.createMessageForOrder(drink);
        assertEquals(orderMessage, returnCommande);
    }

    @Test
    public void should_return_message_not_enough_money() {
        String message = messageMaker.createNotEnoughMoneyProvidedMessage(new Tea(1), 0.1d);
        assertEquals("0,3 euro is missing to order 1 tea", message);
    }

    private static Stream<Arguments> messages() {
        Tea tea = new Tea(2); tea.setExtraHot();
        return Stream.of(
                Arguments.of(new Tea(1), "Drink maker makes 1 tea with 1 sugar and a stick"),
                Arguments.of(new Chocolate(), "Drink maker makes 1 chocolate with no sugar and therefore no stick"),
                Arguments.of(new Coffee(2), "Drink maker makes 1 coffee with 2 sugars and a stick"),
                Arguments.of(new Tea(), "Drink maker makes 1 tea with no sugar and therefore no stick"),
                Arguments.of(new Tea(), "Drink maker makes 1 tea with no sugar and therefore no stick"),
                Arguments.of(new OrangeJuice(), "Drink maker makes 1 orange juice with no sugar and therefore no stick"),
                Arguments.of(tea, "Drink maker makes an extra hot tea with 2 sugars and a stick")
        );
    }


}
