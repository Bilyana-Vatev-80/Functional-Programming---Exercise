import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PO5_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Integer n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> checkIfDivisible = num -> num % n == 0;
        Consumer<List<Integer>> printer = numList -> numList
                .forEach(num -> System.out.print(num + " "));

        numbers.removeIf(checkIfDivisible);
        Collections.reverse(numbers);
        printer.accept(numbers);
    }
}
