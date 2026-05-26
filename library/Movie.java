public class Movie extends LibraryItem{

    private String format;
    private int runtime;
    private String director;

    public Movie(String title, String director, int id, String format, int runtime){
        super(title, id, "Movie");
        this.format = format;
        this.director = director;
        this.runtime = runtime;
    }

    public void setFormat(String format){
        this.format = format;
    }

    public String getFormat(){
        return this.format;
    }

    public void setRuntime(int runtime){
        this.runtime = runtime;
    }
    public int getRuntime(){
        return this.runtime;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public String getDirector(){
        return this.director;   
    }
    
}
