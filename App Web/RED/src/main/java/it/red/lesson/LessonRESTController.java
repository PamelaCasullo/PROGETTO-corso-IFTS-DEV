package it.red.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.red.JdbcUtilityInterface;
import it.red.agenda.Agenda;

@RestController
public class LessonRESTController implements JdbcUtilityInterface<Lesson> {
	@Autowired
	@Qualifier("MYSQLL")
	LessonRepository repository;

	@RequestMapping(value="/Lessons/showAll")
	public List<Lesson> showItems() {
		return repository.findAll();
	}

	@RequestMapping(value="/Lessons/add/newElement", method=RequestMethod.POST)
	public ResponseEntity<String> addElement(Lesson newItem) {
		if(this.repository.save(newItem)>0)
			return new ResponseEntity<String>("SAVED",HttpStatus.CREATED);
		else 
			return new ResponseEntity<String>("ERROR",HttpStatus.NOT_ACCEPTABLE);
	}

	@RequestMapping(value="/Lessons/search/{id_lesson}", method=RequestMethod.POST)
	public Lesson searchElementById(long id) {
		return this.repository.findValueById(id);
	}

	@RequestMapping(value="/Lessons/update/{id_lesson}", method=RequestMethod.POST)
	public Lesson updateElementById(long id, Lesson stMod) {
		Lesson i = this.repository.findValueById(id);

		/*this.presence = presence;
		this.grade = grade;*/
		if(stMod.getPresence()!=true) 
			i.setPresence(stMod.getPresence());
		if(stMod.getGrade()!=0) 
			i.setGrade(stMod.getGrade());
	

		this.repository.updateValueById(i);
		return i;
	}

	@RequestMapping(value="/Lessons/delete/{id_lesson}", method=RequestMethod.POST)
	public void deleteElement(long id) {
		// TODO Auto-generated method stub
		
	}
}
