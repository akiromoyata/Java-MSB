package ObjectPool;

class DatabaseConnection {
    private final int id;
    private boolean inTransaction = false;

    public DatabaseConnection(int id) {
        this.id = id;
        System.out.println("Created Connection ID: " + id);
    }

    public boolean isInTransaction() {
        return inTransaction;
    }

    public void setInTransaction(boolean inTransaction) {
        this.inTransaction = inTransaction;
    }

    public void executeQuery(String sql) {
        System.out.println("Connection " + id + " executing: " + sql);
        this.setInTransaction(true); // Simulating state change
    }

    public void reset() {
        // Resetting internal state before returning to pool
        this.setInTransaction(false);
        System.out.println("Connection " + id + " has been reset.");
    }

    @Override
    public String toString() {
        return "Conn-" + id;
    }
}