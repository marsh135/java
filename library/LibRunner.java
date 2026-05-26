import java.util.ArrayList;
import java.util.Scanner;

public class LibRunner{
    private static ArrayList<LibraryItem> libraryItems = new ArrayList<>();
    public static void main(String[] args){
        final  Boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1, 180);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 2, 281);
        Movie movie1 = new Movie("Inception", "Christopher Nolan", 3, "Blu-ray", 148);
        Movie movie2 = new Movie("The Matrix", "The Wachowskis", 4, "DVD", 136);
        libraryItems.add(book1);
        libraryItems.add(book2);
        libraryItems.add(movie1);
        libraryItems.add(movie2);

        while(isRunning){
            
            System.out.println("Choose an option: \n 1. Register new media \n 2. Check inventory \n 3. Check in \n 4. Check out \n 5. Exit");
            int choice =  scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){ 
                createItem(scanner);
            }
            else if(choice == 2){
                System.out.println("Inventory: ");
                for(LibraryItem item : libraryItems){
                    System.out.println(item.toString());
                }
            }
            else if(choice == 3){
                System.out.println("Enter an ID number to check in: ");
                int id = scanner.nextInt();
                for(LibraryItem item : libraryItems){
                    if(item.getId() == id){
                        if(item.checkIn()){
                            System.out.println(item.getTitle() + " checked in successfully.");
                        }
                        else{
                            System.out.println(item.getTitle() + " could not be checked in.");
                        }
                    }
                }

            }
            else if(choice == 4){
                System.out.println("Enter an ID number to check out: ");
                int id = scanner.nextInt();
                for(LibraryItem item : libraryItems){
                    if(item.getId() == id){
                        if(item.checkOut()){
                            System.out.println(item.getTitle() + " checked out successfully.");
                        }
                        else{
                            System.out.println(item.getTitle() + " could not be checked out.");
                        }
                    }
                }
            }
            else if(choice == 5){
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
            }
            else{
                System.out.println("Invalid choice.");
            }
            
        }
    }

    public static void createItem(Scanner scanner){
        System.out.println("Enter the type of item (book/movie/magazine/newspaper): ");
        String input = scanner.nextLine().toLowerCase();
        if(input.equals("book") || input.equals("b"))
            {
            System.out.println("Enter the title: ");
            String title = scanner.nextLine();
            System.out.println("Enter the author: ");
            String author = scanner.nextLine();
            System.out.println("Enter the ID Number: ");
            int id = scanner.nextInt();
            System.out.println("Number of Pages: ");
            int numPages = scanner.nextInt();
            scanner.nextLine();

            Book book = new Book(title, author, id, numPages);
            libraryItems.add(book);
        }
        else if(input.equals("movie") || input.equals("m"))
            {
            System.out.println("Enter the title: ");
            String title = scanner.nextLine();
            System.out.println("Enter the director: ");
            String director = scanner.nextLine();
            System.out.println("Enter the format: ");
            String format = scanner.nextLine();
            System.out.println("Enter the ID Number: ");
            int id = scanner.nextInt();
            System.out.println("Run Time: ");
            int runtime = scanner.nextInt();
            scanner.nextLine();

            Movie movie = new Movie(title, director, id, format, runtime);
            libraryItems.add(movie);
        }
        else if(input.equals("magazine") || input.equals("mag")){
            System.out.println("Enter the title: ");
            String title = scanner.nextLine();
            System.out.println("Enter the publisher: ");
            String publisher = scanner.nextLine();
            System.out.println("Enter the ID Number: ");
            int id = scanner.nextInt();
            System.out.println("Issue Number: ");
            int issueNumber = scanner.nextInt();
            scanner.nextLine();

            Magazine magazine = new Magazine(title, publisher, id, issueNumber);
            libraryItems.add(magazine);
        }
        
       
        else{
            System.out.println("Invalid item type.");
        }
    }
    
}
