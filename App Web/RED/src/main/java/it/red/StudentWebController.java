package it.red;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentWebController {

	@Autowired
	List<Student> studentList = new ArrayList<>();
	
	
}
