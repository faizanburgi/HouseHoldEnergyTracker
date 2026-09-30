import java.util.ArrayList;
import java.util.List;

/**
 * Household
 * Aggregates appliances and generates summary reports.
 */
public class Household {
    private List<Appliance> appliances;
    private List<EnergyUsageRecord> records;
    private final double COST_PER_KWH = 0.50;

    public Household() {
        this.appliances = new ArrayList<>();
        this.records = new ArrayList<>();
    }

    // Add and store household energy devices/appliances
    public void addAppliance(Appliance appliance) {
        this.appliances.add(appliance);
    }

    // NEW METHOD: Remove an appliance by its index
    public boolean removeAppliance(int index) {
        if (index >= 0 && index < appliances.size()) {
            appliances.remove(index);
            return true; // Successfully removed
        }
        return false; // Invalid index
    }

    public List<Appliance> getAppliances() {
        return appliances;
    }

    // Record energy usage
    public void addUsageRecord(EnergyUsageRecord record) {
        this.records.add(record);
    }

    public double calculateTotalEnergy() {
        double total = 0;
        for (EnergyUsageRecord record : records) {
            total += record.getConsumedEnergy();
        }
        return total;
    }

    // Calculate Average Usage
    public double calculateAverageUsage() {
        if (records.isEmpty()) return 0.0;
        return calculateTotalEnergy() / records.size();
    }

    public double calculateEstimatedCost() {
        return calculateTotalEnergy() * COST_PER_KWH;
    }

    // Display summary reports
    public void displaySummaryReport() {
        System.out.println("\n--- Household Energy Summary Report ---");
        if (records.isEmpty()) {
            System.out.println("No usage records found.");
            return;
        }

        for (EnergyUsageRecord record : records) {
            Appliance app = record.getAppliance();
            double energy = record.getConsumedEnergy();
            System.out.printf("Appliance: %-15s | Hours: %5.2f | Energy: %5.2f kWh\n",
                    app.getName(), record.getHoursUsed(), energy);

            // Identify high energy-consuming appliances
            if (energy > 5.0) {
                System.out.println("   --> [ALERT] High energy-consuming appliance identified! Close this appliance.");
            }
        }

        System.out.println("---------------------------------------");
        System.out.printf("Total Energy Used : %.2f kWh\n", calculateTotalEnergy());
        System.out.printf("Average Usage/Item: %.2f kWh\n", calculateAverageUsage());
        System.out.printf("Estimated Cost    : $%.2f\n", calculateEstimatedCost());
        System.out.println("---------------------------------------");
    }
}