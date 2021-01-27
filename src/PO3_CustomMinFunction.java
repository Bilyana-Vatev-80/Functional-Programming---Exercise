import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class PO3_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Function <int[],Integer> smallestNumber = numArr ->{
            int minNum = Integer.MAX_VALUE;
            for (int i : numArr) {
                if(i < minNum){
                    minNum = i;
                }
            }
            return minNum;
        };

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(smallestNumber.apply(numbers));
    }
}
