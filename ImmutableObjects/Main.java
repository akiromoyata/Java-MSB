package ImmutableObjects;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Successful instantiation
        Money m1 = new Money(new BigDecimal("100.50"), "USD");
        Money m2 = new Money(new BigDecimal("100.5"), "USD");

        System.out.println("M1: " + m1); // $100.5
        System.out.println("Are they equal? " + m1.equals(m2)); // true

        // This will throw an IllegalArgumentException
        try {
            new Money(null, "XYZ");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}