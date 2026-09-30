/**
 * CoolingAppliance (Subclass)
 * Supports multiple appliance types using OOP principles.
 */
public class CoolingAppliance extends Appliance {
    private boolean hasInverter;

    public CoolingAppliance(String name, double powerRating, boolean hasInverter) {
        super(name, powerRating);
        this.hasInverter = hasInverter;
    }

    public boolean hasInverter() {
        return hasInverter;
    }

    public void setHasInverter(boolean hasInverter) {
        this.hasInverter = hasInverter;
    }

    @Override
    public double calculateEnergyConsumption(double hours) {
        double baseEnergy = super.calculateEnergyConsumption(hours);
        // Inverters save roughly 30% energy
        if (hasInverter) {
            return baseEnergy * 0.70;
        }
        return baseEnergy;
    }
}