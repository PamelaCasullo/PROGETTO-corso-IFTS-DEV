package it.red.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.red.JdbcUtilityInterface;


@RestController
public class TeacherRESTController implements JdbcUtilityInterface<Teacher>{

	@Autowired
	@Qualifier("MYSQLT")
	TeacherRepository repository;

	@RequestMapping(value="/Teachers/showAll")
	public List<Teacher> showItems() {
		return repository.findAll();
	}


	@RequestMapping(value="/Teachers/add/newTeacher", method=RequestMethod.POST)
	public ResponseEntity<String> addElement(@RequestBody Teacher newItem) {
		if(this.repository.save(newItem)>0)
			return new ResponseEntity<String>("SAVED",HttpStatus.CREATED);
		else 
			return new ResponseEntity<String>("ERROR",HttpStatus.NOT_ACCEPTABLE);
	}

	@RequestMapping(value="/Teachers/search/{id_teacher}", method=RequestMethod.PUT)
	public Teacher searchElementById(@PathVariable long id_teacher) {
		return this.repository.findValueById(id_teacher);
	}

	@RequestMapping(value="/Teachers/update/{id_teacher}", method=RequestMethod.PUT) 
	public Teacher updateElementById(@RequestBody UpdateProfile updateProfile) {
		Teacher i = this.repository.findValueById(updateProfile.getId_teacher());
		
		if(updateProfile.getPersonal_email() != null) {
			i.setPersonal_email(updateProfile.getPersonal_email());
		}
		if(updateProfile.getPassword() != null) {
			i.setPassword(updateProfile.getPassword());
		}
		if(updateProfile.getPhone_number() != null) {
			i.setPhone_number(updateProfile.getPhone_number());
		}

		this.repository.updateValueById(i);
		return i;
	}

	@RequestMapping(value="/Teachers/delete/{id_teacher}", method=RequestMethod.DELETE)
	public void deleteElement(@PathVariable long id) {
		this.repository.deleteValueById(id);

	}

	//login
	@PostMapping(value="/Teachers/login")
	public Teacher Login(@RequestBody Credenziali credential) {

		if(credential.emailq != null && credential.passwordq != null) {
			System.out.println(credential.emailq);
			System.out.println(credential.passwordq);
			Teacher ss = repository.findEmailPassword(credential.emailq, credential.passwordq).get(0);
			return ss;
		}
		else 
			return null;

	}




}
