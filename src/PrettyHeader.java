public class PrettyHeader {
    public static void main(String[] args) {
        prettyHeader("Message Centered Here");
    }

    public static void prettyHeader(String msg) {
        int totalWidth = 60;
                int msgWidth = msg.length();
                int padding = (totalWidth - msgWidth - 6) / 2;

                printLine(totalWidth);
                System.out.print("***");
                for (int i = 0; i < padding; i++) System.out.print(" ");
                System.out.print(msg);
                for (int i = 0; i < padding; i++) System.out.print(" ");
                System.out.println("***");
                printLine(totalWidth);
            }

    public static void printLine(int width) {
        for (int i = 0; i < width; i++) System.out.print("*");
        System.out.println();
    }
}