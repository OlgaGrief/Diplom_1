import Data.Constants;
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;

public class BunTest {
    Database database = new Database();
    Bun bun = new Bun(database.availableBuns().get(1).getName(), database.availableBuns().get(1).getPrice());

    @Test
    public void getNameTest(){
        Assert.assertEquals("white bun", bun.getName());
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals(200, bun.getPrice(), Constants.DELTA);
    }
}
