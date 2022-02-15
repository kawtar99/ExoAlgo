package playingwithstream;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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

    public static int calculate2(String operation, int a1, int a2){
        Optional<Operation> op = Operation.valueOfOperationType(operation);
        return op.map(x -> x.calculate(a1, a2))
                .orElseThrow(UnsupportedOperationException::new);
    }
}

enum Operation{
    ADDITION("+", (a,b) -> a+b),
    SUBSTRACTION ("-", (a,b) -> a-b),
    MULTIPLICATION("*", (a,b) -> a*b),
    DIVISION("/", (a,b) -> a/b),
    ;

    private final String operationType;
    private final BinaryOperator<Integer> binaryOperator;

    Operation(String operationType, BinaryOperator<Integer> binaryOperator) {
        this.operationType = operationType;
        this.binaryOperator = binaryOperator;
    }

    public int calculate(int a1, int a2) {
        return binaryOperator.apply(a1, a2);
    }

    public static Optional<Operation> valueOfOperationType(String operationType) {
        for (Operation e : Operation.values()) {
            if (e.operationType.equals(operationType)) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }

}
