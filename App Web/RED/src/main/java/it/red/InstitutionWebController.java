package it.red;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstitutionWebController {

	@Autowired
	List<Institution> institutionList = new ArrayList<>();
	
	//aggiungere un'istituzione
	@RequestMapping(value="/addInstitution", method=RequestMethod.POST)
	protected Institution addInstitution(@PathVariable("name") String name) {
		institutionList.add(new Institution(institutionList.size(), name));
		
		return institutionList.get(((institutionList.size()+1)));
	}
	
	//cercare un'istituzione
	@RequestMapping(value="/searchInstitution/{name}", method=RequestMethod.GET)
	protected Institution searchInstitution(@PathVariable String name) {
		for(int i = 0; i < institutionList.size(); i++) {
			if(institutionList.get(i).getName().equals(name)){
				return institutionList.get(i);
			}
		}
		return null;
	}
	
	//mostrare tutti le istituzioni
	@RequestMapping(value="/showInstitutions", method=RequestMethod.GET)
	protected List<Institution> showInstitutions() {
		return institutionList;
	}
	
	//aggiornare un istituto
	@RequestMapping(value="/institution/{name}", method=RequestMethod.PUT) 
	public Institution updateInsitutionById(@PathVariable String name, @RequestBody Institution institutionModify) {
		for (int i = 0; i < this.institutionList.size(); i++)  {
			if(this.institutionList.get(i).getName().equals(name)) {
				return institutionList.set(i, institutionModify);
			}
		}
		return null;
	}
	
	//eliminare un'istituzione
	@RequestMapping(value="/institution/{name}", method=RequestMethod.DELETE) 
	public String deleteDocByName(@PathVariable String name) {
		String res = null;

		for (int i = 0; i < this.institutionList.size(); i++) {
			if(this.institutionList.get(i).getName().equals(name))
			this.institutionList.remove(i);
			return "Oggetto Rimosso " + this.institutionList.get(i).getName();
		}
		return null;
	}
}
