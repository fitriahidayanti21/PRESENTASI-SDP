public class RoleHandler extends AuthHandler {

    @Override
    public boolean handle(LoginRequest request) {
        if (!request.role.equals("admin") && !request.role.equals("user")) {
            System.out.println("[ERROR] Role tidak valid");
            return false;
        }

        System.out.println("[OK] Role valid: " + request.role);
        return handleNext(request);
    }
}