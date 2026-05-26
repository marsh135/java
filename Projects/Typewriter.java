package Projects;

public class Typewriter {

    public static final String RESET   = "\u001B[0m";
    public static final String RED     = "\u001B[31m";
    public static final String GREEN   = "\u001B[32m";
    public static final String YELLOW  = "\u001B[33m";
    public static final String BLUE    = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN    = "\u001B[36m";
    public static final String WHITE   = "\u001B[37m";

    public static void typeOut(String message) throws InterruptedException {
        int delayMillis = 20;
        for (char c : message.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            Thread.sleep(delayMillis);
        }
            System.out.println();
        }

        public static void typeOut(String message, String color) throws InterruptedException {
            int delayMillis = 20;
            System.out.print(color);
            for (char c : message.toCharArray()) {
                System.out.print(c);
                System.out.flush();
                Thread.sleep(delayMillis);
            }
            System.out.println(RESET); // reset to normal after message
        }
    
    }