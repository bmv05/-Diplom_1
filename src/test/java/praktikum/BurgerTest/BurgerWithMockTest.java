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

@RunWith(MockitoJUnitRunner.class)
public class BurgerWithMockTest {
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


}
