package it.red.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="MYSQLS")
public class jdbcStudentController implements StudentRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int save(Student p) {
		int retCode;
		if((jdbcTemplate.update("INSERT INTO student(first_name,last_name,date_of_birth,phone_number,"
				+ "personal_email,institutional_email,photo,password) values(?,?,?,?,?,?,?,?)",
				new Object[] {p.getFirst_name(),p.getLast_name(),p.getDate_of_birth(),p.getPhone_number(),
						p.getPersonal_email(),p.getInstitutional_email(),p.getPhoto(),p.getPassword()}))==1)
			retCode=1;

		else retCode=-1;

		return retCode;
	}

	@Override
	public Student findValueById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM student where id_student=?", BeanPropertyRowMapper.newInstance(Student.class),id);

	}

	@Override
	public List<Student> findAll() {
		return jdbcTemplate.query("SELECT * FROM student", BeanPropertyRowMapper.newInstance(Student.class));

	}


	@Override
	public List<Student> findEmailPassword(String institutional_email, String password) {
		return jdbcTemplate.query("SELECT * FROM student WHERE institutional_email=? AND password=?", BeanPropertyRowMapper.newInstance(Student.class),institutional_email,password);

	}

	@Override
	public long updateValueById(Student p) {
		return jdbcTemplate.update("UPDATE student SET"
				+ "	personal_email = ?,"
				+ "	phone_number = ?,"
				+ "	password = ? WHERE id_student=?",new Object[] 
						{p.getPersonal_email(),p.getPhone_number(),p.getPassword(),p.getId_student()});
	}

	@Override
	public int deleteValueById(long id) {
		return jdbcTemplate.update("DELETE FROM student where id_student=?",id);
	}

	@Override
	public int deleteAll() {
		return jdbcTemplate.update("DELETE * FROM student");
	}

}
