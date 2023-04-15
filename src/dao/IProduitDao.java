package dao;

import java.util.List;

import dao.entities.Produit;

public interface IProduitDao {
	Produit save(Produit p);
	List<Produit> rechercherParMotCle(String motCle);
	void supprimer(int id);
	Produit getProduit(int id);
	void editer(Produit p);
}
