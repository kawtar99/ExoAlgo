import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementsExoTest {

    @Test
    public void removeOnEmptyArray(){
        int[] test = {};

        int newSize = RemoveElementsExo.removeElement(test, 0);
        assertEquals(newSize, 0);
    }

    @Test
    public void shouldRemoveDuplicates(){
        int[] test = {1, 2, 2, 0};

        int newSize = RemoveElementsExo.removeElement(test, 2);
        assertEquals(newSize, 2);

    }

    @Test
    public void shouldRemoveNothing(){
        int[] test = {1, 2, 2, 0};

        int newSize = RemoveElementsExo.removeElement(test, 3);
        assertEquals(newSize, 4);
    }

}