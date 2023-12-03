interface LoginHandler {
    void LoginRequest(User user);
}
class ConsoleOutputHandler implements LoginHandler{
    private LoginHandler next_request;
    public void setNextRequest(LoginHandler next_request){
        this.next_request = next_request;
    }
    @Override
    public void LoginRequest(User user){
        if(next_request != null){
            next_request.LoginRequest(user);
        } else {
            System.out.println("Console");
        }
    }
}
class FileHandler implements LoginHandler{
    private LoginHandler next_request;
    public void setNextRequest(LoginHandler next_request){
        this.next_request = next_request;
    }
    @Override
    public void LoginRequest(User user){
        if(next_request != null){
            next_request.LoginRequest(user);
        } else {
            System.out.println("File");
        }
    }
}
class NetworkSocketHandler implements LoginHandler{
    private LoginHandler next_request;
    public void setNextRequest(LoginHandler next_request){
        this.next_request = next_request;
    }
    @Override
    public void LoginRequest(User user){
        if(next_request != null){
            next_request.LoginRequest(user);
        } else {
            System.out.println("Server");
        }
    }
}

class CheckingHandler implements LoginHandler{
    private LoginHandler next_request;
    public void setNextRequest(LoginHandler next_request){
        this.next_request = next_request;
    }
    @Override
    public void LoginRequest(User user){
        if(user.getEmail().equals("admin@example.com")){
            System.out.println("Email correct");
            if(user.getPassword().equals("12345")){
                System.out.println("Password correct");
                next_request.LoginRequest(user);
            } else {
                System.out.println("Password incorrect");
            }
        } else {
            System.out.println("Email incorrect");
        }
    }
}
class User {
    private String email;
    private String password;
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
public class Main {
    public static void main(String[] args) {
        ConsoleOutputHandler console = new ConsoleOutputHandler();
        FileHandler file = new FileHandler();
        NetworkSocketHandler server = new NetworkSocketHandler();
        CheckingHandler check = new CheckingHandler();

        console.setNextRequest(check);
        check.setNextRequest(file);
        file.setNextRequest(server);

        User user = new User("admin@example.com", "12345");
        console.LoginRequest(user);
    }
}