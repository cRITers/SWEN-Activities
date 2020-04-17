// Adapter pattern utialized in this class
public class ItemAdapter {

    private Item item;
    private double count;

    public ItemAdapter(Item item, double count) {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public double getCount() {
        return count;
    }

    public String getItemName() {
        return item.getName();
    }
}