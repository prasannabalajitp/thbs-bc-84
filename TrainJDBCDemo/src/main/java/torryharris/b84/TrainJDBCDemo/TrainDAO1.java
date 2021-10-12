package torryharris.b84.TrainJDBCDemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class TrainDAO1  implements CRUDOperations{
       private JdbcTemplate jdbcTemplate;
	
	public TrainDAO1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public void insert(Train train) {
		
		if (null != train) {

         // Prepared statement in JDBC : insert statement below 			
			jdbcTemplate.update(
					"insert into trains values(?,?,?,?,?)",
					new Object[] { train.getTrainNo(),
							train.getTrainName(),train.getSource(),
							train.getDestination(), train.getPrice()});
		
	}
		
	}
	
	
public List<Train> selectAll(){
		
		return	jdbcTemplate.query("select * from trains", new RowMapper<Train>() {
            // ResultSet rs = st.executeQuery("Select * from employee");
			
			
			@Override
			public Train mapRow(ResultSet resultSet, int arg1) throws SQLException {
				Train train = new Train();
				train.setTrainNo(resultSet.getInt(1));
				train.setTrainName(resultSet.getString(2));
				train.setSource(resultSet.getString(3));
				train.setDestination(resultSet.getString(4));
				train.setPrice(resultSet.getInt(5));
				return train;
				

			}
		});
		}




public Train select(int trainNo) {
	return (Train) jdbcTemplate.queryForObject(
			"SELECT * FROM trains WHERE TRAIN_NO=?",
			new Object[] { Integer.valueOf(trainNo) },
			new RowMapper<Train>() {

				@Override
				public Train mapRow(ResultSet resultSet, int arg1)
						throws SQLException {
					Train train = new Train();
					train.setTrainNo(resultSet.getInt(1));
					train.setTrainName(resultSet.getString(2));
					train.setSource(resultSet.getString(3));
					train.setDestination(resultSet.getString(4));
					train.setPrice(resultSet.getInt(5));
					return train;
				}
			});
}

}