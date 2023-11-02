package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private IngredientType type;
    private String name;
    private float price;
    private final Ingredient ingredient;


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
        ingredient = new Ingredient(type, name, price);
    }

    @Parameterized.Parameters(name = "Тестовые данные: Модель ингредиента \"{0}\"; Название \"{1}\"; Цена {2}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус фирменный Space Sauce", 0},
                {IngredientType.FILLING, "Говяжий метеорит (отбивная)", 11134},
        };
    }

    @Test
    public void getTypeIngredientTest() {
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void getNameIngredientTest() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceIngredientTest() {
        Assert.assertEquals(price, ingredient.getPrice(), 0.005);
    }
}

