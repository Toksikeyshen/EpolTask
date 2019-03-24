

import java.sql.*;
import java.util.ArrayList;

public class Handler extends Config {
    private Connection connection;

    public Handler() {
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    void createDb() throws SQLException {
        String query1 = "Create TABLE data( date varchar(50) NOT NULL, input varchar(100) NOT NULL, output varchar(50) NOT NULL)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query1);
    }
    void inertResult(String date, ArrayList<String> input, ArrayList<String> ouput) throws SQLException{
        String query = "INSERT INTO data (date, input, output) VALUES (?,?,?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, date);
        preparedStatement.setString(2, String.valueOf(input));
        preparedStatement.setString(3, String.valueOf(ouput));
        preparedStatement.executeUpdate();
    }

}
