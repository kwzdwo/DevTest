import java.util.Scanner;

public class DevTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstName = "";
        int age = 0;
        int favNum = 0;
        double salary = 0;
        double constrained = 0; // must be between 100 and 10000
/*
        firstName = getNonZeroLenString(in, "Enter your first name");

        System.out.println("Fname is " + firstName);


        age = getInt(in, "enter your age");
        System.out.println("You said your age is " + age);


        salary = getDouble(in, "Enter your Salary");
        System.out.println("Salary is " + salary);

        favNum = getRangedInt(in, "Enter your favorite number", 1, 10);
        System.out.println("Your fav number is " + favNum);
        */
        constrained = getRangedDouble(in, "Enter the constrained double", 100, 10000);
        System.out.println("Constrained is " + constrained);
    }

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retVal = "";

        do {
            System.out.println(prompt + ": ");
            retVal = pipe.nextLine();

            if (retVal.isEmpty())
                System.out.println("You must enter at least one character");

        } while (retVal.isEmpty());

        return retVal;
    }

    /**
     * get a int value from the user at the console with no restraint
     *
     * @param pipe
     * @param prompt
     * @return
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.println(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * get a double value from the user at the console with no restraint
     *
     * @param pipe
     * @param prompt
     * @return
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.println(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * gets an integer from the user via the console within a specified range
     *
     * @param pipe   the scanner to use for input
     * @param prompt the prompt to tell the user what is required
     * @param low    the low inclusive low bound
     * @param high   the inclusive high vo
     * @return
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.println(prompt + ":  [" + low + " - " + high + "] ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a value within the range [" + low + " - " + high + "] ");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * gets an integer from the user via the console within a specified range
     *
     * @param pipe   the scanner to use for input
     * @param prompt the prompt to tell the user what is required
     * @param low    the low inclusive low bound
     * @param high   the inclusive high vo
     * @return a double within the specified bounds
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.println(prompt + ":  [" + low + " - " + high + "] ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a value within the range [" + low + " - " + high + "] ");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get a Y or N from the user (yes or no) and returns the equivalent
     *
     * @param pipe   scanner to use for input
     * @param prompt tells the user what to enter
     * @return true or false based on Y or N
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean retVal = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine();

            if (response.isEmpty()) {
                System.out.println("You must enter at least one character");
            } else if (!response.matches("[YyNn]")) {
                System.out.println("You must enter a valid response [Y/N]");
            } else {
                retVal = response.equalsIgnoreCase("Y");
            }

        } while (!response.matches("[YyNn]"));

        return retVal;
    }

    /**
     * get a int value from the user at the console with no restraint
     *
     * @param pipe
     * @param prompt
     * @return
     */
    public static boolean getYNResponse(Scanner pipe, String prompt) {
        String YNResponse = "";
        boolean retVal = false;
        boolean done = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            YNResponse = pipe.nextLine();

            if (!YNResponse.matches("[YyNn]")) {
                System.out.println("You must enter a valid response [Y/N]");
            } else {
                switch (YNResponse) {
                    case "Y":
                    case "y":
                        retVal = true;
                        done = true;
                        break;
                    case "N":
                    case "n":
                        retVal = false;
                        done = true;
                        break;
                }
            }
        } while (!done);

        return retVal;
    }

    /**
     * This method prompts the user for input and ensures that it matches a given regex pattern.
     * @param pipe The Scanner object to take input from the console.
     * @param prompt The message to display to the user.
     * @param regEx The regex pattern the input should match.
     * @return A valid string that matches the provided regex.
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input = "";
        boolean valid = false;

        do {
            System.out.print(prompt);
            input = pipe.nextLine();

            if (input.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Input does not match the pattern. Please try again.");
            }

        } while (!valid);

        return input;
    }
}
