package Java.OOPfiles;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        // Welcome screen
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║       STUDENT ORG-HUB & EVENT SCANNER SYSTEM         ║");
        System.out.println("║           Philippine Christian University            ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println("  System Time: " + currentTime + "\n");

        UserManager userManager = new UserManager();
        boolean running = true;

        while (running) {
            // Log in
            User user = userManager.login(scanner);

            if (user == null) {
                System.out.println("Too many failed attempts. Exiting system.");
                break;
            }

            // Show the right dashboard based on role
            Dashboard dashboard = new Dashboard(user);
            if (user.isOfficer()) {
                dashboard.showOfficerDashboard(scanner);
            } else {
                dashboard.showStudentDashboard(scanner);
            }

            // Ask to switch accounts
            System.out.print("  Switch to another account? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            running = again.equals("yes") || again.equals("y");
            System.out.println();
        }

        System.out.println("Thank you for using Org-Hub. Goodbye!");
        scanner.close();
    }
}
