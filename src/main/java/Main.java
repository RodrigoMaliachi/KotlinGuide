import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String readValue = scanner.nextLine();
        boolean isDigit = readValue.matches("\\d+");
        int number = isDigit ? Integer.parseInt(readValue) : 0;

        System.out.printf(
                "El " + number + "° número de la secuencia de fibonacci es: " +
                fibonacciNumber(number)
        );
    }

    private static int fibonacciNumber(int number) {
        if ( number >= 3 && number <= 100 ) {
            return fibonacciNumber( number - 1) + fibonacciNumber( number - 2 );
        } else if (number == 2) {
            return 1;
        } else {
            return 0;
        }
    }
}