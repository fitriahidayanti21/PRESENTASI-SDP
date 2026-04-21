public class SecurityHandler extends AuthHandler {

    @Override
    public boolean handle(LoginRequest request) {
        if (request.ip.equals("192.168.1.100")) {
            System.out.println("[ERROR] IP diblokir (security risk)");
            return false;
        }

        System.out.println("[OK] Security check passed");
        return handleNext(request);
    }
}