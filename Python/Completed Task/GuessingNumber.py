import random   

print("Welcome to the Number Guessing Game!")
number = random.randint(1, 100)
attemps = 3

while attemps > 0:
    user_guess = int(input("Guess a number between 1 and 100: "))
    attemps -= 1
    if user_guess == number:
        print("Congratulations! You guessed the correct number.")
        break
    elif user_guess < number:
        print("Too low! Try again.")
        print(f"You have {attemps} attempts left.")
    elif user_guess > number:
        print("Too high! Try again.")
        print(f"You have {attemps} attempts left.")
    else:
        print("Invalid input. Please enter a number between 1 and 100.")

if attemps == 0:
    print(f"Game over! The correct number was {number}.")