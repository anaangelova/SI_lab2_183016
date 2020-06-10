import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SIlab2 {

    public boolean function (User user, List<String> allUsers) {
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //1
        if (user==null) { //2
            throw new RuntimeException("The user is not instantiated"); //3
        }
        if (user.getUsername()==null || user.getPassword()==null) //4
            throw new RuntimeException("The user is missing some mandatory information");//5
        String password = user.getPassword(); //6
        String passwordLower = password.toLowerCase(); //7
        if (passwordLower.contains(user.getUsername().toLowerCase())) { //8
            return false;//9
        }
        else if (passwordLower.length()<8)//10
            return false;//11
        else { //12
            boolean digit = false, upper = false, special = false;//13

            for (int i=0;i<password.length();i++) { //14 15 16
                if (Character.isDigit(password.charAt(i))) //17
                    digit = true;//18
                if (Character.isUpperCase(password.charAt(i)))//19
                    upper = true;//20
                if (specialCharacters.contains(String.valueOf(password.charAt(i))))//21
                    special = true;//22
            }
            if (!digit || !upper || !special)//23
                return false;//24
        }
        return true;//25
    }//26
}