import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void sieveOfEratosthenes(int number)
    {
        boolean[] primes = new boolean[number + 1];
        Arrays.fill(primes, true);
        for (int p = 2; p * p <= number; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= number; i += p) {
                    primes[i] = false;
                }
            }
        }
        int x=number;
        for (int i = 2; i <= number; i++) {
            while (primes[i] == true && x!=0){
                if(x%i==0){
                    System.out.print(i + " ");
                    x/=i;
                }
                else{
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        sieveOfEratosthenes(number);
    }
}