package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тип: {0}, Название: {1}, Цена: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Соус Spicy-X", 50f},
                {IngredientType.FILLING, "Мясо бессмертных моллюсков", 100f},
                {IngredientType.SAUCE, "Соус традиционный галактический", 75f}
        });
    }

    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.001);
    }
}
