package SealedClass;

final class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void display() {
        System.out.println("This is a Circle with radius: " + radius);
    }
}