import java.util.Scanner;

public class SafeInput

{

    /**
     * get a string from the user using the console and
     * it must be at least one character in length
     *
     * @param pipe a scanner used to get the input
     * @param prompt the prompt that tells the user what to enter
     * @return a String of at least one character in length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retVal = "";

        do {

            System.out.println(prompt + ": ");
            retVal = pipe.nextLine();

            if(retVal.isEmpty())
                System.out.println("You must enter at least one character");


        }while(retVal.isEmpty());

        return retVal;

    }

    /**
     * get an int vaule from the user at the console
     *
     * @param pipe a scanner used to get the input
     * @param prompt the prompt that tells the user what to enter
     * @return
     */
    public static int getInt(Scanner pipe, String prompt)

    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do {

            System.out.println(prompt + ": ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
          else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash);
            }
        }

        while(!done);

        return retVal;

    }

    /**
     * get a double value from the user at the console with no restraint
     *
     * @param pipe
     * @param prompt
     * @return
     */
    public static double getDouble(Scanner pipe, String prompt)

    {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do {

            System.out.println(prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash);
            }
        }

        while(!done);

        return retVal;

    }

}
