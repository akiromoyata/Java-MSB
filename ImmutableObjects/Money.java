package ImmutableObjects;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public final class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, String currencyCode) {
        // Graceful handling of null/invalid inputs with unchecked exceptions
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        if (currencyCode == null || currencyCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Currency code cannot be null or empty");
        }

        try {
            this.currency = Currency.getInstance(currencyCode.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid ISO 4217 currency code: " + currencyCode);
        }

        // BigDecimal is immutable, but we ensure it has a consistent scale for financial work
        // Strip trailing zeros to ensure 10.0 and 10.00 are treated as equal
        this.amount = amount.stripTrailingZeros();
    }

    // Getters only - no setters allowed in immutable design
    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount) && 
               currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return currency.getSymbol() + amount.toPlainString();
    }
}