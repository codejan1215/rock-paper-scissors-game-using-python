package Java.School;

public class TemparatureSensor {
    private double currentTemp;
    
    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double temp) {
        if (temp >= -273.15) {
            this.currentTemp = temp;
        } else System.out.println("Temperature cannot be below absolute zero.");
    }

    public static void main(String[] args) {
        TemparatureSensor ts1 = new TemparatureSensor();
        ts1.setCurrentTemp(25.0);
        System.out.println("Current Temperature: " + ts1.getCurrentTemp() + "°C");

        TemparatureSensor ts2 = new TemparatureSensor();
        ts2.setCurrentTemp(-300.0);
        System.out.println("Current Temperature: " + ts2.getCurrentTemp() + "°C");
    }
}
