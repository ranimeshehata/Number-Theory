import java.util.Scanner;

public class Main {
    public static int crt(int[]a, int[]m, int n, int M){
        int x = 0;

        for(int i = 0; i<n; i++){
            int Mm = M/m[i], inverse = 0;
            //to get the inverse
            for(int j=0; j<m[i]; j++){
                if((Mm*j)%m[i]==1){
                    inverse = j;
                    break;
                }
            }

            x = x + a[i]*Mm*inverse;
        }
        x = x%M;
        return x;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of congruence relations: ");
        int n = input.nextInt();
        System.out.println("Enter the values of m: ");
        int[] m = new int[n];
        int M = 1;
        for (int i = 0; i < n; i++) {
            System.out.print("m" + (i + 1) + "= ");
            m[i] = input.nextInt();
            M *= m[i];
        }
        System.out.println("Enter the values of a: ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a" + (i + 1) + "= ");
            a[i] = input.nextInt();
        }
        System.out.println("x = " + crt(a, m, n, M));
    }
}