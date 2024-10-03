package connaccess;
public class Owner {
private int id;
private String name;
private String familiq;
private String EGN;
private String tel;
private int address;
// Constructor
public Owner(int id, String name, String familiq, String EGN, String tel, int address) {
this.id = id;
this.name = name;
this.familiq = familiq;
this.EGN = EGN;
this.tel = tel;
this.address = address;
}
// Default Constructor
public Owner() {
this(0, "", "", "", "", 0);
}
// Copy Constructor
public Owner(Owner owner) {
this(owner.id, owner.name, owner.familiq, owner.EGN, owner.tel, owner.address);
}
// Getters and Setters
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public String getName() { return name; }
public void setName(String name) { this.name = name; }
public String getFamiliq() { return familiq; }
public void setFamiliq(String familiq) { this.familiq = familiq; }
public String getEGN() { return EGN; }
public void setEGN(String EGN) { this.EGN = EGN; }
public String getTel() { return tel; }
public void setTel(String tel) { this.tel = tel; }
public int getAddress() { return address; }
public void setAddress(int address) { this.address = address; }
}