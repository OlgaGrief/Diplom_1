import Data.Constants;
import Data.TestDataRandom;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String testBunName;
    private final float testBunPrice;
    private Bun bun;

    public BunParamTest(String testName, float testPrice) {
        this.testBunName = testName;
        this.testBunPrice = testPrice;
    }

    @Parameterized.Parameters(name= "Название: {0}, цена: {1}")
    public static Object[][] dataForBunTest(){
        return new Object[][]{
                {"black bun", 100f},
                {"white bun", 200f},
                {"red bun", 300f},
                {TestDataRandom.randomName, TestDataRandom.randomPrice},
                {"", 300f},
                {"", Float.MIN_VALUE},
                {null, 50f},
                {"name", -10.0f},
                {"name", Float.MAX_VALUE},
                {"name", Float.MIN_VALUE},
                {"namenamenamenamenamenamenamenamenamenamenamenamenamename", 100f},
        };
    }

    @Before
    public void setTestBun(){
        bun = new Bun(testBunName, testBunPrice);
    }

    @Test
    @Description("Проверка названия булочки")
    public void bunNameTest() {
        Assert.assertEquals("Некорректное название булочки", testBunName, bun.getName());
    }

    @Test
    @Description("Проверка цены булочки")
    public void bunPriceTest() {
        Assert.assertEquals("Некорректная цена булочки", testBunPrice, bun.getPrice(), Constants.DELTA);
    }
}
