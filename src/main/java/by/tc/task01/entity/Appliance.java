package by.tc.task01.entity;

import java.util.Comparator;
import java.util.Objects;

public class Appliance {
    private int price;

    /**
     * Gets price.
     *
     * @return appliance price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Initialize fields.
     * @param price param describes appliance price.
     */
    public Appliance(int price){
        this.setPrice(price);
    }

    /**
     * Sets cost.
     *
     * @param price that sets appliance price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return object hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(price);
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
