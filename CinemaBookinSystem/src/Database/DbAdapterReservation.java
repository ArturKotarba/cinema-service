package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Models.MovieScreening;
import Models.Reservation;
import Models.User;
import Windows.Common;
public class DbAdapterReservation {
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
			String sql = "CREATE TABLE RESERVATION " + "(ID INTEGER PRIMARY KEY autoincrement,"
					+ " MOVIE_SCREENING_ID           INTEGER    NOT NULL, " + " USER_ID           INTEGER    NOT NULL, "
					+ " IS_ACCEPTED           CHAR(1)    NOT NULL, " + " SEAT_NUMBER           INTEGER    NOT NULL, "
					+ " IS_ACTIVE           CHAR(1)    NOT NULL,"
					+ "FOREIGN KEY (MOVIE_SCREENING_ID) REFERENCES MOVIE_SCREENING (ID),"
					+ "FOREIGN KEY (USER_ID) REFERENCES USER (ID)); ";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static void checkReservationOnMovie(int movieId, int userId, String isAccepted, int seatNumber, String isActive) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO RESERVATION (MOVIE_SCREENING_ID," + " USER_ID," + "IS_ACCEPTED," + "SEAT_NUMBER,"
					+ "IS_ACTIVE) " + "VALUES( " + movieId + ", " + userId + ", '" + isAccepted + "', " + seatNumber
					+ ", '" + isActive + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	
	
	public static void insertReservation(int movieId, int userId, String isAccepted, int seatNumber, String isActive) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO RESERVATION (MOVIE_SCREENING_ID," + " USER_ID," + "IS_ACCEPTED," + "SEAT_NUMBER,"
					+ "IS_ACTIVE) " + "VALUES( " + movieId + ", " + userId + ", '" + isAccepted + "', " + seatNumber
					+ ", '" + isActive + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static void updateReservation(int id, String isAccepted, String isActive) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "";
			 if ((!isAccepted.isEmpty() && isAccepted != null) && (!isActive.isEmpty() && isActive != null) )
				sql = "UPDATE RESERVATION SET IS_ACTIVE ='" + isActive + "', IS_ACTIVE =" + isActive + "' WHERE ID = " + id + ";";
			 else if (!isAccepted.isEmpty() && isAccepted != null)
				sql = "UPDATE RESERVATION SET IS_ACCEPTED ='" + isAccepted + "' WHERE ID = " + id + ";";
			else if (!isActive.isEmpty() && isActive != null)
				sql = "UPDATE RESERVATION SET IS_ACTIVE ='" + isActive + "' WHERE ID = " + id + ";";
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static Reservation getReservation(int id) {
		Reservation reservation = null;
		Connection c = null;
		Statement stmt = null;
		String query = "SELECT * FROM RESERVATION where ID =" + id + ";";

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				int movieScreeningId = rs.getInt("MOVIE_SCREENING_ID");
				MovieScreening movieScreening = DbAdapterMovieScreening.selectMovieScreening(movieScreeningId);
				int userId = rs.getInt("USER_ID");
				User user = DbAdapterUser.getUser(userId);
				String isAccepted = rs.getString("IS_ACCEPTED");
				String isActive = rs.getString("IS_ACTIVE");
				int seatNumber = rs.getInt("SEAT_NUMBER");
				reservation = new Reservation(id, movieScreening, user, Common.getStatus(isAccepted), seatNumber,
						Common.getStatus(isActive));

			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return reservation;
	}

	public static ArrayList<Reservation> selectReservations() {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RESERVATION;");
			while (rs.next()) {
				int id = rs.getInt("ID");
				int movieScreeningId = rs.getInt("MOVIE_SCREENING_ID");
				MovieScreening movieScreening = DbAdapterMovieScreening.selectMovieScreening(movieScreeningId);
				int userId = rs.getInt("USER_ID");
				User user = DbAdapterUser.getUser(userId);
				String isAccepted = rs.getString("IS_ACCEPTED");
				String isActive = rs.getString("IS_ACTIVE");
				int seatNumber = rs.getInt("SEAT_NUMBER");

				Reservation key = new Reservation(id, movieScreening, user, Common.getStatus(isAccepted), seatNumber,
						Common.getStatus(isActive));
				reservations.add(key);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return reservations;
	}
	
	public static ArrayList<Reservation> selectMyReservations(int idUser) {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RESERVATION where USER_ID ="+idUser+";");
			while (rs.next()) {
				int id = rs.getInt("ID");
				int movieScreeningId = rs.getInt("MOVIE_SCREENING_ID");
				MovieScreening movieScreening = DbAdapterMovieScreening.selectMovieScreening(movieScreeningId);
				int userId = rs.getInt("USER_ID");
				User user = DbAdapterUser.getUser(userId);
				String isAccepted = rs.getString("IS_ACCEPTED");
				String isActive = rs.getString("IS_ACTIVE");
				int seatNumber = rs.getInt("SEAT_NUMBER");

				Reservation key = new Reservation(id, movieScreening, user, Common.getStatus(isAccepted), seatNumber,
						Common.getStatus(isActive));
				reservations.add(key);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return reservations;
	}
	
	public static int  getNumberFreeSeats( int movieScreeningId) {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		Connection c = null;
		Statement stmt = null;
		MovieScreening movieScreening =null;
		
		movieScreening = DbAdapterMovieScreening.selectMovieScreening(movieScreeningId);
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RESERVATION where MOVIE_SCREENING_ID="+movieScreeningId+";");
		
			while (rs.next()) {
				int id = rs.getInt("ID");
	
			
				int userId = rs.getInt("USER_ID");
				User user = DbAdapterUser.getUser(userId);
				String isAccepted = rs.getString("IS_ACCEPTED");
				String isActive = rs.getString("IS_ACTIVE");
				int seatNumber = rs.getInt("SEAT_NUMBER");

				Reservation key = new Reservation(id, movieScreening, user, Common.getStatus(isAccepted), seatNumber,
						Common.getStatus(isActive));
				reservations.add(key);
		
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
					int total = 0;
					for(Reservation r : reservations)
					    total += r.getSeatNumber();	
					
					
					if(reservations.size() ==0)return  movieScreening.getHall().getMaxCapacity();
					
		return movieScreening.getHall().getMaxCapacity() - total;
	}

	public static void deleteReservation(String id) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:CinemaBookingSystem.sqlite");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "DELETE from RESERVATION where ID = " + id + ";";
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
