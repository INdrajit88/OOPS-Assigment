abstract class Shape {
    // Abstract method to calculate the area
    abstract double area();

    // Abstract method to display the area
    abstract void disp();
}

// Concrete class Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    void disp() {
        System.out.println("Rectangle Area: " + area());
    }
}

// Concrete class Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    void disp() {
        System.out.printf("Circle Area: %.2f\n", area());
    }
}

// Concrete class Triangle
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }

    @Override
    void disp() {
        System.out.println("Triangle Area: " + area());
    }
}

// Main class to demonstrate functionality
public class Shp {
    public static void main(String[] args) {
        // Create objects for each shape
        Rectangle rectangle = new Rectangle(10, 5);
        Circle circle = new Circle(7);
        Triangle triangle = new Triangle(6, 4);

        // Display areas
        rectangle.disp();
        circle.disp();
        triangle.disp();
    }
}
