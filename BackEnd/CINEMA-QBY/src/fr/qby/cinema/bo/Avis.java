package fr.qby.cinema.bo;

public class Avis {
	private int id_avis ;
	private Salles id_salles ;
	private Utilisateurs id_users ;
	private double note ;
	private String proprete ;
	
	public Avis(int id_avis, Salles id_salles, Utilisateurs id_users, double note, String proprete)
	{
		this.id_avis = id_avis;
		this.id_salles = id_salles;
		this.id_users = id_users;
		this.note = note;
		this.proprete = proprete;
	}

	public int getId_avis() {
		return id_avis;
	}

	public void setId_avis(int id_avis) {
		this.id_avis = id_avis;
	}

	public Salles getId_salles() {
		return id_salles;
	}

	public void setId_salles(Salles id_salles) {
		this.id_salles = id_salles;
	}

	public Utilisateurs getId_users() {
		return id_users;
	}

	public void setId_users(Utilisateurs id_users) {
		this.id_users = id_users;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getProprete() {
		return proprete;
	}

	public void setProprete(String proprete) {
		this.proprete = proprete;
	}
	
	
}
