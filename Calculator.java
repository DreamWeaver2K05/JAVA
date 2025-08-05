public class Calculator {
    public static double add(double x, double y) {
                return x + y;
    }

    public static double subtract(double x, double y) {
                return x - y;
    }

    public static double multiply(double x, double y) {
                return x * y;
    }

    public static double divide(double x, double y) {
                if (y != 0) {
            return x / y;
        } else {
            System.out.println("Cannot divide by zero.");
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        double num1 = 10.0;
        double num2 = 5.0;

        System.out.println("Addition: " + add(num1, num2));
        System.out.println("Subtraction: " + subtract(num1, num2));
        System.out.println("Multiplication: " + multiply(num1, num2));
        System.out.println("Division: " + divide(num1, num2));
    }
}