package Models;

public class Reservation {
private int id;
private MovieScreening movieScreening;
private User user;
private boolean isAccepted;
private int seatNumber;
private boolean isActive;
private String seats;

public Reservation(int id, MovieScreening movieScreening, User user, boolean isAccepted, int seatNumber,
		boolean isActive, String seats) {
	super();
	this.id = id;
	this.movieScreening = movieScreening;
	this.user = user;
	this.isAccepted = isAccepted;
	this.seatNumber = seatNumber;
	this.isActive = isActive;
	this.seats = seats;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public MovieScreening getMovieScreening() {
	return movieScreening;
}
public void setMovieScreening(MovieScreening movieScreening) {
	this.movieScreening = movieScreening;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public boolean isAccepted() {
	return isAccepted;
}
public void setAccepted(boolean isAccepted) {
	this.isAccepted = isAccepted;
}
public int getSeatNumber() {
	return seatNumber;
}
public void setSeatNumber(int seatNumber) {
	this.seatNumber = seatNumber;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
public String getSeats() {
	return seats;
}
public void setSeats(String seats) {
	this.seats = seats;
}
}