package it.red.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.red.JdbcUtilityInterface;

@RestController
public class AgendaRESTController implements JdbcUtilityInterface<Agenda> {
	@Autowired
	@Qualifier("MYSQLA")
	AgendaRepository repository;
	
	@RequestMapping(value="/Agenda/showAll")
	public List<Agenda> showItems() {
		return repository.findAll();
	}

	@RequestMapping(value="/Agenda/add/newElement", method=RequestMethod.POST)
	public ResponseEntity<String> addElement(Agenda newItem) {
		if(this.repository.save(newItem)>0)
			return new ResponseEntity<String>("SAVED",HttpStatus.CREATED);
		else 
			return new ResponseEntity<String>("ERROR",HttpStatus.NOT_ACCEPTABLE);
	}

	@RequestMapping(value="/Agenda/search/{id_agenda}", method=RequestMethod.PUT)
	public ResponseEntity<String> searchElementById(int id) {
		if(this.repository.findValueById(id)!=null)
			return new ResponseEntity<String>("FOUND",HttpStatus.FOUND);
		else 
			return new ResponseEntity<String>("NOT FOUND",HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/Agenda/update/{id_agenda}", method=RequestMethod.PUT)
	public Agenda updateElementById(long id, Agenda stMod) {
		Agenda i = this.repository.findValueById(id);

		
		if(stMod.getDescription()!=null) 
			i.setDescription(stMod.getDescription());
	

		this.repository.updateValueById(i);
		return i;
	}

	@RequestMapping(value="/Agenda/delete/{id_agenda}", method=RequestMethod.PUT)
	public void deleteElement(long id) {
		this.repository.deleteValueById(id);
		
	}

}
