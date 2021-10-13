package torryharris.b84.MySpringJDBCDemo;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

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
		return null;
	}

	@Override
	public Employee selectAEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
