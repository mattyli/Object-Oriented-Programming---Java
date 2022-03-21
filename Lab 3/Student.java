public class Student extends Person {
    private static Integer maxCourses = 20;     // the maximum array size for the following arrays
    private Integer num_courses = 0;
    private String[] course_codes = new String[maxCourses];      // declaring a string array to hold the course codes
    private Integer[] grades = new Integer[maxCourses];
    

    // constructors

    public Student(String name, String address, int id){
        super(name, address, id);
    }

    public String toString(){
        return ("Student: " + super.toString());
    }

    public void addGrade(String course_code, Integer course_grade){
        // add the code here
        if(num_courses >= 20){
            System.out.println("ERROR! Student has taken the maximum amount of courses");
        }
        else{
            course_codes[num_courses] = course_code;        // assign to proper arrays
            grades[num_courses] = course_grade;             // default num_courses = 0
            num_courses++;                                  // increment the number of courses
        }
        // should probably add conditional 
    }

    public void printGrades(){
        for(int index = 0; index < num_courses; index++){
            System.out.println(course_codes[index] + " : " + grades[index].toString());
        }
    }
}
