import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class StepsExoTest {

    @Test
    void testPossibilitiesforZeroSteps(){
        assertEquals(StepsExo.numberOfPossibilities(0), 0);
    }

    @Test
    void testPossibilitiesforOneSteps(){
        assertEquals(StepsExo.numberOfPossibilities(1), 1);
    }

    @Test
    void testPossibilitiesforFiveSteps(){
        assertEquals(StepsExo.numberOfPossibilities(5), 8);
    }

    @Test
    void testPossibilitiesForManySteps(){
        assertTimeout(Duration.ofMillis(100), () -> {
            StepsExo.numberOfPossibilities(288855);
        });
    }

}