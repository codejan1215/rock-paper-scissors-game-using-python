saving_goal = 50000
current_balance = 100

while current_balance < saving_goal:
    question = float(input("How much money do you want to deposit?: ").strip())
    current_balance += question
    print(f"Current balance: ${current_balance:.2f}")
print("Congratulations! You have reached your saving goal.")