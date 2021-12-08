package by.tc.task01.entity;

public class Oven extends Appliance{
    private int capacity;
    private int depth;
    private int height;
    private int width;

    /**
     * @param capacity ovens capacity.
     * @param depth ovens depth.
     * @param width ovens width.
     * @param price ovens price.
     * @param height ovens height.
     */
    public Oven(int capacity, int depth, int width, int price, int height) {
        super(price);
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    /**
     * Gets capacity.
     * @return the capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets depth.
     * @return the depth.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Gets height.
     * @return the height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets width.
     * @return the width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * gets string representation of oven class
     * @return string representation of oven class.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Oven{");
        sb.append("price = ").append(this.getPrice());
        sb.append(", capacity = ").append(this.getCapacity());
        sb.append(", depth = ").append(this.getDepth());
        sb.append(", width = ").append(this.getWidth());
        sb.append(", height = ").append(this.getHeight());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Oven oven = (Oven) o;
        return capacity == oven.capacity && depth == oven.depth
                && height == oven.height && width == oven.width;
    }
}
