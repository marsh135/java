public class LibraryItem implements Checkable{
    //implements Checkable interface to ensure all library items can be checked in and out
    //Signs a contract that all library items must have these methods implemented

    private String title;
    private int id;
    private boolean isCheckedOut;
    private String type;

    public LibraryItem(String title, int id, String type){
        this.title = title;
        this.id = id;
        this.type = type;
        this.isCheckedOut = false;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public void setId(int id){
        this.id =id;
    }

    public int getId(){
        return id;
    }

    public boolean isCheckedOut(){
        return isCheckedOut;
    }

    public String toString(){
        return "Type: " + type + ", ID: " + id + ", Title: " + title + ", Checked Out: " + isCheckedOut;
    }

    public boolean checkOut(){
        if(!isCheckedOut){
            isCheckedOut = true;
            return true;
        }
        return false;
    }
    
    public boolean checkIn(){
        if(isCheckedOut){
            isCheckedOut = false;
            return true;
        }
        return false;
    }       
    
}
