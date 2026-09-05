loot_chest = ["Gold Coin", "Rusty Sword", "Healing Potion", "Gold Coin", "Magic Ring", "Gold Coin", "Old Boot"]

inventory = {
    "gold_count": 0,
    "rusty_sword_count": 0,
    "magic_ring_count": 0,
    "old_boot_count": 0
}

for item in loot_chest:
    if item == "Gold Coin":
        inventory["gold_count"] += 1
        print(f"Found a {item}! Total Gold Coins: {inventory['gold_count']}")
    elif item == "Rusty Sword":
        inventory["rusty_sword_count"] += 1
        print(f"Found a {item}! Total Rusty Swords: {inventory['rusty_sword_count']}")
    elif item == "Magic Ring":
        inventory["magic_ring_count"] += 1
        print(f"Found a {item}! Total Magic Rings: {inventory['magic_ring_count']}")
    elif item == "Healing Potion":
        inventory["healing_potion_count"] += 1
        print(f"Found a {item}! HP restored!")
    elif item == "Old Boot":
        inventory["old_boot_count"] += 1
        print(f"Found a {item}! Total Old Boots: {inventory['old_boot_count']}")
print("\nLoot Summary:")
print(f"Total Gold Coins: {inventory['gold_count']}")
print(f"Total Rusty Swords: {inventory['rusty_sword_count']}")
print(f"Total Magic Rings: {inventory['magic_ring_count']}")
print(f"Total Healing Potions: {inventory['healing_potion_count']}")
print(f"Total Old Boots: {inventory['old_boot_count']}")
