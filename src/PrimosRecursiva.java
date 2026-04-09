import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimosRecursiva {

    public static final int LIM = 2000;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o valor de N (>1): ");
        int n = input(scanner);

        if (n > LIM) {
            System.out.println("Valor muito alto para recursão. Pode causar StackOverflow.");
            System.out.println("Use um valor <= " + LIM + " ou utilize a versão linear.");
            return;
        }

        ArrayList<Integer> primos = new ArrayList<>();
        primesRecursive(2, n, primos);

        System.out.println("Primos até " + n + ": " + primos);
    }

    public static void primesRecursive(int atual, int n, ArrayList<Integer> lista) {
        if (atual > n) return;

        if (isPrime(atual)) {
            lista.add(atual);
        }

        primesRecursive(atual + 1, n, lista);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int input(Scanner scanner) {
        while (true) {
            try {
                int n = scanner.nextInt();
                if (n <= 1) {
                    System.out.println("Digite um número maior que 1:");
                } else {
                    return n;
                }
            } catch (InputMismatchException e) {
                System.out.println("Escolha um número válido:");
                scanner.next();
            }
        }
    }
}