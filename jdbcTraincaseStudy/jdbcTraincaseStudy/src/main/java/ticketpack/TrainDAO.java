package ticketpack;
import model.Train;

import java.sql.*;

public class TrainDAO {
    public static Connection con = DBManager.getConnection();

    public static Train findTrain(int trainNum) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from trains where train_no =" + trainNum);
        rs.next();
        return new Train(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
    }
}