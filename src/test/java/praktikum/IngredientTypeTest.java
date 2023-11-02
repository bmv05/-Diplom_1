package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {
    @Test
    public void getSauceIngredientTypeTest() {
        Assert.assertEquals("SAUCE",IngredientType.SAUCE.toString());
    }

    @Test
    public void getFillingIngredientTypeTest() {
        Assert.assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}
