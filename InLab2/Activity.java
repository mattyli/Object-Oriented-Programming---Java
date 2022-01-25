import java.util.stream.IntStream;

public class Activity {
    // private instance variables
    private int day, month, year;

    // available only within the class, available to all instances
    private static int[] mon31 = {1,3,5,7,8,10,12}; // months that have 31 days
    private static int[] mon30 = {4,6,9,11};        // months that have 30 days

    // helper functions to validate individual parameters (day, month, year)
    // this method will handle the extremes

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

    
    // END OF IsValid helper functions

    // helper method for the checking whether a date is valid
    // accessible only within the class, and available to all instances
    private static boolean validate(int dayIn, int monthIn, int yearIn){
        if (monthIsValid(monthIn) && yearIsValid(yearIn) && dayIsValid(dayIn, monthIn, yearIn)) {
            // at this point, all years, days, and months are valid
            return true;
        }
        else{
            return false;
        }
    }
    
    // called when validate is false
    private void modIfInvalid(int dayIn, int monthIn, int yearIn){
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
    public Activity(){
        day = 1;
        month = 1;
        year = 1;
    }
    
    // constructor with inoput
    public Activity(int dayIn, int monthIn, int yearIn){
        this(); // automatically set the default values 
        if(validate(dayIn, monthIn, yearIn)){
            day = dayIn;
            month = monthIn;
            year = yearIn;
        }
        else{
            System.out.println("ERROR: Date is invalid\n");
            modIfInvalid(dayIn, monthIn, yearIn);
        }
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){ 
        return year;
    }    

    // mutator method
    // don't need to use this notation as parameters are different from 
    // class attributes
    public void setDate(int dayIn, int monthIn, int yearIn){
        if (validate(dayIn, monthIn, yearIn)){
            this.day = dayIn;
            this.month = monthIn;
            this.year = yearIn;
        }
        else{
            System.out.println("ERROR: Date is invalid, try again\n");
            modIfInvalid(dayIn, monthIn, yearIn);
        }
    }

    public void printDate(){
        System.out.println(String.valueOf(getDay())+'.'+String.valueOf(getMonth())+'.'+String.valueOf(getYear()));
    }
};
