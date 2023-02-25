import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import persistance.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopStore implements DeviceStore<Laptop> {
    private final Logger log = LoggerFactory.getLogger(LaptopStore.class);

    public void create(Laptop laptop) {
        Connection connection = null;
        try {
            final String insertQuery = "INSERT INTO " + SQLCommon.LAPTOP_STORE_TABLE + " (brand_name, model_name, serial_number) VALUES (?, ?, ?)";
            connection = DatabaseManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, laptop.getBrandName());
            preparedStatement.setString(2, laptop.getModelName());
            preparedStatement.setString(3, laptop.getSerialNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error("SQLException occurring when creating the laptop in laptop store", e);
        } finally {
            String message = "Unable to close database connection when try with the creating a laptop";
            closeConnection(connection, message);
        }
    }

    public List<Laptop> read() {
        Connection connection = null;
        final List<Laptop> laptops = new ArrayList<>();
        try {
            connection = DatabaseManager.getInstance().getConnection();
            String query = "SELECT * FROM " + SQLCommon.LAPTOP_STORE_TABLE;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String brand_name = resultSet.getString(2);
                String model_name = resultSet.getString(3);
                String serial_number = resultSet.getString(4);
                laptops.add(new Laptop(brand_name,model_name, serial_number));
            }
        } catch (SQLException e) {
            log.error("SQLException occurring when reading the laptop from laptop store", e);
        } finally {
            String message = "Unable to close database connection when try with the reading a laptop";
            closeConnection(connection, message);
        }
        return laptops;
    }

    public void update(Laptop laptop) {
        //updating logic
    }

    public void delete(Laptop laptop) {
        //deletion logic
    }

    private void closeConnection(Connection connection, String message) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            log.error(message);
            e.printStackTrace();
        }
    }
}
