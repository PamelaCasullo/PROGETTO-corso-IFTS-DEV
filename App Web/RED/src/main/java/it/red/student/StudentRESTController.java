package it.red.student;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.red.JdbcUtilityInterface;
import it.red.LessonHomepageStudent;


@RestController
public class StudentRESTController implements JdbcUtilityInterface<Student> {
	
	String directory = "./src/main/resources/static/red_img/";
	
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
			return new ResponseEntity<String>("ERROR",HttpStatus.NOT_FOUND);
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

		if(updateProfile.personal_email.isBlank()) {
			System.out.println("email="+updateProfile.personal_email);
			i.setPersonal_email(updateProfile.personal_email);
		}
		if(updateProfile.password.isBlank()) {
			System.out.println("pws="+updateProfile.password);
			i.setPassword(updateProfile.password);
		}
		if(updateProfile.phone_number.isBlank()) {
			System.out.println("ph="+updateProfile.password);
			i.setPhone_number(updateProfile.phone_number);
		}
		
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
			Student s = repository.findEmailPassword(credential.emailq, credential.passwordq).get(0);
			return s;
		}
		else 
			return null;
	}
	//listaLezioni
	@RequestMapping(value="/Students/show/ElencoLezioni")
	public List<LessonHomepageStudent> ShowLesson(@RequestHeader int id_student){
		
		return repository.SearchLessonById(id_student);
		
	}
	
	//listaVotiAsegnati
	@RequestMapping(value="/Students/show/ElencoVoti")
	public List<StudentShowGrades> ShowGrades(@RequestHeader int id_student){
		System.out.println("MOSTRA VOTI");
		return repository.SearchGradesById(id_student);
		
	}
	
	@RequestMapping(value = "/Student/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam Photo photo) {
		System.out.println("Dentro REST");
		MultipartFile uploadFile = photo.uploadfile;
		String name = photo.institutional_email;
		
		String filePath = Paths.get(directory, name).toString();
		File newFile = new File(filePath);
			System.out.println(filePath);
		BufferedOutputStream stream;
		try {
			byte[] fileContent = uploadFile.getBytes();
			stream = new BufferedOutputStream(new FileOutputStream(newFile));
			stream.write(fileContent);
			stream.close();
			this.repository.uploadPhoto(photo);
			return directory + name;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;

	}

	
	@RequestMapping(value = "/Student/getFile", method = RequestMethod.POST)
	public String getFile(@PathVariable long id_student) {

		Student student = this.repository.downloadPhoto(id_student);
		return student.getPhoto();

	}
	
	//listaPresenzeStudente
	@RequestMapping(value="/Students/show/ElencoPresenze")
	public List<StudentShowPresences> ShowPresences(@RequestHeader int id_student){
		System.out.println("MOSTRA PRESENZE");
		return repository.SearchPresenceById(id_student);
		
	}


}
