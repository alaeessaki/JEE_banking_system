package Model;

public class Compte {
	private int id;
	private String numero;
	private double solde;
	
	public Compte(int id, String numero, double solde) {
		this.id = id;
		this.numero = numero;
		this.solde = solde;
	}

	public Compte(String numero, double solde) {
		this.numero = numero;
		this.solde = solde;
	}

	public int getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
	}
	
	
	
	
}
