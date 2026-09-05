package Java.OOPfiles;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private static int idCounter = 1;

    private int    id;
    private String name;
    private String location;
    private String date;
    private String time;
    private String organizer;
    private List<String> attendees; // stored as "Name | Year&Section | Check-in Time"

    public Event(String name, String location, String date, String time, String organizer) {
        this.id        = idCounter++;
        this.name      = name;
        this.location  = location;
        this.date      = date;
        this.time      = time;
        this.organizer = organizer;
        this.attendees = new ArrayList<>();
    }

    public void addAttendee(String entry) {
        attendees.add(entry);
    }

    public boolean isToday() {
        return date.equalsIgnoreCase("Today");
    }

    public int         getId()        { return id; }
    public String      getName()      { return name; }
    public String      getLocation()  { return location; }
    public String      getDate()      { return date; }
    public String      getTime()      { return time; }
    public String      getOrganizer() { return organizer; }
    public List<String> getAttendees(){ return attendees; }

    @Override
    public String toString() {
        return String.format("  [%d] %-28s | %-22s | %s | %s",
                id, name, location, date, time);
    }
}
