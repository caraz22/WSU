package Part2;

public class SecureUser extends User {
    
    private String password;
    private int failedAttemps = 0;

    public SecureUser(String username, String password) {
        super(username, password);
        this.password = password;
    }

    @Override
    public boolean authenticate(String inputPassword) {
        if (isValidPassword() == false) {
            System.out.println("Invalid password, authentication will be denied.");
        }

        if (inputPassword.equals(password)) {
            if (failedAttemps < 3) {
                failedAttemps = 0;
                return true;
            } else {
                System.out.println("You are locked out of your account.");
                return false;
            }
        } else {
            if (failedAttemps < 3) {
                failedAttemps++;
            } else {
                System.out.println("You are locked out of your account.");
            }

            return false;
        }
    }
}
