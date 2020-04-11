public class Rocket implements SpaceShip{
    private int cost;
    private int weight;
    private int maxWeight;
    private int currentWeight;
    double chanceOfLaunchExplosion;
    double chanceOfLandingCrash;

   public void setCost(int cost){
       this.cost = cost;
   }
    public void setCurrentWeight(int currentWeight){
        this.currentWeight = currentWeight;
    }

    public void setMaxWeight(){
        this.maxWeight = currentWeight;
    }

    public int getCost(){
       return cost;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public final boolean canCarry(Item item) {
        return getCurrentWeight() + item.getWeight() <= getMaxWeight();
    }

    @Override
    public final void carry(Item item) {
        currentWeight += item.getWeight();
        setCurrentWeight(currentWeight);

    }
}
