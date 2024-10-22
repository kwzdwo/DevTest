import java.util.Scanner;

public class Reggie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String ssn = getRegExString(in, "Enter your SSN (format: 123-45-6789): ", "^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println("SSN: " + ssn);

        String mNumber = getRegExString(in, "Enter your M number (format: M#####): ", "^(M|m)\\d{5}$");
        System.out.println("M number: " + mNumber);

        String menuChoice = getRegExString(in, "Enter your choice [O/S/V/Q]: ", "^[OoSsVvQq]$");
        System.out.println("Menu choice: " + menuChoice);
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        boolean valid = false;
        do {
            System.out.print(prompt);
            input = pipe.nextLine().trim();
            if (input.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Invalid input.");
            }
        } while (!valid);
        return input;
    }
}