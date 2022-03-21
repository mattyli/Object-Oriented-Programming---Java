public class Test {
    public static void main ( String [] args) {
        Person p1 = new Person ("Jane" , "181 University Ave." , 123456);
        System.out.println(p1.toString()) ;
        Student s1 = new Student ("John" , "89 Univerity Ave." ,234567);
        s1.addGrade ("ELEC 279" , 97);
        s1.addGrade ("ELEC 221" , 68);
        System.out.println(s1.toString()) ;
        s1.printGrades();
        }
        
}
