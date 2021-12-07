package by.tc.task01.entity;

import java.util.Comparator;
import java.util.Objects;

public class Appliance {
    private int Price;

    /**
     * Initialize fields.
     * @param price param describes appliance price.
     */
    public Appliance(int price){
        this.setPrice(price);
    }

    /**
     * Gets price.
     *
     * @return appliance price
     */
    public int getPrice() {
        return Price;
    }

    /**
     * Sets cost.
     *
     * @param price that sets appliance price
     */
    public void setPrice(int price) {
        this.Price = price;
    }

    /**
     * @return object hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Price);
    }
}
