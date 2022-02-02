import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindByValueExo {

    public static List<Integer> findByValue(Map<Integer, String> map, String s){
        List<Integer> result = new ArrayList<>();
        map.forEach((k, v) -> {
            if(s.equals(v)){
                result.add(k);
            }
        });
        return  result;
    }
}
