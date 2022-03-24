// 2 type class

public class Triple<T1, T2> {
    private T1 field1;
    private T2 field2;
    private T1 field3;


    public Triple(){
        this.field1 = null;
        this.field2 = null;
        this.field3 = null;
    }// default constructor

    public Triple(T1 f1, T2 f2, T1 f3){
        this.field1 = f1;
        this.field2 = f2;
        this.field3 = f3;
    }// arguement constructor

    public String toString(){
        return ("field 1: " + field1.toString() + ", field 2: " + field2.toString() + ", field 3: " + field3.toString() + "\n");
    }

    public boolean equals(Object otherObj){
        if (otherObj == null){
            return false;
        }
        else if (getClass() != otherObj.getClass()){
            return false;
        }
        else{
            Triple<T1, T2> otherTrip = (Triple<T1, T2>)otherObj;          // downcasting
            return (field1.equals(otherTrip.field1) && field2.equals(otherTrip.field2) && field3.equals(otherTrip.field3));
        }
    }
    
}
