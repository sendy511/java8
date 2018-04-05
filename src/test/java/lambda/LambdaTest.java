package lambda;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LambdaTest {
    @Test
    public void verifyLambdaExpressGrammer() throws Exception {
        Runnable singleLine = () -> System.out.println("Hello World");
        singleLine.run();
        assertTrue(true);

        Runnable withBracket = () -> {System.out.println("Hello World");};
        withBracket.run();
        assertTrue(true);
    }
}
