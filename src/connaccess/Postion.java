package connaccess;
public class Postion {
    private int id;
    private String name;

// Constructor
public Postion(int id, String name) {
this.id = id;
this.name = name;

}
// Default Constructor
public Postion() {
this(0, "");
}
// Copy Constructor
public Postion(Postion car) {
this(car.id, car.name);
}
// Getters and Setters
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public String getName() { return name; }
public void setName(String name) { this.name = name; }
}