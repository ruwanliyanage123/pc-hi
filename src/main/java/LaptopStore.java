import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import persistance.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LaptopStore implements DeviceStore<Laptop>{
    private Logger log = LoggerFactory.getLogger(LaptopStore.class);
    public void create(Laptop laptop) {
        Connection connection = null;
        try {
            final String insertQuery = "INSERT INTO "+SQLCommon.LAPTOP_STORE_TABLE+" (brand_name, model_name, serial_number) VALUES (?, ?, ?)";
            connection = DatabaseManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,laptop.getBrandName());
            preparedStatement.setString(2,laptop.getModelName());
            preparedStatement.setString(3,laptop.getSerialNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error("SQLException occurring when creating the laptop in laptop store");
            e.printStackTrace();
        }finally {
            closeConnection(connection,"Unable to close database connection when try with the creating a laptop");
        }
    }

    public void read() {
        //retrieving logic
    }

    public void update(Laptop laptop) {
        //updating logic
    }

    public void delete(Laptop laptop) {
        //deletion logic
    }

    private void closeConnection(Connection connection, String message){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            log.error(message);
            e.printStackTrace();
        }
    }
}
