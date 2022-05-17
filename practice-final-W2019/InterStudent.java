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

    // WILL WORK
    /**
     * public boolean equals(Object other){
     *      if (other == null) return false;
     *      else if (other.getClass() != this.getClass()){
     *              return false;
     *          }
     *      else{
     *              downcast from object
     *          }
     * }
     * 
     */

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
    }// more accurate compareTo() than just returning -1
    // implement the compareTo()
    // Use the equals() of this class and other classes for the conditional
    // getters and setters, they will work regardless, using dot notation will probably not work

    public InterStudent clone(){
        return new InterStudent(this);  // using copy constructor
    }
}
