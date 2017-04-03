package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @author Alexandr Korotkov (https://github.com/k0r0tk0ff)
 *
 */
public class Settings {

    /**
     * initializa variable
     */
    private static final Settings INSTANCE = new Settings();
    private static Properties properties;
    InputStream input = null;

    private Settings() {
        properties = new Properties();
        input = this.getClass().getClassLoader().getResourceAsStream("dbConnect.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();

            // close connection

        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Settings getInstance() {
        return INSTANCE;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
