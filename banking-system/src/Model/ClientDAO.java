package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.Statement;

import database.Database;

public class ClientDAO {

	public void createClient(Client client) {
		Connection con;
		PreparedStatement preparedStatement;
		String query = "INSERT INTO `client` (`id`, `nom`, `prenom`,`CIN`,`compte_id`) VALUES(NULL,?,?,?,?)";
		
		try {
			con = Database.connect();
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, client.getNom());
			preparedStatement.setString(2, client.getPrenom());
			preparedStatement.setString(3, client.getCIN());
			preparedStatement.setInt(4, client.getCompte().getId());
			
			preparedStatement.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			Database.disconnect();
			con = null;
		}
	}
	
	public Client getClient(int id) {
		Connection con;
		PreparedStatement preparedStatement;
		ResultSet rs;
		String query = "SELECT * FROM client WHERE id=?";
		Compte compte;
		Client client;
		CompteDAO compteDAO = new CompteDAO();

		try {
			con = Database.connect();
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			
			rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String CIN = rs.getString("CIN");
				int compte_id = rs.getInt("compte_id");
				
				compte = compteDAO.getAccount(compte_id);
				client = new Client(id, nom, prenom, CIN, compte);
				
				return client;
			}
			
			return null;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			Database.disconnect();
			con = null;
		}
	}
	
	
	public Client getClient(String nom) {
		Connection con;
		PreparedStatement preparedStatement;
		ResultSet rs;
		String query = "SELECT * FROM client WHERE nom=?";
		Compte compte;
		Client client;
		CompteDAO compteDAO = new CompteDAO();

		try {
			con = Database.connect();
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, nom);
			
			rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String prenom = rs.getString("prenom");
				String CIN = rs.getString("CIN");
				int compte_id = rs.getInt("compte_id");
				
				compte = compteDAO.getAccount(compte_id);
				client = new Client(id, nom, prenom, CIN, compte);
				
				return client;
			}
			
			return null;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			Database.disconnect();
			con = null;
		}
	}
	
	public ArrayList<Client> getAll(){
		
		Connection con;
		Statement statment;
		Compte compte;
		Client client;
		ArrayList<Client> clients = new ArrayList<Client>();
		CompteDAO compteDAO = new CompteDAO();
		
		try {
			con = Database.connect();
			statment = con.createStatement();
			ResultSet rs = statment.executeQuery("SELECT * FROM client");
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String CIN = rs.getString("CIN");
				int compte_id = rs.getInt("compte_id");
				
				compte = compteDAO.getAccount(compte_id);
				client = new Client(id, nom, prenom ,CIN, compte);
				clients.add(client);
			}
			return clients;
		
		}catch(Exception e) {
			e.printStackTrace();
			return null;
			
		}finally {
			Database.disconnect();
			con = null;
		}
		
	}
	
	public boolean updateClient(Client client) {
		
		Connection con;
		PreparedStatement preparedStatement;
		String query = "UPDATE `client` SET `nom` = ?, `prenom`=?, `CIN`=? WHERE `client`.`id` = ? ";
		
		try {
			con = Database.connect();
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, client.getNom());
			preparedStatement.setString(2, client.getPrenom());
			preparedStatement.setString(3, client.getCIN());
			preparedStatement.setInt(4, client.getId());

			preparedStatement.execute();
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			Database.disconnect();
			con = null;
		}
	}
	
	public boolean deleteClient(Client client) {
		
		Connection con;
		PreparedStatement preparedStatement;
		String query = "DELETE FROM client WHERE id=?";
		CompteDAO compteDAO = new CompteDAO();

		try {
			con = Database.connect();
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setInt(1, client.getId());

			preparedStatement.execute();
			compteDAO.deleteAccount(client.getCompte());
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			Database.disconnect();
			con = null;
		}
	}
}
