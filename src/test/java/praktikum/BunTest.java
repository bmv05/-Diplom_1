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

    @Parameterized.Parameters(name = "Тестовые данные: наименование \"{0}\"; Стоимость: {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 998},
                {"Краторная булка N-200i", 116.1f},
        };
    }

    @Test
    public void getNameBunTest() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBunTest() {
        Assert.assertEquals(price, bun.getPrice(), 0.1);
    }
}

