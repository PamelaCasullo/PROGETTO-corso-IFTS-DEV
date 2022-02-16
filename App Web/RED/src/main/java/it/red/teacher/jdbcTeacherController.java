package it.red.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository(value="MYSQL")
public class jdbcTeacherController implements TeacherRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(Teacher p) {
		int retCode;
		if((jdbcTemplate.update("INSERT INTO teacher(first_name,last_name,phone_number,"
				+ "personal_email,institutional_email,photo,password) values(?,?,?,?,?,?,?,?)",
				new Object[] {p.getFirstName(),p.getLast_name(),p.getPhone_number(),
						p.getPersonal_email(),p.getInstitutional_email(),p.getPhoto(),p.getPassword()}))==1)
			retCode=1;

		else retCode=-1;

		return retCode;
	}

	@Override
	public Teacher findValueById(long id) {
		
		return jdbcTemplate.queryForObject("SELECT * FROM teacher where id_teacher=?", BeanPropertyRowMapper.newInstance(Teacher.class),id);
	}

	@Override
	public List<Teacher> findAll() {
		return jdbcTemplate.query("SELECT * FROM teacher", BeanPropertyRowMapper.newInstance(Teacher.class));

	}

	@Override
	public long updateValueById(Teacher p) {
		return jdbcTemplate.update("UPDATE teacher SET"
				+ "	personal_email = ?,"
				+ "	phone_number = ?,"
				+ "	password = ?,"
				+ " image=? WHERE id_student=?",new Object[] 
						{p.getPersonal_email(),p.getPhone_number(),
								p.getPassword(),p.getPhoto(),p.getId_teacher()});
	}

	@Override
	public int deleteValueById(long id) {
		return jdbcTemplate.update("DELETE FROM teacher where id_student=?",id);

	}

	@Override
	public int deleteAll() {
		return jdbcTemplate.update("DELETE FROM teacher");
	}

	


}