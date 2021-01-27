import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PO1_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List <String> name = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        Consumer <List <String>> printer = n -> {
            for (String s : n) {
                System.out.println(s);
            }
        };
        printer.accept(name);
    }
}
