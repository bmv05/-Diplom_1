package praktikum.BurgerTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class BurgerParamTest {
    private final Bun bun;
    private final Ingredient[] ingredients;
    private final float burgerSum;
    private final Burger burger = new Burger();


    public BurgerParamTest(Bun bun, Ingredient[] ingredients, float burgerSum) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.burgerSum = burgerSum;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {index}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {
                        new Bun("Флюоресцентная булка R2-D3", 988),
                        new Ingredient[]{
                                new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90),
                                new Ingredient(IngredientType.SAUCE, "Соус фирменный Space Sauce", 80),
                                new Ingredient(IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337),
                                new Ingredient(IngredientType.FILLING, "Говяжий метеорит (отбивная)", 3000)
                        },
                        6483
                },
                {
                        new Bun("Краторная булка N-200i", 1255),
                        new Ingredient[]{
                                new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15),
                                new Ingredient(IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88),
                                new Ingredient(IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988),
                                new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424)
                        },
                        4025
                },
                {
                        new Bun("Bulka", 900),
                        new Ingredient[]{
                                new Ingredient(IngredientType.SAUCE, "Test1", 15),
                                new Ingredient(IngredientType.SAUCE, "sauce", 888),
                                new Ingredient(IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88),
                                new Ingredient(IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988),
                                new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 300.5f),
                                new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 300.5f),
                                new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 300.5f)
                        },
                        4680.5f
                },
        };
    }

    @Test
    public void setBunsShouldFillBunProperty() {
        burger.setBuns(this.bun);
        Assert.assertEquals(this.bun.getName(), burger.bun.getName());
        Assert.assertEquals(this.bun.getPrice(), burger.bun.getPrice(), 0.1);
    }

    @Test
    public void getPriceRightResult() {
        burger.setBuns(this.bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        Assert.assertEquals(burgerSum, burger.getPrice(), 0.1);
    }

    @Test
    public void getReceiptShouldPrintInformation() {
        burger.setBuns(this.bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burgerSum));

        Assert.assertThat(
                "Возвращается некорректная строка с рецептом",
                burger.getReceipt(),
                equalTo(receipt.toString())
        );
    }
}
