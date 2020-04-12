import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    /**
     * Method loadItems scan a given text file for items to be added to arrayList
     * Each line of the file is declared as an item with item's name followed by "="
     * and items weight in kg after "=".
     * @param filePath - String containing the path to the text file with material list.
     * @return an ArrayList cargo containing items (with names and weights).
     * @throws FileNotFoundException if the text file has not been found.
     */

    ArrayList<Item> loadItems(String filePath) throws FileNotFoundException{
        ArrayList<Item> cargo = new ArrayList<>();
        File materialList = new File(filePath);
        Scanner materialScanner = new Scanner(materialList);
        String[] materialListItem;

        while(materialScanner.hasNextLine()){
            Item item = new Item();
            materialListItem = materialScanner.nextLine().split("=");
            item.setName(materialListItem[0]);
            item.setWeight(Integer.parseInt(materialListItem[1]));
            cargo.add(item);
        }
        return cargo;
    }

    /**
     * Method loadU1 creates an ArrayList of U1 type Rockets and load them with cargo.
     * When a rocket cannot fit the next cargo load, there is a next rocket added to the collection.
     * @param cargo - an arrayList of materials to be U1 Rockets loaded with
     * @return u1Rockets - an ArrayList of U1 Rockets carrying the whole cargo
     */

    ArrayList<Rocket> loadU1(ArrayList<Item> cargo){
        ArrayList<Rocket> u1Rockets = new ArrayList<>();
        Rocket u1Rocket = new U1();
        for (Item item : cargo) {
            if (u1Rocket.canCarry(item)) {
                u1Rocket.carry(item);
            } else {
                u1Rockets.add(u1Rocket);
                u1Rocket = new U1();
                u1Rocket.carry(item);
            }
        }
            if(cargo.size() != 0){
                u1Rockets.add(u1Rocket);
            }
            return u1Rockets;
        }



    /**
     * Method loadU2 creates an ArrayList of U2 type Rockets and load them with cargo.
     * When a rocket cannot fit the next cargo load, there is a next rocket added to the collection.
     * @param cargo - an arrayList of materials to be U2 Rockets loaded with
     * @return u1Rockets - an ArrayList of U1 Rockets carrying the whole cargo
     */

    ArrayList<Rocket> loadU2(ArrayList<Item> cargo){
        ArrayList<Rocket> u2Rockets = new ArrayList<>();
        Rocket u2Rocket = new U2();
        for (Item item : cargo) {
            if (u2Rocket.canCarry(item)) {
                u2Rocket.carry(item);
            } else {
                u2Rockets.add(u2Rocket);
                u2Rocket = new U1();
                u2Rocket.carry(item);
            }
        }
            if(cargo.size() != 0){
                u2Rockets.add(u2Rocket);
            }
            return u2Rockets;
        }


    /**
     * Method runSimulation creates an ArrayList of Rockets and keeps the record of total cost of sent rockets.
     * Also the method verifies if the rockets launch and land successfully.
     * In case any rocket does not make it safely to Mars, it adds to the budget to cost of sending a new one.
     * @param rockets - an ArrayList of all the Rockets to be sent to Mars
     * @return totalBudget counts the cost of all the Rockets to be sent to Mars
     */

    int runSimulation(ArrayList<Rocket> rockets) {
            int totalBudget = 0;
            for (Rocket rocket : rockets) {
                do {
                    totalBudget += rocket.getCost();
                }
                while (!(rocket.launch() && rocket.land()));
            }
            return totalBudget;
        }

}
