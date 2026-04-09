import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigInteger;

public class FibonacciLinear {

    private static ArrayList<BigInteger> fibonacci = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o valor de x para f(x): ");
        int x = input(scanner);
        fibonnaci(x);
        System.out.println("O valor da sequência de fibonacci no valor " + (x) + " é: " + (fibonacci.get(x)));
        scanner.close();
    }

    private static BigInteger fibonnaci(int x) {
        if (fibonacci.isEmpty()) {
            fibonacci.add(BigInteger.ZERO);
            fibonacci.add(BigInteger.ONE);
        }

        if (fibonacci.size() > x) {
            return fibonacci.get(x);
        }

        fibonnaci(x - 1);

        BigInteger nextTerm = fibonacci.get(x - 1).add(fibonacci.get(x - 2));
        fibonacci.add(nextTerm);



        return nextTerm;
    }

    public static int input(Scanner scanner) {
        int i;
        try {
            i = scanner.nextInt();

            if (i < 0) {
                System.out.println("Escolha um número natural para x: ");
                return input(scanner);
            }

            if (i > 5000) {
                System.out.println("A sequência de fibonacci cresce assustadoramente rápido, mesmo usando BigInteger como tipo \nainda temos limites de memória suportado pelo java, tente um valor menor");
                return input(scanner);
            }

        } catch (InputMismatchException e) {
            System.out.println("Escolha um número natural para x: ");
            scanner.next();
            return input(scanner);
        }

        return i;
    }
}