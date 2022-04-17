public class InterStudent extends Student implements Comparable {
    private String homeCountry;

    public InterStudent(){
        super();
        this.homeCountry = "";
    }

    public InterStudent(String name, Date born, String homeCountry){
        super(name, born);
        this.homeCountry = homeCountry;
    }

    public InterStudent(InterStudent student){
        super(student);
        this.homeCountry = student.homeCountry;
    }

    public String toString(){
        return super.toString() + ", home country: " + this.homeCountry;
    }

    public String getHome(){
        return this.homeCountry;
    }

    public void setHome(String home){
        this.home = home;
    }

    public boolean equals(Object otherObj){
        // call to super?
        if (!super.equals(otherObj)) return false;
        if (this.getClass() != otherObj.getClass()){
            return false;
        }
        else{
            InterStudent otherInter = (InterStudent)otherObj;
            return (this.homeCountry.equals(otherInter.homeCountry));
        }
    }// thsi method could work

    public int compareTo(InterStudent otherInter){
        if (this.name.equals(otherInter.getName())){
            if (this.born.equals(otherInter.getBorn())){
                if (this.homeCountry.equals(otherInter.getHome())){
                    return 0;
                }
                return this.homeCountry.compareTo(otherInter.homeCountry);
            }
            return this.born.compareTo(otherInter.born);
        }
        return this.name.compareTo(otherInter.name);
    }
    // implement the compareTo()

    public InterStudent clone(){
        return new InterStudent(this);  // using copy constructor
    }
}
