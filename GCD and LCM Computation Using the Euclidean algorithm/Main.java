import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int gcd (int num1, int num2){
        int x = num1;
        int y = num2;
        int r;
        while(y!=0){
            r = x%y;
            x=y;
            y=r;
        }
        return x;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();
        System.out.print("Enter second number: ");
        int num2 = input.nextInt();
        System.out.println("GCD = " + gcd(num1, num2));
        if(num1 == 0 || num2 == 0)
            System.out.println("LCM = undefined!");
        else {
            int lcm = (num1*num2)/gcd(num1, num2);
            System.out.println("LCM = " + lcm);
        }
    }
}