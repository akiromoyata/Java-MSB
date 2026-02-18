package DeepCloning;


public class DeepCloning {
    public static void main(String[] args) {
        try {
            Manager m1 = new Manager("John Doe", 80000);
            Department d1 = new Department("IT Operations", m1);

            // Execute the deep clone
            Department d2 = (Department) d1.clone();

            System.out.println("ORIGINAL: " + d1);
            System.out.println("CLONED:   " + d2);

            // This comparison now works because getManager() is defined
            if (d1.getManager() != d2.getManager()) {
                System.out.println("\nVerification: Deep Clone Successful.");
                System.out.println("Original Manager Hash: " + System.identityHashCode(d1.getManager()));
                System.out.println("Cloned Manager Hash:   " + System.identityHashCode(d2.getManager()));
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}