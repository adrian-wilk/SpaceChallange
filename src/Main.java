import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Simulation SpaceSimulation = new Simulation();
        ArrayList<Item> phase1Cargo = new ArrayList<>();
        ArrayList<Item> phase2Cargo = new ArrayList<>();

        // phase1Cargo and phase2Cargo load the materialLists from text files

        try {
            phase1Cargo = SpaceSimulation.loadItems("phase-1.txt");
        } catch (FileNotFoundException e) {
            System.out.println("The materialList not found.");
        }

        try {
            phase2Cargo = SpaceSimulation.loadItems("phase-2.txt");
        } catch (FileNotFoundException e) {
            System.out.println("The materialList not found.");
        }

        ArrayList<Rocket> u1RocketsPhase1 = SpaceSimulation.loadU1(phase1Cargo);
        ArrayList<Rocket> u1RocketsPhase2 = SpaceSimulation.loadU1(phase2Cargo);

        int u1Budget = 0;
        u1Budget += SpaceSimulation.runSimulation(u1RocketsPhase1);
        u1Budget += SpaceSimulation.runSimulation(u1RocketsPhase2);

        ArrayList<Rocket> u2RocketsPhase1 = SpaceSimulation.loadU2(phase1Cargo);
        ArrayList<Rocket> u2RocketsPhase2 = SpaceSimulation.loadU2(phase2Cargo);

        int u2Budget = 0;
        u2Budget += SpaceSimulation.runSimulation(u2RocketsPhase1);
        u2Budget += SpaceSimulation.runSimulation(u2RocketsPhase2);

        System.out.println("The budget of Space Program using U1 Rockets sums up to: " + u1Budget + " Million $.");
        System.out.println("The budget of Space Program using U2 Rockets sums up to: " + u2Budget + " Million $.");

        if (u1Budget < u2Budget) {
            System.out.println("The U1 type of Rockets is more efficient to be used for the Space Program than type U2.");
        } else if (u2Budget < u1Budget) {
            System.out.println("The U2 type of Rockets is more efficient to be used for the Space Program than type U1.");
        } else {
            System.out.println("Rockets types U1 and U2 can be both used for the Space Program.");
            System.out.println("The simulation has shown that the budget is the same for both types.");
        }
    }
}