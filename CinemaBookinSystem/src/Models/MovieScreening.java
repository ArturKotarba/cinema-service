package Models;

import java.util.ArrayList;
import java.util.Date;

public class MovieScreening {
private int id;
private Movie movie;
private Hall hall;
private String startDate;
private double price;
private boolean isActive;




public MovieScreening(int id, Movie movie, Hall hall, String startDate, double price, boolean isActive) {
	super();
	this.id = id;
	this.movie = movie;
	this.hall = hall;
	this.startDate = startDate;
	this.price = price;
	this.isActive = isActive;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Movie getMovie() {
	return movie;
}
public void setMovie(Movie movie) {
	this.movie = movie;
}
public Hall getHall() {
	return hall;
}
public void setHall(Hall hall) {
	this.hall = hall;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}

public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}



public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
@Override
public String toString() {
	return "Tytuł filmu: " + movie.toString() + ", \nNumer sali: " + hall.toString() + ", \nData i godzina rozpoczęcia: " + startDate + ", \nCena za jeden bilet: " + price + " zł.";
}





}
