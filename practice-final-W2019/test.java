public class test {
    private int id;
    private String msg;

    public test(int id, String msg){
        this.id = id;
        this.msg = msg;
    }

    public String toString(){
        return calledStatic() + ;
    }

    public static void calledStatic(){
        System.out.println("I called a STATIC");
    }
    public static void main(String[] args){
        //
        test t1 = new test(1, "test 1");
    }
}
