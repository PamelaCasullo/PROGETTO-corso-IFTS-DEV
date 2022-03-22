package it.red.institution;


public class Institution {
	private long id_institution;
	private String name;

	public Institution() {
		
	}
	
	public Institution(long id_institution, String name) {
		this.id_institution = id_institution;
		this.name = name;
	}

	public long getId_institution() {
		return id_institution;
	}

	public void setId_institution(long id_institution) {
		this.id_institution = id_institution;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
