package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockSauce;

    @Mock
    private Ingredient mockFilling;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addIngredientAddsToList() {
        burger.addIngredient(mockSauce);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void addIngredientAddsCorrectIngredient() {
        burger.addIngredient(mockSauce);
        assertEquals(mockSauce, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientReducesSize() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientRemovesCorrectItem() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        burger.removeIngredient(0);

        assertEquals(mockFilling, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientChangesFirstPosition() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        burger.moveIngredient(0, 1);

        assertEquals(mockFilling, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientChangesSecondPosition() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        burger.moveIngredient(0, 1);

        assertEquals(mockSauce, burger.ingredients.get(1));
    }

    @Test
    public void getPriceWithBunAndIngredientsTest() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockSauce.getPrice()).thenReturn(50f);
        when(mockFilling.getPrice()).thenReturn(75f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        // ОР: цена = булка*2 + ингредиент1 + ингредиент2
        float expectedPrice = 100f * 2 + 50f + 75f; // = 325
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void getPriceOnlyBunTest() {
        when(mockBun.getPrice()).thenReturn(100f);

        burger.setBuns(mockBun);

        float expectedPrice = 100f * 2;
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceiptTest() {
        when(mockBun.getName()).thenReturn("Краторная булка");
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn("Соус Spicy-X");
        when(mockSauce.getPrice()).thenReturn(50f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);

        String receipt = burger.getReceipt();

        String expectedReceipt = String.format("(==== Краторная булка ====)%n" +
                "= sauce Соус Spicy-X =%n" +
                "(==== Краторная булка ====)%n" +
                "%n" +
                "Price: 250,000000%n");

        assertEquals(expectedReceipt, receipt);
    }
}
