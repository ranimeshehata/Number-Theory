import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> sieveOfEratosthenes(int number) {
        boolean[] primes = new boolean[number + 1];
        Arrays.fill(primes, true);

        for (int p = 2; p * p <= number; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= number; i += p) {
                    primes[i] = false;
                }
            }
        }
        ArrayList<Integer>primesList = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (primes[i] == true){
                primesList.add(i);
            }
        }
        return primesList;
    }

    public static int gcd (ArrayList<Integer>factors1, ArrayList<Integer>factors2){
        ArrayList<Integer>gcd = new ArrayList<>();
        int res=1;
        for (int i=0; i<factors1.size(); i++){
            for(int j=0; j<factors2.size(); j++) {
                if (factors1.get(i) == factors2.get(j)) {
                    gcd.add(factors1.get(i));
                    factors2.remove(j);
                    break;
                }
            }
        }
        for (int i = 0; i<gcd.size(); i++)
            res *= gcd.get(i);
        return res;

    }

    public static int lcm (ArrayList<Integer>factors1, ArrayList<Integer>factors2){
        ArrayList<Integer>lcm = new ArrayList<>();
        int res=1;
        for (int i=0; i<factors1.size(); i++){
            lcm.add(factors1.get(i));
        }
        for (int i=0; i<lcm.size(); i++){
            for(int j=0; j<factors2.size(); j++) {
                if (lcm.get(i) == factors2.get(j)){
                    break;
                }
            }
        }
        for (int i=0; i<factors2.size(); i++)
            lcm.add(factors2.get(i));
        for (int i = 0; i<lcm.size(); i++)
            res *= lcm.get(i);
        return res;
    }
        public static void main (String[]args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter first number: ");
            int num1 = input.nextInt();
            System.out.print("Enter second number: ");
            int num2 = input.nextInt();
            ArrayList<Integer> primes1 = sieveOfEratosthenes(num1);
            ArrayList<Integer> primes2 = sieveOfEratosthenes(num2);
            ArrayList<Integer> factors1 = new ArrayList<>();
            ArrayList<Integer> factors2 = new ArrayList<>();
            int i=0;
            int x1=num1;
            int x2=num2;
            while (num1 != 0 && i<primes1.size()){
                if(num1%primes1.get(i) == 0){
                    factors1.add(primes1.get(i));
                    num1 /= primes1.get(i);
                }
                else
                    i++;
            }
            i=0;
            while (num2 != 0 && i<primes2.size()){
                if(num2%primes2.get(i) == 0){
                    factors2.add(primes2.get(i));
                    num2 /= primes2.get(i);
                }
                else
                    i++;
            }
            if(x1 == 0){
                System.out.println("GCD = " + x2);
                System.out.println("LCM = undefined!");
            }
            else if(x2 == 0){
                System.out.println("GCD = " + x1);
                System.out.println("LCM = undefined!");
            }else {
                System.out.println("GCD = " + gcd(factors1, factors2));
                System.out.println("LCM = " + lcm(factors1, factors2));
            }
        }
}