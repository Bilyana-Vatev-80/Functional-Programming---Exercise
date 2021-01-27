import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PO8_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List <Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer ::parseInt).collect(Collectors.toList());

        Comparator <Integer> comparator = ((a,b) -> {
            if(a % 2 == 0 && b % 2 == 0){
                return a.compareTo(b); // и двете числа са четни
            } else if (a % 2 == 0 && b % 2 != 0){
                return -1;// а е четно , б е нечетно и ги оставяме в същия ред
            } else if (a % 2 != 0 && b % 2 == 0){
                return +1; // а е нечетно, б е четно и ги разменяма
            }
            return a.compareTo(b);
        });
     numbers.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
