package it.red;

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

@RestController
public class InstitutionRESTController {

	@Autowired
	@Qualifier("MYSQL") //per il testing usare @Qualifier("MEM")
	
	InstitutionRepository repository ;
	
	//mostrare tutti le istituzioni
	@RequestMapping(value="/Institutions/showAll", method=RequestMethod.GET)
	protected List<Institution> showInstitutions() {
		return repository.findAll();
	}
	//aggiungere un'istituzione
	@RequestMapping(value="/Institutions/add", method=RequestMethod.POST)
	protected ResponseEntity<String> addInstitution(@RequestBody Institution newInstitution) {
		if(this.repository.save(newInstitution)>0) 
			return new ResponseEntity<String>("OK",HttpStatus.CREATED);
		 else 
			return new ResponseEntity<String>("KO",HttpStatus.BAD_REQUEST);

	}

	//cercare un'istituzione tramite chiave
	@RequestMapping(value="/Institutions/{name}", method=RequestMethod.GET)
	protected ResponseEntity<String> searchInstitution(@PathVariable int id) {
		
		Institution ins = this.repository.findValueById(id);
		if(ins!=null) 
			return new ResponseEntity<String>("OK",HttpStatus.FOUND);
		else
			return new ResponseEntity<String>("KO",HttpStatus.NOT_FOUND);
	}
	//aggiornare un istituto
	@RequestMapping(value="/Institutions/{name}", method=RequestMethod.PUT) 
	public Institution updateInsitutionById(@PathVariable long id, @RequestBody Institution institutionModify) {
		
		Institution i = this.repository.findValueById(id);
		
		if(institutionModify.getName()!=null) {
			i.setName(institutionModify.getName());
		}
		this.repository.updateValueById(i);
		return i;
	}
	//eliminare un'istituzione
	@RequestMapping(value="/Institutions/{name}", method=RequestMethod.DELETE) 
	public void deleteInst(@PathVariable long id) {
		
		this.repository.deleteValueById(id);
		
	}

}
