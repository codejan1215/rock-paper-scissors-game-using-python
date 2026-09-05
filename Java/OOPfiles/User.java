package Java.OOPfiles;

public class User {
    private int id;
    private String name;
    private String role;        // "student" or "officer"
    private String yearSection; // e.g. BSCPE 2A

    public User(int id, String name, String role, String yearSection) {
        this.id    = id;
        this.name        = name;
        this.role        = role;
        this.yearSection = yearSection;
    }

    public int getId()          { return id; }
    public String getName()        { return name; }
    public String getRole()        { return role; }
    public String getYearSection() { return yearSection; }

    public boolean isOfficer() {
        return role.equalsIgnoreCase("officer");
    }
}
