/**
 * Appliance (Base Class)
 * Represents a household energy device.
 */
public class Appliance {
    private String name;
    private double powerRating; // in watts

    public Appliance(String name, double powerRating) {
        setName(name);
        setPowerRating(powerRating);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown Appliance";
        } else {
            this.name = name;
        }
    }

    public double getPowerRating() {
        return powerRating;
    }

    public void setPowerRating(double powerRating) {
        if (powerRating < 0) {
            this.powerRating = 0;
        } else {
            this.powerRating = powerRating;
        }
    }

    // Base energy calculation (Watts * Hours) / 1000 = kWh
    public double calculateEnergyConsumption(double hours) {
        return (this.powerRating * hours) / 1000.0;
    }
}