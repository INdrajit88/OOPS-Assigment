public class MyCustomException extends Exception {

    private String errorMessage;

    public MyCustomException(String message) {
        this.errorMessage = message;
    }

    public void printErrorMessage() {
        System.out.println("Error: " + errorMessage);
    }

    public static void main(String[] args) {
        try {
            // Simulate a condition that might throw the exception
            int x = 5;
            int y = 0;
            if (y == 0) {
                throw new MyCustomException("Division by zero is not allowed.");
            }
            int result = x / y; 
            System.out.println("Result: " + result); 

        } catch (MyCustomException e) {
            e.printErrorMessage(); 
        }
    }
}