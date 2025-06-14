import java.util.*;

// import Model.book;
// import Model.User;
import Manager.*;
import Model.*;

public class Main_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        libraryManager library = new libraryManager();
        LoginManager l = new LoginManager();

        User currentUser = null;
        while(currentUser == null){
            System.out.println("1. login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Username:");
                String username = sc.next();
                System.out.println("Password:");
                String  password = sc.next();
                currentUser = l.login(username,password, library.getAllUsers());
                if(currentUser == null){
                    System.out.println("invvalid ");
                }
            } else if (choice ==2){
                System.out.println("Name:");
                String name = sc.nextLine();
                System.out.println("Username:");
                String username  = sc.next();
                System.out.println("Enter your password");
                String password=sc.next();
                int userId = 1000 + new Random().nextInt(9000);
                User newuser =  new User(userId , name , username , password , false);
                library.addUser(newuser);
                System.out.println("User Registered Sucesfully , now You can Login");
             } else if (choice ==3){
            System.out.println("Goodbye");
            return;
        }else{
            System.out.println("Invalid choice , try again");
        }
        }
        System.out.println("welcome" + currentUser.getName());
        int choice;
        do{
            System.out.println("=========Menu========");
            if (currentUser.getIsAdmin()){
                System.out.println("1.AddBook");
                System.out.println("2.Viewbook");
                System.out.println("3.ViewUser");
                System.out.println("4.Logout");
                choice = sc.nextInt();
                if ( choice ==1){
                    System.out.print("Book Title:");
                    String title = sc.nextLine();
                    System.out.println("Book Author:");
                    String author= sc.nextLine();
                    System.out.println("Book Publisher:");
                    String publisher=sc.nextLine();
                    System.out.println("Copies:");
                    int copies=sc.nextInt();
                    System.out.println(" Book year:");
                    int year = sc.nextInt();
                    int bookId =1000 + new Random().nextInt(9000);
                    book newBook = new book(bookId, title,author , publisher , year , copies);
                    library.addBook(newBook);
                    System.out.println("Book added successfully");
                    
                } else if  ( choice ==2){
                    System.out.println("========Book List=========");
                    library.viewAllBooks();
                } else if (choice ==3){
                    System.out.println("========User List======== ");
                ArrayList<User>users = library.getAllUsers();
                for (User u : users){
                    String role;
                    if (u.getIsAdmin()){
                        role ="Admin";
                    }else {
                        role = "User";
                    }
                    System.out.println(u.getUserId() + ":" + u.getName() + "|Role" +role);
                    
                }
            }else if (choice==4) {
                System.out.println("Goodbye");
                return;
            } else{
                System.out.println("Invalid choice , Try again");
            }
            }else {
                System.out.println("1, view Book");
                System.out.println("2. Search Book");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. My Borrowed book" );
                System.out.println("6. logout");
                choice = sc.nextInt();
                if (choice == 1){
                    System.out.println("=====Book List=====");
                    library.viewAllBooks();
                }else if(choice ==2){
                    System.out.println("keyword:");
                    String keyword = sc.nextLine();
                    library.searchBookByTitle(keyword);
                }else if(choice == 3){
                    System.out.println("BookId");
                    int bookId = sc.nextInt();
                    library.borrowBook(bookId , currentUser.getUserId());
                }else if (choice == 4){
                    System.out.println("BookId");
                    int bookId = sc.nextInt();
                    library.returnBook(bookId,currentUser.getUserId());
                }else if(choice == 6){
                    System.out.println("=====Logged out=====");
                    return;
                }  else{
                    System.out.println("invalid  choice ,Try Again");
                }  

             }


            }while(true);
           
        }
    }
    

