package com.billing;

import java.util.Scanner;

public class BillingSystem {

    public static double calculateBill(String plan, double dataUsedGB) {
        double baseCost;
        double limitGB;
        double extraRatePerGB;

        switch (plan.toLowerCase().trim()) {
            case "basic":
                baseCost = 20.0;
                limitGB = 10.0;
                extraRatePerGB = 2.0;
                break;
            case "standard":
                baseCost = 40.0;
                limitGB = 50.0;
                extraRatePerGB = 1.5;
                break;
            case "premium":
                baseCost = 70.0;
                limitGB = 100.0;
                extraRatePerGB = 1.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan: " + plan + ". Choose Basic, Standard, or Premium.");
        }

        double extraUsage = Math.max(0, dataUsedGB - limitGB);
        return baseCost + (extraUsage * extraRatePerGB);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "yes";

        System.out.println("=== Internet Data Usage Billing System ===");

        while (choice.equalsIgnoreCase("yes")) {
            System.out.print("\nEnter Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter Plan Type (Basic / Standard / Premium): ");
            String plan = scanner.nextLine();

            System.out.print("Enter Data Used (in GB): ");
            double dataUsage = Double.parseDouble(scanner.nextLine());

            try {
                double totalBill = calculateBill(plan, dataUsage);
                System.out.println("\n------------------------------");
                System.out.println("          INVOICE             ");
                System.out.println("------------------------------");
                System.out.println("Customer Name : " + customerName);
                System.out.println("Plan Type     : " + plan.substring(0, 1).toUpperCase() + plan.substring(1).toLowerCase());
                System.out.println("Data Consumed : " + dataUsage + " GB");
                System.out.printf("Total Bill    : $%.2f%n", totalBill);
                System.out.println("------------------------------");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("\nDo you want to process another customer? (yes/no): ");
            choice = scanner.nextLine();
        }

        System.out.println("\nThank you for using the Billing System!");
        scanner.close();
    }
}