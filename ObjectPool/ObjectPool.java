package ObjectPool;

public class ObjectPool {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();

        // Create 7 worker threads
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                DatabaseConnection conn = null;
                try {
                    conn = connectionPool.borrowConnection();
                    
                    // Simulate work
                    Thread.sleep(2000); 
                    conn.executeQuery("SELECT * FROM users");
                    
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // Always return in finally block to prevent leaks
                    connectionPool.returnConnection(conn);
                }
            }, "Worker-" + i).start();
        }
    }
}