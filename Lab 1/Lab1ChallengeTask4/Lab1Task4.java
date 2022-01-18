import java.util.Scanner;

public class Lab1Task4 {
    public int multiplier; // declaring an integer variable

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Lab1Task4 obj = new Lab1Task4(); // creating an instance of Lab1Task4

        System.out.println("Enter an integer value:");
        obj.multiplier = Integer.valueOf(input.nextLine());

        for (int idx = 1; idx <= 20; idx++){
            System.out.println(Integer.toString(idx*obj.multiplier));
        }

        input.close(); // need to close the input
    }
    
}
