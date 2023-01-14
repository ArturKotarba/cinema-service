package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Models.Movie;
public class DbAdapterMovie {
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
			String sql = "CREATE TABLE MOVIE " + "(ID INTEGER PRIMARY KEY autoincrement,"
					+ " TITLE           TEXT    NOT NULL, " + " DESCRIPTION           TEXT, "
					+ " RELEASE_DATE           TEXT    NOT NULL, " + " IS_ACTIVE           INTEGER    NOT NULL, "
					+ " DURATION_TIME          INTEGER    NOT NULL, " + " CREATION_DATE           TEXT    NOT NULL); ";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static void insertMovie(String title, String description, String releaseDate, int isActive,
			int durationTime, String creationDate) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO MOVIE (TITLE," + " DESCRIPTION," + " RELEASE_DATE," + "IS_ACTIVE,"
					+ "DURATION_TIME, " + "CREATION_DATE) " + 
					"VALUES( '" + title + "', '" + description + "', '"
					+ releaseDate + "', " + isActive + ", " + durationTime + ", '" + creationDate + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public static void updateMovie(int id, String title, String description, String releaseDate, int isActive,
			int durationTime) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "UPDATE MOVIE SET TITLE ='"  + title 
					+"', DESCRIPTION ='"+ description 

					+ "', RELEASE_DATE = '"+ releaseDate 
					
					
					+ "', IS_ACTIVE = '" + isActive 
					
					+ "', DURATION_TIME = " + durationTime +" WHERE ID = "+id+";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static Movie getMovie(int id) {
		Movie movie = null;
		Connection c = null;
		Statement stmt = null;
		String query= "SELECT * FROM MOVIE where ID ='" + id + "';"; 
	
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt
					.executeQuery(query);
			while (rs.next()) {

				String title = rs.getString("TITLE");
				String description = rs.getString("DESCRIPTION");
				String releaseDate = rs.getString("RELEASE_DATE");
				boolean isActive = rs.getBoolean("IS_ACTIVE");
				int durationTime = rs.getInt("DURATION_TIME");
				String creationDate = rs.getString("CREATION_DATE");

				 movie = new Movie(id, title, description, releaseDate, isActive, durationTime, creationDate);
			
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		
		return movie;
	}

	
	public static ArrayList<Movie> selectMovies() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM MOVIE;");
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String description = rs.getString("DESCRIPTION");
				String releaseDate = rs.getString("RELEASE_DATE");
				boolean isActive = rs.getBoolean("IS_ACTIVE");
				int durationTime = rs.getInt("DURATION_TIME");
				String creationDate = rs.getString("CREATION_DATE");

				Movie movie = new Movie(id, title, description, releaseDate, isActive, durationTime, creationDate);
				movies.add(movie);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return movies;
	}

	public static ArrayList<Movie> selectMoviesActive() {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM MOVIE WHERE IS_ACTIVE=1;");
			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String description = rs.getString("DESCRIPTION");
				String releaseDate = rs.getString("RELEASE_DATE");
				boolean isActive = rs.getBoolean("IS_ACTIVE");
				int durationTime = rs.getInt("DURATION_TIME");
				String creationDate = rs.getString("CREATION_DATE");

				Movie movie = new Movie(id, title, description, releaseDate, isActive, durationTime, creationDate);
				movies.add(movie);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return movies;
	}
	
	public static void deleteMovie(String id) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "DELETE from MOVIE where ID = " + id + ";";
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
