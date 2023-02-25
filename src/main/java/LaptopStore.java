import persistance.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LaptopStore implements DeviceStore<Laptop>{

    public void create(Laptop laptop) {
        try {
            final String insertQuery = "INSERT INTO "+SQLCommon.LAPTOP_STORE_TABLE+" (brand_name, model_name, serial_number) VALUES (?, ?, ?)";
            Connection connection = DatabaseManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,laptop.getBrandName());
            preparedStatement.setString(2,laptop.getModelName());
            preparedStatement.setString(3,laptop.getSerialNumber());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
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
}
