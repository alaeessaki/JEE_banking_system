package Model;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String CIN;
	private Compte compte;
	
	public Client(int id, String nom, String prenom, String CIN, Compte compte) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.CIN = CIN;
		this.compte = compte;
	}

	public Client(String nom, String prenom, String CIN, Compte compte) {
		this.nom = nom;
		this.prenom = prenom;
		this.CIN = CIN;
		this.compte = compte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", CIN=" + CIN + ", compte=" + compte + "]";
	}
	
	
	
	
	

}
