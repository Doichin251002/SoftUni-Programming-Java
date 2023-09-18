import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DiabloQuery {
    private static final String query =
            "SELECT u.first_name, u.last_name, COUNT(ug.game_id) AS games " +
            "FROM users_games AS ug JOIN users AS u ON ug.user_id = u.id " +
            "WHERE u.user_name LIKE ? " +
            "GROUP BY ug.user_id";

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();

        String inputUsername = readUsername();

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, inputUsername);

        ResultSet result = statement.executeQuery();

        boolean hasRow = result.next();
        if (hasRow) {
            System.out.println("User: " + inputUsername);
            System.out.printf("%s %s has played %d games", result.getString("first_name"), result.getString("last_name"), result.getInt("games"));
        } else {
            System.out.println("No such user exists");
        }
    }

    private static String readUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        return scanner.nextLine();
    }

    private static Connection getConnection() throws SQLException {
        Properties userPass = new Properties();
        userPass.setProperty("user", "root");
        userPass.setProperty("password", "dodi");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/diablo", userPass);
    }
}
