package it.red;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface JdbcUtilityInterface<T>{

	//showAll
	public List<T> showItems();

	//add
	public ResponseEntity<String> addElement(@RequestBody T newItem);

	//doRetrieveByKey
	
	public ResponseEntity<String> searchElementById(@RequestBody int id);

	//update 
	public T updateElementById(@PathVariable long id, @RequestBody T stMod);

	//delete
	public void deleteElement(@PathVariable long id);
}
