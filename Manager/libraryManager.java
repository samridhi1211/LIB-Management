package Manager;
import Model.*;
import java.util.ArrayList;

public class libraryManager 
{
    ArrayList<book> books=new ArrayList<>();  
    ArrayList<User> users=new ArrayList<>();
    public void addBook(book b)
    {
        books.add(b);
    }

    public void addUser(User u)
    {
        users.add(u);
    }

    public void viewAllBooks()
    {
        for(book b:books)
        {
            System.out.println(b);
        }
    }

    public ArrayList<User> getAllUsers()
    {
        return users;
    }

    public book getBookbyId(int bookId)
    {
        for(book b:books)
        {
            if(b.getBookId()==bookId)
            {
                return b;
            }

        }return null;
    }

    public User getUserbyId(int userId)
    {
        for(User u:users)
        {
            if(u.getUserId()==userId)
            {
                return u;
            }
        }
        return null;
    }

    public void searchBookByTitle(String t)
    {
        String title=t.toLowerCase();
        boolean found=false;
        for(book b:books)
        {
            String bookTitle=b.getTitle().toLowerCase();
            if(bookTitle.contains(title))
            {
                found=true;
                System.out.println(b);
            }
        }
        if(found==false)
        System.out.println("Books Not Found");
    }

    public void  borrowBook(int bookId,int userId)
    {
        book b=getBookbyId(bookId);
        User u=getUserbyId(userId);
        if(b!=null && u!=null && b.getavailableCopies()>0)
        {
            b.decreaseCopies();
            u.borrowedBookId(bookId);
            System.out.println("Book borrowed successfully");
        }
        else
        {
            System.out.println("Unable to borrow book");
        }
    }

    public void returnBook(int bookId,int userId)
    {
        book b=getBookbyId(bookId);
        User u=getUserbyId(userId);
        if(b!=null && u!=null)
        {
            b.increaseCopies();
            u.returnBook(bookId);
            System.out.println("Book returned successfully");
        }
        else{
            System.out.println("Unable to return book");
        }
    }
}