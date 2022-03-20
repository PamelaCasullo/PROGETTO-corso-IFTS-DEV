package it.red.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.red.LessonHomepageStudent;
import it.red.StudentShowGrades;
import it.red.StudentShowPresences;


@Repository(value="MYSQLS")
public class jdbcStudentController implements StudentRepository {

	
	String directory = "./src/main/resources/static/red_img/";
	
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
	public int updateValueById(Student p) {
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
	public List<LessonHomepageStudent> SearchLessonById(long id) {
		return jdbcTemplate.query("select distinct agenda.date, module.title, teacher.first_name, teacher.last_name from student"
				+ "	inner join lesson on lesson.student_id_student=student.id_student"
				+ "	right join agenda on lesson.agenda_id_agenda=agenda.id_agenda"
				+ "	left join module on module.id_module=agenda.module_id_module"
				+ "	left join teacher on teacher.id_teacher=agenda.teacher_id_teacher"
				+ "	where student.id_student=?", BeanPropertyRowMapper.newInstance(LessonHomepageStudent.class),id);
	}
	public List<StudentShowGrades> SearchGradesById(long id) {
		return jdbcTemplate.query("select distinct teacher.first_name,teacher.last_name, lesson.grade, module.title, agenda.date from student"
				+ " right join lesson on lesson.student_id_student=student.id_student"
				+ " left join agenda on lesson.agenda_id_agenda=agenda.id_agenda"
				+ " left join module on module.id_module=agenda.module_id_module"
				+ " left join teacher on agenda.teacher_id_teacher=teacher.id_teacher"
				+ " where student.id_student=? and lesson.grade IS NOT NULL", BeanPropertyRowMapper.newInstance(StudentShowGrades.class),id);
	}
	
	@Override
	public long uploadPhoto(Photo photo) {
		return jdbcTemplate.update("UPDATE student SET photo = ? WHERE id_student = ?", new Object[] {
				directory + photo.getInstitutional_email(), photo.getId_student()
		});
	}

	@Override
	public Student downloadPhoto(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id_student = ?", BeanPropertyRowMapper.newInstance(Student.class), id);
	}
	public List<StudentShowPresences> SearchPresenceById(long id) {
		return jdbcTemplate.query("select distinct lesson.presence,module.title, agenda.date from student"
				+ " inner join lesson on lesson.student_id_student=student.id_student"
				+ " inner join agenda on agenda.id_agenda=lesson.agenda_id_agenda"
				+ " inner join module on agenda.module_id_module=module.id_module"
				+ " where student.id_student=? ", BeanPropertyRowMapper.newInstance(StudentShowPresences.class),id);
	}
}


