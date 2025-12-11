package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private final float bunPrice;
    private final float ingredient1Price;
    private final float ingredient2Price;
    private final float expectedTotal;

    public BurgerParameterizedTest(float bunPrice, float ingredient1Price,
                                   float ingredient2Price, float expectedTotal) {
        this.bunPrice = bunPrice;
        this.ingredient1Price = ingredient1Price;
        this.ingredient2Price = ingredient2Price;
        this.expectedTotal = expectedTotal;
    }

    @Parameterized.Parameters(name = "Булка: {0}, Ингр1: {1}, Ингр2: {2}, Итого: {3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {100f, 50f, 75f, 325f},    // стандартный кейс
                {200f, 100f, 150f, 650f},  // дорогие ингредиенты
                {50f, 25f, 25f, 150f},     // дешевые ингредиенты
                {0f, 0f, 0f, 0f}           // бесплатный бургер
        });
    }

    @Test
    public void getPriceParameterizedTest() {
        Burger burger = new Burger();

        Bun mockBun = mock(Bun.class);
        Ingredient mockIngredient1 = mock(Ingredient.class);
        Ingredient mockIngredient2 = mock(Ingredient.class);

        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockIngredient1.getPrice()).thenReturn(ingredient1Price);
        when(mockIngredient2.getPrice()).thenReturn(ingredient2Price);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        assertEquals(expectedTotal, burger.getPrice(), 0.001);
    }
}
