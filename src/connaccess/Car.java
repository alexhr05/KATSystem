package connaccess;
public class Car {
    private int id;
    private int power;
    private int volume;
    private int mark;
    private int model;
// Constructor
public Car(int id, int power, int volume, int mark,  int model) {
this.id = id;
this.power = power;
this.volume = volume;
this.mark = mark;
this.model = model;
}
// Default Constructor
public Car() {
this(0, 0, 0, 0, 0);
}
// Copy Constructor
public Car(Car car) {
this(car.id, car.power, car.volume, car.mark, car.model);
}
// Getters and Setters
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public int getPower() { return power; }
public void setPower(int power) { this.power = power; }
public int getVolume() { return volume; }
public void setVolume(int volume) { this.volume = volume; }
public int getMark() { return mark; }
public void setMark(int mark) { this.mark = mark; }
public int getModel() { return model; }
public void setModel(int model) { this.model = model; }
}