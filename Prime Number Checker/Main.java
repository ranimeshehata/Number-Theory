import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean isPrime(int number) {
        if (number <= 1)
            return false;

        boolean[] primes = new boolean[number + 1];
        Arrays.fill(primes, true);
        for (int p = 2; p * p <= number; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= number; i += p) {
                    primes[i] = false;
                }
            }
        }
        return primes[number];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if(isPrime(number))
            System.out.println(number + " is a Prime Number.");
        else
            System.out.println(number + " is not a Prime Number.");
    }
}