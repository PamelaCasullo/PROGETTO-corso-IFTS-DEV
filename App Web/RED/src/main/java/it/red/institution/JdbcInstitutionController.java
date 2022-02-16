package it.red.institution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository(value="MYSQL")
public class JdbcInstitutionController implements InstitutionRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public int save(Institution p) {
		int retCode;
		if((jdbcTemplate.update("INSERT INTO institution(name) values (?)", new Object[] {p.getName()}))==1)  
		
			 retCode=1;
		
		else retCode=-1;
		
		return retCode;
	}
		
	@Override
	public Institution findValueById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM institution where id_institution=?", BeanPropertyRowMapper.newInstance(Institution.class),id);

	}

	@Override
	public List<Institution> findAll() {
		return jdbcTemplate.query("SELECT * FROM institution", BeanPropertyRowMapper.newInstance(Institution.class));
	}

	@Override
	public long updateValueById(Institution p) {
		return jdbcTemplate.update("UPDATE institution SET lastName=? WHERE id_institution=?",new Object[] {p.getName(),p.getId_institution()});

	}

	@Override
	public int deleteValueById(long id) {
		return jdbcTemplate.update("DELETE FROM institution WHERE id_institution=?", id);
	}

	@Override
	public int deleteAll() {
		return jdbcTemplate.update("DELETE * FROM institution");

	}


}
