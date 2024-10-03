package connaccess;
public class Office {
private int id;
private String name;
private int address;
// Constructor
public Office(int id, String name, int address) {
    this.id = id;
    this.name = name;
    this.address = address;
}
// Default Constructor
public Office() {
this(0, "", 0);
}
// Copy Constructor
public Office(Office office) {
this(office.id, office.name, office.address);
}
// Getters and Setters
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public String getName() { return name; }
public void setName(String name) { this.name = name; }
public int getAddress() { return address; }
public void setAddress(int address) { this.address = address; }
}