package Recursion;

//2^n-1
public class TowerOfHanoi {

    //move n disks from a to b, using c as temporary pole
    public static void move(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("move disk " + n + " from " + a + " to " + b);
            return;
        }

        move(n - 1, a, c, b); //move top n-1 disks to c using b as temp
        System.out.println("move disk " + n + " from " + a + " to " + b);
        move(n - 1, c, b, a); //move top n-1 disks to b using a as temp
    }
    
    public static void main(String[] args) {
        
        move(3, 'A', 'B', 'C');
    }
}
