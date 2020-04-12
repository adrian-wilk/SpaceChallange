public class U1 extends Rocket {

    public U1(){
        setCost(100);
        setWeight(10000);
        setMaxWeight(18000);
        setCurrentWeight(10000);
    }

    /** Both launch and land are overridden in U1 class.
     *  To indicate either the launch or land is successful the methods compare a percentage chance
     *  of action multiplied by cargo factor and compared to random number higherPower.
     *  Both methods return true if an action has been completed successfully and
     *  both methods return false if landing / launching has ended up tragically.
     */

    @Override
    public boolean launch() {
        double percentChance = 0.05;
        double higherPower = Math.random();
                chanceOfLaunchExplosion = percentChance * (((double) getCurrentWeight()-getWeight())/(getMaxWeight()-getWeight()));
                if(chanceOfLaunchExplosion < higherPower){
                    System.out.println("The launch sequence has finished successfully.");
                    return true;
                }
                else{
                    System.out.println("The U1 rocket has exploded during the launching sequence.");
                    return false;
                }
    }

    @Override
    public boolean land() {
        double percentChance = 0.01;
        double higherPower = Math.random();
        chanceOfLandingCrash = percentChance * (((double) getCurrentWeight() - getWeight())/(getMaxWeight()-getWeight()));
        if(chanceOfLandingCrash < higherPower){
            System.out.println("The landing sequence has finished successfully.");
            return true;
        }
        else{
            System.out.println("The U1 rocket has crashed during the landing sequence.");
            return false;
        }
    }
}
