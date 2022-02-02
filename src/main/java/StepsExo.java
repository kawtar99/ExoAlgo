import java.util.ArrayList;
import java.util.List;

public class StepsExo {

    public static int numberOfPossibilities(int totalSteps) {

        if (totalSteps == 0){
            return 0;
        }

        if (totalSteps == 1){
            return 1;
        }

        // The longest path is 1 + 1 + ... +1 = totalSteps
        int[] stepsByLevel =new int[totalSteps];
        // The possibilities to reach 1th step is 1
        stepsByLevel[0] = 1;
        // The possibilities to reach 2th step is 2
        stepsByLevel[1] = 2;

        // the possibilities of steps needed to reach the n-th step is
        // the possibilities of steps needed to reach the n-1th step +
        // the possibilities of steps needed to reach the n-2th step
        for(int i=2; i<totalSteps; i++){
            stepsByLevel[i] = stepsByLevel[i-1] + stepsByLevel[i-2];
        }
        return stepsByLevel[totalSteps -1];
    }

}
