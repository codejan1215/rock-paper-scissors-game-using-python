package Java.OOPfiles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManager {

    // studentID
    private final Map<Integer, String[]> userDB = new HashMap<>();

    // officer account
    private static final User OFFICER = new User(9999999, "Admin Officer", "officer", "N/A");

    public UserManager() {
        userDB.put(202400111, new String[]{"John Ybrahim Elorta",    "BSCPE 2A"});
        userDB.put(202488022, new String[]{"Krizabelle Ione Balino", "BSIT 3B"});
        userDB.put(202499999, new String[]{"Ram-Edvielen P. Lucena", "BSCS 2C"});
        userDB.put(202411111, new String[]{"James Edward H. Sarte",  "BSIT 3B"});
    }

    public User login(Scanner scanner) {
        // Ask for role
        System.out.println("┌──────────────────────────────────────────────────────┐");
        System.out.println("│                    ROLE SELECTION                    │");
        System.out.println("└──────────────────────────────────────────────────────┘");
        System.out.println("  [1] Student");
        System.out.println("  [2] Admin");
        System.out.print("  Enter your role (1 or 2): ");
        String roleChoice = scanner.nextLine().trim();
        System.out.println();

        // Officer dashboard
        if (roleChoice.equals("2")) {
            System.out.println("  Welcome, Officer " + OFFICER.getName() + "!");
            System.out.println();
            return OFFICER;
        }

        // Student — enter student ID 
        for (int attempts = 0; attempts < 3; attempts++) {
            System.out.println("──────────────────────────────────────────────────────");
            System.out.println("  STUDENT LOGIN");
            System.out.println("──────────────────────────────────────────────────────");
            System.out.print("  Student ID: ");
            String input = scanner.nextLine().trim();
            System.out.println();

            // Make sure the input is a valid number
            int studentID;
            try {
                studentID = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("  Invalid ID. Please enter numbers only. Attempts left: " + (2 - attempts));
                System.out.println();
                continue;
            }

            if (userDB.containsKey(studentID)) {
                String[] data = userDB.get(studentID);
                System.out.println("  Login successful! Welcome, " + data[0] + "!");
                System.out.println();
                return new User(studentID, data[0], "student", data[1]);
            }

            System.out.println("  Student ID not found. Attempts left: " + (2 - attempts));
            System.out.println();
        }

        return null; // too many failed attempts
    }
}
