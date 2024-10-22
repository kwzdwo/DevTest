import java.util.Scanner;

public class BirthDateTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = getRangedInt(in, "Enter your birth year", 1950, 2015);
        int month = getRangedInt(in, "Enter your birth month", 1, 12);

        int days = getDaysInMonth(month);
            int day = getRangedInt(in, "Enter your birth day", 1, days);
            int hour = getRangedInt(in, "Enter the hour of birth", 1, 24);
            int minute = getRangedInt(in, "Enter the minute of birth", 1, 59);

            System.out.println("Birthdate and time: " + year + "/" + month + "/" + day + " " + hour + ":" + minute);
        }

        public static int getDaysInMonth(int month) {
            switch (month) {
                case 2:
                return 29;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
            int retVal = 0;
            boolean done = false;
            do {
                System.out.print(prompt + " [" + low + " - " + high + "]: ");
                if (pipe.hasNextInt()) {
                    retVal = pipe.nextInt();
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
    }