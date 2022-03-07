package it.red.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.red.JdbcUtilityInterface;


@RestController
public class StudentRESTController implements JdbcUtilityInterface<Student> {

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
	public ResponseEntity<String> searchElementById(@RequestBody int id) {
		if(this.repository.findValueById(id)!=null)
			return new ResponseEntity<String>("FOUND",HttpStatus.FOUND);
		else 
			return new ResponseEntity<String>("NOT FOUND",HttpStatus.NOT_FOUND);	
	}

	//update 
	@RequestMapping(value="/Students/update/{id_student}", method=RequestMethod.PUT) 
	public Student updateElementById(@PathVariable long id, @RequestBody Student stMod) {

		Student i = this.repository.findValueById(id);

		if(stMod.getDate_of_birth()!=null) {
			i.setDate_of_birth(stMod.getDate_of_birth());
		}
		if(stMod.getPersonal_email()!=null) {
			i.setPersonal_email(stMod.getPersonal_email());
		}
		if(stMod.getPassword()!=null) {
			i.setPassword(stMod.getPassword());
		}
		if(stMod.getPhone_number()!=null) {
			i.setPhone_number(stMod.getPhone_number());
		}
		if(stMod.getPhoto()!=null) {
			i.setPhoto(stMod.getPhoto());
		}

		this.repository.updateValueById(i);
		return i;
	}

	//delete
	@RequestMapping(value="/Students/delete/{id_student}", method=RequestMethod.DELETE) 
	public void deleteElement(@PathVariable long id) {

		this.repository.deleteValueById(id);

	}
	
	//login
	@PostMapping("/Students/login")
	//@RequestMapping(value="/Students/login", method=RequestMethod.POST)
	public List<Student> login(@RequestBody Credential credential) {
		/*if(institutional_email != null && password != null)
			return repository.findEmailPassword(institutional_email, password);
		else 
			return null;*/
		System.out.println(credential.institutional_email);
		return null;
	}

}
