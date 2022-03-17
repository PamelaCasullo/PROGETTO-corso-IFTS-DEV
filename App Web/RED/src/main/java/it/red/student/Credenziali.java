package it.red.student;

public class Credenziali {
	String emailq;
	String passwordq;
	
	public Credenziali() {
		this.emailq = "AAAAAAAA";
		this.passwordq = "BBBBBBBBBb";
	} 
	
	public Credenziali(String emailq, String passwordq) {
		this.emailq = emailq;
		this.passwordq = passwordq;
	}
	
	public String getEmailq() {
		return emailq;
	}
	public void setEmailq(String emailq) {
		this.emailq = emailq;
	}
	public String getPasswordq() {
		return passwordq;
	}
	public void setPasswordq(String passwordq) {
		this.passwordq = passwordq;
	}
	
	
}
