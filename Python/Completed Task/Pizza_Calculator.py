"""
MISSION: The Pizza Order Calculator

You need to write the logic that calculates the final price of a 
customer's pizza order based on size, toppings, time, and delivery.

HERE ARE THE RULES:
1. Base Price (based on pizza_size):
    - "Small": $10
    - "Medium": $15
    - "Large": $20
    - Anything else: Print "Error: Invalid size" and set price to 0.
2. Toppings: Every topping costs $1.50. Multiply `num_toppings` by 1.5 
    and add it to the total.
3. Late Night Surcharge: If the `order_hour` is 22 or higher (10 PM or later), 
    add a $3 late-night fee.
4. Delivery Fee: If the customer is NOT picking it up (is_pickup is False) 
    AND their current total is LESS than $25, add a $5 delivery fee.
    (Hint: You can use `not is_pickup` or `is_pickup == False`).

YOUR TASK:
Write the logic to calculate the `final_total`.
"""

# --- TEST DATA (Change these to test different scenarios) ---
pizza_size = input("Enter size (Small, Medium, Large): ")
num_toppings = int(input("Enter number of toppings: "))
order_hour = int(input("Enter hour of order (0-23): "))
is_pickup = False  # True for pickup, False for delivery

# This is your starting point
final_total = 0.0

# ==========================================
# WRITE YOUR LOGIC BELOW THIS LINE
# ==========================================

# 1. Base Price (Small=$10, Medium=$15, Large=$20, Else=Error/0)
# (Write your if/elif/else statements here)

if pizza_size == "Small":
    final_total += 10
elif pizza_size == "Medium":
    final_total += 15
elif pizza_size == "Large":
    final_total += 20
else: 
    print("Error/Invalid size of pizza!")
    final_total = 0.0


# 2. Toppings ($1.50 per topping)
# (Write your math here - you don't even need an if statement for this one!)

final_total += (num_toppings * 1.5)

# 3. Late Night Surcharge (order_hour >= 22 adds $3)
# (Write your if statement here)

if order_hour >= 22:
    final_total += 3
    print("Added $3.00 for late-night fee")

# 4. Delivery Fee (is_pickup is False AND final_total < 25 adds $5)
# (Write your if statement here)

if is_pickup == False and final_total < 25:
    final_total += 5
    print("Added $5 for delivery fee")
else: print("Pick up ready/Free Delivery!")

# ==========================================
# WRITE YOUR LOGIC ABOVE THIS LINE
# ==========================================

print("----------------------------")
print("Pizza Size:", pizza_size)
print("Toppings:", num_toppings)
print("Order Hour:", order_hour, ": 00")
print("Pickup Order:", is_pickup)
print("----------------------------")
print("FINAL TOTAL: $", final_total)