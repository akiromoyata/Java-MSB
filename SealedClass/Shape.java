package SealedClass;

public sealed class Shape permits Circle, Triangle {
    public void display() {
        System.out.println("This is a generic shape.");
    }
}