import java.util.Scanner;

public class WorkHourApp {
    public int hoursperday, numdays;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        WorkHourApp obj = new WorkHourApp();

        System.out.println("Enter the number of hours you worked today:");
        obj.hoursperday = Integer.valueOf(input.nextLine());

        System.out.println("Enter the number of days your worked:");
        obj.numdays = Integer.valueOf(input.nextLine());

        for (int day = 1; day <= obj.numdays; day++){
            System.out.println("Day" + Integer.toString(day) + ", Total Hours worked =" + Integer.toString(day * obj.hoursperday));

        }

        input.close();


    }
    
}
