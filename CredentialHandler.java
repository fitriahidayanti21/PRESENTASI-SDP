public class CredentialHandler extends AuthHandler {

    @Override
    public boolean handle(LoginRequest request) {
        if (!request.username.equals("admin") || !request.password.equals("1234")) {
            System.out.println("[ERROR] Username atau password salah");
            return false;
        }

        System.out.println("[OK] Credential valid");
        return handleNext(request);
    }
}