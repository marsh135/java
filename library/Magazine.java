public class Magazine extends LibraryItem implements Checkable{
    
    private String publisher;
    private int issueNumber;

    public Magazine(String title, String publisher, int id, int issueNumber){
        super(title, id, "Magazine");
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public void setIssueNumber(int issueNumber){
        this.issueNumber = issueNumber;
    }
    public int getIssueNumber(){
        return this.issueNumber;
    }
    
}
