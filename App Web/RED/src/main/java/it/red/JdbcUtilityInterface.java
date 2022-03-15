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
	
	public T searchElementById(@RequestBody long id);


	//delete
	public void deleteElement(@PathVariable long id);
	
}
