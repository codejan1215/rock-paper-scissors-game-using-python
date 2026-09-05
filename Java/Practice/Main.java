package Java.Practice;
import java.util.*;

public class Main {
    // User class to represent a user in the system
    public static class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() { return name; }
    }
    // UserManager class to handle user login
    public static class UserManager {

        public User login(Scanner sc) {

            System.out.print("Enter your name: ");
            String name = sc.nextLine().trim();

            for (int attempts = 0; attempts < 3; attempts++) {
                if (!name.isEmpty() && name.matches("[a-zA-Z]{3,10}")) {
                    return new User(name);
                }
                System.out.println("Invalid input. Please enter a valid name (letters only, 3-10 characters). Attempts left: " + (2 - attempts));
                System.out.print("Enter your name: ");
                name = sc.nextLine().trim();
            }
            return null; // Failed to login after 3 attempts
        }
    }
    // Food class to represent a food item
    public static class Food {
        private static int idCounter = 1;

        private int id;
        private String foodName;
        private double price;

        public Food(String foodName, double price) {
            this.id = idCounter++;
            this.foodName = foodName;
            this.price    = price;
        }

        public String getFoodName() { return foodName; }
        public double getPrice()    { return price; }
        public int getId()          { return id; }

        @Override
        public String toString() {
            return String.format("  [%d] %-20s - $ %.2f", id, foodName, price);
        }
    }
    // FoodManager class to manage food items
    public static class FoodManager {
        private static FoodManager instance;

        public static FoodManager getInstance() {
            if (instance == null) instance = new FoodManager();
            return instance;
        }

        private List<Food> foods = new ArrayList<>();

        private FoodManager() {
            // Pre-loaded sample foods
            foods.add(new Food("Adobo", 5.00));
            foods.add(new Food("Sinigang", 7.00));
            foods.add(new Food("Lechon", 10.00));
            foods.add(new Food("Kare-Kare", 9.00));
        }

        public List<Food> getAll() { return foods; }

        public List<Food> getFoodsByPrice(double maxPrice) {
            List<Food> result = new ArrayList<>();
            for (Food f : foods)
                if (f.getPrice() <= maxPrice) result.add(f);
            return result;
        }

        public Food getById(int id) {
            for (Food f : foods)
                if (f.getId() == id) return f;
            return null;
        }

        public void addFood(Food f) { foods.add(f); }

        public boolean removeFood(int id) {
            return foods.removeIf(f -> f.getId() == id);
        }
    }
    //Dashboard class to show user options
    public static class Dashboard {
        private User user;
        private FoodManager foodManager;

        public Dashboard(User user){
            this.user = user;
            this.foodManager = FoodManager.getInstance();
        }

        public void showDashboard(Scanner sc){
            System.out.println("\nWELCOME TO THE FOOD ORDERING SYSTEM, " + user.getName().toUpperCase()+ "!");

            boolean running = true;
            while (running) {
                System.out.println("\nHere's our available food menu:");
                for (Food f : foodManager.getAll()) {
                    System.out.println(f);
                }

                System.out.println("  [0] Exit");
                System.out.print("\nEnter Food ID: ");
                String input = sc.nextLine().trim();

                switch (input) {
                    case "1":
                        System.out.println("You have ordered: " + foodManager.getById(1).getFoodName() + " - $ " + foodManager.getById(1).getPrice());
                        break;
                    case "2":
                        System.out.println("You have ordered: " + foodManager.getById(2).getFoodName() + " - $ " + foodManager.getById(2).getPrice());
                        break;
                    case "3":
                        System.out.println("You have ordered: " + foodManager.getById(3).getFoodName() + " - $ " + foodManager.getById(3).getPrice());
                        break;
                    case "4":
                        System.out.println("You have ordered: " + foodManager.getById(4).getFoodName() + " - $ " + foodManager.getById(4).getPrice());
                        break;
                    case "0":
                        System.out.println("Thank you for using the Food Ordering System. Goodbye!");
                        running = false;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UserManager userManager = new UserManager();
        User user = userManager.login(sc);
        Dashboard dashboard = new Dashboard(user);
        dashboard.showDashboard(sc);

        sc.close();
    }
}
