/**
 * EnergyUsageRecord
 * Tracks energy consumption (in kWh) for a specific appliance.
 */
public class EnergyUsageRecord {
    private Appliance appliance;
    private double hoursUsed;

    public EnergyUsageRecord(Appliance appliance, double hoursUsed) {
        this.appliance = appliance;
        setHoursUsed(hoursUsed);
    }

    public Appliance getAppliance() {
        return appliance;
    }

    public void setAppliance(Appliance appliance) {
        this.appliance = appliance;
    }

    public double getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(double hoursUsed) {
        if (hoursUsed < 0) {
            this.hoursUsed = 0;
        } else {
            this.hoursUsed = hoursUsed;
        }
    }

    public double getConsumedEnergy() {
        return appliance.calculateEnergyConsumption(hoursUsed);
    }
}