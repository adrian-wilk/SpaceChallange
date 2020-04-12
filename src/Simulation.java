import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

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



}
