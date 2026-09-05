password = "pythonrocks"
attempts = 0

while attempts < 3:
    user_input = input("Enter the password: ")
    if user_input == password:
        print("Access granted.")
        break
    else: 
        attempts += 1
        if attempts < 3:
            print(f"Incorrect password. You have {3 - attempts} attempts left.")
else: 
    print("Account locked.")