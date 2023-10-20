package praktikum.BurgerTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class BurgerParamTest {
    private final Bun bun;
    private final Ingredient[] ingredients;
    private final float burgerSum;
    private final Burger burger = new Burger();
    private final String receipt;


    public BurgerParamTest(Bun bun, Ingredient[] ingredients, float burgerSum, String receipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.burgerSum = burgerSum;
        this.receipt = receipt;
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
                        6483,
                        "(==== Флюоресцентная булка R2-D3 ====)\n" +
                                "= sauce Соус Spicy-X =\n" +
                                "= sauce Соус фирменный Space Sauce =\n" +
                                "= filling Мясо бессмертных моллюсков Protostomia =\n" +
                                "= filling Говяжий метеорит (отбивная) =\n" +
                                "(==== Флюоресцентная булка R2-D3 ====)\n" +
                                "\nPrice: 6483,000000\n"
                },
                {
                        new Bun("Краторная булка N-200i", 1255),
                        new Ingredient[]{
                                new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15),
                                new Ingredient(IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88),
                                new Ingredient(IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988),
                                new Ingredient(IngredientType.FILLING, "Биокотлета из марсианской Магнолии", 424)
                        },
                        4025,
                        "(==== Краторная булка N-200i ====)\n" +
                                "= sauce Соус традиционный галактический =\n" +
                                "= sauce Соус с шипами Антарианского плоскоходца =\n" +
                                "= filling Филе Люминесцентного тетраодонтимформа =\n" +
                                "= filling Биокотлета из марсианской Магнолии =\n" +
                                "(==== Краторная булка N-200i ====)\n" +
                                "\nPrice: 4025,000000\n"
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
                        4680,
                        "(==== Bulka ====)\n" +
                                "= sauce Test1 =\n" +
                                "= sauce sauce =\n" +
                                "= sauce Соус с шипами Антарианского плоскоходца =\n" +
                                "= filling Филе Люминесцентного тетраодонтимформа =\n" +
                                "= filling Биокотлета из марсианской Магнолии =\n" +
                                "= filling Биокотлета из марсианской Магнолии =\n" +
                                "= filling Биокотлета из марсианской Магнолии =\n" +
                                "(==== Bulka ====)\n" +
                                "\nPrice: 4680,500000\n"
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
        Assert.assertEquals(receipt, burger.getReceipt());
    }
}
