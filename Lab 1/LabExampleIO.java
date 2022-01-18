
//Similar to importing Date Class in the 
//Previous DateApp exercise, lets import

//Import System class for input output
import java.util.Scanner;

public class LabExampleIO {
	//Declare variable
	public String name;
	public int age;
	public String currentRole;
	
	public static void main(String args[]) {
		//Create an object of the Scanner class
		Scanner input = new Scanner(System.in);
		LabExampleIO obj = new LabExampleIO();
		//Ask user for input name
		System.out.println("Enter your name:");
		//Read input from user
		obj.name = input.nextLine();
		
		//Ask user for current role in the Lab
		//Enter navigator or driver
		System.out.println("What is your role in this lab? Nav. or Driver?:");
		obj.currentRole = input.nextLine();
		
		//Ask user for input age
		System.out.println("Your age please:");
		//Read user input
		obj.age = input.nextInt();
		
		//Close the input stream
		input.close();
		
		//Output to user
		System.out.println("Name:" +obj.name);
		System.out.println("Age:" +obj.age);
		System.out.println("Lab Role:" +obj.currentRole);
		//System.out.println ("/* I love */ Java!");
		
		
	}
}
