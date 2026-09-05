package Java.OOPfiles;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private static EventManager instance;

    public static EventManager getInstance() {
        if (instance == null) instance = new EventManager();
        return instance;
    }

    private List<Event> events = new ArrayList<>();

    private EventManager() {
        // Pre-loaded sample events
        events.add(new Event("General Assembly", "7th Floor, Science Building",        "Today",        "8:00 AM",  "OSA"));
        events.add(new Event("Mental Health Awareness",    "7th Floor, Science Building",      "Today",        "1:00 PM",  "OSA"));
        events.add(new Event("CPElympics",         "FEU Tech",       "Today",        "4:00 PM",  "CPE Org"));
        events.add(new Event("CPE Challenge",           "4th Floor, Science Building",       "May 8, 2026", "7:00 AM",  "OSA"));
        events.add(new Event("Intramurals",          "PCU Main Campus", "May 9, 2026", "9:00 AM",  "OSA"));
        events.add(new Event("Foundation Day",        "PCU Main Campus",  "May 11, 2026",  "10:00 AM", "OSA"));
    }

    public List<Event> getAll() { return events; }

    public List<Event> getTodayEvents() {
        List<Event> result = new ArrayList<>();
        for (Event e : events)
            if (e.isToday()) result.add(e);
        return result;
    }

    public List<Event> getUpcomingEvents() {
        List<Event> result = new ArrayList<>();
        for (Event e : events)
            if (!e.isToday()) result.add(e);
        return result;
    }

    public Event getById(int id) {
        for (Event e : events)
            if (e.getId() == id) return e;
        return null;
    }

    public void addEvent(Event e) { events.add(e); }

    // Remove an event by ID — returns true if found and removed, false if not found
    public boolean removeEvent(int id) {
        return events.removeIf(e -> e.getId() == id);
    }
}
