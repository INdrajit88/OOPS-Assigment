public class NullReferenceDemo {
    public static void main(String[] args) {
        // Define an object reference and initialize it to null
        MyClass obj = null;

        try {
            // Attempt to call a method through the null reference
            obj.displayMessage();
        } catch (NullPointerException e) {
            // Catch and handle the NullPointerException
            System.out.println("Caught a NullPointerException: " + e.getMessage());
        }
    }
}

class MyClass {
    public void displayMessage() {
        System.out.println("Hello from MyClass!");
    }
}
