import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] food = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
        double[] price = {80.00, 120.00, 100.00, 70.00, 90.00};

        int totalQuantity = 0;
        double totalAmount = 0;
        double totalDiscount = 0;

        char again = 'Y';

        System.out.println("===== CANTEEN MENU =====");

        for (int i = 0; i < food.length; i++) {
            System.out.printf("%d. %-10s - $%.2f%n", i + 1, food[i], price[i]);
        }

        while (again == 'Y' || again == 'y') {

            System.out.print("\nEnter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (itemNumber < 1 || itemNumber > 5 || quantity < 1 || quantity > 10) {

                System.out.println("Invalid order! Please enter a valid item and quantity.");

                System.out.print("Do you want to order again? (Y/N): ");
                again = input.next().charAt(0);

                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char student = input.next().charAt(0);

            if (student != 'Y' && student != 'y' &&
                student != 'N' && student != 'n') {

                System.out.println("Invalid student status. Order was not processed.");

                System.out.print("Do you want to order again? (Y/N): ");
                again = input.next().charAt(0);

                continue;
            }

            double subtotal = price[itemNumber - 1] * quantity;
            double discount = 0;

            if (student == 'Y' || student == 'y') {

                if (subtotal >= 500) {
                    discount = subtotal * 0.15;
                } else {
                    discount = subtotal * 0.10;
                }

            } else {

                if (subtotal >= 500) {
                    discount = subtotal * 0.05;
                }
            }

            double orderTotal = subtotal - discount;

            totalQuantity = totalQuantity + quantity;
            totalAmount = totalAmount + subtotal;
            totalDiscount = totalDiscount + discount;

            System.out.printf("\nSubtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);

            System.out.print("\nDo you want to order again? (Y/N): ");
            again = input.next().charAt(0);
        }

        double finalAmount = totalAmount - totalDiscount;

        System.out.println("\n===== FINAL RECEIPT =====");
        System.out.println("Total quantity of items purchased: " + totalQuantity);
        System.out.printf("Total amount before deductions: $%.2f%n", totalAmount);
        System.out.printf("Total deduction: $%.2f%n", totalDiscount);
        System.out.printf("Final amount to pay: $%.2f%n", finalAmount);

        System.out.println("\nThank you for ordering!");

        input.close();
    }
}
