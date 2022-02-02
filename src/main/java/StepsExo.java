import java.util.ArrayList;
import java.util.List;

public class StepsExo {

    public static int numberOfPossibilities(int totalSteps){

        List<Integer> currentLevel;
        List<Integer> previousLevel = new ArrayList<>(1);
        previousLevel.add(0);
        int leafCounter = 0;
        for(int i=0; i<totalSteps; i++){
            currentLevel = new ArrayList<>(previousLevel.size() * 2);
            for (Integer prev : previousLevel){
                Integer oneStep = prev + 1;
                Integer twoSteps = prev + 2;
                leafCounter = loadLevel(currentLevel, oneStep, totalSteps, leafCounter);
                leafCounter = loadLevel(currentLevel, twoSteps, totalSteps, leafCounter);
            }
            previousLevel = currentLevel;
            currentLevel = null;
        }
        return leafCounter;

       }

    static int loadLevel(List<Integer> currentLevel, int nbSteps, int totalSteps, int counter){
        if (nbSteps == totalSteps){
            counter ++;
        }
        else if(nbSteps < totalSteps){
            currentLevel.add(nbSteps);
        }
        return counter;
    }
}
