package connaccess;
public class RegisterNewCarObject {
    private int Car_Id;
    private double PriceOfRegistration;
    
// Constructor
public RegisterNewCarObject(int Car_Id, double priceOfRegistration) {
    this.Car_Id = Car_Id;
    this.PriceOfRegistration = priceOfRegistration;

}
// Default Constructor
public RegisterNewCarObject() {
    this(0, 0);
}
// Copy Constructor
public RegisterNewCarObject(RegisterNewCarObject car) {
    this(car.Car_Id, car.PriceOfRegistration);
}
// Getters and Setters
public int getCar_Id() { return Car_Id; }
public void setCar_Id(int Car_Id) { this.Car_Id = Car_Id; }
public double getPriceOfRegistration() { return PriceOfRegistration; }
public void setPriceOfRegistration(int PriceOfRegistration) { this.PriceOfRegistration = PriceOfRegistration; }

}