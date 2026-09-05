package Java.SchoolOOPproject;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String time = LocalTime.now().format(formatter);
        System.out.println("Time: " + time);


        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Welcome to the School Organization Management System");
        System.out.println("-----------------------------------------------------");

        //User input for role selection
        System.out.println("Are you a student or teacher?");
        System.out.println("Please enter your role: ");
        System.out.println(" ");
        
        //Log in depends on the role selected
        System.out.println("Log in to your account");
        System.out.println("Username:");
        System.out.println("Password:");
        System.out.println(" ");

        System.out.println("Log in successful!");
        System.out.println("");
        System.out.println("");

        System.out.println("WELCOME TO YOUR DASHBOARD!");
        System.out.println("");
        System.out.println("Upcoming events:");
        System.out.println("1. Intramurals - September 15, 2024");
        System.out.println("2. Science Fair - October 10, 2024");
        System.out.println("3. Art Exhibition - November 5, 2024");

        System.out.println("Today's events:");
        System.out.println("1. Basketball Tournament (Gymnasium) - 8:00 AM");
        System.out.println("2. Debate Competition (Library) - 3:00 PM");
        System.out.println("3. Music Concert (Auditorium) - 7:00 PM");

        System.out.println("");
        System.out.println("Attend to our events and activities to enhance your school experience!");
        System.out.println("Name: ");
        System.out.println("Grade and Section: ");
        System.out.println("Choose an event to attend: ");
        System.out.println("");

        //selecting an event to attend
        System.out.println("1. Basketball Tournament");
        System.out.println("2. Debate Competition");
        System.out.println("3. Music Concert");
        System.out.println("");

        System.out.println("Do you want to add another event? (yes/no)");
        System.out.println("");
        //if yes, repeat the process of selecting an event

        //after selecting an event
        System.out.println("You have successfully checked in for the event!");
        System.out.println(" ");
        System.out.println("Event Name: Basketball Tournament");
        System.out.println("Event Location: Gymnasium");
        System.out.println("Event Time: 8:00 AM");
        System.out.println("Time of Check-in: " + time);
        System.out.println("Student Name: John Doe");
        System.out.println("Grade and Section: BSCPE 2A");

        

    }
}
