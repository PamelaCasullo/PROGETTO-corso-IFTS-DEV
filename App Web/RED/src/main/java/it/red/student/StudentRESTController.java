package it.red.student;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import it.red.JdbcUtilityInterface;
import it.red.LessonHomepageStudent;


@RestController
public class StudentRESTController implements JdbcUtilityInterface<Student> {
	PreparedStatement ps =null;

	String DB_TABLE = "Student";

	@Autowired
	@Qualifier("MYSQLS")
	StudentRepository repository;

	//showAll
	@RequestMapping(value="/Students/showAll", method=RequestMethod.GET)
	public List<Student> showItems() {
		return repository.findAll();
	}

	//add
	@RequestMapping(value="/Students/add/newStudent", method=RequestMethod.POST)
	public ResponseEntity<String> addElement(@RequestBody Student newStudent) {
		if(this.repository.save(newStudent)>0)
			return new ResponseEntity<String>("SAVED",HttpStatus.CREATED);
		else 
			return new ResponseEntity<String>("ERROR",HttpStatus.NOT_ACCEPTABLE);
	}

	//doRetrieveByKey
	@RequestMapping(value="/Students/search/{id_student}", method=RequestMethod.PUT)
	public Student searchElementById(@PathVariable long id_student) {
		
		System.out.println(id_student);
		return this.repository.findValueById(id_student);

	}

	//update
	@RequestMapping(value="/Students/update", method=RequestMethod.PUT) 
	public Student updateElementById(@RequestBody UpdateProfile updateProfile) {
		
		Student i = this.repository.findValueById(updateProfile.getId_student());

		if(updateProfile.personal_email != null) {
			i.setPersonal_email(updateProfile.personal_email);
		}
		if(updateProfile.password != null) {
			i.setPassword(updateProfile.password);
		}
		if(updateProfile.phone_number != null) {
			i.setPhone_number(updateProfile.phone_number);
		}

		System.out.println(i.getPersonal_email());
		this.repository.updateValueById(i);
		return i;
	}

	//delete
	@RequestMapping(value="/Students/delete/{id_student}", method=RequestMethod.DELETE) 
	public void deleteElement(@PathVariable long id_student) {

		this.repository.deleteValueById(id_student);

	}

	//login
	@PostMapping(value="/Students/login")
	public Student Login(@RequestBody Credenziali credential) {

		if(credential.emailq != null && credential.passwordq != null) {
			System.out.println(credential.emailq);
			Student ss = repository.findEmailPassword(credential.emailq, credential.passwordq).get(0);
			return ss;
		}
		else 
			return null;
	}
	//listaLezioni
	@RequestMapping(value="/Students/show/ElencoLezioni")
	public List<LessonHomepageStudent> ShowLesson(@RequestHeader int id_student){
		System.out.println("Dentro ShowLesson");
		return repository.SearchLessonById(id_student);
		
	}



}
