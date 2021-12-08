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

    public static final Comparator<Appliance> compareByPrice = new Comparator<Appliance>() {

        /**
         * @param o1 the object being compared.
         * @param o2 the object being compared.
         * @return the difference of the objects being compared
         */
        @Override
        public int compare(Appliance o1, Appliance o2) {
            return o1.getPrice() - o2.getPrice();
        }
    };
}
