package Time;
public class DriverT {

    public static void main(String[] args) {

        Time t1 = new Time();
        System.out.println("t1 " + t1);

        Time t2 = new Time( 17, 33, 30);
        System.out.println("t2 " + t2);
        System.out.println("add 2 hours to t2 " + t2.add(2));

        Time t3 = new Time(8, 27, 31);
        System.out.println("t3 " + t3);
        System.out.println("t2 add t3 is " + t2.add(t3));

        //.equals method for comparing two object contents
        System.out.println("use .equals() to compare two objects");
        System.out.println("t2 equals t3: " + t2.equals(t3));

        System.out.println("t3 equals t2: " + t3.equals(t2));

        Time t4 = new Time (8, 27, 31);
        System.out.println("t4 " + t4);
        System.out.println("t4 equals t3: " +t4.equals(t3));
        System.out.println("t4: " + t4 + " t3: " + t3);
        System.out.println("== operator compares references to objects; references are different to ...?");
        System.out.println("t4 == t3: " + (t4 == t3));
    }    
}
