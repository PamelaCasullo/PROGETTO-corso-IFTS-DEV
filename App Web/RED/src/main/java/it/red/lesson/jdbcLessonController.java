package it.red.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="MYSQLL")
public class jdbcLessonController implements LessonRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public int save(Lesson a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Lesson findValueById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Lesson> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long updateValueById(Lesson a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteValueById(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
