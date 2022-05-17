public class Student {
    private String name;
    private Date born;

    public Student(){
        this.name = "";
        this.born = new Date();
    }// no arg

    public Student(String name, Date born){
        this.name = name;
        this.born = new Date(born);
    }// arg

    public Student(Student student){
        this.name = student.name;
        this.born = new Date(student.born);
    }// copy constructor

    public String getName(){
        return this.name;
    }

    public Date getBorn(){
        return new Date(born);  // ensuring no privacy leak
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBorn(Date born){
        this.born = new Date(born);
    }

    public String toString(){
        return "Name: " + this.name + ", Born: " + this.born.toString();    // using the Date toString()
    }

    public boolean equals(Object otherObj){
        if (otherObj == null){
            return false;
        }
        else if (otherObj.getClass() != this.getClass()){
            return false;
        }
        else{
            Student otherStudent = (Student)otherObj;       // downcast
            return (this.name.equals(otherStudent.getName()) && this.born.equals(otherStudent.getBorn()));
            // invoking equals methods defined in the other classes
        }
    }


    public Student clone(){
        return new Student(this);
    }// use copy constructor here
}

