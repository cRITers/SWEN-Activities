
public class Food implements Item {

    private String name;
    private double calories;
    private double fat;
    private double carbs;
    private double protein;

    public Food(String name, double calories, double fat, double carbs, double protein) {
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return this.calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getFat() {
        return this.fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return this.carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getProtein() {
        return this.protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", calories='" + getCalories() + "'" + ", fat='" + getFat() + "'"
                + ", carbs='" + getCarbs() + "'" + ", protein='" + getProtein() + "'" + "}";
    }

}
