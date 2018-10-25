import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sequence of figures:");
        String line = scanner.nextLine();
        if (!line.matches("^[IJLOSTZ]+$")) throw new IllegalArgumentException("Incorrect data");

    }
}
