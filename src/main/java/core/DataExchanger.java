package core;

import core.exceptions.DataExchangerException;

import java.util.HashMap;
import java.util.Map;

public class DataExchanger {

    private static ThreadLocal<Map<String, String>> savedValues = ThreadLocal.withInitial(HashMap::new);

    private DataExchanger() {

    }

    public static Map<String, String> getSavedValues() {
        return savedValues.get();
    }

    public static String getValue(String key) {
        if (key == null) {
            throw new DataExchangerException("Can not find local variable. Please check variable name.");
        }
        String result = savedValues.get().get(key.toLowerCase());
        if (result == null) {
            throw new DataExchangerException("Can not find local variable " + key + ".");
        }
        return result;
    }

    public static void saveValue(String key, String value) {
        if (key != null || value != null) {
            savedValues.get().put(key.toLowerCase(), value);
        }
    }
}