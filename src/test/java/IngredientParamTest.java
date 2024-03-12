import data.*;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final String ingredientName;
    private final float ingredientPrice;
    private Ingredient ingredient;
    private final IngredientType ingredientType;

    public IngredientParamTest(IngredientType ingredientType, String ingredientName, float ingredientPrice){
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters(name= "Тип: {0}, название: {1}, цена: {2}")
    public static Object[][] dataForIngredientTest(){
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100f},
                {IngredientType.SAUCE, "sour cream", 200f},
                {IngredientType.SAUCE, "chili sauce", 300f},
                {IngredientType.FILLING, "cutlet", 100f},
                {IngredientType.FILLING, "dinosaur", 200f},
                {IngredientType.FILLING, "sausage", 300f},
                {IngredientType.SAUCE, TestDataRandom.randomName, TestDataRandom.randomPrice},
                {IngredientType.SAUCE, "", 200f},
                {null, "dinosaur", 200f},
                {IngredientType.FILLING, "", 300f},
                {IngredientType.FILLING, "sausage", Float.MIN_VALUE},
                {IngredientType.FILLING, "sausage", Float.MAX_VALUE},
                {null, null, 0},
                {IngredientType.FILLING, "dinosaur", -10f},
        };
        }

    @Before
    public void setTestIngredient(){
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    @Description("Проверка типа ингредиента")
    public void ingredientTypeTest() {
        Assert.assertEquals("Некорректный тип ингредиента", ingredientType, ingredient.getType());
    }

    @Test
    @Description("Проверка названия ингредиента")
    public void ingredientNameTest() {
        Assert.assertEquals("Некорректное название ингредиента", ingredientName, ingredient.getName());
    }

    @Test
    @Description("Проверка цены ингредиента")
    public void ingredientPriceTest() {
        Assert.assertEquals("Некорректная цена ингредиента", ingredientPrice, ingredient.getPrice(), Constants.DELTA);
    }

}
