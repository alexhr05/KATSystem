package connaccess;
public class BrandCar {
    private int id;
    private String name;

// Constructor
public BrandCar(int id, String name) {
this.id = id;
this.name = name;

}
// Default Constructor
public BrandCar() {
this(0, "");
}
// Copy Constructor
public BrandCar(BrandCar car) {
this(car.id, car.name);
}
// Getters and Setters
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public String getName() { return name; }
public void setName(String name) { this.name = name; }
}