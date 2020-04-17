import java.util.ArrayList;

public class Recipe implements Item {

    private ArrayList<ItemAdapter> foods;
    private String name;

    public void addItem(ItemAdapter item) {
        foods.add(item);
    }

    public ArrayList<ItemAdapter> getFoods() {
        return foods;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        // Change later
        return 0;
    }

    public double getFat() {
        // Change later
        return 0;
    }

    public double getCarbs() {
        // Change later
        return 0;
    }

    public double getProtein() {
        // Change later
        return 0;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", calories='" + getCalories() + "'" + ", fat='" + getFat() + "'"
                + ", carbs='" + getCarbs() + "'" + ", protein='" + getProtein() + "'" + "}";
    }

}