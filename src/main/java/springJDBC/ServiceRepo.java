package springJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceRepo {
	
	private JdbcTemplate temp;

	public JdbcTemplate getTemp() {
		return temp;
	}
    
//	we want spring inject the the object of JdbcTemplate 
	@Autowired
	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}

//	insert data into StudModel
	public void save(StudModel sm) {
		try {
		String sql = "insert into StudModel (id, name, age) values (?,?,?)";
		temp.update(sql, sm.getId(), sm.getName(), sm.getAge());
		System.out.println("Success!");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
//	retrieve all data from table
	public List<StudModel> findAll() {
		
		String sql = "Select * from StudModel";
		RowMapper<StudModel> mapper = new RowMapper<StudModel>() {
			@Override
			public StudModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudModel sdm = new StudModel();
				sdm.setId(rs.getInt(1));
				sdm.setName(rs.getString(2));
				sdm.setAge(rs.getInt(3));
				return sdm;
			}
		};
		
		List<StudModel> stud = temp.query(sql, mapper);
		return stud ;
	}
	
//	retrieve single data from table
public List<StudModel> find() {
		
		String sql = "Select * from StudModel where age = 20";
		RowMapper<StudModel> mapper = new RowMapper<StudModel>() {
			@Override
			public StudModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudModel sdm = new StudModel();
				sdm.setId(rs.getInt(1));
				sdm.setName(rs.getString(2));
				sdm.setAge(rs.getInt(3));
				return sdm;
			}
		};
		
		List<StudModel> stud = temp.query(sql, mapper);
		return stud ;
	}
	
	
//  delete single row from table
	public void deleteRow(int id) {
		String sql = "Delete from StudModel where id=?";
		int rows = temp.update(sql, id);
		System.out.println(rows +" affected !");
	}
	
//	delete all the rows from table
	public void DeleteAll() {
		String sql = "Delete from StudModel";
		int rows = temp.update(sql);
		System.out.println(rows +" affected !");
	}
	
//	update rows from table
	public void update(int id , String name) {
		String sql = "Update StudModel set name=? where id=?";
		int rows = temp.update(sql , name, id);
		System.out.println(rows +" updated !");
	}
	
//	update alter table 
	public void alter() {
		String sql = "Alter table StudModel add marks int";
		int rows = temp.update(sql);
		System.out.println(rows + "Affected !");
	}
	
}
