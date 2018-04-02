package behavior_as_parameter;

public class AppleWeightPredicate implements ApplePredicate {
    private int filterWeight;

    public AppleWeightPredicate(int weight){
        this.filterWeight = weight;
    }

    @Override
    public boolean test(Apple apple) {
        if(apple.getWeight() >= filterWeight){
            return true;
        }
        else {
            return false;
        }
    }
}
