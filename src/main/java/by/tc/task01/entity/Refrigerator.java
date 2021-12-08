package by.tc.task01.entity;

public class Refrigerator extends Appliance{
    private int overallCapacity;
    private int height;
    private int width;

    /**
     *
     * @param price refrigerators price.
     * @param overall_Capacity refrigerators overall capacity.
     * @param height refrigerators height.
     * @param width refrigerators width.
     */
    public Refrigerator(int price, int overall_Capacity, int height, int width) {
        super(price);
        this.height = height;
        this.width = width;
        this.overallCapacity = overall_Capacity;
    }

    /**
     * Gets overallCapacity.
     * @return the overallCapacity
     */
    public int getOverallCapacity() {
        return overallCapacity;
    }

    /**
     * Gets height.
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets width.
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Refrigerator{");
        sb.append("price = ").append(this.getPrice());
        sb.append(", overall capacity = ").append(this.getOverallCapacity());
        sb.append(", width = ").append(this.getWidth());
        sb.append(", height = ").append(this.getHeight());
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Refrigerator that = (Refrigerator) o;
        return overallCapacity == that.overallCapacity
                && height == that.height && width == that.width;
    }
}
