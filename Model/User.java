package Model;
import java.util.*;

public class User {
    private int userId;
    private String name;
    private String username;
    private String password;
    private boolean isAdmin;
    private ArrayList<Integer> borrowedBookId=new ArrayList<>();

    // constructor
    public User(int userId, String name, String username, String password , boolean isAdmin)
    {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    // getters
    public int getUserId(){
        return userId;
    }
    //getname
    public String getName(){
        return name;
    }
    public String getusername(){
        return username;
    }
    public String password(){
        return password;
    }
    public boolean getIsAdmin(){
        return isAdmin;
    }

    public void borrowedBookId(int bookId){
        borrowedBookId.add(bookId);
    } 
    public void returnBook(int bookId){
         borrowedBookId.remove(bookId);
    }

    public void ShowBorrowedBooks(){
        if(borrowedBookId.isEmpty()){
            System.out.println("you have no borrowed");
        }else{
            System.out.println("borrowed book id : "+ borrowedBookId);

        }
        }
    }
