/*
    Lab 5 - ELEC 279
    March 24, 2022
    Matthew Li   - 20217346
    Jacob O'Neil - 20221893
*/

public class Pair<T> {
    // instance variable declaration
    private T wife;
    private T husband;

    public Pair(){
        this.wife = null;
        this.husband = null;
    }// default constructor

    public Pair(T f1, T f2){
        this.wife = f1;
        this.husband = f2;
    }// constructor
    
    public T getwife(){
        return this.wife;
    }
    public T gethusband(){
        return this.husband;
    }


    public String toString(){
        return ("Wife's name: " + wife.toString() + "; Husband's name: " + husband.toString() +"\n");     // depending on the object type, call that types toString
    }

    public boolean equals(Object otherObj){
        if (otherObj == null){
            return false;
        }
        else if (getClass() != otherObj.getClass()){
            return false;
        }
        else{
            Pair<T> otherPair = (Pair<T>)otherObj;          // downcasting
            return (wife.equals(otherPair.wife) && husband.equals(otherPair.husband));
        }
    }

}
