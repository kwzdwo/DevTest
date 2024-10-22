import java.util.Scanner;

public class CheckOut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double total = 0;
        boolean moreItems = false;

        do {
            double price = getRangedDouble(in, "Enter the price of your item", 0.50, 10.00);
            total += price;
            moreItems = getYNConfirm(in, "Do you have more items?");
        } while (moreItems);

        System.out.printf("Total cost: $%.2f\n", total);
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        boolean done = false;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Input must be within range.");
                }
            } else {
                System.out.println("Invalid input.");
                pipe.nextLine();
            }
        } while (!done);
        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        do {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine().trim().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("Invalid input.");
        } while (true);
    }
}