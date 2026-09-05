transactions = [1200, -45, -20, -150, 500, -800, -10, -20, -30, 100, -50]
balance = 0
deposit_count = 0
withdrawal_count = 0
consecutive_withdrawals = 0

for money in transactions:
    balance += money
    
    if money > 0:
        consecutive_withdrawals = 0
        deposit_count += 1
    elif money < 0:
        withdrawal_count += 1
        consecutive_withdrawals += 1
        
        
        if money <= -500:
            print(f"ALERT: Large withdrawal of ${-money} detected!")
            
        if consecutive_withdrawals == 3:
            print("SECURITY LOCK: Three consecutive withdrawals detected!")
            print("ACCOUNT FROZEN: Halting all further transactions.")
            break  # This kills the loop instantly!

print("\n--- Daily Summary ---")
print(f"Ending Balance: ${balance}")
print(f"Total Deposits: {deposit_count}")
print(f"Total Withdrawals: {withdrawal_count}")


