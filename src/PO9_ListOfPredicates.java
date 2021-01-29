import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PO9_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt) .boxed().collect(Collectors.toCollection(HashSet::new));

        Predicate <Integer> predicate = num -> {
            for (Integer integer : numbers) {
                if(num % integer != 0){
                    return false;
                }
            }
            return true;
        };
        for (int number = 1; number < n; number++) {
            if(predicate.test(number) ){
                System.out.print(number + " ");
            }
        }
    }
}
