public abstract class AuthHandler {
    protected AuthHandler next;

    public void setNext(AuthHandler next) {
        this.next = next;
    }

    public abstract boolean handle(LoginRequest request);

    protected boolean handleNext(LoginRequest request) {
        if (next == null) return true;
        return next.handle(request);
    }
}