import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PO2_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List <String> listOfNames = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Consumer<List <String>> printName = p -> {
            for (String name : p) {
                System.out.println("Sir " + name);
            }
        };
        printName.accept(listOfNames);
    }
}
