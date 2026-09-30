/**
 * LightAppliance (Subclass)
 * Supports multiple appliance types using OOP principles.
 */
public class LightAppliance extends Appliance {
    private boolean isLED;

    public LightAppliance(String name, double powerRating, boolean isLED) {
        super(name, powerRating);
        this.isLED = isLED;
    }

    public boolean isLED() {
        return isLED;
    }

    public void setLED(boolean isLED) {
        this.isLED = isLED;
    }

    @Override
    public double calculateEnergyConsumption(double hours) {
        double baseEnergy = super.calculateEnergyConsumption(hours);
        // LEDs use 20% less energy than the base calculation
        if (isLED) {
            return baseEnergy * 0.80;
        }
        return baseEnergy;
    }
}