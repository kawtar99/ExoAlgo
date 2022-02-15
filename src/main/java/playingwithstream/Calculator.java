package playingwithstream;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Calculator {

    public static final Map<String, BinaryOperator<Integer>> operations = new HashMap<>();
    static {
        operations.put("+", (a,b) -> a+b);
        operations.put("*", (a,b) -> a*b);
        operations.put("-", (a,b) -> a-b);
        operations.put("/", (a,b) -> a/b);
    }


    public static int calculate(String operation, int a1, int a2){
        return Optional.ofNullable(operations.get(operation))
                .map((m) -> m.apply(a1, a2))
                .orElseThrow(UnsupportedOperationException::new);
    }
}
