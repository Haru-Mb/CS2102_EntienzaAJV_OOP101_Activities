import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalQuantity = 0;
        double totalBeforeDeductions = 0.0;
        double totalDeduction = 0.0;
        double finalAmountToPay = 0.0;

        boolean keepOrdering = true;

        while (keepOrdering) {
            System.out.println("==========================================");
            System.out.println("          CANTEEN MENU SELECTION          ");
            System.out.println("==========================================");
            System.out.println("[1] Roasted Chicken Meal  - $125.00");
            System.out.println("[2] Fettuccine Alfredo    - $100.00");
            System.out.println("[3] Pizza Special         - $150.00");
            System.out.println("[4] Clubhouse Sandwich    - $60.00");
            System.out.println("[5] Cafe Latte            - $30.00");
            System.out.println("==========================================\n");

            System.out.print("Enter Item Number (1-5): ");
            int itemChoice = scanner.hasNextInt() ? scanner.nextInt() : -1;
            if (itemChoice == -1) scanner.next(); 

            System.out.print("Enter Quantity (1-10): ");
            int quantity = scanner.hasNextInt() ? scanner.nextInt() : -1;
            if (quantity == -1) scanner.next(); 

            if (itemChoice < 1 || itemChoice > 5 || quantity < 1 || quantity > 10) {
                System.out.println("\n------------------------------------------");
                System.out.println("[ERROR] Invalid order! Item must be 1-5 and quantity 1-10.");
                System.out.println("Order was skipped.");
                System.out.println("------------------------------------------");
                
                System.out.print("Do you want to order again? (Y/N): ");
                char tryAgain = scanner.next().toUpperCase().charAt(0);
                if (tryAgain != 'Y') {
                    keepOrdering = false;
                }
                System.out.println();
                continue; 
            }

            System.out.print("Are you a student? (Y/N): ");
            char studentChar = scanner.next().toUpperCase().charAt(0);
            boolean isStudent = (studentChar == 'Y');


            double itemPrice = 0.0;
            switch (itemChoice) {
                case 1: itemPrice = 125.00; break;
                case 2: itemPrice = 100.00; break;
                case 3: itemPrice = 150.00; break;
                case 4: itemPrice = 60.00; break;
                case 5: itemPrice = 30.00; break;
            }

            double subtotal = itemPrice * quantity;

            double discountRate = 0.0;
            if (isStudent && subtotal >= 500.00) {
                discountRate = 0.15;
            } else if (isStudent) {
                discountRate = 0.10;
            } else if (subtotal >= 500.00) {
                discountRate = 0.05;
            }

            double orderDiscount = subtotal * discountRate;
            double orderTotal = subtotal - orderDiscount;

            System.out.println("\n------------------------------------------");
            System.out.printf("Subtotal    : $%.2f%n", subtotal);
            System.out.printf("Discount    : -$%.2f%n", orderDiscount);
            System.out.printf("Order Total : $%.2f%n", orderTotal);
            System.out.println("------------------------------------------");

            totalQuantity += quantity;
            totalBeforeDeductions += subtotal;
            totalDeduction += orderDiscount;
            finalAmountToPay += orderTotal;

            System.out.print("\nDo you want to order again? (Y/N): ");
            char again = scanner.next().toUpperCase().charAt(0);
            if (again != 'Y') {
                keepOrdering = false;
            }
            System.out.println();
        }

        System.out.println("==========================================");
        System.out.println("             FINAL SUMMARY                ");
        System.out.println("==========================================");
        System.out.printf("Total Quantity Purchased : %d%n", totalQuantity);
        System.out.printf("Total Before Deductions  : $%.2f%n", totalBeforeDeductions);
        System.out.printf("Total Discount           : -$%.2f%n", totalDeduction);
        System.out.println("------------------------------------------");
        System.out.printf("Final Amount to Pay      : $%.2f%n", finalAmountToPay);
        System.out.println("==========================================");
        System.out.println("Thank you for ordering!");

        scanner.close();
    }
}