public class InLab2 {
    // Main method
	public static void testActivity(){
		// Test default constructor
		System.out.println("Testing default constructor Activity()");
		Activity act1 = new Activity();
		System.out.println("Should say: 1.1.1");
		act1.printDate();
		
		// Test filled constructor
		// Test good input
		System.out.println("Testing setDate");
		System.out.println("Try 8, 8, 1304:");
		Activity act2 = new Activity(8,8,1304);
		System.out.println("Should say: 8.8.1304");
		act2.printDate();
		
		// Test bad day
		System.out.println("Testing setDate");
		System.out.println("Try 40, 8, 1304:");
		System.out.println("Should print error:");
		Activity act3 = new Activity(40,8,1304);
		System.out.println("Should say: 1.8.1304");
		act3.printDate();
		
		// Test bad month
		System.out.println("Testing setDate");
		System.out.println("Try 8, 0, 1304:");
		System.out.println("Should print error:");
		Activity act4 = new Activity(8,0,1304); // ERROR HERE

		System.out.println("Should say: 8.1.1304");
		act4.printDate();
		
		// Test bad year
		System.out.println("Testing setDate");
		System.out.println("Try 8, 8, -1304:");
		System.out.println("Should print error:");
		Activity act5 = new Activity(8,8,-1304);
		System.out.println("Should say: 8.8.1");
		act5.printDate();
		
		
		// Test date setting
		System.out.println("Testing setDate");
		System.out.println("Try 12, 2, 2017:");
		act1.setDate(12, 2, 2017);
		System.out.println("Should say: 12.2.2017");
		act1.printDate();
		
		System.out.println("Try 30, 2, 2017:");
		System.out.println("Should print error:");
		act1.setDate(30, 2, 2017);
		System.out.println("Should say: 12.2.2017");
		act1.printDate();
		
		System.out.println("Try 5, 6, 2020:");
		act1.setDate(5, 6, 2020);
		System.out.println("Should say: 5.6.2020");
		act1.printDate();
		
		System.out.println("Try 31, 4, 2017:");
		System.out.println("Should print error:");
		act1.setDate(31, 4, 2017);
		System.out.println("Should say: 5.4.2017");
		act1.printDate();
		
		System.out.println("Try 10, 14, 2017:");
		System.out.println("Should print error:");
		act1.setDate(10, 14, 2017);
		System.out.println("Should say: 10.4.2017");
		act1.printDate();
		
		act1.setDate(10, 4, 2017);
		// Test Accessors
		// Test getDay
		System.out.println("Should say 10: " + act1.getDay());
		
		// Test getMonth
		System.out.println("Should say 4: " + act1.getMonth());
		
		// Test getYear
		System.out.println("Should say 2017: " + act1.getYear());
	}
	
	// Main method
	public static void testStock(){
		System.out.println("\nTest Stock\n");
		
		Stock asset1 = new Stock();
		System.out.println("Should print: : 1.1.1 values: \n0, 0, 0, 0, 0, 0, 0");
		asset1.printStock();

		
		System.out.println("Checking Full Constructor:");
		// Check that shot list doesn't work 
		int[] values1 = new int[1];
		values1[0] = 1077;
		System.out.println("Should give error: ");
		Stock asset2 = new Stock(15,5,2017,"GOOGL",values1);
		System.out.println("Should print: GOOGL: 15.5.2017 values: \n0, 0, 0, 0, 0, 0, 0");
		asset2.printStock();
		
		
		// Check that the full constructor works
		int[] values2 = new int[7];
		for(int i = 0; i < 7; i++){
			values2[i] = 1007 + i*3;
		}
		Stock asset3 = new Stock(15,5,2017,"GOOGL",values2);
		System.out.println("Should print: GOOGL: 15.5.2017 values: \n1007, 1010, 1013, 1016, 1019, 1022, 1025");
		asset3.printStock();
		
		// Check getValue and for side effects 
		System.out.println("Check getValue and for sideffects");
		values2[2] = 5;
		System.out.println("Should say 1013: " + asset3.getValue(2)); // ERROR (Fixed)
		
		System.out.println("Should give error: ");
		System.out.println("Should say 0: " + asset3.getValue(20)); // THIS SHOULD SAY -1, return 0 is not specified
		
		// Check mean
		System.out.println("Check getMean");
		System.out.println("Should say 1016: " + asset3.getMeanValue());
		
		// Check name
		System.out.println("Check getName");
		System.out.println("Should say GOOGL: " + asset3.getName());
		
		// Check set name
		System.out.println("Check setName");
		asset3.setName("FB");
		System.out.println("Should say FB: " + asset3.getName());
		
		// Check setValue 
		System.out.println("Check setValue");
		System.out.println("Should give error: ");
		asset3.setValue(-1, 3);
		
		System.out.println("Should give error: ");
		asset3.setValue(2000, 80);
		
		System.out.println("Should give print: FB: 15.5.2017 values: \n1007, 1010, 1013, 2000, 1019, 1022, 1025");
		asset3.setValue(2000, 3);
		asset3.printStock();
		
	}

	public static void main(String [ ] args){
		testActivity();
		testStock();
	}
    
}
