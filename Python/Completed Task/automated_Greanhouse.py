time_of_day = input("Enter the time of day (day or night): ").strip()
temperature = float(input("Enter the current temperature in Celsius: ").strip())
humidity = float(input("Enter the current humidity percentage: ").strip())

if temperature < 10 or temperature > 35:
    print("CRITICAL ALARM: INITIATE EMERGENCY PROTOCOL.")

elif time_of_day == "day":
    if 20 <= temperature <= 28 and humidity == 60:
        print("System Status: Optimal. Plant is happy.")
    else:    
        if temperature < 20:
            print("Action: Turn on the heating system.")
        elif temperature > 28:
            print("Action: Turn on the cooling system.")
        else: print("System Status: Temperature is fine.")    
            
        if humidity < 60:
            print("Action: Turn on Misters")
        elif humidity > 60:
            print("Action: Turn on Dehumidifiers")
        else: print("System Status: Humidity is fine.")
            
elif time_of_day == "night":
    if 15 <= temperature <= 18 and 40<= humidity <= 50:
        print("System Status: Optimal. Plant is happy.")
    else: 
        if temperature < 15:
            print("Action: Turn on the heating system.")
        elif temperature > 18:
            print("Action: Turn on the cooling system.")
        else: print("System Status: Temperature is fine.")    
            
        if humidity < 40:
            print("Action: Turn on Misters")
        elif humidity > 50:
            print("Action: Turn on Dehumidifiers")
        else: print("System Status: Humidity is fine.")
else:
    print("Invalid input for time of day. Please enter 'day' or 'night'.")
    