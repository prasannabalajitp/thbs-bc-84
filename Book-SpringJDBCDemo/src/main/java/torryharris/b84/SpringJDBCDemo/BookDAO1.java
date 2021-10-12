package torryharris.b84.SpringJDBCDemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class BookDAO1  implements CRUDOperations{
       private JdbcTemplate jdbcTemplate;
	
	public BookDAO1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public void insert(Book book) {
		
		if (null != book) {

         // Prepared statement in JDBC : insert statement below 			
			jdbcTemplate.update(
					"insert into book values(?,?,?)",
					new Object[] { book.getBookId(),
							book.getBookName(),book.getBookPrice() });
		
	}
		
	}
	
	
public List<Book> selectAll(){
		
		return	jdbcTemplate.query("select * from book", new RowMapper<Book>() {
            // ResultSet rs = st.executeQuery("Select * from employee");
			
			
			@Override
			public Book mapRow(ResultSet resultSet, int arg1) throws SQLException {
				Book book = new Book();
				book.setBookId(resultSet.getInt(1));
				book.setBookName(resultSet.getString(2));
				book.setBookPrice(resultSet.getInt(3));
				return book;

			}
		});
		}




public Book select(int bookId) {
	return (Book) jdbcTemplate.queryForObject(
			"SELECT * FROM book WHERE bookId=?",
			new Object[] { Integer.valueOf(bookId) },
			new RowMapper<Book>() {

				@Override
				public Book mapRow(ResultSet resultSet, int arg1)
						throws SQLException {
					Book book = new Book();
					book.setBookId(resultSet.getInt(1));
					book.setBookName(resultSet.getString(2));
					book.setBookPrice(resultSet.getInt(3));
					return book;
				}
			});
}

}