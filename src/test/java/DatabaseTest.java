import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

public class DatabaseTest {
    Database database = new Database();

    @Test
    @Description("Проверка размера списка доступных булочек")
    public void availableBunsTest() {
        List<Bun> buns = database.availableBuns();
        Assert.assertEquals("Некорректный размер списка", 3, database.availableBuns().size());
    }
    @Test
    @Description("Проверка размера списка доступных ингредиентов")
    public void availableIngredientsTest() {
        List<Ingredient> ingredients = database.availableIngredients();
        Assert.assertEquals("Некорректный размер списка", 6, database.availableIngredients().size());
    }
}
