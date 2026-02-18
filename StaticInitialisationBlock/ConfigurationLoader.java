package StaticInitialisationBlock;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader {
    private static final Properties properties = new Properties();

    static {
        System.out.println("Initializing ConfigurationLoader...");
        
        try (InputStream input = ConfigurationLoader.class.getClassLoader()
                                    .getResourceAsStream("config.properties")) {
            
            if (input == null) {
                // This usually means the file isn't in 'src' or 'resources'
                System.err.println("CRITICAL: File '" + "config.properties" + "' not found in classpath.");
                System.err.println("Check if the file exists in your 'src' or 'resources' folder.");
            } else {
                properties.load(input);
                System.out.println("SUCCESS: Properties loaded from " + "config.properties");
            }
            
        } catch (IOException ex) {
            System.err.println("ERROR: Could not read the properties file.");
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println("Main method started.");
        String user = ConfigurationLoader.getProperty("db.user");
        String pass = ConfigurationLoader.getProperty("db.password");

        if (user != null && pass != null) {
            System.out.println("Config loaded for user: " + user);
            System.out.println("Password length: " + pass.length() + " characters");
        } else {
            System.out.println("Failed to retrieve MySQL credentials. Check config.properties file.");
        }
        String dbUrl = ConfigurationLoader.getProperty("db.url");
        System.out.println("Database URL: " + dbUrl);
    }
}