package it.red.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.red.student.Student;



@Repository(value="MYSQLT")
public class jdbcTeacherController implements TeacherRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(Teacher p) {
		int retCode;
		if((jdbcTemplate.update("INSERT INTO teacher(first_name,last_name,phone_number,"
				+ "personal_email,institutional_email,photo,password) values(?,?,?,?,?,?,?,?)",
				new Object[] {p.getFirst_name(),p.getLast_name(),p.getPhone_number(),
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
				+ " image=? WHERE id_teacher=?",new Object[] 
						{p.getPersonal_email(),p.getPhone_number(),
								p.getPassword(),p.getPhoto(),p.getId_teacher()});
	}

	@Override
	public int deleteValueById(long id) {
		return jdbcTemplate.update("DELETE FROM teacher where id_teacher=?",id);

	}

	@Override
	public int deleteAll() {
		return jdbcTemplate.update("DELETE FROM teacher");
	}

	@Override
	public List<Teacher> findEmailPassword(String institutional_email, String password) {
		return jdbcTemplate.query("SELECT * FROM teacher WHERE institutional_email=? AND password=?", BeanPropertyRowMapper.newInstance(Teacher.class),institutional_email,password);

	}

	


}
