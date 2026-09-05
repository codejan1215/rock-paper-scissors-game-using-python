import random

def player_choice():
    choice = input("Enter your choice (rock, paper, scissors): ").lower()
    while choice not in ['rock', 'paper', 'scissors']:
        print("Invalid choice. Please try again.")
        choice = input("Enter your choice (rock, paper, scissors): ").lower()
    return choice

def computer_choice():
    return random.choice(['rock', 'paper', 'scissors'])

def game_flow(player, computer):
    if player == computer:
        return "tie"
    elif (player == 'rock' and computer == 'scissors') or (player == 'paper' and computer == 'rock') or (player == 'scissors' and computer == 'paper'):
        return "Player"
    else:
        return "Computer"

def main():
    score: int = 5
    player_score: int = 0
    computer_score: int = 0
    name:str = input("Enter your name: ")
    print(f"Hello, {name}! Welcome to Rock, Paper, Scissors game!")

    while True:
        player = player_choice()
        computer = computer_choice()
        print(f"\nYou chose: {player}")
        print(f"Computer chose: {computer}")
            
        result = game_flow(player, computer)
        if player_score < score and computer_score < score:
            if result == "tie":
                print("It's a tie!")
            if result == "Player":
                print(f"You win this round {name}!")
                player_score += 1
            if result == "Computer":
                print(f"Computer wins this round {name}!")
                computer_score += 1
        if player_score == score:
            print(f"Congratulations! You won the game {name}!")
            break
        if computer_score == score:
            print(f"Sorry, the computer won the game {name}!")
            break
        print(f"Score - {name}: {player_score}, Computer: {computer_score}")
    print("\nThe final score is:")
    print(f"{name}: {player_score}, Computer: {computer_score}")

    play_again = input('\nDo you want to play again? (yes/no): ').lower()
    while play_again not in ['yes', 'no']:
        print("Invalid choice. Please try again.")
        play_again = input('\nDo you want to play again? (yes/no): ').lower()
    if play_again == 'no':
        print(f"Thank you for playing, {name}! Goodbye!")
    if play_again == 'yes':
        main()

if __name__ == "__main__":
    main()