package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

public class Laptop extends Appliance{
    private int SystemMemory;
    private String Cpu;

    /**
     * Initialize new instance of laptop class.
     * @param systemMemory laptops system memory.
     * @param price laptops price.
     * @param cpu laptops cpu.
     */
    public Laptop(int systemMemory, int price, String cpu) {
        super(price);
        this.Cpu = cpu;
        this.SystemMemory = systemMemory;
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

    /**
     * Gets system memory.
     * @return the system memory
     */
    public int getSystemMemory() {
        return SystemMemory;
    }

    /**
     * Gets cpu.
     * @return the cpu
     */
    public String getCpu() {
        return Cpu;
    }


}
