import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindByValueExo {

    public static List<Integer> findByValue(Map<Integer, String> map, String s){
        return map.entrySet().stream()
                .filter(x -> s.equals(x.getValue()))
                .map(x -> x.getKey())
                .toList();
    }
}
