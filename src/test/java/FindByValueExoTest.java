import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindByValueExoTest {

    Map<Integer, String> map;

    @BeforeEach
    public void setUp(){
        map = new HashMap<>();
    }

    @Test
    public void findByValueOnEmptyMap() {
         List<Integer> result = FindByValueExo.findByValue(map, "test");

         assertEquals(result.size(), 0);
    }

    @Test
    public void findByValueExistent(){
        map.put(1, "value1");
        map.put(2, "value2");
        map.put(3, "value3");

        List<Integer> result = FindByValueExo.findByValue(map, "value1");

        assertEquals(result.size(), 1);
        assertEquals(result.get(0), 1);
    }

    @Test
    void findByValueDouble(){
        map.put(1, "value");
        map.put(2, "value");

        List<Integer> result = FindByValueExo.findByValue(map, "value");

        assertEquals(result.size(), 2);
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
    }

    @Test
    void findByValueNotFound(){
        map.put(1, "value1");
        map.put(2, "value2");

        List<Integer> result = FindByValueExo.findByValue(map, "value3");

        assertEquals(result.size(), 0);
    }
}