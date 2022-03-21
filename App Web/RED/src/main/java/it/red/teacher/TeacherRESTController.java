package it.red.teacher;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import it.red.JdbcUtilityInterface;


@RestController
public class TeacherRESTController implements JdbcUtilityInterface<Teacher>{

	String directory = "./src/main/resources/static/red_img/";

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

	@RequestMapping(value="/Teachers/update", method=RequestMethod.PUT) 
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


	@RequestMapping(value = "/Teachers/uploadFile", method = RequestMethod.PUT)
	public String uploadFile(@RequestBody Photo photo) {

		MultipartFile uploadFile = photo.getUploadfile();
		String name = photo.getInstitutional_email();

		String filePath = Paths.get(directory, name).toString();

		BufferedOutputStream stream;
		try {
			stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(uploadFile.getBytes());
			stream.close();
			this.repository.uploadPhoto(photo);
			return directory + photo.getInstitutional_email();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;

	}


	@RequestMapping(value = "/Teachers/getFile", method = RequestMethod.POST)
	public String getFile(@PathVariable long id_teacher) {

		Teacher teacher = this.repository.downloadPhoto(id_teacher);
		return teacher.getPhoto();

	}
	//listaLezioni
	@RequestMapping(value="/Teachers/show/ElencoLezioni")
	public List<TeacherShowLesson> ShowLesson(@RequestHeader long id_teacher){
		System.out.println("ElencoLezioni");
		return repository.SearchLessonById(id_teacher);
		
	}
	//listaVotiAssegnatiDalDocente
		@RequestMapping(value="/Teachers/show/ElencoVoti")
		public List<TeacherShowGrades> ShowGrade(@RequestHeader long id_teacher){
			System.out.println("ElencoVoti");
			return repository.SearchGradeById(id_teacher);
			
		}
		@RequestMapping(value="/Teachers/show/ElencoModuli")
		public List<ModuleTeacher> ShowModules(@RequestHeader long id_teacher){
			System.out.println("ElencoModuliSpecifico");
			return repository.SearchModuleById(id_teacher);
			//	public List<ModuleTeacher> SearchGradeByIdSpecified(long id) {

		}
		
	@RequestMapping(value="/Teachers/show/ElencoVoteModuleSelected/{title}")
	public List<VoteTeacher> Show(@PathVariable String title, @RequestHeader long id_teacher ){
		System.out.println("ElencoVotiSelected");
		return repository.ShowGradeById(id_teacher, title);
		
	}

}
