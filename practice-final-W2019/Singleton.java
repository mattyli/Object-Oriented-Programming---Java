public class Singleton {
    private static Singleton single;
    private String s;
    // private constructor
    private Singleton(){
        this.s = "Only object in the world";
    }

    // getInstance
    public static Singleton getInstance(){
        if (single == null){
            single = new Singleton();
        }
        // if the single is null, it will create a new singleton
        // then fall through and return reference to it
        return this.single;
    }
    /**
     * For singleton class:
     * - need private static instance variable
     * - (whatever else private variables you need)
     * - private constructor
     * - public static getInstance method()
     *      - must check whether there is already an instance
     *          - if there is, return reference to existing object
     *          - if there isn't, create instance and return reference to it
     * 
     */

}
