import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PO9_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List <Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        BiFunction <List <Integer>,Integer ,Boolean> predicate = ((List,number) ->{
            for (Integer integer : List) {
                if(number % integer != 0){
                    return false;
                }
            }
            return true;
        });
        for (int number = 1; number < n; number++) {
            if(predicate.apply(numbers,number)){
                System.out.print(number + " ");
            }
        }
    }
}
