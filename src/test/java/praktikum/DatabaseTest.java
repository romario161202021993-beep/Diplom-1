package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {

    @Spy
    private Database database;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient;

    @Test
    public void availableBunsTest() {
        List<Bun> buns = database.availableBuns();
        assertNotNull(buns);
        assertEquals(3, buns.size());
    }

    @Test
    public void availableIngredientsTest() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertNotNull(ingredients);
        assertEquals(6, ingredients.size());
    }

    @Test
    public void availableBunsWithMockTest() {
        when(database.availableBuns()).thenReturn(Arrays.asList(mockBun));

        List<Bun> buns = database.availableBuns();

        assertEquals(1, buns.size());
        assertEquals(mockBun, buns.get(0));
    }

    @Test
    public void availableIngredientsWithMockTest() {
        when(database.availableIngredients()).thenReturn(Arrays.asList(mockIngredient));

        List<Ingredient> ingredients = database.availableIngredients();

        assertEquals(1, ingredients.size());
        assertEquals(mockIngredient, ingredients.get(0));
    }
}
