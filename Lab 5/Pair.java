/*
    ClassName<Type> --> making a generic class
    Can be any data type

*/

public class Pair<T> {
    // instance variable declaration
    private T obj1;
    private T obj2;

    public Pair(){
        this.obj1 = null;
        this.obj2 = null;
    }// default constructor

    public Pair(T f1, T f2){
        this.obj1 = f1;
        this.obj2 = f2;
    }// constructor

    // public Pair(T copied){
    //     this.obj1 = copied.obj1;
    //     this.obj2 = copied.obj2;
    // }// copy constructor

    // error in the copy constructor
    
    public T getObj1(){
        return this.obj1;
    }
    public T getObj2(){
        return this.obj2;
    }


    public String toString(){
        return ("field 1: " + obj1.toString() + " , field 2: " + obj2.toString() +"\n");     // depending on the object type, call that types toString
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
            return (obj1.equals(otherPair.obj1) && obj2.equals(otherPair.obj2));
        }
    }

}
