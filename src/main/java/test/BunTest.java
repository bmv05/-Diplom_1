package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun bun;

    @Test
    public void getNameReturnName(){
        bun.getName();
        bun.getPrice();
        Mockito.verify(bun, Mockito.times(1)).getName();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }
}
