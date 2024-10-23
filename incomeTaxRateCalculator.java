import java.util.Scanner;

public class incomeTaxRateCalculator {
    public static void main(String[] args) {
        // declarations
        Scanner userInput = new Scanner(System.in);
        double userIncome;
        double incomeRounded;
        float taxRate;
        double userTax;
        double takeHome;
        String userContinue = "yes";

        // main
        System.out.println("*** Welcome to the Income Tax Rate Calculator! ***");
        while (!userContinue.equals("no")) {
            if (userContinue.equals("yes")) {
                System.out.println("\nPlease enter your gross weekly income: ");
                userIncome = userInput.nextFloat();
                incomeRounded = Math.round(userIncome * 100) / 100.0; // ensures userIncome always rounds to 2 decimals

                // conditional statements to determine correct tax rate to apply
                if (incomeRounded < 500) {
                    taxRate = 0.10f;
                    userTax = incomeRounded * taxRate;
                } else if ((incomeRounded > 500) && (incomeRounded < 1500)) {
                    taxRate = 0.15f;
                    userTax = incomeRounded * taxRate;
                } else if ((incomeRounded > 1500) && (incomeRounded < 2500)) {
                    taxRate = 0.20f;
                    userTax = incomeRounded * taxRate;
                } else {
                    taxRate = 0.30f;
                    userTax = incomeRounded * taxRate;
                }

                takeHome = userIncome - userTax;

                System.out.println("\n_______Results_______");
                System.out.println("Gross weekly income: $" + (Math.round(userIncome * 100) / 100.0));
                System.out.println("Tax rate: " + (Math.round(taxRate * 100)) + "%");
                System.out.println("Tax withholding: -$" + (Math.round(userTax * 100) / 100.0));
                System.out.println("Weekly income: $" + (Math.round(takeHome * 100) / 100.0));

                System.out.println("\nWould you like to generate another report? 'yes'/'no'");
                userContinue = userInput.next().toLowerCase();
            } else if (userContinue.equals("no")) {
                break;
            } else {
                System.out.println("Error - invalid entry");
                System.out.println("\nWould you like to generate another report? 'yes'/'no'");
                userContinue = userInput.next().toLowerCase();
            }
        }
        System.out.println("Program is closing...");
    }
}