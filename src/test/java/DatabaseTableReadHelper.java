import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTableReadHelper {
    public ResultSet readTable(final Connection connection, final String tableName){
        ResultSet resultSet = null;
        try {
            final String query = "SELECT * FROM "+ tableName;
            final Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
