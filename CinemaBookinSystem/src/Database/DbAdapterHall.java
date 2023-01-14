package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Models.Hall;
public class DbAdapterHall {
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
			String sql = "CREATE TABLE HALL " + "(ID INTEGER PRIMARY KEY autoincrement,"
					+ " MAX_CAPACITY           INTEGER    NOT NULL, " + " HALL_NUMBER           INTEGER    NOT NULL); ";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static void insertHall(int maxCapacity, int hallNumber) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO HALL (MAX_CAPACITY," + " HALL_NUMBER) VALUES( " + maxCapacity + ", "
					+ hallNumber + ");";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static ArrayList<Hall> selectHalls() {
		ArrayList<Hall> halls = new ArrayList<Hall>();
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM HALL;");
			while (rs.next()) {
				int id = rs.getInt("ID");
				int maxCapacity = rs.getInt("MAX_CAPACITY");
				int hallNumber = rs.getInt("HALL_NUMBER");
				Hall key = new Hall(id, maxCapacity, hallNumber);
				halls.add(key);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return halls;
	}

	public static Hall getHall(int id) {
		Hall halls = null;
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM HALL WHERE ID = "+id +";");
			while (rs.next()) {
			
				int maxCapacity = rs.getInt("MAX_CAPACITY");
				int hallNumber = rs.getInt("HALL_NUMBER");
				halls= new Hall(id, maxCapacity, hallNumber);
				
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return halls;
	}

	
	public static void deleteHall(String id) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "DELETE from HALL where ID = " + id + ";";
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