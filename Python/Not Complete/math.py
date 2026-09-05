print("Welcome to the calculator program!")
print(" ")

op1 = input("Enter the operation you want to perform (+, -, *, /): ")
input1 = int(input("Enter your first number: "))
input2 = int(input("Enter your second number: "))



def add(input1: float, input2: float) -> float:
    return input1 + input2

def subtract(input1: float, input2: float) -> float:
    return input1 - input2

def multiply(input1: float, input2: float) -> float:
    return input1 * input2

def divide(input1: float, input2: float) -> float:
    if input2 == 0:
        return "Error: Division by zero is not allowed."
    return input1 / input2

try: 
    match op1:
        case "+":
            print(f"\nTotal: {add(input1, input2)}")
        case "-":
            print(f"\nTotal: {subtract(input1, input2)}")
        case "*":
            print(f"\nTotal: {multiply(input1, input2)}")
        case "/":
            print(f"\nTotal: {divide(input1, input2)}")

except TypeError as e:
    print(f"Error: {e}. Please enter valid numbers.")
except ValueError as e:
    print(f"Error: {e}. Please enter valid numbers.")
except Exception as e:
    print(f"An unexpected error occurred: {e}")

