package it.red.lesson;

import java.util.List;

public interface LessonRepository {

	int save(Lesson a);
	
	Lesson findValueById(long id);
	
	List<Lesson> findAll();
	
	long updateValueById(Lesson a);
	
	int deleteAll();
	
	int deleteValueById(long id);
}
