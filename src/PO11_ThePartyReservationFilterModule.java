import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PO11_ThePartyReservationFilterModule {
    static List <String> names = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
         names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map <String,Predicate <String>> predicates = new HashMap<>();
        String line = " ";

        while (!"Print".equals(line = scanner.nextLine())){
            String[] tokens = line.split(";");
            String predicateNames = tokens[1] + tokens[2];
            switch (tokens[0]){
                case "Add filter":
                    Predicate <String> predicate = getPredicate(tokens);
                    predicates.put(predicateNames,predicate) ;
                    break;
                case "Remove filter":
                    predicates.remove(predicateNames);
                    break;
            }
        }
        names.stream().filter(names -> {
            boolean isValid = true;
            for(Predicate<String> predicate : predicates.values()){
                if(predicate.test(names)){
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(e -> System.out.print(e + " "));

    }
    private static Predicate <String> getPredicate(String[] tokens) {
        Predicate <String> predicate = null;
        switch (tokens[1]){
            case"Start with":
                predicate = name -> name.startsWith(tokens[2]);
                break;
            case "End with":
                predicate = name -> name.endsWith(tokens[2]);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(tokens[2]);
                break;
            default :
                predicate = name -> name.contains(tokens[2]);
                break;
        }
        return predicate;
    }
}
