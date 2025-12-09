package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeSauceTest() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void ingredientTypeFillingTest() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}
