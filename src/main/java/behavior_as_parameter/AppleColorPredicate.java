package behavior_as_parameter;

import lombok.Data;

public class AppleColorPredicate implements ApplePredicate {
    private String filterColor;

    public AppleColorPredicate(String color){
        this.filterColor = color;
    }

    @Override
    public boolean test(Apple apple) {
        if(apple.getColor() == filterColor){
            return true;
        }
        else {
            return false;
        }
    }
}
