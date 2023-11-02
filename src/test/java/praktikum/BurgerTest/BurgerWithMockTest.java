package praktikum.BurgerTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerWithMockTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientSauce;
    @Mock
    Ingredient ingredientFilling;

    @Test
    public void getReceiptShouldPrintReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        Mockito.when(bun.getName()).thenReturn("Булочка");
        Mockito.when(bun.getPrice()).thenReturn(999f);
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientSauce.getName()).thenReturn("Сырный");
        Mockito.when(ingredientSauce.getPrice()).thenReturn(90f);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientFilling.getName()).thenReturn("Говядина");
        Mockito.when(ingredientFilling.getPrice()).thenReturn(200f);
        String newGetReceipt = "(==== Булочка ====)\n" +
                "= sauce Сырный =\n" +
                "= filling Говядина =\n" +
                "(==== Булочка ====)\n" +
                "\nPrice: 2288,000000" + "\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals("В чеке указана неверная информация", newGetReceipt.replace("\r\n", "\n"), actualReceipt.replace("\r\n", "\n"));
    }

    @Test
    public void addIngredientCheck() {
        burger.addIngredient(ingredientSauce);
        List<Ingredient> ingredients = List.of(ingredientSauce);
        Assert.assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void removeIngredientCheck() {
        burger.addIngredient(ingredientSauce);
        Assert.assertTrue(burger.ingredients.contains(ingredientSauce));
        int index = burger.ingredients.indexOf(ingredientSauce);
        burger.removeIngredient(index);
        Assert.assertFalse(burger.ingredients.contains(ingredientSauce));
    }

    @Test
    public void moveIngredientCheck() {
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        int indexSauce = burger.ingredients.indexOf(ingredientSauce);
        int indexFilling = burger.ingredients.indexOf(ingredientFilling);
        List<Ingredient> ingredients = List.of(ingredientSauce, ingredientFilling);
        Assert.assertEquals(ingredients, burger.ingredients);
        burger.moveIngredient(indexSauce, indexFilling);
        List<Ingredient> movedIngredients = List.of(ingredientFilling, ingredientSauce);
        Assert.assertEquals(movedIngredients, burger.ingredients);
    }
}
