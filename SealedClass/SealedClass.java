package SealedClass;
public class SealedClass {
    public static void main(String[] args) {
        Shape myCircle = new Circle(5.0);
        Shape myTriangle = new Triangle(10.0, 4.0);

        myCircle.display();
        myTriangle.display();
    }
}