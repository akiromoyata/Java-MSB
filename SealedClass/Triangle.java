package SealedClass;

final class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public void display() {
        System.out.println("This is a Triangle with base " + base + " and height " + height);
    }
}