"""
MISSION: The Movie Theater Kiosk

You are programming the self-serve ticket kiosk for a local cinema.
Your job is to calculate the final ticket price based on the customer's 
age, the time of day, movie type, and whether they are buying snacks.

HERE ARE THE RULES:
1. Base Price: Set the starting ticket price based on age:
    - Children (under 12 years old): $8
    - Seniors (65 years or older): $9
    - Everyone else: $12
2. Matinee Discount: If the time is BEFORE 17 (5:00 PM uses 24-hour clock, so less than 17), subtract $2 from the price.
3. 3D Fee: If the movie is in 3D (is_3d is True), add $3 to the price.
4. Snack Combo: If the customer is buying snacks (wants_snacks is True) AND their current ticket price is GREATER than $10, give them a $1 discount (subtract $1).

YOUR TASK:
Write the logic to calculate the `ticket_price`.
"""

# --- TEST DATA (Change these to test different scenarios) ---
age = int(input("Enter customer age: "))
hour_of_day = int(input("Enter hour of day (0-23): "))
is_3d = True          # True or False
wants_snacks = True   # True or False

# This is your starting point
ticket_price = 0.0

# ==========================================
# WRITE YOUR LOGIC BELOW THIS LINE
# ==========================================

# 1. Set base price based on age (Under 12: $8, 65 or older: $9, Others: $12)
# (Write your if/elif/else statements here)

if age < 12:
    ticket_price += 8
elif age >= 65:
    ticket_price += 9
else: age >= 13 
ticket_price += 12
    

# 2. Check matinee discount (hour_of_day is less than 17)
# (Write your if statement here)

if hour_of_day < 17:
    ticket_price -= 2
else: print("Don't have discount!")

# 3. Check 3D fee (is_3d is True)
# (Write your if statement here)

if is_3d:
    ticket_price += 3

# 4. Check snack combo discount (wants_snacks is True AND ticket_price > 10)
# (Write your if statement here - Hint: Remember the 'and' logical operator!)

if wants_snacks and ticket_price > 10:
    ticket_price -= 1

# ==========================================
# WRITE YOUR LOGIC ABOVE THIS LINE
# ==========================================

print("----------------------------")
print("Age:", age)
print("Time:", hour_of_day, ": 00")
print("3D Movie:", is_3d)
print("Buying Snacks:", wants_snacks)
print("----------------------------")
print("FINAL TICKET PRICE: $", ticket_price)