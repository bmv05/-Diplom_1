package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Burger burger;

    @Test
    public void SetBunsShouldCallOnce() {
        Bun bun = new Bun("Кунжутная", 100);
        //burger.setBuns(bun);
        Assert.assertEquals(
                bun.getName(),
                burger.bun.getName());
    }
}
