package playingwithstream;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Calculator {

    public static int calculate(String operation, int a1, int a2){
        Map<String, BinaryOperator<Integer>> operations = new HashMap<>();
        operations.put("+", (a,b) -> a+b);
        operations.put("*", (a,b) -> a*b);
        operations.put("-", (a,b) -> a-b);
        operations.put("/", (a,b) -> a/b);

        return Optional.ofNullable(operations.get(operation))
                .map((m) -> m.apply(a1, a2))
                .orElseThrow(UnsupportedOperationException::new);

    }
}
