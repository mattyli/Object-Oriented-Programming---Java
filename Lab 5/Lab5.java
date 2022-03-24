import java.util.ArrayList;
import java.util.Random;


public class Lab5 {
    public static void main(String[] args){
        int listSize = 5;
        ArrayList<Integer> intArray = new ArrayList<Integer>(listSize);         // declaring a new ArrayList of type Integer, with size 5

        Random rand = new Random();                                             // make instance of the Random class
        intArray.ensureCapacity(10);                                            // ensuring that there is enough space to store the next 10 ints

        // for loop to generate 10 random numbers
        for (int i = 0; i<10; i++){
            int randInt = rand.nextInt(100);                                    // make random integer
            intArray.add(randInt);
        }

        // System.out.println(intArray.toString());                                // Printing to check

        // For loop to reverse the generated intArray
        ArrayList<Integer> revIntArray = new ArrayList<Integer>(10);
        revIntArray.ensureCapacity(10);                                         // ensuring enough room

        // use indexOf?
        // arrayList does not support negative indexing
        intArray.forEach((num) -> {
            revIntArray.add(0, num);
        });

        System.out.println(revIntArray.toString());                              // Printing to check

        ArrayList<HourlyEmployee> listOfHourlyEmployees = new ArrayList<HourlyEmployee>(100);       // list of hourly employees
        // Add the four elements

        HourlyEmployee H1 = new HourlyEmployee();
        HourlyEmployee H2 = new HourlyEmployee();
        HourlyEmployee H3 = new HourlyEmployee();
        HourlyEmployee H4 = new HourlyEmployee();

        H2.setRate(3.0);
        H3.setRate(20.00);
        H4.setRate(35.00);

        listOfHourlyEmployees.add(H1);
        listOfHourlyEmployees.add(H2);
        listOfHourlyEmployees.add(H3);
        listOfHourlyEmployees.add(H4);

        System.out.println(listOfHourlyEmployees.toString());

        HourlyEmployee H5 = new HourlyEmployee();
        H5.setRate(260.00);
        listOfHourlyEmployees.add(0, H5);
        System.out.println(listOfHourlyEmployees.toString());

        System.out.println(listOfHourlyEmployees.size());                       // the .size() returns an int
        /*
            Size = number of objects in the array list
            Capacity = number of objects that can be in the array list
        */
        listOfHourlyEmployees.remove(2);                                        // removing the third element
        //System.out.println(listOfHourlyEmployees.toString());                   // H2 should be removed --> 3.0

        listOfHourlyEmployees.trimToSize();                                     // making capacity = size

        /*
            Testing the custom generic classes
        */

        
        Pair<String> couple1 = new Pair<String>("Janice", "Rob");
        Pair<String> couple2 = new Pair<String>("Janice", "Rob");
        Pair<String> couple3 = new Pair<String>("Karen", "Rob");
    
        System.out.println(Boolean.toString(couple1.equals(couple3)));
        System.out.println(couple3.toString());

        Triple<String, Double> trip1 = new Triple<>("Toronto", 547.0, "Montreal");
        Triple<String, Double> trip2 = new Triple<>("Toronto", 547.0, "Montreal");
        Triple<String, Double> trip3 = new Triple<>("Yukon", 23447.0, "Montreal");

        System.out.println(trip1.toString());
        System.out.println(Boolean.toString(trip1.equals(trip3)));


    }
}
