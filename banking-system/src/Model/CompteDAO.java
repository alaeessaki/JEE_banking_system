package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.Database;

public class CompteDAO {
	
	public void createAccount(Compte compte) {
		Connection con;
		String query = "INSERT INTO `compte` (`id`, `numero`, `solde`) VALUES(NULL,?,?)";
		PreparedStatement preparedStatement;
		try {
			con = Database.connect();
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setString(1, compte.getNumero());
			preparedStatement.setDouble(2, compte.getSolde());
			
			preparedStatement.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Database.disconnect();
			con=null;
		}
	}
	
	public Compte getAccount(int id) {
		Connection con;
		String query = "SELECT * FROM compte WHERE id=?";
		PreparedStatement preparedStatement;
		try {
			con = Database.connect();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				String numero = rs.getString("numero");
				double solde = rs.getDouble("solde");
				
				Compte compte = new Compte(id, numero, solde);
				return compte;
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Compte getAccount(String numero) {
		Connection con;
		String query = "SELECT * FROM compte WHERE numero=?";
		PreparedStatement preparedStatement;
		try {
			con = Database.connect();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, numero);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				double solde = rs.getDouble("solde");
				
				Compte compte = new Compte(id, numero, solde);
				return compte;
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			Database.disconnect();
			con = null;
		}
	}
	
	public void updateSolde(double solde, Compte compte) {
		Connection con;
		String query = "UPDATE `compte` SET `solde` = ? WHERE `compte`.`id` = ? ";
		PreparedStatement preparedStatement;
		try {
			con = Database.connect();
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setDouble(1, solde);
			preparedStatement.setInt(2, compte.getId());
			preparedStatement.execute();
			
		}catch(Exception e) {
			
		}finally{
			Database.disconnect();
			con=null;
		}
	}
	
	public void addSolde(double solde, Compte compte) {
		updateSolde(solde + compte.getSolde(), compte);
	}
	
	public boolean removeSolde(double solde, Compte compte) {
		if(solde >= compte.getSolde()) {
			compte.setSolde(compte.getSolde() - solde);
			updateSolde(compte.getSolde(), compte);
			return true;
		}
		return false;
	}
	
	public boolean deleteAccount(Compte compte) {
		Connection con;
		String query = "DELETE FROM compte WHERE id=?";
		PreparedStatement preparedStatement;
		
		try {
			con = Database.connect();
			preparedStatement = con.prepareStatement(query);
			
			preparedStatement.setInt(1, compte.getId());
			
			preparedStatement.execute();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
