import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindByValueExo {

    /**
     *
     * @param map : key : an Integer, value: a String
     * @param s String to search for in the map values
     * @return a List of keys corresponding to the searched String s,
     *         The list might be empty if no key corresponding to the String s is found.
     */

    public static List<Integer> findByValue(Map<Integer, String> map, String s){
        return map.entrySet().stream()
                .filter(x -> s.equals(x.getValue()))
                .map(x -> x.getKey())
                .toList();
    }
}
