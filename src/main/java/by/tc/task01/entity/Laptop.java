package by.tc.task01.entity;

public class Laptop extends Appliance{
    private int systemMemory;
    private String cpu;

    /**
     * Initialize new instance of laptop class.
     * @param systemMemory laptops system memory.
     * @param price laptops price.
     * @param cpu laptops cpu.
     */
    public Laptop(int systemMemory, int price, String cpu) {
        super(price);
        this.cpu = cpu;
        this.systemMemory = systemMemory;
    }


    /**
     * Gets system memory.
     * @return the system memory
     */
    public int getSystemMemory() {
        return systemMemory;
    }

    /**
     * Gets cpu.
     * @return the cpu
     */
    public String getCpu() {
        return cpu;
    }

    /**
     * gets string representation of laptop class
     * @return string representation of laptop class.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("price = ").append(this.getPrice());
        sb.append(", system memory = ").append(this.getSystemMemory());
        sb.append(", cpu = ").append(this.getCpu());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return systemMemory == laptop.systemMemory && cpu == laptop.cpu;
    }
}
