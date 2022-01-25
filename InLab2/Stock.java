import java.util.Arrays;
import java.util.stream.IntStream;

public class Stock {
    // private instance variables
    private int day, month, year;
    private String name;
    private int[] values = new int[7];

    // available only within the class, available to all instances
    private static int[] mon31 = {1,3,5,7,8,10,12}; // months that have 31 days
    private static int[] mon30 = {4,6,9,11};        // months that have 30 days

    // helper method for the checking whether a date is valid
    private static boolean dayIsValid(int dayIn, int monthIn, int yearIn){
        if (dayIn > 31 || dayIn <= 0){
            return false;
        }
        else{
            // months with 31 days 
            if (IntStream.of(mon31).anyMatch(mon -> mon==monthIn)){
                return true;
            }
            // months with 30 days
            else if (IntStream.of(mon30).anyMatch(mon -> mon==monthIn)){
                if (dayIn > 30){
                    return false;
                }
                else{
                    return true;
                }
            }
            // february case
            else{
                // leap year case
                if (yearIn % 4 == 0){
                    if (dayIn > 29){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
                // regular years
                else{
                    if (dayIn > 28){
                        return false;
                    }
                    else{
                        return true;
                    }
                }
            }
        }
    }

    private static boolean yearIsValid(int yearIn){
        if (yearIn <= 0){
            return false;
        }
        else {
            return true;
        }
    }

    private static boolean monthIsValid(int monthIn){
        if (monthIn > 12 || monthIn <= 0){
            return false;
        }
        else{
            return true;
        }
    }
    // accessible only within the class, and available to all instances
    private static boolean validate(int dayIn, int monthIn, int yearIn){
        if (yearIsValid(yearIn) && dayIsValid(dayIn, monthIn, yearIn) && monthIsValid(monthIn)) {
            // at this point, all years, days, and months are valid
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean validateStock(int[] valIn){
        if (valIn.length != 7){
            return false;
        }
        // checking if the individual values themselves are valid (>= 0)
        else{
            for(int idx = 0; idx < 7; idx++){
                if(Integer.signum(valIn[idx]) < 0){     // the value is negative
                    return false;
                }
                else{
                    continue;
                }
            }
            return true;

        }
    }

    private void modStockIfInvalid(int[] valIn){
        if (validateStock(valIn)){
            this.values = valIn;
        }
        else{}
    }

    private void modDateIfInvalid(int dayIn, int monthIn, int yearIn){
        if(dayIsValid(dayIn, monthIn, yearIn)){
            this.day = dayIn;
        }
        else{}

        if (monthIsValid(monthIn)){
            this.month = monthIn;
        }
        else{}

        if (yearIsValid(yearIn)){
            this.year = yearIn;
        }
        else{}
    }
    // default constructor (no input)
    public Stock(){
        day = 1;
        month = 1;
        year = 1;
        name = "";
        values = new int[]{0,0,0,0,0,0,0};
    }
    
    // constructor with input
    public Stock(int dayIn, int monthIn, int yearIn, String nameIn, int[] valIn){
        this(); // call default constructor
                // initially set to default values, then check if they
                // are valid or not, if they are, update, if not keep them
        name = nameIn;
        if(validate(dayIn, monthIn, yearIn) && validateStock(valIn)){
            day = dayIn;
            month = monthIn;
            year = yearIn;
            
            values = java.util.Arrays.copyOf(valIn, 7);
        }
        else{
            System.out.println("ERROR: something is invalid\n");
            modDateIfInvalid(dayIn, monthIn, yearIn);
            modStockIfInvalid(valIn);
            // can I access the stock default constructor?
        }
    }

    // ACCESSOR METHODS
    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){ 
        return year;
    }    

    public String getName(){
        return name;
    }

    public int getValue(int ind){
        if (ind >= 7){
            System.out.println("Invalid index, out of bounds");
            return -1;
        }
        else{
            return this.values[ind];
        }
    }

    // MUTATOR METHOD(s)
    // don't need to use this notation as parameters are different from 
    // class attributes
    public void setDate(int dayIn, int monthIn, int yearIn){
        if (validate(dayIn, monthIn, yearIn)){
            day = dayIn;
            month = monthIn;
            year = yearIn;
        }
        else{
            System.out.println("ERROR: Date is invalid, try again\n");
            modDateIfInvalid(dayIn, monthIn, yearIn);
        }
    }

    public void setName(String nameIn){
        name = nameIn;
    }

    public void setValue(int val, int ind){
        // checking whether the value is negative or the index
        // is out of bounds
        if (Integer.signum(val) < 0 || ind >= 7){
            System.out.println("ERROR: invalid value or index\n");
        }
        else{
            values[ind] = val;
        }
    }

    public void printStock(){
        System.out.println(name +": " + String.valueOf(getDay())+'.'+String.valueOf(getMonth())+'.'+String.valueOf(getYear()) + " values:");
        System.out.println(Arrays.toString(values).replace("[","").replace("]", ""));
    }

    public int getMeanValue(){
        int sum = 0;
        for(int i=0; i < 7; i++)
        {
            sum += values[i];
        }
        return (sum/7);
    }
    
    // main for testing purposes
    // public static void main(String[] args){
    //     Activity act = new Activity(5, 3, 2011);
    //     System.out.println();
    //     act.printDate();
    // }
};