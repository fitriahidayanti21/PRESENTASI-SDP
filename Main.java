public class Main {

    public static void main(String[] args) {

        // bikin chain
        AuthHandler h1 = new CredentialHandler();
        AuthHandler h2 = new RoleHandler();
        AuthHandler h3 = new SecurityHandler();

        h1.setNext(h2);
        h2.setNext(h3);

        // =========================
        runTest("TEST 1 - BERHASIL",
                new LoginRequest("admin", "1234", "admin", "192.168.1.1"),
                h1);

        runTest("TEST 2 - PASSWORD SALAH",
                new LoginRequest("admin", "wrong", "admin", "192.168.1.1"),
                h1);

        runTest("TEST 3 - ROLE SALAH",
                new LoginRequest("admin", "1234", "superadmin", "192.168.1.1"),
                h1);

        runTest("TEST 4 - IP DIBLOKIR",
                new LoginRequest("admin", "1234", "admin", "192.168.1.100"),
                h1);
    }

    static void runTest(String title, LoginRequest request, AuthHandler handler) {
        System.out.println("\n=========================");
        System.out.println(title);
        System.out.println("=========================");

        boolean result = handler.handle(request);

        System.out.println("LOGIN STATUS: " + (result ? "BERHASIL" : "GAGAL"));
    }
}