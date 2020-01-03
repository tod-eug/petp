package core.database;

import java.sql.*;

/**
 * This class manage connections for PostgreSQL Database.
 */
public class DatabaseHelper {

    private String url;
    private String user;
    private String password;

    private Connection connection;
    private Statement statement;


    public DatabaseHelper(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        createConnection();

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            return preparedStatement;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Can not prepare statement for sql=" + sql);
        }
    }

    public void closeConnections() {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }

            statement = null;
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                closeConnections();
            }
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
