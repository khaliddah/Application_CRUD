package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.entities.Produit;

public class ProduitDaoImpl implements IProduitDao{

	@Override
	public Produit save(Produit p) {
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO PRODUIT(DESIGNATION,PRIX,QUANTITE) VALUES (?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			ps.close();
			PreparedStatement ps2=con.prepareStatement("SELECT MAX(ID) as MAX_ID FROM PRODUIT");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt("MAX_ID"));
			}
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<Produit> rechercherParMotCle(String motCle) {
		List<Produit> prods=new ArrayList();
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM PRODUIT WHERE DESIGNATION LIKE ?");
			ps.setString(1, motCle);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Produit p=new Produit();
				p.setId(rs.getInt(1));
				p.setDesignation(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
				prods.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public void supprimer(int id) {
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM PRODUIT WHERE ID=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produit getProduit(int id) {
		Produit p=new Produit();
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM PRODUIT WHERE ID=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt(1));
				p.setDesignation(rs.getString(2));
				p.setPrix(rs.getDouble(3));
				p.setQuantite(rs.getInt(4));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void editer(Produit p) {
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE PRODUIT SET DESIGNATION=?,PRIX=?,QUANTITE=? WHERE ID=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
