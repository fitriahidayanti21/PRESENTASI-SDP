public class LoginRequest {
    String username;
    String password;
    String role;
    String ip;

    public LoginRequest(String username, String password, String role, String ip) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.ip = ip;
    }
}