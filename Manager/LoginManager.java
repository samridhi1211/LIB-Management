package Manager;

import java.util.ArrayList;
import Model.*; // Correct class name with capital 'U'

public class LoginManager {

    public User login(String u, String p, ArrayList<User> users) {
        for (User user : users) {
            String tempUserName = user.userName(); 
            String tempPassword = user.password();

            if (tempUserName.equals(u) && tempPassword.equals(p)) {
                return user;
            }
        }
        return null;
    }
}

