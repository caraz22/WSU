package Midterm;

public class ModInverse {

    public static int modularInverse(int x, int m) {
        int modInv = 0;
        for (int i = 0; i < m; i++) {
            int inverse = (x * i) % m;
            if (inverse == 1) {
                modInv = i;
            } else {
                modInv = -1;
            }
        }
        
        return modInv;
    }
    
    public static void main(String[] args) {

        int m = 26;
        for (int x = 0; x < m; x++) {
            int n = modularInverse(x, m);
            if (n == -1) {
                System.out.println("The modular inverse of x " + x + " does not exist.");
            } else {
                System.out.println("The modular inverse of x " + x + " is: " + n + " for mod " + m);
            }
        }
    }
}
