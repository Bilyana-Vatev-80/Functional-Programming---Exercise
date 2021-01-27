import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PO4_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Consumer <List<Integer>> printer = numList -> {
            for (Integer integer : numList) {
                System.out.print(integer + " ");
            }
        };

        List <Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String commands;
        while (!"end".equals(commands = scanner.nextLine())){
            if("print".equals(commands)){
                printer.accept(numbers);
                System.out.println();
            } else {
                Function <List <Integer>,List <Integer>> function = modiyList(commands);
                numbers = function.apply(numbers);
            }
        }
    }

    private static Function<List<Integer>, List<Integer>> modiyList(String commands) {
        return switch (commands) {
            case "add" -> numList -> numList.stream().map(e -> e + 1).collect(Collectors.toList());
            case "multiply" -> numList -> numList.stream().map(e -> e * 2).collect(Collectors.toList());
            case "subtract" -> numList -> numList.stream().map(e -> e - 1).collect(Collectors.toList());
            default -> numList -> numList;
        };
    }
}
