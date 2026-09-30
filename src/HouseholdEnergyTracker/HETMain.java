import java.util.Scanner;
import java.util.List;

/**
 * HETMain
 * Console-based menu for tracking energy consumption.
 */
public class HETMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Household household = new Household();
        boolean running = true;

        System.out.println("Welcome to the Household Energy Tracker (SDG 7)");

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Appliance");
            System.out.println("2. Remove Appliance");
            System.out.println("3. Record Energy Usage");
            System.out.println("4. View Summary Report");
            System.out.println("5. Exit Program");
            System.out.print("Select an option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:  // add appliance
                    System.out.println("Choose Appliance Type: 1. Light  2. Cooling");
                    int type = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Appliance Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Power Rating (Watts): ");
                    double power = input.nextDouble();

                    if (type == 1) {
                        System.out.print("Is it an LED? (true/false): ");
                        boolean isLED = input.nextBoolean();
                        household.addAppliance(new LightAppliance(name, power, isLED));
                    } else if (type == 2) {
                        System.out.print("Has Inverter? (true/false): ");
                        boolean hasInverter = input.nextBoolean();
                        household.addAppliance(new CoolingAppliance(name, power, hasInverter));
                    } else {
                        System.out.println("Invalid appliance type.");
                        break;
                    }
                    System.out.println("Appliance added and stored successfully!");
                    break;

                case 2:  // remove appliance
                    List<Appliance> appsToRemove = household.getAppliances();
                    if (appsToRemove.isEmpty()) {
                        System.out.println("No appliances stored! Nothing to remove.");
                        break;
                    }

                    System.out.println("Select an Appliance to remove:");
                    for (int i = 0; i < appsToRemove.size(); i++) {
                        System.out.println((i + 1) + ". " + appsToRemove.get(i).getName());
                    }
                    System.out.print("Which appliance do you want to remove: ");
                    int removeChoice = input.nextInt();

                    if (household.removeAppliance(removeChoice - 1)) {
                        System.out.println("Appliance removed successfully!");
                    } else {
                        System.out.println("Invalid choice. Appliance could not be removed.");
                    }
                    break;

                case 3: // To store usage
                    List<Appliance> apps = household.getAppliances();
                    if (apps.isEmpty()) {
                        System.out.println("No appliances stored! Please add an appliance first.");
                        break;
                    }

                    System.out.println("Select an Appliance to record usage for:");
                    for (int i = 0; i < apps.size(); i++) {
                        System.out.println((i + 1) + ". " + apps.get(i).getName());
                    }
                    System.out.print("Choice: ");
                    int appChoice = input.nextInt();

                    if (appChoice < 1 || appChoice > apps.size()) {
                        System.out.println("Invalid choice.");
                        break;
                    }

                    System.out.print("Enter Usage Duration (Hours): ");
                    double hours = input.nextDouble();

                    Appliance selectedApp = apps.get(appChoice - 1);
                    household.addUsageRecord(new EnergyUsageRecord(selectedApp, hours));
                    System.out.println("Energy usage recorded successfully!");
                    break;

                case 4: // summary report
                    household.displaySummaryReport();
                    break;

                case 5: // SHIFTED FROM CASE 4
                    running = false;
                    System.out.println("Exiting program. Support SDG 7 by conserving energy!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        input.close();
    }
}