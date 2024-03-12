import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParamTest {
    private final String ingredientType;

    public IngredientTypeParamTest(String ingredientType){
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name= "Ингридиент: {0}")
    public static Object[][] getIngredientType() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
        public void testIngredientType() {
        assertEquals("Тип ингредиента не совпадает", ingredientType, IngredientType.valueOf(ingredientType).toString());
    }
}
