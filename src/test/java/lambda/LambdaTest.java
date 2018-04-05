package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import static org.junit.Assert.assertFalse;
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

    @Test
    public void useFunctionReference() throws Exception {
        BiPredicate<List<String>, String> containsWithLambda =
                (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> containsUsingFunctionReference =
                List::contains;


        List<String> names = Arrays.asList("Yansen", "Didi");
        boolean hasYansen = containsWithLambda.test(names, "Yansen");
        assertTrue(hasYansen);

        boolean hasTa = containsUsingFunctionReference.test(names, "Ta");
        assertFalse(hasTa);
    }
}
