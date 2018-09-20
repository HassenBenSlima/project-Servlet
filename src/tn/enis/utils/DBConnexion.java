package tn.enis.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnexion {

	Connection connexion = null;
	Statement statement = null;

	public DBConnexion() {
	}

	public void connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/comptes", "root", "root");

			statement = connexion.createStatement();

		} catch (ClassNotFoundException e) {
			System.out.println("00000001");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("00000002");
			e.printStackTrace();
		}

	}

	public ResultSet selectQuery(String request) {

		ResultSet result = null;

		try {
			result = statement.executeQuery(request);
		} catch (SQLException e) {
			System.out.println("00000004");
			e.printStackTrace();
		}
		return result;
	}

	public void updateQuery(String request) {

		try {
			statement.executeUpdate(request);
		} catch (SQLException e) {
			System.out.println("00000005");
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			statement.close();
			connexion.close();
		} catch (SQLException e) {
			System.out.println("00000003");
			e.printStackTrace();
		}
	}
}
