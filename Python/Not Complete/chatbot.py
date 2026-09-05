bot_name: str = 'Zed'
user_name: str = input("How can I call you? ").strip()
print(f'Hello {user_name}! I am {bot_name}, your friendly chatbot. How can I assist you today?')

while True:
    user_input: str = input(f"{user_name}: ").lower().strip()
    
    if user_input in ['hi', 'hello', 'hey']:
        print(f'{bot_name}: Hello {user_name}! How can I help you today?')
    elif user_input in ['bye', 'exit', 'quit', 'goodbye']:
        print(f'{bot_name}: Goodbye {user_name}! Have a great day!')
        break
    elif user_input in ['+', 'add']:       
        print(f'{bot_name}: Sure! Let\'s add some numbers.')
        try:
            num1: float = float(input("Enter the first number: "))
            num2: float = float(input("Enter the second number: "))
            result: float = num1 + num2
            print(f'{bot_name}: The result of adding {num1} and {num2} is {result}.')
        except ValueError:
            print(f'{bot_name}: Please enter valid numbers.')
        except Exception as e:
            print(f'{bot_name}: An unexpected error occurred: {e}')
    else:
        print(f'{bot_name}: I\'m sorry, I didn\'t understand that. Please try again or type "bye" to exit.')