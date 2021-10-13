package torryharris.b84.MySpringJDBCDemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDAO implements EmployeeCRUD{
	
	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDAO(JdbcTemplate jdbcTemplate) {
		//super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


								//INSERTING THE NEW RECORD IN THE DB
	@Override
	public void insert(Employee employee) {
		// TODO Auto-generated method stub
		if(employee != null)
		{
			jdbcTemplate.update("insert into employee values(?,?,?)",
					new Object[] {employee.getEmployeeId(), employee.getEmployeeName(), employee.getSalary()});
		}
	}

	@Override
	public List<Employee> selectAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setSalary(rs.getInt(3));
				
				return employee;
			}
		});
	}

	@Override
	public Employee selectAEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from employee where empId=?",new Object[] {
				employeeId
		}, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setSalary(rs.getInt(3));
				return employee;
			}
		});
	}

}
