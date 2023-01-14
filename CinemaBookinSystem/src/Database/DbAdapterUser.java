package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Models.User;

public class DbAdapterUser {
	public static void connectToDatabase() {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static void createTable() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			stmt = c.createStatement();
			String sql = "CREATE TABLE USER " + "(ID INTEGER PRIMARY KEY autoincrement,"
					+ " EMAIL           TEXT    NOT NULL, " + " PHONE_NUMBER           CHAR(16)    NOT NULL, "
					+ " PASSWORD           TEXT    NOT NULL, " + " ROLE           TEXT    NOT NULL); ";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static void insertUser(String email, String phoneNumber, String password, String role) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO USER (EMAIL, PHONE_NUMBER, PASSWORD, ROLE) VALUES ('" + email + "', '"
					+ phoneNumber + "', '" + password + "', '" + role + "');";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static ArrayList<User> selectUsers() {
		ArrayList<User> users = new ArrayList<User>();
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER;");
			while (rs.next()) {
				int id = rs.getInt("ID");
				String email = rs.getString("EMAIL");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				String password = rs.getString("PASSWORD");
				String role = rs.getString("ROLE");

				User key = new User(id, email, phoneNumber, password, role);
				users.add(key);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return users;
	}

	public static User getUser(String email, String password) {
		User user = null;
		Connection c = null;
		Statement stmt = null;
		String query;
		if (password == null)
			query = "SELECT * FROM USER where EMAIL ='" + email + "';";
		else
			query = "SELECT * FROM USER where EMAIL ='" + email + "' AND PASSWORD = '" + password + "';";

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String e = rs.getString("EMAIL");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				String p = rs.getString("PASSWORD");
				String role = rs.getString("ROLE");
				user = new User(id, e, phoneNumber, p, role);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return user;
	}

	public static User getUser(int id) {
		User user = null;
		Connection c = null;
		Statement stmt = null;
		String query = "SELECT * FROM USER where ID=" + id + ";";

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				String e = rs.getString("EMAIL");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				String p = rs.getString("PASSWORD");
				String role = rs.getString("ROLE");
				user = new User(id, e, phoneNumber, p, role);

			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return user;
	}

	public static void deleteUser(String id) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "DELETE from USER where ID = " + id + ";";
			stmt.executeUpdate(sql);
			c.commit();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
