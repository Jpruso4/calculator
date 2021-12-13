import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class calculator {
    public static void main(String[] args){

        BiFunction<Integer, Integer, Integer> addition  = (a, b) -> a + b;

        BiFunction<Integer, Integer, Integer> subtraction = (a, b) -> a - b;

        BiFunction<Integer, Integer, Integer> multiplication = (a, b) ->
                IntStream.range(0, b + 1)
                        .reduce((accumulator, number) -> addition.apply(accumulator, a))
                        .getAsInt();

        BiFunction<Integer, Integer, Integer> division = (a, b) -> {
            return IntStream.range(0, a)
                    .reduce((accumulator, number) -> multiplication.apply(number, b) <= a ? addition.apply(accumulator, 1) : accumulator)
                    .orElse(0);
        };

        System.out.println("Addition: " + addition.apply(4,4));
        System.out.println("Subtraction: " + subtraction.apply(6,3));
        System.out.println("Multiplication: " + multiplication.apply(5,5));
        System.out.println("Division: " + division.apply(20,5));


    }
}
