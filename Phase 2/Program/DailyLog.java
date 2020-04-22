
public class DailyLog {

    private String name;
    private int year;
    private int month;
    private int weight;

    public DailyLog() {
    }

    public DailyLog(String name, int year, int month, int weight) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public DailyLog name(String name) {
        this.name = name;
        return this;
    }

    public DailyLog year(int year) {
        this.year = year;
        return this;
    }

    public DailyLog month(int month) {
        this.month = month;
        return this;
    }

    public DailyLog weight(int weight) {
        this.weight = weight;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", year='" + getYear() + "'" +
            ", month='" + getMonth() + "'" +
            ", weight='" + getWeight() + "'" +
            "}";
    }

}
