package DiamondProblem;

/**
 * The diamond class gives compilation error if the display method is not overridden
 */
public class Diamond implements Interface1, Interface2{

    @Override
    public void display() {
        Interface1.super.display();
    }
}
