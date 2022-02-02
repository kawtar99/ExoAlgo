import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindByValueExo {

    public static List<Integer> findByValue(Map<Integer, String> map, String s){
        List<Integer> result = new ArrayList<>();
        for (Integer key : map.keySet()){
            if (s.equals(map.get(key))){
                result.add(key);
            }
        }
        return  result;
    }
}
