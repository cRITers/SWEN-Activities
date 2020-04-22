import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class FileManager {
    private final String LOG_DIRECTORY = "log/";
    private final String FOOD_FILE_NAME = "foods.csv";
    private final String DAY_FILE_NAME = "foods.csv";
    private DataOutputStream out = null;
    private DataInputStream in = null;

    private String catalogue = "";

    public FileManager() {
        try {
            out = new DataOutputStream(new FileOutputStream(LOG_DIRECTORY + FOOD_FILE_NAME, true));
            in = new DataInputStream(new FileInputStream(LOG_DIRECTORY + FOOD_FILE_NAME));
        } catch (Exception e) {
            System.out.println("Error creating FileManager: " + e.getMessage());
        }
    }

    // Same name but this one has food
    public boolean addItem(Food food) {
        String toPrint = "b," + food.getName() + "," + food.getCalories() + "," + food.getFat() + "," + food.getCarbs()
                + "," + food.getProtein();
        return writeLine(toPrint);
    }

    // Same name but this one has recipe
    public boolean addItem(Recipe recipe) {
        String toPrint = "r," + recipe.getName();
        ArrayList<ItemAdapter> items = recipe.getFoods();
        for (ItemAdapter item : items) {
            toPrint += item.getItemName() + "," + item.getCount();
        }
        return writeLine(toPrint);
    }

    public String getCatalogue() {
        try {
            while (in.available() > 0) {
                catalogue += (char) in.read();
            }
            return catalogue;
        } catch (Exception e) {
            System.out.println("Error happened when trying using method getCatalogue: " + e.getMessage());
            return "error";
        }
    }

    public boolean writeLine(String line) {
        try {
            out.writeUTF("\n" + line);
            return true;
        } catch (Exception e) {
            System.out.println("Error happened when trying using method writeLine: " + e.getMessage());
            return false;
        }
    }

    public boolean send() {
        try {
            out.flush();
            return true;
        } catch (Exception e) {
            System.out.println("Error happened when trying using method send: " + e.getMessage());
            return false;
        }
    }

    public boolean close() {
        try {
            out.close();
            in.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error happened when trying using method close: " + e.getMessage());
            return false;
        }
    }
}