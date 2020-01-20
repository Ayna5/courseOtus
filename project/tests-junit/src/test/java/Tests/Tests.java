package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Tests {
    private int a;
    private int b;
    private int c;

    public Tests(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {10,4,40},
                {2,2,4},
                {11,4,15}
    });
    }

    @Test
    public void methodMult() {
        Assert.assertEquals("Expected and actual results don't match", a*b, c);
    }

    @Test
    public void methodSum() {
        Assert.assertEquals("Expected and actual results don't match", a+b, c);
    }

}
