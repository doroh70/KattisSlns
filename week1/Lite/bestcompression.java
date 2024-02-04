import java.util.Scanner;

public class bestcompression {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long b = scanner.nextInt();

        System.out.println(N <= (1<<(b+1)) -1 ? "yes": "no");
    }
}