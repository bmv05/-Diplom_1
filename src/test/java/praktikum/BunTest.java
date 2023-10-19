package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private final Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
        bun = new Bun(name, price);
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Космос", 1000},
                {"Space", 11.1f},
                {"Луна", -555},
                {"облачко", 0},
                {"пыль", -0},
        };
    }

    @Test
    public void getNameBun() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBun() {
        Assert.assertEquals(price, bun.getPrice(), 0.1);
    }
}

