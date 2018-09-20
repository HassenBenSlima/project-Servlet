package tn.enis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.enis.model.CompteBancaire;
import tn.enis.utils.DBConnexion;

public class CompteBancaireDao {
	DBConnexion dbConnexion = new DBConnexion();

	public CompteBancaireDao() {
		dbConnexion.connect();
	}

	public void save(CompteBancaire compte) {

		String request = "INSERT INTO compte(client, solde) VALUES ('" + compte.getClient() + "','" + compte.getSolde()
				+ "')";

		dbConnexion.updateQuery(request);
	}

	public List<CompteBancaire> getAll() {
		// liste à retourner
		List<CompteBancaire> comptes = new ArrayList<>();

		// requete sql
		ResultSet result = dbConnexion.selectQuery("Select * from compte");

		try {
			while (result.next()) {

				// récuperation des données
				long rib = result.getLong("rib");
				String client = result.getString("client");
				float solde = result.getFloat("solde");
				// création de compte bancaire
				CompteBancaire cb = new CompteBancaire(client, solde);
				cb.setRib(rib);
				// ajout à la liste
				comptes.add(cb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comptes;
	}

	public void delete(long rib) {

		String request = "Delete from compte where rib ='" + rib + "' ";

		dbConnexion.updateQuery(request);
	}

	public CompteBancaire getById(long rib) {

		// requete sql
		ResultSet result = dbConnexion.selectQuery("Select * from compte where rib ='" + rib + "' ");

		CompteBancaire cb = null;
		try {
			if (result.next()) {

				// récuperation des données
				String client = result.getString("client");
				float solde = result.getFloat("solde");
				// création de compte bancaire
				cb = new CompteBancaire(client, solde);
				cb.setRib(rib);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cb;
	}

	public void update(CompteBancaire compte) {

		String request = "UPDATE compte SET solde = '" + compte.getSolde() + "' , client = '" + compte.getClient()
				+ "'  WHERE compte.rib ='" + compte.getRib() + "' ";

		dbConnexion.updateQuery(request);
	}
}
