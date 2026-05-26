package Projects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcRunner {
    Scanner scanner = new Scanner(System.in);
    //Calc calc = new Calc();

    public void run() {
        System.out.print("Enter first number:");
        boolean cont = scanner.hasNextDouble();
        if (!cont) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }
        double num1 = scanner.nextDouble();
        

        System.out.println();
        System.out.print("Enter operation (+, -, *, /, sqrt, ^):");
        
        String operation = scanner.next();
        System.out.println();
        
        double num2 = 0; 
        if (!operation.equals("sqrt")) {
            System.out.print("Enter second number: ");
            boolean cont2 = scanner.hasNextDouble();
            if (!cont2) {
                System.out.println("Invalid input. Please enter a valid number.");
                return;
            }
            
            num2 = scanner.nextDouble();
            System.out.println();
        }
        double result = 0;
        switch (operation) {
            case "+":
                result = adder(num1, num2);
                break;
            case "-":
                result = subtractor(num1, num2);
                break;
            case "*":
                result = mutiplier(num1, num2);
                break;
            case "/":
                try{
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                } 
                catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                result = divider(num1, num2);
                break;
            case "sqrt":
                result = rooter(num1);
                break;
            case "^":
                result = exponent(num1, num2);
                break;
            default:
                System.out.println("Invalid operation");
                return;
        }
        System.out.println(num1 + " " + operation + " " + (operation.equals("sqrt") ? "" : num2) + " = " + result);

        if (operation.equals("+")) {
            result = adder(num1, num2);
        } else if (operation.equals("-")) {
            result = subtractor(num1, num2);
        } else if (operation.equals("*")) {
            result = mutiplier(num1, num2);
        } else if (operation.equals("/")) {
            try {
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return;
            }
            result = divider(num1, num2);
        } else if (operation.equals("sqrt")) {
            result = rooter(num1);
        } else if (operation.equals("^")) {
            result = exponent(num1, num2);
        } else {
            System.out.println("Invalid operation");
            return;
        }
        System.out.println(num1 + " " + operation + " " + (operation.equals("sqrt") ? "" : num2) + " = " + result);
    }

    public static void main(String[] args) {
        CalcRunner runner = new CalcRunner();
        runner.run();
    }



    public double adder(double x, double y){
        return x+y;
    }
    public double subtractor(double x, double y){
        return x-y;
    }
    public double mutiplier(double x, double y){
        return x*y;
    }
    public double divider(double x, double y){
        return x/y;
    }
    public double rooter(double x){
        return Math.sqrt(x);
    }
    public double exponent(double x, double y){
        return Math.pow(x,y);
    }
}
