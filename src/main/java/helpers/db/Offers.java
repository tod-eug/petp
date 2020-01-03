package helpers.db;

import core.config.Configuration;
import core.database.DatabaseHelper;

import java.sql.SQLException;

/**
 * This class may be used for creating some preconditions before test by inserting some data in database.
 */
public class Offers {

    public static void letInsertOffers(String company, String model, String color, int price, String bodyType) {
        DatabaseHelper dbHelper = new DatabaseHelper(
                Configuration.configurationProperties.get("DB_URL"),
                Configuration.configurationProperties.get("DB_USERNAME"),
                Configuration.configurationProperties.get("DB_PASSWORD"));

        String insertQuery = String.format("insert into offer (\"company\", \"model\", \"color\", \"price\", \"body\") VALUES ('%s', '%s', '%s', %s, '%s');", company, model, color, price, bodyType);

        try {
            dbHelper.getPreparedStatement(insertQuery).execute();
        } catch (SQLException  e) {
            e.printStackTrace();
        } finally {
            dbHelper.closeConnections();
        }
    }
}
