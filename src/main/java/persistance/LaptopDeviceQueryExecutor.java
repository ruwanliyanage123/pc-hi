package persistance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class LaptopDeviceQueryExecutor {
    private LaptopDeviceQueryExecutor() {
        Connection connection = DatabaseManager.getInstance().getConnection();
        StringBuilder stringBuilder = new StringBuilder();
        //reading the sql file and append the content into the string builder
        try {
            String file = "src/main/resources/excecute-database.sql";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //executing the content of the string builder
        try {
            Statement statement = connection.createStatement();
            String[] commands = stringBuilder.toString().split(";");
            for (String command : commands) {
                statement.execute(command);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static final class LaptopDeviceQueryExecutorLazyLoader {
        public static final LaptopDeviceQueryExecutor INSTANCE = new LaptopDeviceQueryExecutor();
    }

    public static LaptopDeviceQueryExecutor getInstance() {
        return LaptopDeviceQueryExecutorLazyLoader.INSTANCE;
    }
}
