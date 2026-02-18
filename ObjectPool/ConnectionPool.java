package ObjectPool;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {
    private final int MAX_POOL_SIZE = 5;
    private final Queue<DatabaseConnection> pool = new LinkedList<>();

    public ConnectionPool() {
        // Pre-populate the pool with 5 connections
        for (int i = 1; i <= MAX_POOL_SIZE; i++) {
            pool.add(new DatabaseConnection(i));
        }
    }

    /**
     * Borrows a connection. Blocks if no connections are available.
     */
    public DatabaseConnection borrowConnection() throws InterruptedException {
        synchronized (pool) {
            // Block until a connection is available
            while (pool.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " is waiting for a connection...");
                pool.wait(); 
            }
            DatabaseConnection conn = pool.poll();
            System.out.println(Thread.currentThread().getName() + " borrowed " + conn);
            return conn;
        }
    }

    /**
     * Returns a connection to the pool and notifies waiting threads.
     */
    public void returnConnection(DatabaseConnection conn) {
        if (conn == null) return;

        synchronized (pool) {
            // Ensure the connection is clean before re-pooling
            conn.reset();
            pool.add(conn);
            
            System.out.println(Thread.currentThread().getName() + " returned " + conn);
            
            // Wake up threads waiting in borrowConnection()
            pool.notifyAll();
        }
    }
}