package Models;
public class Hall {
private int id;
private int maxCapacity;
private int hallNumber;


public Hall(int id, int maxCapacity, int hallNumber) {
	super();
	this.id = id;
	this.maxCapacity = maxCapacity;
	this.hallNumber = hallNumber;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getMaxCapacity() {
	return maxCapacity;
}
public void setMaxCapacity(int maxCapacity) {
	this.maxCapacity = maxCapacity;
}
public int getHallNumber() {
	return hallNumber;
}
public void setHallNumber(int hallNumber) {
	this.hallNumber = hallNumber;
}
public String toString() {
    return String.valueOf(this.hallNumber);
}

}
