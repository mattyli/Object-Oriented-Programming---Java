/** FILE CREATED BY ELEC 279 AUTHORS
 * I DO NOT TAKE CREDIT FOR THIS FILE
 */


import java.util.Scanner;

public class Date
{
    private String month;
    private int day;
    private int year; //a four digit number.

    // -------- CONSTRUCTORS -----------
    public Date()
    {
        month = "January";
        day = 1;
        year = 1000;
    }

    public Date(int monthInt, int day, int year)
    {
        setDate(monthInt, day, year);
    }

    public Date(String monthString, int day, int year)
    {
        setDate(monthString, day, year);
    }

    public Date(int year)
    {
        setDate(1, 1, year);
    }

    public Date(Date aDate)
    {
        if (aDate == null)//Not a real date.
        {
             System.out.println("Fatal Error.");
             System.exit(0);
        }

        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }

    /** Added by Matthew Li
     *  Format needs to be MM/DD/YYYY
     *  Call the private dateOK() method to verify
     */

    public Date(String strDate){
        Integer[] arr = new Integer[3];
        arr = splitStr(strDate);

        if (dateOK(arr[0], arr[1], arr[2])){
            setDate(arr[0], arr[1], arr[2]);
        }
        else{
            System.out.println("Fatal Error, date is invalid");
            System.exit(0);
        }

    }

    // -------- END OF CONSTRUCTORS -----------

    public void setDate(int monthInt, int day, int year)
    {
        if (dateOK(monthInt, day, year))
        {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public void setDate(int year)
    {
        setDate(1, 1, year);
    }

    public void setYear(int year)
    {
        if ( (year < 1000) || (year > 9999) )
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.year = year;
    }
    public void setMonth(int monthNumber)
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

    public void setDay(int day)
    {
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.day = day;
    }

    public int getMonth()
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }

    public int getDay()
    {
        return day;
    }

    public int getYear()
    {
        return year;
    }

    public String toString( )
    {
        return (month + " " + day + ", " + year);
    }

    public boolean equals(Date otherDate)
	{
	    if (otherDate == null)
	        return false;
	    else
	        return ((month.equals(otherDate.month)) &&
	            (day == otherDate.day) && (year == otherDate.year) );
    }

    public boolean precedes(Date otherDate)
    {
        return ((year < otherDate.year) ||
           (year == otherDate.year && getMonth() < otherDate.getMonth()) ||
           (year == otherDate.year && month.equals(otherDate.month) && day < otherDate.day));
    }

    // modified by Matthew Li
    public void readInput()
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year in MM/DD/YYYY format");
            String dateinput = keyboard.next();
            if (dateinput.toUpperCase().equals("QUIT")){
                System.out.println("You have quit");
                System.exit(0);
            }
            else{
                if (dateOK(dateinput)){
                    Integer[] arr = new Integer[3];
                    arr = splitStr(dateinput);

                    setDate(arr[0], arr[1], arr[2]);
                    tryAgain = false;
                    break;
                }
                else
                    System.out.println("Illegal date. Reenter input.");
            }  
         }
    }

    // prototype splitting helper function
    // will split the date into the appropriate values (input format is assumed to be correct)
    private Integer[] splitStr(String strDate){
        Integer[] arr = new Integer[3];
        String[] arrOfDates = strDate.split("/",-2);
        
        for (int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(arrOfDates[i]);
        }
        return arr;
    }
    // Returns true/false
    // Added by Matthew Li
    private Boolean dateOK(String strDate){
        Integer[] arr = new Integer[3];
        arr = splitStr(strDate);
        return (dateOK(arr[0], arr[1], arr[2]));
    }
    
    private boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        return ( monthOK(monthString) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    private String monthString(int monthNumber)
    {
        switch (monthNumber)
        {
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default:
            System.out.println("Fatal Error");
            System.exit(0);
            return "Error"; //to keep the compiler happy
        }
    }

    // Main function for debugging and testing
    // DELETE/ COMMENT OUT AFTER
    // public static void main(String[] args){
    //     Date date = new Date();
    //     String teststr = "12/07/1867";
    //     Integer[] testArr = new Integer[3];
    //     testArr = date.splitStr(teststr);
    //     System.out.println(Arrays.toString(testArr));
        
    // }
}
