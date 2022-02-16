package it.red.institution;


public class Institution {
	private int id_institution;
	private String name;

	public Institution() {
		
	}
	
	public Institution(int id_institution, String name) {
		this.id_institution = id_institution;
		this.name = name;
	}

	public int getId_institution() {
		return id_institution;
	}

	public void setId_institution(int id_institution) {
		this.id_institution = id_institution;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
