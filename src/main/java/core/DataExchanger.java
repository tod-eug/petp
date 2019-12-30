package core;

import core.exceptions.DataExchangerException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataExchanger {

    private static Map<String, String> savedValues = new ConcurrentHashMap<>();

    private DataExchanger() {

    }

    public static Map<String, String> getSavedValues() {
        return savedValues;
    }

    public static String getValue(String key) {
        if (key == null) {
            throw new DataExchangerException("Can not find local variable. Please check variable name.");
        }
        String result = savedValues.get(key.toLowerCase());
        if (result == null) {
            throw new DataExchangerException("Can not find local variable " + key + ".");
        }
        return result;
    }

    public static void saveValue(String key, String value) {
        if (key != null || value != null) {
            savedValues.put(key.toLowerCase(), value);
        }
    }
}