package escapeRooms;
import java.util.Scanner;


public class breakout {


    public static boolean snGate = false;
    public static boolean pwGate =  false;
    public static boolean rGate =  false;

    public static void main(String[] args)
    {
        System.out.println("\u001B[34m"+"Welcome to the Library Breakout Game!");
        System.out.println("\n\n\nthis should still be blue");
        System.out.println("\n\n\n");
        Scanner s =  new Scanner(System.in);
        try {
            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.GREEN);
            Typewriter.typeOut("The time is now 10:00 PM.", Typewriter.GREEN);
            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.GREEN);
            Typewriter.typeOut("\n\nYou and your team have been locked inside the old town library \nafter closing hours. According to local legend, the head librarian, \nMs. Wren, hid a powerful secret in these walls before she mysteriously \nvanished. To escape, you must follow her trail of clues before the doors \nlock permanently at midnight.\n\n");
            Typewriter.typeOut("Hidden in the margins of three different old books are faintly written Roman numerals:\n" );
            Typewriter.typeOut("\tBook of Maps: C");
            Typewriter.typeOut("\tBook of Fables: XXX");
            Typewriter.typeOut("\tBook of Poetry: V");
            Typewriter.typeOut("There is a locked chest that requires a number to open - what is the number? ");

        
        } catch (InterruptedException e) {
            System.err.println("An error occurred: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        while(!snGate){
            try {
                Typewriter.typeOut("What is the number? ");
            } catch (InterruptedException e) {
                System.err.println("An error occurred: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            int ug = s.nextInt();
            snGate = breakOutMethods.sn(ug);
        }

        System.out.println("\n\n\n");
        try {

            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.YELLOW);
            Typewriter.typeOut("The time is now 11:00 PM.", Typewriter.YELLOW);
            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.YELLOW);
            Typewriter.typeOut("You successfully opened the chest and found a book.\n Inside the book, a riddle is inscribed.");
            Typewriter.typeOut("\tI am always hungry,");
            Typewriter.typeOut("\tI must always be fed,");
            Typewriter.typeOut("\tThe finger I lick");
            Typewriter.typeOut("\tWill soon turn red.,");
        } catch (InterruptedException e) {
            System.err.println("An error occurred: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        while(!rGate){
            try {
                Typewriter.typeOut("What am I? ");
            } catch (InterruptedException e) {
                System.err.println("An error occurred: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            s.nextLine();
            String ri = s.nextLine();
            rGate = breakOutMethods.ri(ri);
        }
        System.out.println("\n\n\n");
        try {
            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.RED);
            Typewriter.typeOut("The time is now 11:54 PM.", Typewriter.RED);
            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.RED);
            Typewriter.typeOut("The answer leads to a small lantern in the room. When lit, it reveals hidden writing on the wall..");
            Typewriter.typeOut("\tSpeak the word that is never spelled wrong.");
        } catch (InterruptedException e) {
            System.err.println("An error occurred: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        
        while(!pwGate){
            try {
                Typewriter.typeOut("What is the password? ");
            } catch (InterruptedException e) {
                System.err.println("An error occurred: " + e.getMessage());
                Thread.currentThread().interrupt();
            }

            String pw = s.nextLine();
            pwGate = breakOutMethods.pw(pw);
        }
        System.out.println("\n\n\n");
        try {
            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.RED);
            Typewriter.typeOut("The time is now 11:59 PM.", Typewriter.YELLOW);
            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.GREEN);
            Typewriter.typeOut("In the distance, you hear a lock click, \n and see a faint glimmer of light that slowly widens to a flood. \n You have escaped the library, and learned a valuable lesson\n on the dangers of reading.", Typewriter.GREEN);
            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.GREEN);
            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.GREEN);
            Typewriter.typeOut("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-", Typewriter.GREEN);

        } catch (InterruptedException e) {
            System.err.println("An error occurred: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

}
