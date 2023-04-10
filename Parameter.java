import java.util.Locale;

/**
 * This class represent each individual sample parameter
 */
public class Parameter {

    private String name;
    private double value;
    private double minRange;
    private double maxRange;

    /**
     * Default constructor
     */
    public Parameter() {
    }

    /**
     * Parameterized constructor
     *
     * @param name     Parameter name
     * @param value    current value
     * @param minRange Min range
     * @param maxRange Max range
     */
    public Parameter(String name, double value, double minRange, double maxRange) {
        this.name = name;
        this.value = value;
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMinRange() {
        return minRange;
    }

    public void setMinRange(double minRange) {
        this.minRange = minRange;
    }

    public double getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(double maxRange) {
        this.maxRange = maxRange;
    }

    /**
     * String representation of the Parameter class
     *
     * @return String representation
     */
    @Override
    public String toString() {

        return String.format(Locale.US, "%-23s %12.1f %12.1f %12.1f\n", name, value, minRange, maxRange);

    }
}
