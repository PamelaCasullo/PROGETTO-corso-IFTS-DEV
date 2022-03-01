package it.red.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="MYSQLA")
public class jdbcAgendaController implements AgendaRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public int save(Agenda a) {
		int retCode;
		if((jdbcTemplate.update("INSERT INTO agenda(date,"
				+ " description, "
				+ "agenda_id_module, "
				+ "agenda_id_teacher) "
				+ "values(?,?,?,?)",
			new Object[] {a.getDate(),a.getDescription(),
					a.getModule_id_module(),a.getTeacher_id_teacher()}))==1)
			retCode=1;

		else retCode=-1;

		return retCode;
	}

	@Override
	public Agenda findValueById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM agenda where id_agenda=?", BeanPropertyRowMapper.newInstance(Agenda.class),id);

	}

	@Override
	public List<Agenda> findAll() {
		return jdbcTemplate.query("SELECT * FROM agenda", BeanPropertyRowMapper.newInstance(Agenda.class));

	}

	@Override
	public long updateValueById(Agenda a) {
		return jdbcTemplate.update("UPDATE agenda SET"
				+ "	description = ?,"
				+" WHERE id_agenda=?",new Object[] 
						{a.getDescription(),a.getId_agenda()});
	}

	@Override
	public int deleteValueById(long a) {
		return jdbcTemplate.update("DELETE FROM agenda where id_agenda=?",a);

	} 

	@Override
	public int deleteAll() {
		return jdbcTemplate.update("DELETE FROM agenda");
	}

}
