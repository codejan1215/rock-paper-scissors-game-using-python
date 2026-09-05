package Java.OOPfiles;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Dashboard {

    private User user;
    private EventManager eventManager;

    // Reusable format for event tables
    private static final String TABLE_HEADER  = "  %-5s %-28s %-22s %-15s %s%n";
    private static final String TABLE_DIVIDER = "  " + "─".repeat(80);

    public Dashboard(User user) {
        this.user         = user;
        this.eventManager = EventManager.getInstance();
    }

    // ── STUDENT DASHBOARD 

    public void showStudentDashboard(Scanner scanner) {
        printHeader("STUDENT DASHBOARD!");

        boolean running = true;
        while (running) {
            System.out.println("  ┌─────────────────────────────────────────────────────┐");
            System.out.println("  │                    MAIN MENU                        │");
            System.out.println("  ├─────────────────────────────────────────────────────┤");
            System.out.println("  │  [1] View Today's Events                            │");
            System.out.println("  │  [2] View Upcoming Events                           │");
            System.out.println("  │  [3] Check In to an Event                           │");
            System.out.println("  │  [4] View My Attendance Log                         │");
            System.out.println("  │  [5] Logout                                         │");
            System.out.println("  └─────────────────────────────────────────────────────┘");
            System.out.print("  Choose an option: ");
            String choice = scanner.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1" -> showEvents("TODAY'S EVENTS",  eventManager.getTodayEvents());
                case "2" -> showEvents("UPCOMING EVENTS", eventManager.getUpcomingEvents());
                case "3" -> checkIn(scanner);
                case "4" -> viewMyLog();
                case "5" -> running = false;
                default  -> System.out.println("  Invalid choice. Please try again.\n");
            }
        }
    }

    // ── OFFICER DASHBOARD 

    public void showOfficerDashboard(Scanner scanner) {
        printHeader("OFFICER DASHBOARD!");

        boolean running = true;
        while (running) {
            System.out.println("  ┌─────────────────────────────────────────────────────┐");
            System.out.println("  │                  OFFICER MENU                       │");
            System.out.println("  ├─────────────────────────────────────────────────────┤");
            System.out.println("  │  [1] View All Events                                │");
            System.out.println("  │  [2] Create New Event                               │");
            System.out.println("  │  [3] View Attendance List (by Event)                │");
            System.out.println("  │  [4] Generate OSA Report                            │");
            System.out.println("  │  [5] Remove an Event                                │");
            System.out.println("  │  [6] Logout                                         │");
            System.out.println("  └─────────────────────────────────────────────────────┘");
            System.out.print("  Choose an option: ");
            String choice = scanner.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1" -> showEvents("ALL EVENTS", eventManager.getAll());
                case "2" -> createEvent(scanner);
                case "3" -> viewAttendanceByEvent(scanner);
                case "4" -> generateOSAReport();
                case "5" -> removeEvent(scanner);
                case "6" -> running = false;
                default  -> System.out.println("  Invalid choice. Please try again.\n");
            }
        }
    }

    // ── SHARED: Show a list of events

    private void showEvents(String title, List<Event> events) {
        printSubHeader(title);
        if (events.isEmpty()) {
            System.out.println("  No events to show.\n");
            return;
        }
        System.out.printf(TABLE_HEADER, "ID", "Event Name", "Location", "Date", "Time");
        System.out.println(TABLE_DIVIDER);
        for (Event e : events) System.out.println(e);
        System.out.println();
    }

    // ── STUDENT: Check in to an event

    private void checkIn(Scanner scanner) {
        printSubHeader("EVENT CHECK-IN");
        showEvents("ALL EVENTS", eventManager.getAll());

        boolean checkingIn = true;
        while (checkingIn) {
            System.out.print("  Enter Event ID to check in: ");
            String input = scanner.nextLine().trim();

            int id;
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("  Invalid input. Please enter a number.\n");
                continue;
            }

            Event event = eventManager.getById(id);
            if (event == null) {
                System.out.println("  Event not found. Try again.\n");
                continue;
            }

            // Record check-in
            String checkInTime = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
            event.addAttendee(user.getName() + " | " + user.getYearSection() + " | " + checkInTime);

            // Show confirmation
            System.out.println();
            System.out.println("  ╔══════════════════════════════════════════════════╗");
            System.out.println("  ║            CHECK-IN SUCCESSFUL!                  ║");
            System.out.println("  ╠══════════════════════════════════════════════════╣");
            System.out.printf ("  ║  Event Name    : %-30s ║%n", event.getName());
            System.out.printf ("  ║  Location      : %-30s ║%n", event.getLocation());
            System.out.printf ("  ║  Event Date    : %-30s ║%n", event.getDate());
            System.out.printf ("  ║  Event Time    : %-30s ║%n", event.getTime());
            System.out.printf ("  ║  Check-in Time : %-30s ║%n", checkInTime);
            System.out.printf ("  ║  Student Name  : %-30s ║%n", user.getName());
            System.out.printf ("  ║  Year & Section: %-30s ║%n", user.getYearSection());
            System.out.println("  ╚══════════════════════════════════════════════════╝");
            System.out.println();

            System.out.print("  Check in to another event? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            checkingIn = again.equals("yes") || again.equals("y");
            System.out.println();
        }
    }

    // ── STUDENT: View own attendance log ─────────────────────────────

    private void viewMyLog() {
        printSubHeader("MY ATTENDANCE LOG");
        boolean found = false;

        for (Event e : eventManager.getAll()) {
            for (String record : e.getAttendees()) {
                if (!record.startsWith(user.getName())) continue;

                if (!found) {
                    System.out.printf("  %-28s %-20s %-15s%n", "Event", "Location", "Check-in Time");
                    System.out.println("  " + "─".repeat(65));
                    found = true;
                }

                String[] parts     = record.split(" \\| ");
                String checkInTime = parts.length >= 3 ? parts[2] : "N/A";
                System.out.printf("  %-28s %-20s %-15s%n", e.getName(), e.getLocation(), checkInTime);
            }
        }

        if (!found) System.out.println("  You have no attendance records yet.");
        System.out.println();
    }

    // ── OFFICER: Create a new event ──────────────────────────────────

    private void createEvent(Scanner scanner) {
        printSubHeader("CREATE NEW EVENT");
        System.out.print("  Event Name : "); String name     = scanner.nextLine().trim();
        System.out.print("  Location   : "); String location = scanner.nextLine().trim();
        System.out.print("  Date       : "); String date     = scanner.nextLine().trim();
        System.out.print("  Time       : "); String time     = scanner.nextLine().trim();
        System.out.println();

        Event newEvent = new Event(name, location, date, time, user.getName());
        eventManager.addEvent(newEvent);

        System.out.println("  Event \"" + name + "\" created! (ID: " + newEvent.getId() + ")");
        System.out.println();
    }

    // ── OFFICER: Remove an event (for emergencies) ───────────────────

    private void removeEvent(Scanner scanner) {
        printSubHeader("REMOVE AN EVENT");
        showEvents("ALL EVENTS", eventManager.getAll());

        if (eventManager.getAll().isEmpty()) return;

        System.out.print("  Enter Event ID to remove: ");
        String input = scanner.nextLine().trim();
        System.out.println();

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("  Invalid input. Please enter a number.\n");
            return;
        }

        // Get the event name before removing (for the confirmation message)
        Event event = eventManager.getById(id);
        if (event == null) {
            System.out.println("  Event not found.\n");
            return;
        }

        // Ask for confirmation before deleting
        System.out.println("  Event to remove: " + event.getName() + " on " + event.getDate());
        System.out.print("  Are you sure you want to remove this event? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        System.out.println();

        if (confirm.equals("yes") || confirm.equals("y")) {
            eventManager.removeEvent(id);
            System.out.println("  Event \"" + event.getName() + "\" has been removed successfully.");
        } else {
            System.out.println("  Removal cancelled.");
        }
        System.out.println();
    }

    // ── OFFICER: View attendance for a specific event ─────────────────

    private void viewAttendanceByEvent(Scanner scanner) {
        printSubHeader("VIEW ATTENDANCE LIST");
        showEvents("ALL EVENTS", eventManager.getAll());

        System.out.print("  Enter Event ID: ");
        String input = scanner.nextLine().trim();
        System.out.println();

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("  Invalid ID.\n");
            return;
        }

        Event event = eventManager.getById(id);
        if (event == null) {
            System.out.println("  Event not found.\n");
            return;
        }

        System.out.println("  Attendance List for: " + event.getName() + " (" + event.getDate() + ")");
        System.out.println("  " + "─".repeat(65));

        List<String> attendees = event.getAttendees();
        if (attendees.isEmpty()) {
            System.out.println("  No attendees yet.");
        } else {
            System.out.printf("  %-5s %-25s %-15s %-15s%n", "#", "Name", "Year & Section", "Check-in Time");
            System.out.println("  " + "─".repeat(65));
            for (int i = 0; i < attendees.size(); i++) {
                String[] parts = attendees.get(i).split(" \\| ");
                System.out.printf("  %-5d %-25s %-15s %-15s%n",
                        i + 1,
                        parts.length > 0 ? parts[0] : "",
                        parts.length > 1 ? parts[1] : "",
                        parts.length > 2 ? parts[2] : "");
            }
        }
        System.out.println();
    }

    // ── OFFICER: Generate summary report ─────────────────────────────

    private void generateOSAReport() {
        printSubHeader("OSA ATTENDANCE REPORT");
        System.out.println("  Generating report for Office of Student Affairs...\n");

        int total = 0;
        for (Event e : eventManager.getAll()) {
            int count = e.getAttendees().size();
            total += count;
            System.out.printf("  %-30s | Attendees: %d%n", e.getName(), count);
        }

        System.out.println("  " + "─".repeat(50));
        System.out.println("  Total Check-ins: " + total);
        System.out.println("\n  Report ready. (In a full build, this exports to a file.)\n");
    }

    // ── Helpers ──────────────────────────────────────────────────────

    private void printHeader(String title) {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.printf ("║  %-52s║%n", title);
        System.out.println("╚══════════════════════════════════════════════════════╝\n");
    }

    private void printSubHeader(String title) {
        System.out.println("  ──────────────────────────────────────────────────────");
        System.out.println("   " + title);
        System.out.println("  ──────────────────────────────────────────────────────");
    }
}
