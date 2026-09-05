# --- TEST DATA (Change these to test different scenarios) ---
package_weight = float(input("Enter package weight: "))      # in kilograms
destination = str(input("Enter destination: "))       # "Earth", "Mars", or "Jupiter"
is_express = True          # True or False
# This is your starting point
final_cost = 50.0  

# ==========================================
# WRITE YOUR LOGIC BELOW THIS LINE
# ==========================================

# 1. Check weight fee
# (Write your if statement here)
if package_weight >= 10:
    final_cost += 100
    print("- Heavy Cargo fee added.")
else: print("Error")

# 2. Check destination fee
# (Write your if/elif/else statements here)
if destination == "Earth":
    final_cost += 0
elif destination == "Mars":
    final_cost += 150
elif destination == "Jupiter":
    final_cost += 300
else: 
    print("Invalid Destination") 
    final_cost = 0

# 3. Check express shipping
# (Write your if statement here)
if is_express: 
    final_cost *= 2
    print(f"The Entire cost is {final_cost}")

# 4. Check for high-spender discount
# (Write your if statement here)
if final_cost >= 500:
    final_cost *= 0.8
    print("- 20% High-Spender discount applied!")

# ==========================================
# WRITE YOUR LOGIC ABOVE THIS LINE
# ==========================================

print("Destination:", destination)
print("Weight:", package_weight, "kg")
print("Express:", is_express)
print("----------------------------")
print("FINAL COST: $", final_cost)