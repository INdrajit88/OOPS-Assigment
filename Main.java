// Define the first interface
interface InterfaceOne {
    void methodOne();
}

// Define the second interface
interface InterfaceTwo {
    void methodTwo();
}

// Create a new interface inheriting from InterfaceOne and InterfaceTwo
interface CombinedInterface extends InterfaceOne, InterfaceTwo {
    void methodThree();
}

// Define a concrete base class
class BaseClass {
    void baseClassMethod() {
        System.out.println("Method in BaseClass");
    }
}

// Implement the CombinedInterface and inherit from BaseClass
class MyClass extends BaseClass implements CombinedInterface {
    @Override
    public void methodOne() {
        System.out.println("Implementation of methodOne from InterfaceOne");
    }

    @Override
    public void methodTwo() {
        System.out.println("Implementation of methodTwo from InterfaceTwo");
    }

    @Override
    public void methodThree() {
        System.out.println("Implementation of methodThree from CombinedInterface");
    }
}

// Define methods to take each interface as an argument
public class Main {

    public static void processInterfaceOne(InterfaceOne obj) {
        obj.methodOne();
    }

    public static void processInterfaceTwo(InterfaceTwo obj) {
        obj.methodTwo();
    }

    public static void processCombinedInterface(CombinedInterface obj) {
        obj.methodThree();
    }

    public static void main(String[] args) {
        // Create an object of MyClass
        MyClass myClassObject = new MyClass();

        // Pass the object to each of the methods
        processInterfaceOne(myClassObject); // Calls methodOne
        processInterfaceTwo(myClassObject); // Calls methodTwo
        processCombinedInterface(myClassObject); // Calls methodThree

        // Call the method from the base class
        myClassObject.baseClassMethod(); // Calls baseClassMethod
    }
}
