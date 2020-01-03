package core.config;

import core.exceptions.ConfigNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In this class loads all configuration parameters in framework.
 */
public class Configuration {
    public static Map<String, String> configurationProperties = new ConcurrentHashMap<>();
    public static Browsers browser = Browsers.valueOf(System.getProperty("browser", "chrome").toUpperCase());

    public static void setUp() {
        loadConfigs("src/main/resources/environment.properties");
    }

    /**
     * Method load all parameters from config file to Map
     * @param configFile - exact file which config we want to load
     */
    private static void loadConfigs(String configFile) {
        Properties envProp = new Properties();

        try {
            envProp.load(new FileInputStream(configFile));
        } catch (IOException e) {
            throw new ConfigNotFoundException(String.format("Config \"%s\" not found", configFile));
        }
        envProp.forEach((key, value) -> {
            configurationProperties.put(key.toString().trim(), value.toString().trim());
        });
    }
}
