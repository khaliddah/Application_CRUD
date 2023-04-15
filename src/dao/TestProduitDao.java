package dao;

import java.util.List;

import dao.entities.Produit;

public class TestProduitDao {
	public static void main(String[] args) {
		ProduitDaoImpl p=new ProduitDaoImpl();
		List<Produit> liste=p.rechercherParMotCle("%HP%");
		System.out.println("hh");
		for(Produit po:liste) {
			System.out.println(po.getId());
		}
	}
}
