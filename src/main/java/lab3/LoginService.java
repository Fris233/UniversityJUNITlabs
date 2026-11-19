package lab3;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private static final Map<String, String> records = new HashMap<>();
    static {
        records.put("user", "Pass12");                     // 4char username, 6char password
        records.put("user1", "ValidPass1");                // 5char username
        records.put("admin1", "Secre1");
        records.put("user123456789012345", "ValidPass1");  // 19char username
        records.put("user1234567890123456", "ValidPass1"); // 20char username
    }

    public String login(String username, String password) {

        if(username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return "empty input";
        }

        //username: 4-20 alphanumeric characters
        if (!isValidUsername(username)) {
            return "invalid format";
        }

        // password: at least 6 chars, >= 1 uppercase, >= 1 digit
        if (!isValidPassword(password)) {
            return "invalid format";
        }

        // test against stored records
        String storedPassword = records.get(username);
        if (storedPassword != null && storedPassword.equals(password)) {
            return "Login successful";
        }

        return "wrong credentials";
    }

    private boolean isValidUsername(String username) {
        return username.trim().matches("^[a-zA-Z0-9]{4,20}$");
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 6) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasUppercase && hasDigit;
    }
}