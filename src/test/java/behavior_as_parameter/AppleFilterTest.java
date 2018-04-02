package behavior_as_parameter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppleFilterTest {

    @Test
    public void filterWithColor(){
        Apple apple = new Apple();
        apple.setColor("red");
        Apple apple2 = new Apple();
        apple2.setColor("green");
        List<Apple> apples = Arrays.asList(apple, apple2);
        List<Apple> red = AppleFilter.Filter(apples, "red", -1);

        assertEquals(1, red.size());
    }

    @Test
    public void filterWithWeight(){
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setWeight(100);
        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight(30);
        List<Apple> apples = Arrays.asList(apple, apple2);
        List<Apple> filterApples = AppleFilter.Filter(apples, "", 50);

        assertEquals(1, filterApples.size());
    }

    @Test
    public void newFilterWithColor(){
        Apple apple = new Apple();
        apple.setColor("red");
        Apple apple2 = new Apple();
        apple2.setColor("green");
        List<Apple> apples = Arrays.asList(apple, apple2);
        List<Apple> red = AppleFilter.NewFilter(apples, new AppleColorPredicate("red"));

        assertEquals(1, red.size());
    }

    @Test
    public void newFilterWithWeight(){
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setWeight(100);
        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight(30);
        List<Apple> apples = Arrays.asList(apple, apple2);
        List<Apple> filterApples = AppleFilter.NewFilter(apples, new AppleWeightPredicate(50));

        assertEquals(1, filterApples.size());
    }
}