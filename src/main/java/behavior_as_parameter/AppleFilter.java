package behavior_as_parameter;

import java.util.ArrayList;
import java.util.List;

public class AppleFilter {
    public static List<Apple> Filter(List<Apple> apples, String color, int weight){
        ArrayList<Apple> filteredApple = new ArrayList<>();
        for(Apple apple : apples){
            if((color != "" && apple.getColor() == color) ||
                    (weight > 0 && apple.getWeight() > weight)){
                filteredApple.add(apple);
            }
        }

        return filteredApple;
    }

    public static List<Apple> NewFilter(List<Apple> apples, ApplePredicate predicate){
        ArrayList<Apple> filteredApple = new ArrayList<>();
        for(Apple apple : apples){
            if(predicate.test(apple)){
                filteredApple.add(apple);
            }
        }

        return filteredApple;
    }
}
