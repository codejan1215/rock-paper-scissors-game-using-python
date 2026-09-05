"""
MISSION: The RPG Damage Calculator

You are programming the combat system for a new fantasy adventure game.
Your job is to calculate the final damage a player deals to a monster 
based on their weapon, the monster's armor, and special combat conditions.

HERE ARE THE RULES:
1. Base Damage (based on weapon_type):
    - "Sword": 20 damage
    - "Bow": 15 damage
    - "Magic": 25 damage
    - Anything else (Punching!): 5 damage
2. Armor Reduction (based on enemy_armor):
    - "Heavy": Subtract 10 from damage
    - "Light": Subtract 5 from damage
    - "None": Subtract 0
3. Stealth Bonus: If the player is attacking from the shadows (is_stealthy is True), 
    add 10 to the damage.
4. Critical Hit: If the attack is a critical hit (is_critical is True), 
    multiply the ENTIRE current damage by 2.
5. Minimum Damage Check: Sometimes heavy armor absorbs everything! 
    If the final calculated damage is LESS than 0, set the damage back to 0 
    (so we don't heal the enemy!).

YOUR TASK:
Write the logic to calculate the `total_damage`.
"""

# --- TEST DATA (Change these to test different scenarios) ---
weapon_type = input("Enter weapon (Sword, Bow, Magic): ")
enemy_armor = input("Enter enemy armor (Heavy, Light, None): ")
is_stealthy = True     # True or False
is_critical = True    # True or False

# This is your starting point
total_damage = 0

# ==========================================
# WRITE YOUR LOGIC BELOW THIS LINE
# ==========================================

# 1. Base Damage (Sword=20, Bow=15, Magic=25, Else=5)
# (Write your if/elif/else statements here)

if weapon_type == "Sword":
    total_damage += 20
elif weapon_type == "Bow":
    total_damage += 15
elif weapon_type == "Magic":
    total_damage += 25
else: total_damage += 5

# 2. Armor Reduction (Heavy=-10, Light=-5, None=-0)
# (Write your if/elif/else statements here)

if enemy_armor == "Heavy":
    total_damage -= 10
elif enemy_armor == "Light":
    total_damage -= 5
else: total_damage -= 0

# 3. Stealth Bonus (is_stealthy is True)
# (Write your if statement here)

if is_stealthy:
    total_damage += 10

# 4. Critical Hit (is_critical is True)
# (Write your if statement here)

if is_critical:
    total_damage *= 2

# 5. Minimum Damage Check (if total_damage < 0, set it to 0)
# (Write your if statement here)

if total_damage < 0:
    total_damage = 0

# ==========================================
# WRITE YOUR LOGIC ABOVE THIS LINE
# ==========================================

print("----------------------------")
print("Weapon:", weapon_type)
print("Enemy Armor:", enemy_armor)
print("Stealth Attack:", is_stealthy)
print("Critical Hit:", is_critical)
print("----------------------------")
print("TOTAL DAMAGE DEALT:", total_damage)