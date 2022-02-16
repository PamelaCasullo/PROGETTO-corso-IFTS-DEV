package it.red.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.red.JdbcUtilityInterface;


@RestController
public class TeacherRESTController implements JdbcUtilityInterface<Teacher>{

	@Autowired
	@Qualifier("MYSQL")
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
	public ResponseEntity<String> searchElementById(@RequestBody int id) {
		if(this.repository.findValueById(id)!=null)
			return new ResponseEntity<String>("FOUND",HttpStatus.FOUND);
		else 
			return new ResponseEntity<String>("NOT FOUND",HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/Teachers/search/{id_teacher}", method=RequestMethod.PUT) 
	public Teacher updateElementById(@PathVariable long id,@RequestBody Teacher stMod) {
		Teacher i = this.repository.findValueById(id);

		
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
	
	@RequestMapping(value="/Teachers/search/{id_teacher}", method=RequestMethod.DELETE)
	public void deleteElement(@PathVariable long id) {
		this.repository.deleteValueById(id);
		
	}
	
	
	


}
