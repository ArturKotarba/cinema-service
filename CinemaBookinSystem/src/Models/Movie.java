package Models;

public class Movie {
private int id;
private String title;
private String description;
private String releaseDate;
private boolean isActive;
private int durationTime;
private String creationDate;
public Movie(int id, String title, String description, String releaseDate,
		boolean isActive, int durationTime,
		String creationDate) {
	super();
	this.id = id;
	this.title = title;
	this.description = description;
	this.releaseDate = releaseDate;
	this.isActive = isActive;
	this.durationTime = durationTime;
	this.creationDate = creationDate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getReleaseDate() {
	return releaseDate;
}
public void setReleaseDate(String releaseDate) {
	this.releaseDate = releaseDate;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
public int getDurationTime() {
	return durationTime;
}
public void setDurationTime(int durationTime) {
	this.durationTime = durationTime;
}
public String getCreationDate() {
	return creationDate;
}
public void setCreationDate(String creationDate) {
	this.creationDate = creationDate;
}
public String toString() {
    return this.title;
}

}
