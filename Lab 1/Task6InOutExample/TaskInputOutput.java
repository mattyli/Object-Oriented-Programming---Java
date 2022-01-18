import java.util.Scanner;
public class TaskInputOutput {
    public int num1, num2, mult, add;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        TaskInputOutput obj = new TaskInputOutput();

        System.out.println("Enter the first integer:");
        obj.num1 = Integer.valueOf(input.nextLine());

        System.out.println("Enter the second integer:");
        obj.num2 = Integer.valueOf(input.nextLine());

        System.out.println("The numbers added is " + Integer.toString(obj.num1 + obj.num2));
        System.out.println("The numbers multiploed is " + Integer.toString(obj.num1 * obj.num2));
        input.close();
    }
    
}
