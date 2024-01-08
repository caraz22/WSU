import java.util.Scanner;

class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("What is the temperature in Fahrenheit? ");
        int temp = in.nextInt();

        double C = (temp - 32) * 5.0 / 9;

        System.out.println(temp + " degrees Fahrenheit is " + C + " Celcius");

        in.close();
    }
}
