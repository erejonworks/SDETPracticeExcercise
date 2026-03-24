package org.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        String env = System.getProperty("env", "dev");
        String configFile = String.format("config/%s.properties", env);

        try (InputStream input = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream(configFile)) {
            if (input == null) {
                throw new RuntimeException("Config File not found: " + configFile);
            }
            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Error loading the config file: " + configFile, e);
        }
    }

    public static String getProperty(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }

    public static int getIntProperty(String key, int defaultValue) {
        String value = getProperty(key);
        return value != null ? Integer.parseInt(value) : defaultValue;
    }

}
