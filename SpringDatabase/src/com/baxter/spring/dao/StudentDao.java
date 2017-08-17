package com.baxter.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.baxter.spring.beans.Student;

@Component("studentDao")
public class StudentDao {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Student> getStudents()
	{
	 return jdbc.query("select * from student", new RowMapper<Student>(){

		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student students = new Student();
			students.setId(rs.getInt("id"));
			students.setName(rs.getString("name"));
			students.setEmail(rs.getString("email"));
			return students;
		}		 
	 });
	}
	
	public Student getStudent(int id)
	{
		MapSqlParameterSource param = new MapSqlParameterSource("id",id);
		return jdbc.queryForObject("select * from student where id=:id", param, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				return student;
			}
		});
	}
	
	public boolean deleteStudent(int id)
	{
		MapSqlParameterSource param = new MapSqlParameterSource("id",id);
		return jdbc.update("delete from student where id=:id", param)==1;
	}
	
	public boolean createStudent(Student student)
	{
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);
		return jdbc.update("insert into student values(:id,:name,:email)", params)==1;
	}
	
	public int updateStudent(Student student)
	{
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(student);
		return jdbc.update("update student set email=:email,name=:name where id=:id", param);
	}
	
	@Transactional
	public int[] createStudents(List<Student> students)
	{
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(students.toArray());
		return jdbc.batchUpdate("insert into student values(:id,:name,:email)", params);
	}
	
	

}
