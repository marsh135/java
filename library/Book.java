public class Book extends LibraryItem{
    
    private String author;
    private int pages;

    public Book(String title, String author,  int id, int pages){
        super(title, id, "Book");
        this.author = author;
        this.pages = pages;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setPages(int pages){
        this.pages = pages;
    }
    public int getPages(){
        return this.pages;
    }
}
