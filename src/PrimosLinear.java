import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimosLinear {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o valor de N (>1): ");
        int n = input(scanner);

        ArrayList<Integer> primos = primos(n);

        System.out.println("Primos até " + n + ": " + primos);
    }

    public static ArrayList<Integer> primos(int n) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (ehPrimo(i)) {
                lista.add(i);
            }
        }

        return lista;
    }

    public static boolean ehPrimo(int num) {
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