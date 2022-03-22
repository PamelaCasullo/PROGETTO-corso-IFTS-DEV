package it.red.teacher;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.red.lesson.Lesson;
import it.red.student.Student;


@Repository(value="MYSQLT")
public class jdbcTeacherController implements TeacherRepository {

	String directory = "./src/main/resources/static/red_img/";

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
				+ "	password = ?"
				+ " WHERE id_teacher=? ",new Object[] 
						{p.getPersonal_email(),p.getPhone_number(),
								p.getPassword(),p.getId_teacher()});
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

	@Override
	public long uploadPhoto(Photo photo) {
		return jdbcTemplate.update("UPDATE teacher SET photo = ? WHERE id_teacher = ?", new Object[] {
				directory + photo.getInstitutional_email(), photo.getId_teacher()
		});
	}

	@Override
	public Teacher downloadPhoto(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM teacher WHERE id_teacher = ?", BeanPropertyRowMapper.newInstance(Teacher.class), id);
	}
	public List<TeacherShowLesson> SearchLessonById(long id) {
		return jdbcTemplate.query("select distinct agenda.date, module.title from teacher "
				+ "left join agenda "
				+ "on agenda.teacher_id_teacher=teacher.id_teacher "
				+ "left join module "
				+ "on agenda.module_id_module=module.id_module "
				+ "where teacher.id_teacher=?", BeanPropertyRowMapper.newInstance(TeacherShowLesson.class),id);
	}
	public List<TeacherShowGrades> SearchGradeById(long id) {
		return jdbcTemplate.query("select distinct student.first_name,student.last_name,lesson.grade, module.title ,agenda.date from teacher"
				+ "	left join agenda on agenda.teacher_id_teacher=teacher.id_teacher"
				+ " left join module on module.id_module=agenda.module_id_module"
				+ " left join lesson on lesson.agenda_id_agenda=agenda_id_agenda"
				+ " left join student on student.id_student=lesson.student_id_student"
				+ " where lesson.grade !=0 and teacher.id_teacher=?", BeanPropertyRowMapper.newInstance(TeacherShowGrades.class),id);
	}
	public List<ModuleTeacher> SearchModuleById(long id) {
		return jdbcTemplate.query("select distinct module.title from teacher "
				+ "left join agenda on agenda.teacher_id_teacher=teacher.id_teacher "
				+ "left join module on module.id_module=agenda.module_id_module "
				+ "where teacher.id_teacher=? and module.title IS NOT NULL",BeanPropertyRowMapper.newInstance(ModuleTeacher.class) ,id);
	}
	public List<VoteTeacher> ShowGradeById(long id, String title){
				return jdbcTemplate.query("select student.last_name,student.first_name,lesson.grade,agenda.date from teacher "
						+ "left join agenda on agenda.teacher_id_teacher=teacher.id_teacher "
						+ "left join module on module.id_module=agenda.module_id_module "
						+ "left join lesson on lesson.agenda_id_agenda=agenda.id_agenda "
						+ "left join student on lesson.student_id_student=student.id_student "
						+ "where teacher.id_teacher=? and module.title =? ", BeanPropertyRowMapper.newInstance(VoteTeacher.class),id,title);
	}
	/*select agenda.id_agenda from agenda
left join teacher on teacher.id_teacher=agenda.teacher_id_teacher
left join module on module.id_module=agenda.module_id_module
where date="2022-02-16" and module.title="Sviluppo applicazioni Android"*/
	
	public List<AgendaPerVote> getIdAgendaPerVote(Date date, String title) {
		return jdbcTemplate.query("select distinct agenda.* from agenda "
				+ "left join teacher on teacher.id_teacher=agenda.teacher_id_teacher "
				+ "left join module on module.id_module=agenda.module_id_module "
				+ "where date=? and module.title=? ", BeanPropertyRowMapper.newInstance(AgendaPerVote.class), date,title);
	}
	
	public List<Student>getIdStudentPerVote(String institutional_email){
		return jdbcTemplate.query("select * from student "
				+ "where student.institutional_email=?",BeanPropertyRowMapper.newInstance(Student.class),institutional_email);
	}
	
	public int saveVoto(Lesson p) {
		int retCode;
		if((jdbcTemplate.update("INSERT INTO lesson(grade,agenda_id_agenda,student_id_student)"
				+ " values(?,?,?)",
				new Object[] {p.getAgenda_id_agenda(),p.getStudent_id_student(),p.getGrade()}))==1)
			retCode=1;

		else retCode=-1;

		return retCode;
	}
	public List<Student> showStudentByTeacher(long id_teacher) {
		
		return jdbcTemplate.query("select distinct student.first_name,student.last_name,student.institutional_email,student.phone_number from teacher "
				+ "left join agenda on agenda.teacher_id_teacher=teacher.id_teacher "
				+ "left join lesson on lesson.agenda_id_agenda=agenda.id_agenda "
				+ "left join student on lesson.student_id_student=student.id_student "
				+ "left join module on agenda.module_id_module=module.id_module "
				+ "where teacher.id_teacher=?", BeanPropertyRowMapper.newInstance(Student.class) ,id_teacher);
	}
//
public List<Student> showStudentByTeacher1(long id_teacher,String title) {
		
		return jdbcTemplate.query("select distinct student.first_name,student.last_name,student.institutional_email,student.phone_number from teacher "
				+ "left join agenda on agenda.teacher_id_teacher=teacher.id_teacher "
				+ "left join lesson on lesson.agenda_id_agenda=agenda.id_agenda "
				+ "left join student on lesson.student_id_student=student.id_student "
				+ "left join module on agenda.module_id_module=module.id_module "
				+ "where teacher.id_teacher=? and module.title=?", BeanPropertyRowMapper.newInstance(Student.class) ,id_teacher,title);
	}
}
