package Exceptions;

public class UncheckedException {
    
    public static void main(String[] args) {

        //System.out.println(1/0);
        System.out.println(1.0/0);

        int[] a = {1, 2, 3, 4, 5};
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }

        Object[] objectArray = new Object[10];
        objectArray[0].toString();
    }
}
