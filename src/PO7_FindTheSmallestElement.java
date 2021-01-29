import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PO7_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List <Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

       // Function <List <Integer>,Integer> smallestNumber = num -> Collections.min(num);
        Function <List<Integer>,Integer> getLastInd =
                list -> list.lastIndexOf(list.stream().min(Integer::compare).get());

        //int minNum = smallestNumber.apply(numbers);
        //System.out.println(numbers.lastIndexOf(minNum));
        System.out.println(getLastInd.apply(numbers));
    }
}
