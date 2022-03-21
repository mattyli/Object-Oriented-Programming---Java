public class Person {
    //  Instance variables
    private String name, address;
    private int ID;
   
    // Constructor
    public Person(String name, String address, int idNum) {
        this.name = name;
        this.address = address;
        this.ID = idNum;
    }
   
    // Mutators and accessors
    public String getName() {
        return name;
    }
    public int getID() {
        return ID;
        
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
   
    // Describle itself
    public String toString() {
        return name +": "+ ID + "(" + address + ")";
    }
}