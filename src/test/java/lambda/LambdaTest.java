package lambda;

import behavior_as_parameter.Apple;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static org.junit.Assert.*;

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

    @Test
    public void comparationComposition() throws Exception {
        List<String> names = Arrays.asList("Yanse", "Yansen", "Zizi", "Zizii");

        names.sort(comparing(String::length).thenComparing(s -> s.charAt(0)));

        List<String> expectSortResult = Arrays.asList("Zizi", "Yanse", "Zizii", "Yansen");

        assertArrayEquals(expectSortResult.toArray(), names.toArray());
    }

    @Test
    public void predicateComposition() {
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setWeight(100);
        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight(30);
        Apple apple3 = new Apple();
        apple2.setColor("green");
        apple2.setWeight(100);

        List<Apple> apples = Arrays.asList(apple, apple2, apple3);

        Predicate<Apple> greePredicate = (x) -> x.getColor() == "green";
        Predicate<Apple> greenAndAbove50 = greePredicate.and((x) -> x.getWeight() > 50);
        List<Apple> filterApples = apples
                .stream()
                .filter(greenAndAbove50)
                .collect(Collectors.toList());

        assertEquals(1, filterApples.size());
    }
}
