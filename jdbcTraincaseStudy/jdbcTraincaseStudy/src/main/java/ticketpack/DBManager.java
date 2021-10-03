package ticketpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private  static  Connection connection;
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookingticket",
                    "root","Tvszest7252$$");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
