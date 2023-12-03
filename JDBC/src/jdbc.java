import java.sql.*;

public class jdbc {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/kalyani";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Registering the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Opening a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Creating a statement
            statement = connection.createStatement();

            // Creating a table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS jdbc_details (first_name VARCHAR(50), last_name VARCHAR(50), age INT PRIMARY KEY)";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table created successfully");

            // Inserting values into the table
            String insertSQL = "INSERT INTO jdbc_details (first_name, last_name, age) VALUES ('John','Doe', 30), ('Alice','Fergusson', 25), ('Bob','Builder', 15)";
            statement.executeUpdate(insertSQL);
            System.out.println("Values inserted into table");

            // Retrieving all values from the table
            String retrieveSQL = "SELECT * FROM jdbc_details";
            ResultSet resultSet = statement.executeQuery(retrieveSQL);

            // Displaying retrieved values
            System.out.println("Retrieving values from table...");
            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int age = resultSet.getInt("age");

                System.out.println("First Name " + first_name + ", Last Name: " + last_name + ", Age: " + age);
            }

            // Closing resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}