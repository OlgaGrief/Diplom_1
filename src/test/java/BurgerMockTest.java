import data.*;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    Burger burger;
    @Mock
    Bun testBun;
    @Mock
    Ingredient testIngredient;
    @Mock
    Ingredient secondTestIngredient;

    @Before
    public void setBurger() {
        burger = new Burger();
        burger.setBuns(testBun);
    }

    @Test
    @Description("Проверка установки булочки")
    public void setBunTest() {
        assertEquals(testBun,burger.bun);
    }

    @Test
    @Description("Проверка добавления ингредиентов в бургер")
    public void addIngredientTest() {
        burger.addIngredient(testIngredient);
        assertEquals("Ингредиент не добавлен", 1, burger.ingredients.size());
    }

    @Test
    @Description("Проверка удаления ингредиента")
    public void removeIngredientTest() {
        burger.addIngredient(testIngredient);
        burger.removeIngredient(0);
        assertEquals("Ингредиент не удален", 0, burger.ingredients.size());
    }

    @Test
    @Description("Проверка перемещения ингредиентов")
    public void moveIngredientTest() {
        burger.addIngredient(testIngredient);
        burger.addIngredient(secondTestIngredient);
        burger.moveIngredient(0,1);
        assertEquals("Ингредиент не перемещен", testIngredient, burger.ingredients.get(1));
    }

    @Test
    @Description("Проверка стоимости бургера с одним ингредиентом")
    public void getPriceTest() {
        burger.addIngredient(testIngredient);
        Mockito.when(testBun.getPrice()).thenReturn(TestDataRandom.randomPrice);
        Mockito.when(testIngredient.getPrice()).thenReturn(TestDataRandom.randomPrice);
        float expectedPrice = testBun.getPrice()*2 + testIngredient.getPrice();
        assertEquals("Некорректная стоимость бургера",expectedPrice, burger.getPrice(), Constants.DELTA);
        System.out.println("Стоимость бургера: " + burger.getPrice());
    }

    @Test
    @Description("Проверка чека с информацией о бургере")
    public void getReceiptTest() {
        burger.addIngredient(testIngredient);
        Mockito.when(testBun.getName()).thenReturn(TestDataRandom.randomName);
        Mockito.when(testBun.getPrice()).thenReturn(TestDataRandom.randomPrice);
        Mockito.when(testIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(testIngredient.getName()).thenReturn(TestDataRandom.randomName);
        Mockito.when(testIngredient.getPrice()).thenReturn(TestDataRandom.randomPrice);
        String receiptExpected = String.format("(==== %s ====)%n" + "= %s %s =%n" + "(==== %s ====)%n" + "%nPrice: %f%n", testBun.getName(), testIngredient.getType().toString().toLowerCase(), testIngredient.getName(), testBun.getName(), burger.getPrice());
        assertEquals(receiptExpected, burger.getReceipt());
        System.out.println(burger.getReceipt());
    }
}
