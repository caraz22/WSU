class MoreMethods {

    public static void main(String[] args) { //void is for when there's no return value
        //System.out.println(luckySum(1, 2, 3));
        int x = add(4, 5);
        System.out.println("x = " + x);

        int y = add(4, 5, 6);
        System.out.println("y = " + y);

        double z = add(4.0, 5);
        System.out.println("z = " + z);
    }

    //method overloading
    public static double add(double a, double b) {
        System.out.println("two double params");
        return a + b;
    }
    public static int add(int a, int b) { //< this is a method signature
        System.out.println("two int params");
        return a + b;
    }

    public static int add(int a, int b, int c) {
        System.out.println("three int params");
        return a + b + c;
        //return add(add (a, b), c);
    }

    public static int luckySum(int a, int b, int c) {
        if (a == 13) {
            return 0;
        }

        if (b == 13) {
            return a;
        }

        if (c == 13) {
            return a + b;
        }

        return a + b + c;
    }
}