/*
    Lab 5 - ELEC 279
    March 24, 2022
    Matthew Li   - 20217346
    Jacob O'Neil - 20221893
*/
public class Triple<T1, T2> {
    private T1 origin;
    private T2 distance;
    private T1 destination;


    public Triple(){
        this.origin = null;
        this.distance = null;
        this.destination = null;
    }// default constructor

    public Triple(T1 f1, T2 f2, T1 f3){
        this.origin = f1;
        this.distance = f2;
        this.destination = f3;
    }// arguement constructor

    public String toString(){
        return ("Departure city: " + origin.toString() + "; Distance: " + distance.toString() + "; Arrival city: " + destination.toString() + "\n");
    }// calling each fields respective toString() method

    public boolean equals(Object otherObj){
        if (otherObj == null){
            return false;
        }
        else if (getClass() != otherObj.getClass()){
            return false;
        }
        else{
            Triple<T1, T2> otherTrip = (Triple<T1, T2>)otherObj;          // downcasting
            return (origin.equals(otherTrip.origin) && distance.equals(otherTrip.distance) && destination.equals(otherTrip.destination));
        }
    }
    
}
