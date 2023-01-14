package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Models.Hall;
import Models.Movie;
import Models.MovieScreening;
public class DbAdapterMovieScreening {
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
			String sql = "CREATE TABLE MOVIE_SCREENING " + "(ID INTEGER PRIMARY KEY autoincrement,"
					+ " MOVIE_ID           INTEGER    NOT NULL, " + " HALL_ID           INTEGER    NOT NULL, "
					+ " START_DATE           TEXT    NOT NULL, " + " PRICE           NUMERIC    NOT NULL, IS_ACTIVE           NUMERIC    NOT NULL,"
					+ "    FOREIGN KEY (MOVIE_ID) REFERENCES MOVIE (ID),"
					+ " FOREIGN KEY (HALL_ID) REFERENCES HALL (ID) ); ";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static void insertMovieScreening(int movieId, int hallId, String startDate, double price) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO MOVIE_SCREENING (MOVIE_ID," + " HALL_ID," + "START_DATE," + "PRICE,IS_ACTIVE) "
					+ "VALUES( " + movieId + ", " + hallId + ", '" + startDate + "', " + price + ", 1);";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}	
	public static ArrayList<MovieScreening> selectMovieScreenings2() {
		ArrayList<MovieScreening> movieScreenings = new ArrayList<MovieScreening>();
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM MOVIE_SCREENING;");
			while (rs.next()) {
				int id = rs.getInt("ID");
				
				String movieId = rs.getString("MOVIE_ID");
				Movie movie = DbAdapterMovie.getMovie(Integer.parseInt(movieId));
				String hallId = rs.getString("HALL_ID");
				Hall hall = DbAdapterHall.getHall(Integer.parseInt(hallId));
				String startDate = rs.getString("START_DATE");
				
				double price = rs.getDouble("PRICE");
				boolean isActive = rs.getBoolean("IS_ACTIVE");
				MovieScreening key = new MovieScreening(id,movie,hall,startDate, price, isActive);
				movieScreenings.add(key);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return movieScreenings;
	}
	
	public static ArrayList<MovieScreening> selectMovieScreenings2(int state) {
		ArrayList<MovieScreening> movieScreenings = new ArrayList<MovieScreening>();
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM MOVIE_SCREENING where IS_ACTIVE ="+state+";");
			while (rs.next()) {
				int id = rs.getInt("ID");
				
				String movieId = rs.getString("MOVIE_ID");
				Movie movie = DbAdapterMovie.getMovie(Integer.parseInt(movieId));
				String hallId = rs.getString("HALL_ID");
				Hall hall = DbAdapterHall.getHall(Integer.parseInt(hallId));
				String startDate = rs.getString("START_DATE");
				boolean isActive = rs.getBoolean("IS_ACTIVE");
				double price = rs.getDouble("PRICE");
				MovieScreening key = new MovieScreening(id,movie,hall,startDate, price, isActive);
				movieScreenings.add(key);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return movieScreenings;
	}
	
	

	
	
	public static MovieScreening selectMovieScreening(int id) {
		MovieScreening movieScreenings=null;
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM MOVIE_SCREENING where ID ="+id+";");
			while (rs.next()) {
			
				String movieId = rs.getString("MOVIE_ID");
				Movie movie = DbAdapterMovie.getMovie(Integer.parseInt(movieId));
				String hallId = rs.getString("HALL_ID");
				Hall hall = DbAdapterHall.getHall(Integer.parseInt(hallId));
				String startDate = rs.getString("START_DATE");
				
				double price = rs.getDouble("PRICE");
				movieScreenings= new MovieScreening(id,movie,hall,startDate, price, true);
				
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return movieScreenings;
	}

	public static void updateMovieScreening(String id) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "UPDATE MOVIE_SCREENING  SET IS_ACTIVE = 0 where ID = " + id + " ;";
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
