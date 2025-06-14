package Model;

public class book {
    private int BookId;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int totalCopies;
    private int availableCopies;
    // constructor 
    public book(int BookId, String title, String author, String publisher, int year,int copies ){
        this.BookId=BookId;
        this.title=title;
        this.author=author;
        this.publisher=publisher;
        this.year=year;
        this.totalCopies=copies;
        this.availableCopies=copies;
    }

    // getters
    public int getBookId() {
        return BookId;
    }
     public String getTitle() {
        return title;
    }

     public String getAuthor() {
        return author;
    }
     public String getPublisher() {
        return publisher;
    }
     public int getYear() {
        return year;
    }
     public int gettotalCopies() {
        return totalCopies;
    }
     public int getavailableCopies() {
        return availableCopies;
    }
    public void increaseCopies(){
        this.availableCopies++;
    }
    public void decreaseCopies(){
        if(this.availableCopies>0){
            this.availableCopies--;
        }
    }
    public String fullDetails(){
       return "Book ID: "+BookId+"\nTitle: "+title+"\nAuthor: "+"\nYear: "+year+"\nPublisher: "+publisher+"\nTotal Copies: "+totalCopies+"\nAvailableCopies: "+availableCopies;
    }
    }