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
public class StudentWebController {

	@Autowired
	List<Student> studentList = new ArrayList<>();
	
	//aggiornare dati studente
	//TODO da sistemare, rimosso l'id dalla classe studente
	/*
	@RequestMapping(value="/student/{id}", method=RequestMethod.PUT) 
	protected Student updateStudentById(@PathVariable int id, @RequestBody Student studentModify) {
		for (int i = 0; i < this.studentList.size(); i++)  {
			if(this.studentList.get(i).getId_student() == id) {
				return studentList.set(i, studentModify);
			}
		}
		return null;
	}
	*/
}
