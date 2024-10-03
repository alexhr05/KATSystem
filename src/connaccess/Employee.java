package connaccess;
public class Employee {
private int id;
private String name;
private String family;
private int position;
// Constructor
public Employee(int id, String name, String family, int position) {
this.id = id;
this.name = name;
this.family = family;
this.position = position;
}
// Default Constructor
public Employee() {
this(0, "", "", 0);
}
// Copy Constructor
public Employee(Employee employee) {
this(employee.id, employee.name, employee.family, employee.position);
}
// Getters and Setters
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public String getName() { return name; }
public void setName(String name) { this.name = name; }
public String getFamily() { return family; }
public void setFamily(String family) { this.family = family; }
public int getPosition() { return position; }
public void setPosition(int position) { this.position = position; }
}